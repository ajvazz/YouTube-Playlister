import java.io.PrintWriter;
import java.util.*;

import static io.restassured.RestAssured.*;

public class Main {

    public static String API_KEY = "AIzaSyDciUo9L8xywPEvPqvMsLfsMIdHjNFo73I";
    public static String baseURI = "https://www.googleapis.com/youtube/v3/playlistItems";
    public static String regionCode = "regionCode=us";
    public static String maxResults = "maxResults=50";
    public static String playlistId = "";
    public static String request = "";
    public static ArrayList<LinkedHashMap> snippets;

    private static String separatorDouble = "==================================================================================================";


    public static void main(String[] args) {
        inputParameters();
        createRequest();
        sendRequest();
        displayInfo();
        saveInfo();
    }

    private static void sendRequest() {
        System.out.println("\033[3mSending request...\033[0m");
        snippets =  given().
                    contentType("application/json; charset=UTF-16").
                    when().
                    get(request)
                    .then().extract().path("items.snippet");
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
        try (Scanner sc = new Scanner(System.in)) {
            parseLink(sc);
        } catch (Exception e) {
            System.err.println("Exception! Error: " + e.getMessage());
        }
    }

    private static void parseLink(Scanner sc) {
        System.out.print("Please enter YT playlist link: ");
        String link = sc.nextLine().trim();
        try {
            playlistId = link.substring(link.indexOf("list=") + 5);
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