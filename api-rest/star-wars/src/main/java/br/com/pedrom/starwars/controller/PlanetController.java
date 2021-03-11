package br.com.pedrom.starwars.controller;

import br.com.pedrom.starwars.domain.Planet;
import br.com.pedrom.starwars.dto.PlanetDTO;
import br.com.pedrom.starwars.services.PlanetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Api(tags = "PlanetEndpoint")
@RequestMapping("/v1/planets")
public class PlanetController {
	private PlanetService service;

    public PlanetController(PlanetService service) {
        this.service = service;
    }

    @GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
    @ApiOperation(value = "Find all planets" )
    @Cacheable(value = "listOfPlanets")
    public ResponseEntity<List<PlanetDTO>> findAll() {
        log.info("Iniciado findAll");
        List<Planet> planets = service.findAll();
        log.info("Sucesso findAll");
        List<PlanetDTO> listDTO = planets.stream().map(x -> new PlanetDTO(x)).collect(Collectors.toList());
        log.info("Fim findAll");
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/paged", produces = { "application/json", "application/xml", "application/x-yaml" })
    @ApiOperation(value = "Find all planets" )
    @Cacheable(value = "listOfPlanetsPaged")
    public ResponseEntity<Page<Planet>> findAllPaged(@PageableDefault(
                            sort = "id",
                            direction = Sort.Direction.DESC,
                            page = 0, size = 10) Pageable paginacao) {
        log.info("Iniciado findAllPaged");
        Page<Planet> planets = service.findAllPaged(paginacao);
        log.info("Sucesso findAllPaged");
        log.info("Fim findAllPaged");
        return ResponseEntity.ok().body(planets);
    }

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
    @ApiOperation(value = "Find a specific planet by your ID" )
    public ResponseEntity<PlanetDTO> findById(@PathVariable String id) {
        log.info("Iniciado findById");
        Planet planet = service.findById(id);
        log.info("Sucesso findById");
        log.info("Fim findById");
        return ResponseEntity.ok().body(new PlanetDTO(planet));
    }

    @GetMapping(value = "/name", produces = { "application/json", "application/xml", "application/x-yaml" })
    @ApiOperation(value = "Find a specific planet by your NAME" )
    public ResponseEntity<PlanetDTO> findByName(@RequestParam String name) {
        log.info("Iniciado findByName");
        Planet planet = service.findByName(name);
        log.info("Sucesso findByName");
        log.info("Fim findByName");
        return ResponseEntity.ok().body(new PlanetDTO(planet));
    }

    @PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" },
            consumes = { "application/json", "application/xml", "application/x-yaml" })
    @ApiOperation(value = "Create a new planet")
    @Transactional
    @CacheEvict(value = "listOfPlanets", allEntries = true)
    public ResponseEntity<PlanetDTO> create(@RequestBody PlanetDTO planetDTO) {
        log.info("Iniciado create");
        Planet planet = service.fromDTO(planetDTO);
        PlanetDTO dto = new PlanetDTO(service.create(planet));
        log.info("Sucesso create");
        log.info("Fim create");
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" },
            consumes = { "application/json", "application/xml", "application/x-yaml" })
    @ApiOperation(value = "Update a specific planet")
    @Transactional
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
    @Transactional
    @CacheEvict(value = "listOfPlanets", allEntries = true)
    @ApiOperation(value = "Delete a specific planet by your ID")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Iniciado delete");
        service.delete(id);
        log.info("Sucesso delete");
        log.info("Fim delete");
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/films/{id}")
    @ApiOperation(value = "Find how many films the specific planet appers")
    public ResponseEntity<Object> getFilms(@PathVariable String id) {
        log.info("Iniciado getFilms");
        Object obj = service.getFilms(id);
        log.info("Sucesso getFilms");
        log.info("Fim getFilms");
        return ResponseEntity.ok().body(obj);
    }

}
