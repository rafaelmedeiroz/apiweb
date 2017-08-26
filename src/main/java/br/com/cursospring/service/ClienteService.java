'package br.com.cursospring.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursospring.model.Cliente;
import br.com.cursospring.repository.ClienteRepository;
@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	
	
	//business
	//Add
	public Cliente cadastrar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	//List
	public Collection<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	//Remove
	public void deletar(Cliente cliente) {
		
		clienteRepository.delete(cliente);
		}
	//alter
	public Cliente buscarPorId(Integer id) {
		
		return clienteRepository.findOne(id);
	}
	
	public Cliente alterar(Cliente cliente) {
		
		
		return clienteRepository.save(cliente);
	}


}
