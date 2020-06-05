import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.*;

import java.io.File;
import java.util.List;

public class RequestTest {

    private static List<YouTubeVideo> videos;
    private static final String validPlaylist    = "https://www.youtube.com/playlist?list=PL7DA3D097D6FDBC02";
    private static final String invalidPlaylist  = "https://www.youtube.com/playlist?list=PL7DA3DD6FDBC02";

    @BeforeClass
    public static void setup() {
        YouTubeAPI.notTesting = false;
        videos = new YouTubePlaylister().getVideosFromPlaylist(validPlaylist);
    }

    @AfterClass
    public static void tearDown() {
        YouTubeAPI.notTesting = true;
    }


    @Test
    public void validRequest() {
        YouTubeAPI api = new YouTubeAPI(validPlaylist);
        Response response = api.requestVideos();
        response.then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void invalidRequest() {
        YouTubeAPI api = new YouTubeAPI(invalidPlaylist);
        Response response = api.requestVideos();
        response.then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    public void outputFileCreated() {
        final String outputFile = "output.json";
        new YouTubePlaylister().saveVideosToFile(videos, outputFile);
        Assert.assertTrue(new File(outputFile).exists());
    }

    @Test
    public void outputFileNotEmpty() {
        final String outputFile = "output.json";
        new YouTubePlaylister().saveVideosToFile(videos, outputFile);
        Assert.assertNotEquals(new File(outputFile).length(), 0);
    }

    // NOTE: there will either be 150, or 149. Observed that one song often gets taken down and uploaded again.
    @Test
    public void correctLength() {
        Assert.assertEquals(150, videos.size());
    }
}
