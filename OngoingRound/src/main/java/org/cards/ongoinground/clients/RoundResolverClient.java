package org.cards.ongoinground.clients;

import lombok.extern.slf4j.Slf4j;
import org.cards.ongoinground.dtos.OutcomeDTO;
import org.cards.ongoinground.model.RoundR;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class RoundResolverClient {

    private final RestTemplate restTemplate;
    private final String resolverServiceUrl;

    public RoundResolverClient(
            RestTemplateBuilder builder,
            @Value("http://localhost:8080") final String resolverServiceUrl
    ){
        this.restTemplate= builder.build();
        this.resolverServiceUrl = resolverServiceUrl;
    }

    public OutcomeDTO remoteSolve(RoundR round){
        // contact Resolver - send round. get outcome
        String callUrl = resolverServiceUrl + "/round/test";

        ResponseEntity<OutcomeDTO> response = restTemplate.getForEntity(callUrl, OutcomeDTO.class);

        try {
            //response = restTemplate.postForEntity(callUrl, round, OutcomeDTO.class);
            response = restTemplate.getForEntity(callUrl, OutcomeDTO.class);
        }
        catch (Exception e){
            log.error(e.getMessage());
            return null;
        }

        return response.getBody();
    }
}


