import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Param {
    public static String API_KEY = "AIzaSyDciUo9L8xywPEvPqvMsLfsMIdHjNFo73I";
    public static String baseURI = "https://www.googleapis.com/youtube/v3/playlistItems";
    public static String regionCode = "regionCode=us";
    public static String maxResults = "maxResults=50";
    public static String playlistId = "";
    public static String request = "";
    public static String outputPath = "";
    public static String nextPageToken = "";
    public static ArrayList<LinkedHashMap> snippets = null;
    public static Response response = null;
    public static String separatorDouble = "==================================================================================================";
    public static String validRequest = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&regionCode=us&key=AIzaSyDciUo9L8xywPEvPqvMsLfsMIdHjNFo73I&playlistId=PLQ9sFiNxsP2GnltE3MA7-Imx9Mz03HXzl&maxResults=50";
    public static String invalidRequest = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&regionCode=us&key=AIzaSyDciUo9L8xywPEvPqvMsLfsMIdHjNFo73I&playlistId=PLQ9sP2GnltE3MA7-Imx9Mz03HXzl&maxResults=50";

    public static boolean publishedAt = false;
    public static boolean description = false;
    public static boolean channelTitle = false;

    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";

}
