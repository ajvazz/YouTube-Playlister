import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class RequestTest {

    @BeforeClass
    public static void turnOnTesting() {
        Param.notTesting = false;
    }
    @AfterClass
    public static void turnOffTesting() {
        Param.notTesting = true;
    }


    @Test
    public void validRequest() {
        Param.request = Param.validRequest;
        Response response = RequestController.sendRequest();
        response.then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void invalidRequest() {
        Param.request = Param.invalidRequest;
        Response response = RequestController.sendRequest();
        response.then().
                assertThat().
                statusCode(404);
    }

    @Test
    public void accurateResponse() {

    }

}
