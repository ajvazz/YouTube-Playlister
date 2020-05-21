import java.util.*;
import java.io.PrintWriter;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Playlister {


//    public static String API_KEY = "AIzaSyDciUo9L8xywPEvPqvMsLfsMIdHjNFo73I";
//    public static String baseURI = "https://www.googleapis.com/youtube/v3/playlistItems";
//    public static String regionCode = "regionCode=us";
//    public static String maxResults = "maxResults=50";
//    public static String playlistId = "";
//    public static String request = "";
//    public static String outputPath = "";
//    public static String nextPageToken = "";
//    public static ArrayList<LinkedHashMap> snippets;
//    public static Response response = null;
//    private static String separatorDouble = "==================================================================================================";

    public static void main(String[] args) {
        inputParameters();
        createNewRequest();
        sendRequest();
    }

    public static Response sendRequest() {
        System.out.println("\u001b[32m" + "\033[3mSending request...\033[0m");
        boolean resultsExist = true;

        while (resultsExist) {

            getResponse();
            snippets = response.then().extract().path("items.snippet");

            displayInfo();
            saveInfo();

            // Create request again with new page token, which contains next 50 results
            if (nextPageExists())
                createNewRequest();
            else
                resultsExist = false;
        }

        return response;
    }

    private static void getResponse() {
        response = given().
                contentType("application/json; charset=UTF-16").
                when().
                get(request);
    }

    private static void createNewRequest() {
        request =  baseURI +
                "?part=snippet" +
                "&" + regionCode +
                "&key=" + API_KEY +
                "&playlistId=" + playlistId +
                "&" + maxResults +
                "&pageToken=" + nextPageToken;
    }

    private static void inputParameters() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Please enter YT playlist link, or enter playlist ID: ");
            parseInput(sc);
            System.out.print("Please enter where you want to save the output (example: 'myPlaylist.txt'): ");
            outputPath = sc.nextLine();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private static void parseInput(Scanner sc) {
        String input = sc.nextLine().trim();
        try {
            if (input.contains("https://www.youtube.com/"))  // It's a link
                playlistId = input.substring(input.indexOf("list=") + 5);
            else
                playlistId = input;        // It's an ID
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Wrong playlist link!");
            System.exit(1);
        }
    }

    private static boolean nextPageExists() {
        nextPageToken = response.then().extract().path("nextPageToken");
        return (nextPageToken != null);
    }

    private static void displayInfo() {
        System.out.println();
        for (LinkedHashMap snippet : snippets) {
            System.out.println(separatorDouble);
            System.out.println("VIDEO TITLE: " + snippet.get("title"));
            System.out.println("UPLOADER: " + snippet.get("channelTitle"));
        } System.out.println(separatorDouble);
    }

    private static void saveInfo() {
        try (PrintWriter file = new PrintWriter(outputPath, "UTF-8")) {
            for (LinkedHashMap snippet : snippets) {
                file.println(separatorDouble + separatorDouble);
                String separatorSingle = "--------------------------------------------------------------------------------------------------";
                file.println(); file.println();
                file.println("VIDEO TITLE: " + snippet.get("title"));
                file.println(separatorSingle + separatorSingle);
                file.println("UPLOADER: "    + snippet.get("channelTitle"));
                file.println(separatorSingle + separatorSingle);
                file.println("DESCRIPTION: " + snippet.get("description"));
                file.println(); file.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}