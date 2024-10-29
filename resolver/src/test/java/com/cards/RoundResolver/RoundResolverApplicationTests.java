package com.cards.RoundResolver;

import com.cards.RoundResolver.model.Round;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.ValidatableResponse;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class RoundResolverApplicationTests {
	@LocalServerPort
	private int port;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	void preTestSetup(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	@Test
	void basicGetTest(){
		ValidatableResponse res_0 = given().accept("*/*")
					.contentType("application/json")
				.when()
					.get("/round/test")
				.then()
					.statusCode(200)
					.assertThat()
					.contentType("application/json")
					.body("id", emptyOrNullString())
					.body("playerId", emptyOrNullString())
					.body("cardId", emptyOrNullString());
	}

	@Test
	void basicPostTest(){
		Round round = new Round();
		round.setPlayerId(42L);
		round.setPlayedCardId(13L);


		ValidatableResponse res_0 = given().accept("*/*")
				.contentType("application/json")
				.body(round)
				.when()
				.post("/round")
				.then()
				.statusCode(200)
				.assertThat()
				.contentType("application/json")
				.body("outcomeId", notNullValue());

		System.out.println(res_0);
	}
}
