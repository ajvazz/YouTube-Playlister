import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.*;

import java.io.File;
import java.util.List;

public class RequestTest {

    private static List<YouTubeVideo> videos;

    @BeforeClass
    public static void setup() {
        Param.notTesting = false;
        videos = new YouTubePlaylister().getVideosFromPlaylist(Param.validPlaylist);
    }

    @AfterClass
    public static void tearDown() {
        Param.notTesting = true;
    }


    @Test
    public void validRequest() {
        YouTubeAPI api = new YouTubeAPI(Param.validPlaylist);
        Response response = api.requestVideos();
        response.then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void invalidRequest() {
        YouTubeAPI api = new YouTubeAPI(Param.invalidPlaylist);
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

    @Test
    public void correctLength() {
        Assert.assertEquals(149, videos.size());
    }
}
