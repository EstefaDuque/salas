package co.com.salas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sala {
	
	@Id
    private String id;
	
	private String bloque;
	private int piso;
	private String capacidad;
	private String nombreSala;
	private float horasDisponible;

}
