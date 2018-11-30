package br.com.xpto.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cidade implements Serializable
{

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long idIbge;
	private String uf;
	private String nome;
	private String capital;
	private String logitude;
	private String latitude;
	private String no_accents;
	private String alternativeNome;
	private String microRegioes;
	private String mesoregion;
	
	
	public Cidade()
	{
		
	}
	
	
	public Cidade(Long idIbge, String uf, String nome, String capital, String logitude, String latitude,
			String no_accents, String alternativeNome, String microRegioes, String mesoregion) {
		super();
		this.idIbge = idIbge;
		this.uf = uf;
		this.nome = nome;
		this.capital = capital;
		this.logitude = logitude;
		this.latitude = latitude;
		this.no_accents = no_accents;
		this.alternativeNome = alternativeNome;
		this.microRegioes = microRegioes;
		this.mesoregion = mesoregion;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getIdIbge() {
		return idIbge;
	}
	
	public void setIdIbge(Long idIbge) {
		this.idIbge = idIbge;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getLogitude() {
		return logitude;
	}
	public void setLogitude(String logitude) {
		this.logitude = logitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getNo_accents() {
		return no_accents;
	}
	public void setNo_accents(String no_accents) {
		this.no_accents = no_accents;
	}
	public String getAlternativeNome() {
		return alternativeNome;
	}
	public void setAlternativeNome(String alternativeNome) {
		this.alternativeNome = alternativeNome;
	}
	public String getMicroRegioes() {
		return microRegioes;
	}
	public void setMicroRegioes(String microRegioes) {
		this.microRegioes = microRegioes;
	}
	public String getMesoregion() {
		return mesoregion;
	}
	public void setMesoregion(String mesoregion) {
		this.mesoregion = mesoregion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idIbge == null) ? 0 : idIbge.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (idIbge == null) {
			if (other.idIbge != null)
				return false;
		} else if (!idIbge.equals(other.idIbge))
			return false;
		return true;
	}
	
	
	

}
