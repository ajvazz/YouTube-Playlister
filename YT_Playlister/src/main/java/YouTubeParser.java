import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class YouTubeParser {

    public String parseID(String playlist) {
        if (playlist.contains("https://www.youtube.com/"))
            return playlist.substring(playlist.indexOf("list=") + 5);
        else return playlist;
    }

    public List<YouTubeVideo> getNext50Videos(ArrayList<LinkedHashMap> snippets) {
        List<YouTubeVideo> videos = new ArrayList<>();
        for (LinkedHashMap snippet : snippets) {
            String title = snippet.get("title").toString();
            String description = snippet.get("description").toString();
            String publishedAt = snippet.get("publishedAt").toString();
            YouTubeVideo video = new YouTubeVideo(title, description, publishedAt);
            videos.add(video);
        }
        return videos;
    }
}
