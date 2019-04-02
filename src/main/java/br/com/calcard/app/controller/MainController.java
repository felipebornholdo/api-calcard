package br.com.calcard.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.app.model.Client;
import br.com.calcard.app.model.Result;
import br.com.calcard.app.repository.ClientRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/demo")
public class MainController {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private Analyzer analyzer;

	@CrossOrigin(origins = "*")
	@ApiOperation(value = "Adiciona um novo cadastro.")
	@PostMapping(path = "/add")
	public Result addNewCliente(@RequestBody Client client) {

		Result result = analyzer.analyze(client);

		client.setResult(result);

		clientRepository.save(client);

		return result;
	}

	@CrossOrigin(origins = "*")
	@ApiOperation(value = "Lista todos os cadastrados.")
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Client> getAllClients() {
		return clientRepository.findAll();
	}
}
