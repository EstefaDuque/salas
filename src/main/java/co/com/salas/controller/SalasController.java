package co.com.salas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.com.salas.model.Sala;
import co.com.salas.repositorio.RepositorioSalas;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpStatus;

@RestController
@AllArgsConstructor
@RequestMapping("/salas")
public class SalasController {

	RepositorioSalas repository;

	@GetMapping
	public Flux<Sala> getAllSalas() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public Mono<Sala> getSalas(@PathVariable String id) {
		return repository.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Sala> saveSala(@RequestBody Sala sala) {
		return repository.save(sala);
	}

}
