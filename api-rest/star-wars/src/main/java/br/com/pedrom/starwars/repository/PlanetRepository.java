package br.com.pedrom.starwars.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.pedrom.starwars.domain.Planet;

@Repository
public interface PlanetRepository extends MongoRepository<Planet,String> {
	
	Optional<Planet> findByName(String name);

}
