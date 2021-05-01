package com.github.samueljml.domain.model.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.samueljml.domain.exception.EntidadeNaoEncontradaException;
import com.github.samueljml.domain.exception.NegocioException;
import com.github.samueljml.domain.model.Cliente;
import com.github.samueljml.domain.model.Comentario;
import com.github.samueljml.domain.model.OrdemServico;
import com.github.samueljml.domain.model.StatusOrdemServico;
import com.github.samueljml.domain.repository.ClienteRepository;
import com.github.samueljml.domain.repository.ComentarioRepository;
import com.github.samueljml.domain.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired 
	private ComentarioRepository comentarioRepo;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		Cliente cliente = clienteRepo.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
		
		ordemServico.setCliente(cliente);
		ordemServico.setDataAbertura(OffsetDateTime.now());
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		return ordemServicoRepo.save(ordemServico);
	}
	
	public void finalizar(Long ordemServicoId) {
		OrdemServico ordemServico = buscar(ordemServicoId);
		
		ordemServico.finalizar();
		
		ordemServicoRepo.save(ordemServico);
	}
	
	public Comentario adicionarComentario(Long ordemServicoId, String descricao) {
		OrdemServico ordemServico = buscar(ordemServicoId);
		
		Comentario comentario = new Comentario();
		comentario.setDataEnvio(OffsetDateTime.now());
		comentario.setDescricao(descricao);
		comentario.setOrdemServico(ordemServico);
	
		return comentarioRepo.save(comentario);
	}
	
	private OrdemServico buscar(Long ordemServicoId) {
		return ordemServicoRepo.findById(ordemServicoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de serviço não encontrada"));
	}
}
