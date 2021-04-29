package com.github.samueljml.domain.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.samueljml.domain.model.Cliente;
import com.github.samueljml.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepo.save(cliente);
	}
	
	public void excluir(Long clienteId) {
		clienteRepo.deleteById(clienteId);
	}
}