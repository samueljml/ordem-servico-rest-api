package com.github.samueljml.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.samueljml.domain.model.OrdemServico;
import com.github.samueljml.domain.model.service.OrdemServicoService;
import com.github.samueljml.domain.repository.OrdemServicoRepository;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepo;
	
	@Autowired
	private OrdemServicoService ordemServicoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico criar(@RequestBody OrdemServico ordemServico) {
		return ordemServicoService.criar(ordemServico);
	}
}
