public class App {

    public static void main(String[] args) {
        // args[1] = playlistId, url
        // args[2] = output file

        
        RequestController c = new RequestController();
        c.getPlaylistInfo();
    }
}