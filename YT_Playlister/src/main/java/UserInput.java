import java.util.Scanner;

public class UserInput {

    public static void getParameters() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print(Param.RED + "[REQUIRED]" + Param.RESET + " Please enter YT playlist link, or enter playlist ID: ");
            parseInput(sc);
            System.out.print(Param.RED + "[REQUIRED]" + Param.RESET + " Please enter where you want to save the output (example: 'myPlaylist.txt'): ");
            Param.outputPath = sc.nextLine();
            System.out.println(Param.CYAN + "[OPTIONAL]" + Param.RESET + " Enter additional information you want to be displayed, or enter \"skip\". Separate with comma.");
            System.out.print(Param.YELLOW + "(Available: \"videoDescription\", \"datePublished\"): " + Param.RESET);
            parseAdditionalInformation(sc);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void parseInput(Scanner sc) {
        String input = sc.nextLine().trim();
        try {
            if (input.contains("https://www.youtube.com/"))  // It's a link
                Param.playlistId = input.substring(input.indexOf("list=") + 5);
            else
                Param.playlistId = input;        // It's an ID
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Wrong playlist link!");
            System.exit(1);
        }
    }

    private static void parseAdditionalInformation(Scanner sc) {
        String response = sc.nextLine().trim();
        if (response.equalsIgnoreCase("skip"))
            return;
        for (String s : response.split(","))
            resolveInfo(s.trim());
    }

    private static void resolveInfo(String info) {
        if (info.equalsIgnoreCase("datePublished"))
            Param.publishedAt = true;
        else if (info.equalsIgnoreCase("videoDescription"))
            Param.description = true;
        else {
            System.err.println("Error! Unknown information: '" + info + "'! Please start program again.");
            System.exit(1);
        }
    }
}
