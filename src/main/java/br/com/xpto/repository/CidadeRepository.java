package br.com.xpto.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.xpto.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> 
{
	
	//QUESTÃO 6
	public List<Cidade> findByUf(String uf);
	
	//QUESTÃO 5
	public Cidade findByIdIbge(long idIbge);
	
	//QUESTÃO 2
	@Query(value="select distinct * from cidade where capital = \"true\" order by nome", nativeQuery=true)
	public Set<Cidade> cidadesCapitais();
	
	//QUESTÃO 3
	@Query(value="(SELECT 'MAIOR' AS TIPO, UF, TOTAL\r\n" + 
			"FROM (\r\n" + 
			"SELECT UF, COUNT(*) AS TOTAL\r\n" + 
			"  FROM CIDADE\r\n" + 
			"GROUP BY UF\r\n" + 
			"ORDER BY TOTAL DESC\r\n" + 
			") X LIMIT 1)\r\n" + 
			"\r\n" + 
			"UNION ALL\r\n" + 
			"\r\n" + 
			"(SELECT 'MENOR' AS TIPO, UF, TOTAL\r\n" + 
			"FROM (\r\n" + 
			"SELECT UF, COUNT(*) AS TOTAL\r\n" + 
			"  FROM CIDADE\r\n" + 
			"GROUP BY UF\r\n" + 
			"ORDER BY TOTAL\r\n" + 
			") X LIMIT 1)", nativeQuery=true)
	public List<Object> buscarMaiorMenorEstadoCidade();
	
	//QUESTÃO 4
	@Query(value="select uf, count(nome) as total  from cidade group by uf", nativeQuery=true)
	public List<Object> cidadesEstados();
	
	//QUESTÃO 11
	@Query(value="select count(*) from cidade", nativeQuery=true)
	public Integer totalRegistro();
	
	
	
	
	
}
