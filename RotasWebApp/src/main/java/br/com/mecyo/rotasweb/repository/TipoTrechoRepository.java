/**
 * 
 */
package br.com.mecyo.rotasweb.repository;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import br.com.mecyo.rotasweb.connection.RotasWebService;
import br.com.mecyo.rotasweb.entity.ObjectId;
import br.com.mecyo.rotasweb.entity.TipoTrecho;
import br.com.mecyo.rotasweb.entity.TipoTrechos;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
public class TipoTrechoRepository extends RotasWebService<TipoTrecho> {

	private String urlCollection = "geradoras/";

	@Override
	public TipoTrecho cadastrar(TipoTrecho pObject) {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection);

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(pObject, "application/json;charset=UTF-8"));

		return response.readEntity(TipoTrecho.class);
	}

	@Override
	public TipoTrecho editar(TipoTrecho pObject) {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection).path(String.valueOf(pObject.get_id()));

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.put(Entity.entity(pObject, "application/json;charset=UTF-8"));

		return response.readEntity(TipoTrecho.class);
	}

	@Override
	public List<TipoTrecho> findAll() {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection);

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(TipoTrechos.class);
	}

	@Override
	public TipoTrecho getById(ObjectId id) {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection).path(String.valueOf(id));

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(TipoTrecho.class);
	}

	@Override
	public void excluir(TipoTrecho pObject) {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection).path(String.valueOf(pObject.get_id()));

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		invocationBuilder.delete();
	}
}
