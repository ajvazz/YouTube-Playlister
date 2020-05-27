import java.io.PrintWriter;
import java.util.List;

public class PlaylistOutput {

    public void write(List<YouTubeVideo> videos, String outputFile) {
        int itemNum = 1;
        try (PrintWriter file = new PrintWriter(outputFile, "UTF-8")) {
            file.println("{ \"playlistItems\": [");
            for (YouTubeVideo video : videos) {
                file.println();
                file.println("      \"item" + (itemNum++) + "\": {");
                file.println(video);
                file.println("      },");
            }
            file.println("      ]");
            file.println("}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
