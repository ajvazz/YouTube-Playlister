import java.util.List;

public class YouTubePlaylister {

    public List<YouTubeVideo> getVideosFromPlaylist(String playlist) {
        YouTubeAPI youTube = new YouTubeAPI(playlist);
        return youTube.requestVideos();
    }

    public void saveVideosToFile(List<YouTubeVideo> videos, String file) {
        PlaylistOutput output = new PlaylistOutput();
        output.writeAsJSON(videos, file);
        System.out.println("Playlist information successfully obtained! Output saved in \""+ file +"\".");
    }
}
