package org.cards.recorder;

import io.restassured.response.ValidatableResponse;
import org.cards.recorder.dtos.RecorderDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.test.RabbitListenerTest;
import org.springframework.amqp.rabbit.test.RabbitListenerTestHarness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.given;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@RabbitListenerTest
class RecorderApplicationTests {
    @LocalServerPort
    private int port;

    @Autowired
    private RabbitListenerTestHarness rabbitListenerTestHarness;

    @Test
    void contextLoads() {
    }

    @BeforeEach
    void preTestSetup(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void receiveMsgTest(){
        String message = "message";


    }

    @Test
    void addSomeRecord(){
        RecorderDTO recorderDTO = new RecorderDTO();
        recorderDTO.setRecordId(42L);
        recorderDTO.setPlayedCardId(13L);
        recorderDTO.setOutcomeId(13L);
        recorderDTO.setRoundId(13L);
        recorderDTO.setWinningPlayerId(13L);
        recorderDTO.setOutcomeText("All lucky 13s");

        ValidatableResponse res_0 =
                given().accept("*/*")
                        .contentType("application/json")
                        .body(recorderDTO)
                        .when()
                        .post("/record")
                        .then()
                        .statusCode(200);
        System.out.println(res_0);
    }

}
