package br.com.pedrom.starwars.feign.service;

import br.com.pedrom.starwars.config.FromUrlEncodedClientConfiguration;
import br.com.pedrom.starwars.feign.response.StarWarsSwapiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "apiStarWarsSwapi", url = "${service.StarWarsSwapi.url}", configuration = FromUrlEncodedClientConfiguration.class)
public interface APIStarWarsSwapiService {

    @RequestMapping(value = "/planets/{id}/", method = RequestMethod.GET)
    StarWarsSwapiResponse getFilms(@PathVariable("id") String id);

}
