package com.github.samueljml.domain.model.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	private OrdemServicoRepository OrdemServicoRepo;
	
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
		return OrdemServicoRepo.save(ordemServico);
	}
	
	public Comentario adicionarComentario(Long ordemServicoId, String descricao) {
		OrdemServico ordemServico = OrdemServicoRepo.findById(ordemServicoId)
				.orElseThrow(() -> new NegocioException("Ordem de serviço não encontrada"));
		
		Comentario comentario = new Comentario();
		comentario.setDataEnvio(OffsetDateTime.now());
		comentario.setDescricao(descricao);
		comentario.setOrdemServico(ordemServico);
	
		return comentarioRepo.save(comentario);
	}
	
}
