/**
 * 
 */
package br.com.mecyo.rotasweb.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
public class Rota implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 8255560650848906725L;
	private ObjectId _id;
	private Endereco enderecoInicial;
	private Endereco enderecoFinal;
	private List<Geradora> geradoras;
	private List<TipoTrecho> trechos;
	
	
	/**
	 * @return the _id
	 */
	public ObjectId get_id() {
		return this._id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(ObjectId id) {
		this._id = id;
	}
	/**
	 * @return the geradoras
	 */
	public List<Geradora> getGeradoras() {
		return geradoras;
	}
	/**
	 * @param geradoras the geradoras to set
	 */
	public void setGeradoras(List<Geradora> geradoras) {
		this.geradoras = geradoras;
	}
	/**
	 * @return the trechos
	 */
	public List<TipoTrecho> getTrechos() {
		return trechos;
	}
	/**
	 * @param trechos the trechos to set
	 */
	public void setTrechos(List<TipoTrecho> trechos) {
		this.trechos = trechos;
	}
	/**
	 * @return the enderecoInicial
	 */
	public Endereco getEnderecoInicial() {
		return enderecoInicial;
	}
	/**
	 * @param enderecoInicial the enderecoInicial to set
	 */
	public void setEnderecoInicial(Endereco enderecoInicial) {
		this.enderecoInicial = enderecoInicial;
	}
	/**
	 * @return the enderecoFinal
	 */
	public Endereco getEnderecoFinal() {
		return enderecoFinal;
	}
	/**
	 * @param enderecoFinal the enderecoFinal to set
	 */
	public void setEnderecoFinal(Endereco enderecoFinal) {
		this.enderecoFinal = enderecoFinal;
	}
	@Override
	public String toString() {
		return "Rota: Endere�o Inicial= " + enderecoInicial + ", Endere�o Final= " + enderecoFinal + "]";
	}
	
	
}
