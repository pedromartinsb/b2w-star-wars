package br.com.pedrom.starwars.dto;

import java.io.Serializable;

import br.com.pedrom.starwars.domain.Planet;
import lombok.Data;

@Data
public class PlanetDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String climate;
    private String terrain;

    public PlanetDTO(){}

    public PlanetDTO(Planet planet) {
    	this.id = planet.getId();
    	this.name = planet.getName();
    	this.climate = planet.getClimate();
    	this.terrain = planet.getTerrain();
    }
    
}
