/**
 * 
 */
package br.com.mecyo.rotasweb.entity;

import java.awt.Color;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
public class TipoTrecho {
	private long id;
	private String nome;
	private Color cor;
	
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the cor
	 */
	public Color getCor() {
		return cor;
	}
	/**
	 * @param cor the cor to set
	 */
	public void setCor(Color cor) {
		this.cor = cor;
	}
}
