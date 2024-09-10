package org.cards.ongoinground.clients;

import lombok.extern.slf4j.Slf4j;
import org.cards.ongoinground.dtos.RecorderDTO;
import org.cards.ongoinground.model.OutcomeR;
import org.cards.ongoinground.model.RoundR;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class RecorderClient {

    private final String restServiceUrl;
    private final RestTemplate restTemplate;

    public RecorderClient(
            RestTemplateBuilder restTemplateBuilder,
            @Value("http://localhost:8082") final String url
    ) {
        this.restTemplate = restTemplateBuilder.build();
        this.restServiceUrl = url;
    }

    public String record(RoundR round, OutcomeR outcome) {
        String url = restServiceUrl + "/record";
        String response = null;

        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            RecorderDTO record = new RecorderDTO(round, outcome);

            response = restTemplate.postForObject(url, record, String.class);

        }
        catch(Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
        log.info("Added round");

        return response;
    }
}
