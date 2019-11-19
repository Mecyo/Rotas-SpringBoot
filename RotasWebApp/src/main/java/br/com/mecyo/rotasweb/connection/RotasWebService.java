/**
 * 
 */
package br.com.mecyo.rotasweb.connection;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import br.com.mecyo.rotasweb.entity.Endereco;
import br.com.mecyo.rotasweb.entity.Enderecos;
import br.com.mecyo.rotasweb.entity.ObjectId;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
public class RotasWebService {

		/**GERENCIA A INFRAESTRUTURA DE COMUNIÇÃO DO LADO 
		 * CLIENTE PARA EXECUTAR AS SOLICITAÇÕES REALIZADAS*/
		private Client client;
	 
		/**ACESSA UM RECURSO IDENTIFICADO PELO URI(Uniform Resource Identifier/Identificador Uniforme de Recursos)*/
		private WebTarget webTarget;
	 
		/**URL DO SERVIÇO REST QUE VAMOS ACESSAR */
		private final String URL_WEBSERVICE = "http://localhost:8080/";
	 
		/**CONSTRUTOR DA NOSSA CLASSE*/
		public RotasWebService(){
			this.client = ClientBuilder.newClient();  
		}
	 
		/**CADASTRA UMA NOVA PESSOA ATRAVÉS DA OPERAÇÃO cadastrar(MÉTODO HTTP: POST) */
		public Endereco cadastrarEndereco(Endereco endereco) {
	 
			this.webTarget = this.client.target(URL_WEBSERVICE).path("enderecos/");
	 
			Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8");
	 
			Response response = invocationBuilder.post(Entity.entity(endereco, "application/json;charset=UTF-8"));
	 
			return response.readEntity(Endereco.class);
	 
		}
	 
		/**ALTERA UM REGISTRO JÁ CADASTRADO ATRAVÉS DA OPERAÇÃO alterar(MÉTODO HTTP:PUT)*/
		public Endereco EditarEndereco(Endereco endereco){
	 
			this.webTarget = this.client.target(URL_WEBSERVICE).path("enderecos/").path(String.valueOf(endereco.get_id()));
	 
			Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8");
	 
			Response response = invocationBuilder.put(Entity.entity(endereco, "application/json;charset=UTF-8"));
	 
			return response.readEntity(Endereco.class);
	 
		}
	 
		/**CONSULTA TODAS AS PESSOAS CADASTRADAS NO SERVIÇO ATRAVÉS DA OPERAÇÃO todasPessoas(MÉTODO HTTP:GET)*/
		public List<Endereco> findAllEnderecos(){
	 
			this.webTarget = this.client.target(URL_WEBSERVICE).path("enderecos/");
	 
			Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8");
	 
			Response response = invocationBuilder.get();
	 
			return response.readEntity(Enderecos.class);
	 
		}
	 
		/**CONSULTA UMA PESSOA PELO CÓDIGO ATRAVÉS DA OPERAÇÃO getPessoa(MÉTODO HTTP: GET)*/
		public Endereco getEnderecoById(ObjectId id){
	 
			this.webTarget = this.client.target(URL_WEBSERVICE).path("enderecos/").path(String.valueOf(id));
	 
			Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8");
	 
			Response response = invocationBuilder.get();
	 
			return response.readEntity(Endereco.class);
		}
	 
	 
		/**EXCLUI UM REGISTRO CADASTRADO PELO CÓDIGO ATRAVÉS DA OPERAÇÃO excluir(MÉTODO HTTP:delete)*/
		public void excluirEndereco(Endereco end) {
	 
			this.webTarget = this.client.target(URL_WEBSERVICE).path("enderecos/").path(String.valueOf(end.get_id()));
	 
			Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8");
	 
			invocationBuilder.delete();
		}
	 
	
	/*public List<Endereco> findAllEnderecos() {
		WebResource wr = getWebResource("enderecos/");
		String json = wr.get(String.class);

		Gson gson = new Gson();
		return gson.fromJson(json, new TypeToken<List<Endereco>>() {
		}.getType());
	}

	public List<Geradora> findAllGeradoras() {
		WebResource wr = getWebResource("geradoras/");
		String json = wr.get(String.class);

		Gson gson = new Gson();
		return gson.fromJson(json, new TypeToken<List<Geradora>>() {
		}.getType());
	}

	public List<Rota> findAllRotas() {
		WebResource wr = getWebResource("rotas/");
		String json = wr.get(String.class);

		Gson gson = new Gson();
		return gson.fromJson(json, new TypeToken<List<Rota>>() {
		}.getType());
	}

	public List<TipoTrecho> findAllTipoTrechos() {
		WebResource wr = getWebResource("tipotrechos/");
		String json = wr.get(String.class);

		Gson gson = new Gson();
		return gson.fromJson(json, new TypeToken<List<TipoTrecho>>() {
		}.getType());
	}

	private WebResource getWebResource(String url) {
		Client c = Client.create();
		WebResource wr = c.resource(URL_WEBSERVICE + url);

		return wr;
	}

	public void excluirEndereco(Endereco selectedEndereco) {
		// TODO Auto-generated method stub

	}

	public Endereco cadastrarEndereco(Endereco endereco) {
		Gson gson = new Gson();
		String url = "enderecos/";	
		
		RequestBody

		url += gson.toJson(endereco);
		
		WebResource wr = getWebResource(url);
		
		String json = wr.get(String.class);

		return gson.fromJson(json, new TypeToken<Endereco>() {
		}.getType());
	}*/
}
