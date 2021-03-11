package br.com.pedrom.starwars.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.com.pedrom.starwars.feign.response.StarWarsSwapiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.pedrom.starwars.domain.Planet;
import br.com.pedrom.starwars.dto.PlanetDTO;
import br.com.pedrom.starwars.services.PlanetService;

@Slf4j
@RestController
@RequestMapping("/planets")
public class PlanetController {
	private PlanetService service;

    public PlanetController(PlanetService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<PlanetDTO>> findAll() {
        log.info("Iniciado findAll");
        List<Planet> planets = service.findAll();
        log.info("Sucesso findAll");
        List<PlanetDTO> listDTO = planets.stream().map(x -> new PlanetDTO(x)).collect(Collectors.toList());
        log.info("Fim findAll");
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanetDTO> findById(@PathVariable String id) {
        log.info("Iniciado findById");
        Planet planet = service.findById(id);
        log.info("Sucesso findById");
        log.info("Fim findById");
        return ResponseEntity.ok().body(new PlanetDTO(planet));
    }

    @PostMapping()
    public ResponseEntity<PlanetDTO> create(@RequestBody PlanetDTO planetDTO) {
        log.info("Iniciado create");
        Planet planet = service.fromDTO(planetDTO);
        PlanetDTO dto = new PlanetDTO(service.create(planet));
        log.info("Sucesso create");
        log.info("Fim create");
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanetDTO> update(@PathVariable String id, @RequestBody PlanetDTO planetDTO) {
        log.info("Iniciado update");
        Planet planet = service.fromDTO(planetDTO);
        planet.setId(id);
        PlanetDTO dto = new PlanetDTO(service.update(planet));
        log.info("Sucesso update");
        log.info("Fim update");
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Iniciado delete");
        service.delete(id);
        log.info("Sucesso delete");
        log.info("Fim delete");
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/films/{id}")
    public ResponseEntity<Object> getFilms(@PathVariable String id) {
        log.info("Iniciado getFilms");
        Object obj = service.getFilms(id);
        log.info("Sucesso getFilms");
        log.info("Fim getFilms");
        return ResponseEntity.ok().body(obj);
    }

}
