/**
 * 
 */
package br.com.mecyo.rotasweb.connection;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import br.com.mecyo.rotasweb.entity.ObjectId;

/**
 * @author Emerson Santos (Mecyo)
 * @param <T>
 *
 */
public abstract class RotasWebService<T> {

	/**
	 * GERENCIA A INFRAESTRUTURA DE COMUNIÇÃO DO LADO CLIENTE PARA EXECUTAR AS
	 * SOLICITAÇÕES REALIZADAS
	 */
	protected Client client;

	/**
	 * ACESSA UM RECURSO IDENTIFICADO PELO URI(Uniform Resource
	 * Identifier/Identificador Uniforme de Recursos)
	 */
	protected WebTarget webTarget;

	/** URL DO SERVIÇO REST QUE VAMOS ACESSAR */
	protected static final String URL_WEBSERVICE = "http://localhost:8080/";

	/** CONSTRUTOR DA NOSSA CLASSE */
	protected RotasWebService() {
		this.client = ClientBuilder.newClient();
	}

	public abstract T cadastrar(T pObject);

	public abstract T editar(T pObject);

	public abstract List<T> findAll();

	public abstract T getById(ObjectId id);

	public abstract void excluir(T pObject);

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the webTarget
	 */
	public WebTarget getWebTarget() {
		return webTarget;
	}

	/**
	 * @param webTarget the webTarget to set
	 */
	public void setWebTarget(WebTarget webTarget) {
		this.webTarget = webTarget;
	}
}
