import java.io.PrintWriter;
import java.util.List;

public class YouTubePlaylister {

    public List<YouTubeVideo> getVideosFromPlaylist(String playlist) {
        YouTubeAPI youTube = new YouTubeAPI(playlist);
        return youTube.requestVideos();
    }

    public void saveVideosToFile(List<YouTubeVideo> videos, String outputFile) {
        try (PrintWriter file = new PrintWriter(outputFile, "UTF-8")) {
            for (YouTubeVideo video : videos) {
                file.println(video);
                file.println(Param.separatorDouble);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Playlist information successfully obtained! Output saved in \""+ outputFile +"\".");
    }
}
