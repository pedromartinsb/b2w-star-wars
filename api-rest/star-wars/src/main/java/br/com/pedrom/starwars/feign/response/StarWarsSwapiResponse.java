package br.com.pedrom.starwars.feign.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class StarWarsSwapiResponse {

    public String name;
    public String rotation_period;
    public String orbital_period;
    public String diameter;
    public String climate;
    public String gravity;
    public String terrain;
    public String surface_water;
    public String population;
    public List<String> residents;
    public List<String> films;
    public Date created;
    public Date edited;
    public String url;

}
