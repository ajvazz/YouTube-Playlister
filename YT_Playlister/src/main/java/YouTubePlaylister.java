import java.util.List;

public class YouTubePlaylister {

    public List<YouTubeVideo> getVideosFromPlaylist(String playlist) {
        YouTubeAPI youTube = new YouTubeAPI(playlist);
        youTube.requestVideos();
        return youTube.getVideos();
    }

    public void saveVideosToFile(List<YouTubeVideo> videos, String file) {
        new PlaylistOutput().writeToJSON(videos, file);
        System.out.println("Playlist information successfully obtained! Output saved in \""+ file +"\".");
    }
}
