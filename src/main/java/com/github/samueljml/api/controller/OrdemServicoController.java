package com.github.samueljml.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.samueljml.domain.model.service.OrdemServicoService;
import com.github.samueljml.domain.repository.OrdemServicoRepository;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepo;
	
	@Autowired
	private OrdemServicoService ordemServicoService;
}
