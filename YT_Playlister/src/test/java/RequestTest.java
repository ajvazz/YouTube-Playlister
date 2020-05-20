import com.google.api.services.youtube.model.PlaylistItem;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

public class RequestTest {

    private static String validRequest = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&regionCode=us&key=AIzaSyDciUo9L8xywPEvPqvMsLfsMIdHjNFo73I&playlistId=PLQ9sFiNxsP2GnltE3MA7-Imx9Mz03HXzl&maxResults=50";
    private static String invalidRequest = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&regionCode=us&key=AIzaSyDciUo9L8xywPEvPqvMsLfsMIdHjNFo73I&playlistId=PLQ9sP2GnltE3MA7-Imx9Mz03HXzl&maxResults=50";

    @Test
    public void validRequest() {
        Playlister.request = validRequest;
        Response response = Playlister.sendRequest();
        response.then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void invalidRequest() {
        Playlister.request = invalidRequest;
        Response response = Playlister.sendRequest();
        response.then().
                assertThat().
                statusCode(404);
    }

}
