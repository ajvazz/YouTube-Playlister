import java.io.PrintWriter;
import java.util.List;

public class PlaylistOutput {

    public void writeToJSON(List<YouTubeVideo> videos, String outputFile) {
        try (PrintWriter file = new PrintWriter(outputFile, "UTF-8")) {
            file.println("{ \"playlistItems\": {");
            file.println();
            file.println("      \"size\": " + videos.size() + ",");
            file.println();
            file.println("      \"items\": [");
            for (int i=0; i < videos.size(); i++) {
                file.println();
                file.println("      {");
                file.println(videos.get(i));
                if (i != videos.size()-1)
                    file.println("      },");
                else
                    file.println("      }");
            }
            file.println("  ]");
            file.println("  }");
            file.println("}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
