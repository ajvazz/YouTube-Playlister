import java.io.PrintWriter;
import java.util.LinkedHashMap;

public class UserOutput {

    public static void displayInfo() {
        System.out.println();
        for (LinkedHashMap snippet : Param.snippets) {
            System.out.println(Param.separatorDouble);
            System.out.println("VIDEO TITLE: " + snippet.get("title"));
            System.out.println("UPLOADER: " + snippet.get("channelTitle"));
        } System.out.println(Param.separatorDouble);
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
                file.println("DESCRIPTION: " + snippet.get("description"));
                file.println(); file.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
