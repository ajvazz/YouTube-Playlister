import java.util.*;
import java.io.PrintWriter;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Playlister {

    public static String API_KEY = "AIzaSyDciUo9L8xywPEvPqvMsLfsMIdHjNFo73I";
    public static String baseURI = "https://www.googleapis.com/youtube/v3/playlistItems";
    public static String regionCode = "regionCode=us";
    public static String maxResults = "maxResults=50";
    public static String playlistId = "";
    public static String request = "";
    public static ArrayList<LinkedHashMap> snippets;
    public static Response response = null;

    private static String separatorDouble = "==================================================================================================";


    public static void main(String[] args) {
        inputParameters();
        createRequest();
        sendRequest(request);
        displayInfo();
        saveInfo();
    }

    public static Response sendRequest(String request) {
        System.out.println("\033[3mSending request...\033[0m");
        response = given().
                contentType("application/json; charset=UTF-16").
                when().
                get(request);
        snippets = response.then().extract().path("items.snippet");
        return response;
    }

    private static void createRequest() {
        request +=  baseURI +
                "?part=snippet" +
                "&" + regionCode +
                "&key=" + API_KEY +
                "&playlistId=" + playlistId +
                "&" + maxResults;
    }

    private static void inputParameters() {
        System.out.print("Please enter YT playlist link, or enter playlist ID: ");
        try (Scanner sc = new Scanner(System.in)) {
            parseInput(sc);
        } catch (Exception e) {
            System.err.println("Exception! Error: " + e.getMessage());
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

    private static void displayInfo() {
        System.out.println();
        for (LinkedHashMap snippet : snippets) {
            System.out.println(separatorDouble);
            System.out.println("VIDEO TITLE: " + snippet.get("title"));
            System.out.println("UPLOADER: " + snippet.get("channelTitle"));
        }
        System.out.println(separatorDouble);
    }

    private static void saveInfo() {
        try (PrintWriter file = new PrintWriter("src/main/resources/playlistInfo.txt", "UTF-8")) {
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