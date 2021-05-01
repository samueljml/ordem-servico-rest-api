package com.github.samueljml.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.samueljml.api.model.OrdemServicoInput;
import com.github.samueljml.api.model.OrdemServicoModel;
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
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico criar(@Valid @RequestBody OrdemServicoInput ordemServicoInput) {
		OrdemServico ordemServico = toEntity(ordemServicoInput);
		
		return ordemServicoService.criar(ordemServico);
	}
	
	@GetMapping
	public List<OrdemServicoModel> listar() {
		return toModel(ordemServicoRepo.findAll());
	}
	
	@GetMapping("/{ordemServicoId}")
	public ResponseEntity<OrdemServicoModel> buscar(@PathVariable Long ordemServicoId) {
		Optional<OrdemServico> ordemServico = ordemServicoRepo.findById(ordemServicoId);
		
		if(ordemServico.isPresent()) {
			OrdemServicoModel model = toModel(ordemServico.get());
			return ResponseEntity.ok(model);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{ordemServicoId}/finalizacao")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long ordemServicoId) {
		ordemServicoService.finalizar(ordemServicoId);
	}
	
	public OrdemServicoModel toModel(OrdemServico ordemServico) {
		return modelMapper.map(ordemServico, OrdemServicoModel.class);
	}
	
	public List<OrdemServicoModel> toModel(List<OrdemServico> ordensServico) {
		return ordensServico.stream()
			.map(ordemServico -> toModel(ordemServico))
			.collect(Collectors.toList());
	}
	
	private OrdemServico toEntity(OrdemServicoInput ordemServicoInput) {
		return modelMapper.map(ordemServicoInput, OrdemServico.class);
	}
}
