/**
 * 
 */
package br.com.mecyo.rotasweb.repository;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import br.com.mecyo.rotasweb.connection.RotasWebService;
import br.com.mecyo.rotasweb.entity.Geradora;
import br.com.mecyo.rotasweb.entity.Geradoras;
import br.com.mecyo.rotasweb.entity.ObjectId;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
public class GeradoraRepository extends RotasWebService<Geradora> implements Serializable {
    
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String urlCollection = "geradoras/";

	@Override
	public Geradora cadastrar(Geradora pObject) {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection);

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(pObject, "application/json;charset=UTF-8"));

		return response.readEntity(Geradora.class);
	}

	@Override
	public Geradora editar(Geradora pObject) {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection).path(String.valueOf(pObject.get_id()));

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.put(Entity.entity(pObject, "application/json;charset=UTF-8"));

		return response.readEntity(Geradora.class);
	}

	@Override
	public List<Geradora> findAll() {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection);

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(Geradoras.class);
	}

	@Override
	public Geradora getById(ObjectId id) {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection).path(String.valueOf(id));

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(Geradora.class);
	}

	@Override
	public void excluir(Geradora pObject) {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection).path(String.valueOf(pObject.get_id()));

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		invocationBuilder.delete();
	}
}
