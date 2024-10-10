package org.cards.ongoinground.clients;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cards.ongoinground.dtos.OutcomeDTO;
import org.cards.ongoinground.model.RoundR;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class RoundClient {

    // GET /round/test
    // -> Outcome

    private final String restServiceUrl;
    private final RestTemplate restTemplate;

    public RoundClient(
            RestTemplateBuilder restTemplateBuilder,
            @Value("${round.client.host}") final String url
    ){
        this.restTemplate = restTemplateBuilder.build();
        this.restServiceUrl = url;
    }

    public OutcomeDTO externalResolve(){
        String url = restServiceUrl + "/round/test";
        ResponseEntity<OutcomeDTO> response = null;
        try {
            response = restTemplate.getForEntity(url, OutcomeDTO.class);
        }
        catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
        return response.getBody();
    }

    public OutcomeDTO externalPostSolver(RoundR round){
        String url = restServiceUrl + "/round";
        //ResponseEntity<OutcomeDTO> response = null;
        OutcomeDTO response = null;

        try {
            HttpHeaders header = new HttpHeaders();
            header.setContentType(MediaType.APPLICATION_JSON);

            log.info("Round: " + round.toString());

            HttpEntity<String> entity = new HttpEntity<String>(round.toString(), header);
            //response = restTemplate.postForObject(url, entity, OutcomeDTO.class);
            response = restTemplate.postForObject(url, round, OutcomeDTO.class);
        }
        catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }

        log.info("Well I'm here, and not crashing");
        log.warn("Response: " + response.getOutcomeText());
        return response;
    }
}
