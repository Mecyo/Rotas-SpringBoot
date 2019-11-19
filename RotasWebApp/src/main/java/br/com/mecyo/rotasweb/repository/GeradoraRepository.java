/**
 * 
 */
package br.com.mecyo.rotasweb.repository;

import java.util.List;

import javax.inject.Inject;

import br.com.mecyo.rotasweb.connection.RotasWebService;
import br.com.mecyo.rotasweb.entity.Geradora;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
public class GeradoraRepository {

	@Inject
	private RotasWebService managerConnection;

	/*public List<Geradora> getAllGeradoras() {
		return managerConnection.findAllGeradoras();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Geradora getGeradoraById(@PathVariable("id") String id) {
		return repository.findById(id).get();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyGeradoraById(@PathVariable("id") ObjectId id, @Valid @RequestBody Geradora geradora) {
		geradora.setId(id);
		repository.save(geradora);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Geradora createGeradora(@Valid @RequestBody Geradora geradora) {
		geradora.setId(ObjectId.get());
		repository.save(geradora);
		return geradora;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteGeradora(@PathVariable ObjectId id) {
		repository.deleteById(id.toString());
	}*/
}
