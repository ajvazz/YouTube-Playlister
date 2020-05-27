import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class YouTubeAPI {

    private final String baseURI = "https://www.googleapis.com/youtube/v3/playlistItems";
    private final String API_KEY = "AIzaSyDciUo9L8xywPEvPqvMsLfsMIdHjNFo73I";
    private final String regionCode = "regionCode=us";
    private final String maxResults = "maxResults=50";

    private ArrayList<LinkedHashMap> snippets = null;
    private String request = null;
    private String playlistId = null;
    private Response response = null;
    private String nextPageToken = "";

    private List<YouTubeVideo> videos;
    private YouTubeParser parser;


    public YouTubeAPI(String playlist) {
        parser = new YouTubeParser();
        this.playlistId = parser.parseID(playlist);
        this.videos = new ArrayList<>();
    }

    public List<YouTubeVideo> requestVideos() {
        createNewRequest();
        sendRequest();
        return videos;
    }

    private void createNewRequest() {
        request = baseURI +
                "?part=snippet" +
                "&"             + regionCode  +
                "&key="         + API_KEY     +
                "&playlistId="  + playlistId  +
                "&"             + maxResults  +
                "&pageToken="   + nextPageToken;
    }

    public Response sendRequest() {
        while (true) {
            getResponse();
            extractResponse();
            if (nextPageExists())
                createNewRequest();
            else break;
        }
        return response;      // Used in tests
    }

    private void getResponse() {
        response = given().
                when().
                get(request);
    }

    private boolean nextPageExists() {
        nextPageToken = response.then().extract().path("nextPageToken");
        return (nextPageToken != null);
    }

    private void extractResponse() {
        snippets = response.then().extract().path("items.snippet");
        videos.addAll(parser.getNext50Videos(snippets));

//        if (Param.notTesting) {     // This is going to be null when testing, so this needs to work only in non-testing mode
//            if (snippets == null) {
//                System.err.println( "YouTube API error: Daily Limit Exceeded! You have made too many calls today. " +
//                        "The quota will reset at midnight Pacific Time (PT). Try again later.");
//                System.exit(1);
//            }
//        }
    }
}
