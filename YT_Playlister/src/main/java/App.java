import java.util.List;

public class App {

    public static void main(String[] args) {
        String playlist   = args[0];
        String outputFile = (args.length==2) ? args[1] : "playlistOutput.json";
        if (!outputFile.endsWith(".json")) {
            System.err.println("Output file must end with .json! Aborting.");
            System.exit(1);
        }

        YouTubePlaylister yt = new YouTubePlaylister();
        List<YouTubeVideo> videos = yt.getVideosFromPlaylist(playlist);

        yt.saveVideosToFile(videos, outputFile);
    }
}