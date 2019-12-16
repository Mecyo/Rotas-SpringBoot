/**
 * 
 */
package br.com.mecyo.rotasweb.repository;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import br.com.mecyo.rotasweb.connection.RotasWebService;
import br.com.mecyo.rotasweb.entity.Endereco;
import br.com.mecyo.rotasweb.entity.Enderecos;
import br.com.mecyo.rotasweb.entity.ObjectId;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
public class EnderecoRepository extends RotasWebService<Endereco> {

	private String urlCollection = "enderecos/";

	@Override
	public Endereco cadastrar(Endereco pObject) {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection);

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(pObject, "application/json;charset=UTF-8"));

		return response.readEntity(Endereco.class);
	}

	@Override
	public Endereco editar(Endereco pObject) {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection).path(String.valueOf(pObject.get_id()));

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.put(Entity.entity(pObject, "application/json;charset=UTF-8"));

		return response.readEntity(Endereco.class);
	}

	@Override
	public List<Endereco> findAll() {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection);

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(Enderecos.class);
	}

	@Override
	public Endereco getById(ObjectId id) {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection).path(String.valueOf(id));

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(Endereco.class);
	}

	@Override
	public void excluir(Endereco pObject) {
		this.webTarget = this.client.target(URL_WEBSERVICE).path(urlCollection).path(String.valueOf(pObject.get_id()));

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		invocationBuilder.delete();
	}
}
