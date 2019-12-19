package br.com.mecyo.rotasweb.entity;

import java.io.Serializable;

/**
 * @author Emerson Santos(Mecyo)
 *
 */
public class Geradora  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2448377937595895621L;
	private ObjectId _id;
	private String nome;
	private Endereco endereco;
	
	
	
	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	/**
	 * @return the id
	 */
	public ObjectId get_id() {
		return _id;
	}
	/**
	 * @param id the id to set
	 */
	public void set_id(ObjectId id) {
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
}
