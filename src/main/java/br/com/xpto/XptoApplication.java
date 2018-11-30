package br.com.xpto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.xpto.model.Cidade;
import br.com.xpto.repository.CidadeRepository;

@SpringBootApplication
public class XptoApplication implements CommandLineRunner{

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) throws IOException{
		SpringApplication.run(XptoApplication.class, args);
	}
	

	//QUESTÃO 1
	@Override
	public void run(String... args) throws Exception 
	{
		//Caminho do arquivo
		String csvArquivo = "E:\\senior\\Projeto\\XPTO\\src\\main\\resources\\arquivos\\cidades.csv";
		BufferedReader conteudoCsv =null;
		String linha = "";
		String separadorCampo = ",";
		
		try
		{
			//Pegando o conteudo do arquivo
			conteudoCsv = new BufferedReader(new FileReader(csvArquivo));
			//Ignorando a primeira linha do arquivo que são as colunas do excel
			conteudoCsv.readLine();	
			while((linha= conteudoCsv.readLine()) != null)
			{
				
				String[] cidades = linha.split(separadorCampo);
					
				//Adicionando o que foi lido pra na minha classe cidade
				Cidade cid = new Cidade();
				//Long ib = Long.parseLong(cidades[0].toString());
				cid.setIdIbge(Long.parseLong(cidades[0]));
				cid.setUf(cidades[1]);
				cid.setNome(cidades[2]);
				cid.setCapital(cidades[3]);
				cid.setLogitude(cidades[4]);
				cid.setLatitude(cidades[5]);
				cid.setNo_accents(cidades[6]);
				cid.setAlternativeNome(cidades[7]);
				cid.setMicroRegioes(cidades[8]);
				cid.setMesoregion(cidades[9]);		
				
				//gravando no banco de dados
				cidadeRepository.save(cid);
			}
		}catch(FileNotFoundException e)
		{
			System.out.println("erro "+e.getMessage());
		}finally
		{
			if(conteudoCsv != null)
			{
				conteudoCsv.close();
			}
		}
	}

}