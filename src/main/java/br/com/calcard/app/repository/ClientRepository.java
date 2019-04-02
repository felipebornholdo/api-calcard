package br.com.calcard.app.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.calcard.app.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
