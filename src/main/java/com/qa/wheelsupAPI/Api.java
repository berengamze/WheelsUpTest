package com.qa.wheelsupAPI;

import org.json.JSONException;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;
import static io.restassured.RestAssured.given;

public class Api {
    Response response;
    public void getResponse() throws IOException, JSONException {
        RestAssured.baseURI = ("https://wheelsup.com/_mock_/initial-data.json");
        response = given().headers(
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .get("https://wheelsup.com/_mock_/initial-data.json")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        response.prettyPrint();
    }
    public JSONObject parseResponse() throws IOException {
        String inline = "";
        URL url = new URL("https://wheelsup.com/_mock_/initial-data.json");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if(responsecode != 200)
            throw new RuntimeException("HttpResponseCode:"+responsecode);
        else
        {
            Scanner sc = new Scanner(url.openStream());
            while(sc.hasNext())
            {
                inline += sc.nextLine();
            }
            System.out.println("\\nJSON data in string format");
            System.out.println(inline);
            sc.close();
        }

        JSONObject json = new JSONObject(inline);
        System.out.println(json.toString());
        String keys = json.getString("keys");
        System.out.println(keys);
        JSONObject jsonKeys = new JSONObject(keys);
        return jsonKeys;
    }
    public void verifyTwitterAccount( String account,String expectedResult ) throws IOException {
        JSONObject keys = parseResponse();
         account = keys.getString("twitter");
        System.out.println(account);
        try {
            Assert.assertEquals(account, expectedResult);
        }catch (Exception e){
            System.out.println("Assertion failed.");
        }
    }

    public void verifyInstagramAccount( String account,String expectedResult ) throws IOException {
        JSONObject keys = parseResponse();
        account = keys.getString("instagram");
        System.out.println(account);
        try {
            Assert.assertEquals(account, expectedResult);
        }catch (Exception e){
            System.out.println("Assertion failed.");
        }
    }
    public void removeAndDisplayEditedKeys(JSONObject keys) throws IOException, JSONException {
        System.out.println("Number of the keys fields: "+keys.length());
        keys.remove("google_tag_manage");
        keys.remove("mapbox_accesstoken");
        keys.remove("footer_disclaimer");
        System.out.println("Number of the keys fields: "+keys.length());
        keys.put("email","abc123@gmail.com");
        System.out.println(keys.toString());
    }
    }

