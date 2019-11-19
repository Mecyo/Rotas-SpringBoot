/**
 * 
 */
package br.com.mecyo.rotasweb.repository;

import java.util.List;

import javax.inject.Inject;

import br.com.mecyo.rotasweb.connection.RotasWebService;
import br.com.mecyo.rotasweb.entity.TipoTrecho;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
public class TipoTrechoRepository {

	@Inject
	private RotasWebService managerConnection;

	/*public List<TipoTrecho> getAllTipoTrechos() {
		return managerConnection.findAllTipoTrechos();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TipoTrecho getTipoTrechoById(@PathVariable("id") String id) {
		return repository.findById(id).get();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyTipoTrechoById(@PathVariable("id") ObjectId id, @Valid @RequestBody TipoTrecho tipoTrecho) {
		tipoTrecho.setId(id);
		repository.save(tipoTrecho);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public TipoTrecho createTipoTrecho(@Valid @RequestBody TipoTrecho tipoTrecho) {
		tipoTrecho.setId(ObjectId.get());
		repository.save(tipoTrecho);
		return tipoTrecho;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteTipoTrecho(@PathVariable ObjectId id) {
		repository.deleteById(id.toString());
	}*/
}
