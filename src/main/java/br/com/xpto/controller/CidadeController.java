package br.com.xpto.controller;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.xpto.dto.CidadeEstadoDTO;
import br.com.xpto.dto.MaiorMenorEstadoDTO;
import br.com.xpto.model.Cidade;
import br.com.xpto.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController 
{
	@Autowired
	private CidadeService cidadeService;
	
	//QUESTÃO 2
	@GetMapping("/cidadesCapitais")
	public ResponseEntity<Set<Cidade>> cidadesCapitais()
	{
		Set<Cidade> cidadesCapitais = cidadeService.cidadesCapitais();
		return ResponseEntity.ok().body(cidadesCapitais);
	}
	
	//QUESTÃO 3
	@GetMapping("/menorMaior")
	public ResponseEntity<List<MaiorMenorEstadoDTO>> menorMaior() throws IOException
	{
		List<MaiorMenorEstadoDTO> cidadesCapitais = cidadeService.maiorMenorEstadoCidade();
		
		return ResponseEntity.ok().body(cidadesCapitais);
	}
	
	//QUESTÃO 4
	@GetMapping("/cidadesEstados")
	public ResponseEntity<List<CidadeEstadoDTO>> cidadesEstados()
	{
		List<CidadeEstadoDTO> cidadesEstados = cidadeService.cidadesEstados();
		
		return ResponseEntity.ok().body(cidadesEstados);
	}
	
	//QUESTÃO 5
	@GetMapping("/ibge/{idIbge}")
	public ResponseEntity<Cidade> buscarIbgePorId(@PathVariable long idIbge) {
		Cidade cidades = cidadeService.buscarIbgePorID(idIbge);
		return ResponseEntity.ok().body(cidades);
	}
	
	//QUESTÃO 6
	@GetMapping("/nomeCidades/{uf}")
	public ResponseEntity<List<Cidade>> buscarCidadePorEstado(@PathVariable String uf) {
		List<Cidade> cidades = cidadeService.buscarCidadePorEstado(uf);
		return ResponseEntity.ok().body(cidades);
	}
	
	//QUESTÃO 7
	@PostMapping()
	public ResponseEntity<Void> insert(@Valid @RequestBody Cidade cidade)
	{
		cidade = cidadeService.inserir(cidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(cidade.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//QUESTÃO 8
	@DeleteMapping("/{id}")
	public ResponseEntity<Cidade> delete(@PathVariable Long id) {
		cidadeService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//QUESTÃO 11
	@GetMapping("/totalRegistro")
	public ResponseEntity<Integer> totalRegistro()
	{
		Integer totalRegistro = cidadeService.totalRegistro();
		
		return ResponseEntity.ok().body(totalRegistro);
	}
	
	@GetMapping()
	public ResponseEntity<List<Cidade>> findAll() {
		List<Cidade> cidades = cidadeService.findAll();
		
		return ResponseEntity.ok().body(cidades);
	}

}
