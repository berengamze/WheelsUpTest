package Tests;

import com.qa.wheelsupAPI.Api;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;
import java.io.IOException;


public class TestApi {

    @Test(priority=1,description = "Get data from the end point")
    void getResponseFromWheelsupEndPoint() throws IOException, JSONException {
    Api api= new Api();
    api.parseResponse();
    }

    @Test(priority = 2, description = "Get JSON response and parse") //verify social accounts, display the total number of values from the keys, removed fields")
    void getJsonResponseAndParseTest(JSONObject keys) throws IOException, JSONException {
        Api api= new Api();
        api.parseResponse();
    }
    @Test(priority = 3,description = "verify social accounts")
    void verifySocialAccountsTest() throws IOException {
        Api api= new Api();
        api.parseResponse();
        api.verifyTwitterAccount("twitter","https://twitter.com/WheelsUp");
        api.verifyInstagramAccount("instagram","http://instagram.com/wheelsup8760");
    }
    @Test(priority = 3,description = "remove fields and display")
    void removeAndDisplayEditedKeysTest() throws IOException, JSONException {
        Api api= new Api();
        api.removeAndDisplayEditedKeys(api.parseResponse());
    }
}