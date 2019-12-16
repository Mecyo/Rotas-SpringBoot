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
	private ObjectId _id;
	private String nome;
	private Color cor;
	
	
	/**
	 * @return the id
	 */
	public ObjectId get_Id() {
		return _id;
	}
	/**
	 * @param id the id to set
	 */
	public void set_Id(ObjectId id) {
		this._id = id;
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
