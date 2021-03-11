package br.com.pedrom.starwars.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Document()
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Planet implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String climate;
    private String terrain;
}
