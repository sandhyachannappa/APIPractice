package GoogleMapAPITests;

import GoogleMapAPITests.pojo.AddAPIRequest;
import GoogleMapAPITests.pojo.Location;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

public class AddPlaceAPI {

    public static void main(String[] args){

        AddAPIRequest add=new AddAPIRequest();
        add.setAccuracy(50);
        add.setName("Frontline house");
        add.setPhone_number("(+91) 983 893 3937");
        add.setAddress("29, side layout, cohen 09");
        List<String> types=new ArrayList<>();
        types.add("shoe park");
        types.add("shop");
        add.setTypes(types);
        add.setWebsite("http://google.com");
        add.setLanguage("French-IN");
        Location loc=new Location();
        loc.setLat("-38.383494");
        loc.setLng("33.427362");
        add.setLocation(loc);


//     RequestSpecification request= new RequestSpecBuilder().
//                setBaseUri("https://rahulshettyacademy.com").
//                addQueryParam("key","qaclick123").
//                setContentType(ContentType.JSON).build();
//
//    ResponseSpecification responseSpec=new ResponseSpecBuilder().
//            expectStatusCode(200).build();
//
//     RequestSpecification addRequest=given().spec(request).body(add);
//
//     Response res=addRequest.when().post("/maps/api/place/add/json").
//             then().spec(responseSpec).extract().response();
//
//
//     String responseString= res.asString();
//        System.out.println(responseString);

        RestAssured.baseURI="https://rahulshettyacademy.com";


given().contentType(ContentType.JSON).
        queryParam("key","qaclick123").body(add).
        when().post("/maps/api/place/add/json").
        then()
        .assertThat().statusCode(200).body("status",equalTo("OK"));

    }
}
