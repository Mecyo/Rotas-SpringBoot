/**
 * 
 */
package br.com.mecyo.rotasweb.repository;

import java.util.List;

import javax.inject.Inject;

import br.com.mecyo.rotasweb.connection.RotasWebService;
import br.com.mecyo.rotasweb.entity.Endereco;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
public class EnderecoRepository {

	@Inject
	private RotasWebService managerConnection;

	public List<Endereco> getAllEnderecos() {
		return managerConnection.findAllEnderecos();
	}

	public void excluirEndereco(Endereco selectedEndereco) {
		managerConnection.excluirEndereco(selectedEndereco);		
	}

	public Endereco cadastrarEndereco(Endereco endereco) {
		return managerConnection.cadastrarEndereco(endereco);
	}

	/*public Endereco getEnderecoById(@PathVariable("id") String id) {
		return managerConnection.findById(id).get();
	}

	public void modifyEnderecoById(@PathVariable("id") ObjectId id, @Valid @RequestBody Endereco endereco) {
		endereco.set_id(id);
		managerConnection.save(endereco);
	}

	public Endereco createEndereco(@Valid @RequestBody Endereco endereco) {
		endereco.set_id(ObjectId.get());
		managerConnection.save(endereco);
		return endereco;
	}

	public void deleteEndereco(@PathVariable ObjectId id) {
		managerConnection.deleteById(id.toString());
	}*/
}
