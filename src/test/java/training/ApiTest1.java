package training;

import Model.Product;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest1 {

    @Test
    public void getCategories(){
        String endPoint = "http://192.168.1.11/api_testing/category/read.php";
        var response = given().when().get(endPoint).then();
        response.log().body();
    }

    @Test
    public void getProduct(){
    String endpoint = "http://192.168.1.11/api_testing/product/read_one.php";
      var response =
                   given().
                            queryParam("id", 2).
                        when().
                            get(endpoint).
                        then().
                           assertThat().
                           statusCode(200).
                           body("id", equalTo("2")).
                           body("name",equalTo("Cross-Back Training Tank")).
                           body("description",equalTo("The most awesome phone of 2013!")).
                           body("price",equalTo("299.00")).
                           body("category_name",equalTo("Active Wear - Women"));
        //response.log().body();
    }

    @Test
    public void createProduct(){
        String endPoint = "http://192.168.1.11/api_testing/product/create.php";
        String body = """
                {
                "name" : "Water bottle1",
                "description" : "Blue green water bottle",
                "price" : 12,
                "category_id" : 3 
                }
                """;
        var response = given().body(body).when().post(endPoint).then();
        response.log().body();
    }

    @Test
    public void updateProduct(){
        String endPoint = "http://192.168.1.11/api_testing/product/update.php";
        String body = """
                {
                "id": 1001,
                "name" : "Water bottle1",
                "description" : "Blue green water bottle",
                "price" : 15,
                "category_id" : 3 
                }
                """;

       var response =  given().body(body).when().put(endPoint).then();
       response.log().body();
    }

    @Test
    public void deleteProduct(){
        String endPoint = "http://192.168.1.11/api_testing/product/delete.php";
        String body = """
                {
                "id": 1004
                }
                """;

        var response =  given().body(body).when().delete(endPoint).then();
        response.log().body();
    }

    @Test
    public void createSerializedProduct(){
        String endpoint = "http://192.168.1.11/api_testing/product/create.php";
        Product product = new Product("Bicycle","Blue Green Ladies bicycle",21,4);
        var response = given().body(product).when().post(endpoint).then();
        response.log().body();
    }

    @Test
    public void endToEndProductFlow(){
        String endpoint_create = "http://192.168.1.11/api_testing/product/create.php";
        String endpoint_get = "http://192.168.1.11/api_testing/product/read.php";
        String endpoint_update = "http://192.168.1.11/api_testing/product/update.php";
        String endpoint_delete = "http://192.168.1.11/api_testing/product/delete.php";

        var response = given().when().get(endpoint_get).then();
        response.log().body();
        Product prod_create = new Product("Sweatband","Anonymous Sweatband",15,3);
        given().body(prod_create).when().post(endpoint_create).then().log().body();
        Product prod_update = new Product(1006,"Sweatband","Anonymous Sweatband",16,1);
        given().body(prod_update).when().put(endpoint_update).then().log().body();
        Product prod_delete = new Product(1006);
        given().body(prod_delete).when().delete(endpoint_delete).then().log().body();
    }

    @Test
    public void deSerializedProduct() {
        String endpoint = "http://192.168.1.11/api_testing/product/read_one.php";
               given().
                  queryParam("id", 2).
               when().
               get(endpoint).
                  as(Product.class);
    }
}
