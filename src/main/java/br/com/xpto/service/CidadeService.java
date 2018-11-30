package br.com.xpto.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.xpto.dto.CidadeEstadoDTO;
import br.com.xpto.dto.MaiorMenorEstadoDTO;
import br.com.xpto.model.Cidade;
import br.com.xpto.repository.CidadeRepository;

@Service
public class CidadeService 
{
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> findAll() {
		
		return cidadeRepository.findAll();
	}
	
	//QUESTÃO 2
	public Set<Cidade> cidadesCapitais() {
		
		return cidadeRepository.cidadesCapitais();
	}
	
	//QUESTÃO 3
	public List<MaiorMenorEstadoDTO> maiorMenorEstadoCidade()
	{
		List<Object> result = (List<Object>) cidadeRepository.buscarMaiorMenorEstadoCidade(); 
		Iterator itr = result.iterator();
		
		List<MaiorMenorEstadoDTO> lista = new ArrayList<>();
		while(itr.hasNext())
		{
			MaiorMenorEstadoDTO maiorMenorEstadoDTO = new MaiorMenorEstadoDTO();
			Object[] obj = (Object[]) itr.next();
			
			maiorMenorEstadoDTO.setTipo(String.valueOf(obj[0]));
			maiorMenorEstadoDTO.setUf(String.valueOf(obj[1]));
			maiorMenorEstadoDTO.setTotal(Integer.parseInt(String.valueOf(obj[2]))); 
		   
			lista.add(maiorMenorEstadoDTO);
		}
		
		return lista;
	}
	
	//QUESTÃO 4
	public List<CidadeEstadoDTO> cidadesEstados() 
	{
		
		List<Object> result = (List<Object>) cidadeRepository.cidadesEstados(); 
		Iterator itr = result.iterator();
		
		List<CidadeEstadoDTO> lista = new ArrayList<>();
		while(itr.hasNext())
		{
			CidadeEstadoDTO cidadeEstadoDTO = new CidadeEstadoDTO();
			Object[] obj = (Object[]) itr.next();
			
			cidadeEstadoDTO.setUf(String.valueOf(obj[0])); 
			cidadeEstadoDTO.setTotalCidade(Integer.parseInt(String.valueOf(obj[1]))); 
		   
			lista.add(cidadeEstadoDTO);
		}
		
		return lista;
	}
	
	//QUESTÃO 5
	public Cidade buscarIbgePorID(long idIbge) {
		
		return cidadeRepository.findByIdIbge(idIbge);
	}
	
	//QUESTÃO 6
	public List<Cidade> buscarCidadePorEstado(String uf) {
			
		return cidadeRepository.findByUf(uf);
	}
	
	//QUESTÃO 7
	public Cidade inserir(Cidade cidade)
	{
		cidade.setId(null);
		return cidadeRepository.save(cidade);
	}
	
	//QUESTÃO 8
	public void delete(Long id)
	{
		cidadeRepository.findById(id);
		try
		{
			cidadeRepository.deleteById(id);
		}catch (DataIntegrityViolationException e) 
		{
			throw new RuntimeException("Não foi possível excluir a cidade");
		}
		
	}
	
	//QUESTÃO 11
	public Integer totalRegistro() {
			
		return cidadeRepository.totalRegistro();
	}
	
	
	/*
	public Cidade buscarPorId(Long id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		if(cidade == null)
		{
			throw new RuntimeException("Cidade não encontrada");
		}
		return cidade;
	}
	*/
	

}
