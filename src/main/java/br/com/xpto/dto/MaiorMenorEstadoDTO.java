package br.com.xpto.dto;

import java.io.Serializable;

public class MaiorMenorEstadoDTO implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	private String tipo;
	private String uf;
	private Integer total;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
}
