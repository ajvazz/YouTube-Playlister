import io.restassured.response.Response;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Scanner;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Controller {

    public void getPlaylistInfo() {
        inputParameters();
        createNewRequest();
        sendRequest();
    }

    public static Response sendRequest() {
        System.out.println("\u001b[32m" + "\033[3mSending request...\033[0m");
        boolean resultsExist = true;

        while (resultsExist) {
            getResponse();
            extractInfo();
            displayInfo();
            saveInfo();

            // Create request again with new page token, which contains next 50 results
            if (nextPageExists())
                createNewRequest();
            else
                resultsExist = false;
        }
        return Param.response;
    }


    private static void getResponse() {
        Param.response = given().
                contentType("application/json; charset=UTF-16").
                when().
                get(Param.request);
    }

    private static void createNewRequest() {
        Param.request = Param.baseURI +
                "?part=snippet" +
                "&" + Param.regionCode +
                "&key=" + Param.API_KEY +
                "&playlistId=" + Param.playlistId +
                "&" + Param.maxResults +
                "&pageToken=" + Param.nextPageToken;
    }

    private static boolean nextPageExists() {
        Param.nextPageToken = Param.response.then().extract().path("nextPageToken");
        return (Param.nextPageToken != null);
    }

    private static void extractInfo() {
        Param.snippets = Param.response.then().extract().path("items.snippet");
    }

    private static void inputParameters() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Please enter YT playlist link, or enter playlist ID: ");
            parseInput(sc);
            System.out.print("Please enter where you want to save the output (example: 'myPlaylist.txt'): ");
            Param.outputPath = sc.nextLine();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void parseInput(Scanner sc) {
        String input = sc.nextLine().trim();
        try {
            if (input.contains("https://www.youtube.com/"))  // It's a link
                Param.playlistId = input.substring(input.indexOf("list=") + 5);
            else
                Param.playlistId = input;        // It's an ID
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Wrong playlist link!");
            System.exit(1);
        }
    }

    private static void displayInfo() {
        System.out.println();
        for (LinkedHashMap snippet : Param.snippets) {
            System.out.println(Param.separatorDouble);
            System.out.println("VIDEO TITLE: " + snippet.get("title"));
            System.out.println("UPLOADER: " + snippet.get("channelTitle"));
        } System.out.println(Param.separatorDouble);
    }

    private static void saveInfo() {
        try (PrintWriter file = new PrintWriter(Param.outputPath, "UTF-8")) {
            for (LinkedHashMap snippet : Param.snippets) {
                file.println(Param.separatorDouble + Param.separatorDouble);
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
