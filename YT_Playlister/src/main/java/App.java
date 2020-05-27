import java.util.List;

public class App {

    public static void main(String[] args) {
        String playlist   = args[0];
        String outputFile = args[1];

        YouTubePlaylister yt = new YouTubePlaylister();
        List<YouTubeVideo> videos = yt.getVideosFromPlaylist(playlist);
        yt.saveVideosToFile(videos, outputFile);
    }
}