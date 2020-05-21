import java.util.Scanner;

public class UserInput {

    public static void getParameters() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Please enter YT playlist link, or enter playlist ID: ");
            parseInput(sc);
            System.out.print("Please enter where you want to save the output (example: 'myPlaylist.txt'): ");
            Param.outputPath = sc.nextLine();
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
}
