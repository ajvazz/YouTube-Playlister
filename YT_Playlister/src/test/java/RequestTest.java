import io.restassured.response.Response;
import org.junit.Test;

public class RequestTest {

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

}
