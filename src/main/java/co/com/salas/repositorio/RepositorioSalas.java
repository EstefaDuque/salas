package co.com.salas.repositorio;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import co.com.salas.model.Sala;

public interface RepositorioSalas extends ReactiveMongoRepository<Sala, String>{

}
