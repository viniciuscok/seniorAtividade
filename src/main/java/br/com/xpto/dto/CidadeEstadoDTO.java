package br.com.xpto.dto;

import java.io.Serializable;

public class CidadeEstadoDTO implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	private String uf;
	private Integer totalCidade;
	
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public Integer getTotalCidade() {
		return totalCidade;
	}
	public void setTotalCidade(Integer totalCidade) {
		this.totalCidade = totalCidade;
	}
	
	

}
