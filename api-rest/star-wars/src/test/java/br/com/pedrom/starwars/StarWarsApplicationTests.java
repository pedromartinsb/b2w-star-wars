package br.com.pedrom.starwars;

import br.com.pedrom.starwars.controller.PlanetController;
import br.com.pedrom.starwars.domain.Planet;
import br.com.pedrom.starwars.services.PlanetService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(PlanetController.class)
class StarWarsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PlanetService planetService;

	Planet mockPlanet = Planet.builder()
			.id("1")
			.name("Name Alterado")
			.climate("Climate Alterado")
			.terrain("Terrain Alterado")
			.build();

	String examplePlanetJson = "{\"id\":\"2\",\"name\":\"Name Test\",\"climate\":\"Climate Test\",\"terrain\":\"Terrain Test\"}";

	@Test
	void contextLoads() {
	}

	@Test
	void retrieveDetailsForPlanet() throws Exception {
		Mockito.when(planetService.findById(Mockito.anyString())).thenReturn(mockPlanet);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/planets/1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:\"1\",name:\"Name Alterado\",climate:\"Climate Alterado\",terrain:\"Terrain Alterado\"}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

	@Test
	void createPlanet() throws Exception {
		Planet mockPlanet = Planet.builder()
				.id("2")
				.name("Name Test")
				.climate("Climate Test")
				.terrain("Terrain Test")
				.build();

		Mockito.when(planetService.create(Mockito.any(Planet.class))).thenReturn(mockPlanet);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/v1/planets")
				.accept(MediaType.APPLICATION_JSON)
				.content(examplePlanetJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost:8080/v1/planets/2",
				response.getHeader(HttpHeaders.LOCATION));
	}

}
