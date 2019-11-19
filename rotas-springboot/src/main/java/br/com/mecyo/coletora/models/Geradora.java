package br.com.mecyo.coletora.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Emerson Santos(Mecyo)
 *
 */
@Document(collection = "geradoras")
public class Geradora {
	@Id
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
	public ObjectId getId() {
		return _id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(ObjectId id) {
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
