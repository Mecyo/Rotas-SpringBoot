/**
 * 
 */
package br.com.mecyo.rotasweb.repository;

import java.util.List;

import javax.inject.Inject;

import br.com.mecyo.rotasweb.connection.RotasWebService;
import br.com.mecyo.rotasweb.entity.Rota;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
public class RotaRepository {

	@Inject
	private RotasWebService managerConnection;

	/*public List<Rota> getAllRotas() {
		return managerConnection.findAllRotas();
	}

	public void excluirRota(Rota selectedRota) {
		// TODO Auto-generated method stub
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Rota getRotaById(@PathVariable("id") String id) {
		return repository.findById(id).get();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyRotaById(@PathVariable("id") ObjectId id, @Valid @RequestBody Rota rota) {
		rota.setId(id);
		repository.save(rota);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Rota createPet(@Valid @RequestBody Rota rota) {
		rota.setId(ObjectId.get());
		repository.save(rota);
		return rota;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePet(@PathVariable ObjectId id) {
		repository.deleteById(id.toString());
	}*/
}
