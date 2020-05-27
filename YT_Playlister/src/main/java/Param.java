public class Param {

    // TODO: Da li ovo treba da postoji?
    public static boolean publishedAt = false;
    public static boolean description = false;
    public static boolean notTesting = true;

    public static final String newLine = System.lineSeparator();
    public static final String separatorDouble = "==================================================================================================";
    public static final String separatorSingle = "--------------------------------------------------------------------------------------------------";
    public static final String validRequest = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&regionCode=us&key=AIzaSyDciUo9L8xywPEvPqvMsLfsMIdHjNFo73I&playlistId=PL7DA3D097D6FDBC02&maxResults=50";
    public static final String invalidRequest = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&regionCode=us&key=AIzaSyDciUo9L8xywPEvPqvMsLfsMIdHjNFo73I&playlistId=PL7DA3DD6FDBC02&maxResults=50";
}
