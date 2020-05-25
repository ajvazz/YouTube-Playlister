import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RequestController {

    public void getPlaylistInfo() {
        UserInput.getParameters();
        createNewRequest();
        sendRequest();
    }

    private static void createNewRequest() {
        Param.request = Param.baseURI +
                "?part=snippet" +
                "&"             + Param.regionCode  +
                "&key="         + Param.API_KEY     +
                "&playlistId="  + Param.playlistId  +
                "&"             + Param.maxResults  +
                "&pageToken="   + Param.nextPageToken;
    }

    public static Response sendRequest() {
        if (Param.notTesting) {
            System.out.println();
            System.out.println(Param.YELLOW + "Sending request..." + Param.RESET);
        }

        while (true) {
            getResponse();
            extractInfo();
            if (Param.notTesting)
               UserOutput.saveInfo();

            if (nextPageExists())
                createNewRequest();
            else break;
        }
        if (Param.notTesting)
            UserOutput.successMessage();

        return Param.response;      // Used in tests
    }


    private static void getResponse() {
        Param.response = given().
                contentType("application/json; charset=UTF-16").
                when().
                get(Param.request);
    }

    private static boolean nextPageExists() {
        Param.nextPageToken = Param.response.then().extract().path("nextPageToken");
        return (Param.nextPageToken != null);
    }

    private static void extractInfo() {
        Param.snippets = Param.response.then().extract().path("items.snippet");

        if (Param.notTesting) {     // This is going to be null when testing, so this needs to work only in non-testing mode
            if (Param.snippets == null) {
                System.err.println( "YouTube API error: Daily Limit Exceeded! You have made too many calls today. " +
                        "The quota will reset at midnight Pacific Time (PT). Try again later.");
                System.exit(1);
            }
        }
    }

}
