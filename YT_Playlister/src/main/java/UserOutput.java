import java.io.PrintWriter;
import java.util.LinkedHashMap;

public class UserOutput {

    public static void successMessage() {
        System.out.println();
        System.out.println(Param.GREEN + "Playlist information successfully obtained! Information saved in '"+ Param.outputPath +"'.");
    }

    public static void saveInfo() {
        try (PrintWriter file = new PrintWriter(Param.outputPath, "UTF-8")) {
            for (LinkedHashMap snippet : Param.snippets) {
                file.println(Param.separatorDouble + Param.separatorDouble);
                String separatorSingle = "--------------------------------------------------------------------------------------------------";
                file.println(); file.println();
                file.println("VIDEO TITLE: " + snippet.get("title"));
                file.println(separatorSingle + separatorSingle);
                file.println("UPLOADER: "    + snippet.get("channelTitle"));
                file.println(separatorSingle + separatorSingle);
                if (Param.description) {
                    file.println("DESCRIPTION: " + snippet.get("description"));
                    file.println(separatorSingle + separatorSingle);
                    file.println(); file.println();
                } if (Param.publishedAt) {
                    file.println("PUBLISHED AT: " + snippet.get("publishedAt"));
                    file.println(separatorSingle + separatorSingle);
                    file.println(); file.println();
                } if (Param.channelTitle) {
                    file.println("CHANNEL TITLE: " + snippet.get("channelTitle"));
                    file.println(separatorSingle + separatorSingle);
                    file.println(); file.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
