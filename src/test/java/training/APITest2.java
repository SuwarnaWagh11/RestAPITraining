package training;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Map;

import io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class APITest2 {

    /* Q. De-serialize the response to a container with a generic type
     * this test won't be passed bcoz the json we are getting as a object and not as array or something.
     * hence we are getting .MismatchedInputException: Cannot deserialize value.
     * But we can see how we can use the deserialized response and validate that.
     */
    //@Test
    public void example3_DeserializeTheResponseWithGenericType(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        String endpoint = "http://192.168.1.11/api_testing/product/read.php";
        List<Map<String, Object>> records = given().get(endpoint).as(new TypeRef<List<Map<String, Object>>>() {});
        assertThat(records, hasSize(2));
        assertThat(records.get(0).get("id"), equalTo(2));
        assertThat(records.get(0).get("name"), equalTo("An ice sculpture"));
        assertThat(records.get(0).get("price"), equalTo(12.5));
        assertThat(records.get(1).get("id"), equalTo(3));
        assertThat(records.get(1).get("name"), equalTo("A blue mouse"));
        assertThat(records.get(1).get("price"), equalTo(25.5));
    }
    // EXAMPLE 3 -  Complex parsing and validation
    /*
     * Q. Print the name,id with a price less than 15 are "Sayings of the Century" and "Moby Dick"
     * Q. Assert that the id with a price = 99 is "","",""...
     * Q. Assert that the sum of the length of all names are greater than 10
     */
    @Test
    public void example3_PrintTheNameIdWithPriceLessThan15(){
        String endpoint = "http://192.168.1.11/api_testing/product/read.php";
        given().
        when().get(endpoint).
        then().
                body("records.findAll {it.price == '99.00'}.id", hasItems("1") ).//.log().body();
                body("records.findAll {it.name == 'Bamboo Thermal Ski Coat'}.price", hasItem("99.00")).
                body("records.name*.length().sum()", greaterThan(8));
        //[2,3]
        String  response =  given().when().get(endpoint).asString();
        List<String> prices = from(response).getList("records.findAll {it.name == 'Bamboo Thermal Ski Coat' }.price");
        List<Integer> id = from(response).getList("records.findAll {it.price == '99.00' }.id");

        System.out.print(id + "\n" + prices + "\n" + 1);

    }

    /*  EXAMPLE 1
    * This test will not work as it is just an example to
    * show how can we validate the schema of the Product using located in the classpath as products-schema.json
     */
    //@Test
    public void example1_Schemavalidation(){
        String endpoint = "http://192.168.1.11/api_testing/product/read.php";
        var response = given().get(endpoint).then().assertThat().body(matchesJsonSchemaInClasspath("products-schema.json"));
     //or
        String json = String.valueOf(response);//some response in json string format
      //  given().get(endpoint).then().assertThat(json, matchesJsonSchemaInClasspath("product-schema.json"));
    }

    /*
    *Below test seems working same for is() & equalTo(). Why?
    * According to the Docs, is(Object obj) is just a shortcut for is(equalTo(Object obj)), where you can use is to compose more expressive matchers
    * More sophisticated way, is() decorates another Matcher, retaining its behaviour, but allowing tests to read slightly more like an English phrase.
    * assertThat(cheese, is(equalTo(smelly)))
    * instead of:
    * assertThat(cheese, equalTo(smelly))
    */
    @Test
    public void example1_readProductPriceAsBigDecimal(){
        String endpoint = "http://192.168.1.11/api_testing/product/read.php";
        var response = given().when().get(endpoint).then().
                assertThat().statusCode(200).
                body("records.id[0]", equalTo("1013")).
                body("records.price[0]", is("21.00"));
               // body("records.price[0]", is(new BigDecimal(12.00)));
        response.log().body();
    }
    @Test
    public void example1_readProduct(){
        String endpoint = "http://192.168.1.11/api_testing/product/read.php";
        var response = given().when().get(endpoint).then().
                assertThat().statusCode(200).
                body("records.id[0]", equalTo("1013")).
                body("records.id", hasItems("1013", "1009", "1012","1","2","3","4"));
        response.log().body();
    }
    @Test
    public void example1_readCategory(){
        String endpoint = "http://192.168.1.11/api_testing/category/read.php";
        var response = given().when().get(endpoint).then().
                assertThat().statusCode(200).
                body("records.id[0]", equalTo("1")).
                body("records.id", hasItems("1","2","3","4"));
        response.log().body();
    }
}
