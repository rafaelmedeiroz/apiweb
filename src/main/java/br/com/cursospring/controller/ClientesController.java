package br.com.cursospring.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.cursospring.model.Cliente;
import br.com.cursospring.service.ClienteService;



@RestController
public class ClientesController {
@Autowired
ClienteService clienteService;
//end points
@RequestMapping(method=RequestMethod.POST, value="/clientes", consumes=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		Cliente Clientecadastrado = clienteService.cadastrar(cliente);
		return new ResponseEntity<Cliente>(Clientecadastrado, HttpStatus.CREATED);
	}
//end points
@RequestMapping(method=RequestMethod.GET, value="/clientes", produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {
	Collection<Cliente> clientesBuscados = clienteService.buscarTodos();
	return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);
}
@RequestMapping(method=RequestMethod.GET, value="/clientes/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Integer id) {
	Cliente clientesencontrado = clienteService.buscarPorId(id);
	return new ResponseEntity<>(clientesencontrado, HttpStatus.OK);
}
//endpoint
@RequestMapping(method=RequestMethod.DELETE, value="/clientes/{id}")
public ResponseEntity<Cliente> exlcuirCliente(@PathVariable Integer id) {
		
		Cliente clienteEncontrado = clienteService.buscarPorId(id);
		
		if(clienteEncontrado==null) {
			//mensagem
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		clienteService.deletar(clienteEncontrado);
		return new ResponseEntity<>(HttpStatus.OK);
	}
//end points
@RequestMapping(method=RequestMethod.PUT, value="/clientes", consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {
		Cliente Clientealterado = clienteService.alterar(cliente);
		return new ResponseEntity<Cliente>(Clientealterado, HttpStatus.OK);
	}

}