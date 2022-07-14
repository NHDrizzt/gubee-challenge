package resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@Tag("integration")
class ShowProductResourceTestIT {

    @Test
    void should_receive_json() {
        JsonObject jsonObject =
                Json.createObjectBuilder()
                        .add("id", 1)
                        .add("name", "test")
                        .build();
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonObject.toString())
                .when()
                .post("/showProduct/listTest")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }
}
