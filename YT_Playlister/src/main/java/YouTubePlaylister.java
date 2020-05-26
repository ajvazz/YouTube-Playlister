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
            //            for (LinkedHashMap snippet : Param.snippets) {
//                file.println(Param.separatorDouble + Param.separatorDouble);
//                String separatorSingle = "--------------------------------------------------------------------------------------------------";
//                file.println(); file.println();
//                file.println("VIDEO TITLE: " + snippet.get("title"));
//                file.println(separatorSingle + separatorSingle);
//                file.println("CHANNEL TITLE: "    + snippet.get("channelTitle"));
//                file.println(separatorSingle + separatorSingle);
//                if (Param.description) {
//                    file.println("DESCRIPTION: " + snippet.get("description"));
//                    file.println(separatorSingle + separatorSingle);
//                    file.println(); file.println();
//                } if (Param.publishedAt) {
//                    file.println("PUBLISHED AT: " + snippet.get("publishedAt"));
//                    file.println(separatorSingle + separatorSingle);
//                    file.println(); file.println();
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println(Param.GREEN + "Playlist information successfully obtained! Output saved in '"+ Param.outputPath +"'.");
    }
}
