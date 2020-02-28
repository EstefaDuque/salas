package co.com.salas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.com.salas.model.Sala;
import co.com.salas.repositorio.RepositorioSalas;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
    @Bean
    CommandLineRunner init(RepositorioSalas repo) {
    	return args -> {
    		Flux<Sala> salas = Flux.just(
    				Sala.builder().bloque("A1").piso(2).capacidad("35").nombreSala("Colombia").horasDisponible(10).build(),
    				Sala.builder().bloque("A2").piso(2).capacidad("40").nombreSala("Argentina").horasDisponible(20).build(),
    				Sala.builder().bloque("A3").piso(2).capacidad("45").nombreSala("Brasil").horasDisponible(30).build()
    		).flatMap(repo::save);
    	
    	salas.thenMany(repo.findAll())
    		.subscribe(System.out::println);
    	};
    }
}
