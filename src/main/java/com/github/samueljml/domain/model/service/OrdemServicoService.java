package com.github.samueljml.domain.model.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.samueljml.domain.exception.NegocioException;
import com.github.samueljml.domain.model.Cliente;
import com.github.samueljml.domain.model.OrdemServico;
import com.github.samueljml.domain.model.StatusOrdemServico;
import com.github.samueljml.domain.repository.ClienteRepository;
import com.github.samueljml.domain.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {
	
	@Autowired
	private OrdemServicoRepository OrdemServicoRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		Cliente cliente = clienteRepo.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
		
		ordemServico.setCliente(cliente);
		ordemServico.setDataAbertura(LocalDateTime.now());
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		return OrdemServicoRepo.save(ordemServico);
	}
	
}
