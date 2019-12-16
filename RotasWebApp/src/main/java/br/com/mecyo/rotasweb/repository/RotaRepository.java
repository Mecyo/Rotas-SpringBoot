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
import br.com.mecyo.rotasweb.entity.Rota;
import br.com.mecyo.rotasweb.entity.Rotas;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
public class RotaRepository extends RotasWebService<Rota> {

	private String urlCollection = "geradoras/";

	@Override
	public Rota cadastrar(Rota pObject) {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection);

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(pObject, "application/json;charset=UTF-8"));

		return response.readEntity(Rota.class);
	}

	@Override
	public Rota editar(Rota pObject) {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection).path(String.valueOf(pObject.get_Id()));

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.put(Entity.entity(pObject, "application/json;charset=UTF-8"));

		return response.readEntity(Rota.class);
	}

	@Override
	public List<Rota> findAll() {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection);

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(Rotas.class);
	}

	@Override
	public Rota getById(ObjectId id) {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection).path(String.valueOf(id));

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(Rota.class);
	}

	@Override
	public void excluir(Rota pObject) {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection).path(String.valueOf(pObject.get_Id()));

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		invocationBuilder.delete();
	}
}
