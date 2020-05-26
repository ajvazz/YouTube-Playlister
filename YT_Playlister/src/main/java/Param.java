import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Param {

    public static String outputPath = "";

    // TODO: Da li ovo treba da postoji?
    public static boolean publishedAt = false;
    public static boolean description = false;
    public static boolean notTesting = true;

    public static final String separatorDouble = "==================================================================================================";
    public static final String separatorSingle = "--------------------------------------------------------------------------------------------------";
    public static final String newLine = System.lineSeparator();
    public static final String validRequest = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&regionCode=us&key=AIzaSyDciUo9L8xywPEvPqvMsLfsMIdHjNFo73I&playlistId=PL7DA3D097D6FDBC02&maxResults=50";
    public static final String invalidRequest = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&regionCode=us&key=AIzaSyDciUo9L8xywPEvPqvMsLfsMIdHjNFo73I&playlistId=PL7DA3DD6FDBC02&maxResults=50";


    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
}
