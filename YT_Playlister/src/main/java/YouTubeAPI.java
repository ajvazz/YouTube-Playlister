import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class YouTubeAPI {

    private final YouTubeParser parser;
    private final List<YouTubeVideo> videos;

    private String request = null;
    private String playlistId = null;
    private Response response = null;
    private String nextPageToken = "";
    public static boolean notTesting = true;


    public YouTubeAPI(String playlist) {
        parser = new YouTubeParser();
        this.playlistId = parser.parseID(playlist);
        this.videos = new ArrayList<>();
    }

    public List<YouTubeVideo> getVideos() {
        return videos;
    }

    public Response requestVideos() {
        createNewRequest();
        return sendRequest();   // Return value used only in tests
    }

    private void createNewRequest() {
        final String baseURI = "https://www.googleapis.com/youtube/v3/playlistItems";
        final String API_KEY = "AIzaSyDciUo9L8xywPEvPqvMsLfsMIdHjNFo73I";
        request = baseURI +
                "?part=snippet" +
                "&key="         + API_KEY     +
                "&playlistId="  + playlistId  +
                "&maxResults=50"+
                "&regionCode=us"+
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
        return response;
    }

    private void getResponse() {
        response = given().when().get(request);
    }

    private boolean nextPageExists() {
        nextPageToken = response.then().extract().path("nextPageToken");
        return (nextPageToken != null);
    }

    private void extractResponse() {
        ArrayList<LinkedHashMap> snippets;
        snippets = response.then().extract().path("items.snippet");
        if (snippets == null) {
            if (notTesting) {
                System.err.println( "Parameter error! Aborting.");
                System.exit(1);
            }
        } else
            videos.addAll(parser.getNext50Videos(snippets));
    }

}
