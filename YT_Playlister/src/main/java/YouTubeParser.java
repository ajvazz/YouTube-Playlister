import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class YouTubeParser {

    public String parseID(String playlist) {
        if (playlist.contains("https://www.youtube.com/"))  // It's a link
            return playlist.substring(playlist.indexOf("list=") + 5);
        else
            return playlist;        // It's an ID
    }

    public List<YouTubeVideo> getNext50Videos(ArrayList<LinkedHashMap> snippets) {
        List<YouTubeVideo> videos = new ArrayList<>();

        for (LinkedHashMap snippet : snippets) {
            String title = snippet.get("title").toString();
            String description = snippet.get("description").toString();
            String publishedAt = snippet.get("publishedAt").toString().substring(0, 10);

            YouTubeVideo video = new YouTubeVideo(title, description, publishedAt);
            videos.add(video);
        }

        return videos;
    }
}
