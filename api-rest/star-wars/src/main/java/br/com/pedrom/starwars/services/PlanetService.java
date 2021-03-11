package br.com.pedrom.starwars.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.pedrom.starwars.dto.PlanetDTO;
import br.com.pedrom.starwars.feign.response.StarWarsSwapiResponse;
import br.com.pedrom.starwars.feign.service.APIStarWarsSwapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedrom.starwars.domain.Planet;
import br.com.pedrom.starwars.repository.PlanetRepository;
import br.com.pedrom.starwars.services.exceptions.ObjectNotFoundException;

@Service
public class PlanetService {
	private PlanetRepository repository;
	private APIStarWarsSwapiService apiStarWarsSwapi;

    public PlanetService(PlanetRepository repository, APIStarWarsSwapiService apiStarWarsSwapi) {
        this.repository = repository;
        this.apiStarWarsSwapi = apiStarWarsSwapi;
    }

    public List<Planet> findAll() {
        return repository.findAll();
    }

    public Planet findById(String id) {
        Optional<Planet> planet = repository.findById(id);
        return planet.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public Planet create(Planet planet){
        return repository.save(planet);
    }

    public Planet update(Planet planet) {
        Optional<Planet> updatePlanet = repository.findById(planet.getId());
        return updatePlanet.map(u -> repository.save(new Planet(u.getId(), planet.getName(), planet.getClimate(), planet.getTerrain())))
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public Planet fromDTO(PlanetDTO planetDTO) {
        return new Planet().builder()
                .id(planetDTO.getId())
                .name(planetDTO.getName())
                .climate(planetDTO.getClimate())
                .terrain(planetDTO.getTerrain())
                .build();
    }

    public Object getFilms(String id) {
        StarWarsSwapiResponse response = apiStarWarsSwapi.getFilms(id);
        Planet planet = findById(id);

        Map<Object, Object> model = new HashMap<>();
        model.put("id", planet.getId());
        model.put("name", planet.getName());
        model.put("films", response.getFilms().size());
        return model;
    }

}
