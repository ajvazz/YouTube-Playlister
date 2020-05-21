import io.restassured.response.Response;

import java.io.PrintWriter;
import java.util.LinkedHashMap;

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
        System.out.println("\u001b[32m" + "\033[3mSending request...\033[0m");

        while (true) {
            getResponse();
            extractInfo();
            UserOutput.displayInfo();
            UserOutput.saveInfo();

            // Create request again with new page token, which contains next 50 results
            if (nextPageExists())
                createNewRequest();
            else break;
        }
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
    }

}
