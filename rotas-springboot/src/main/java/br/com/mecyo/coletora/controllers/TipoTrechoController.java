/**
 * 
 */
package br.com.mecyo.coletora.controllers;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mecyo.coletora.interfaces.TipoTrechosRepository;
import br.com.mecyo.coletora.models.TipoTrecho;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
@RestController
@RequestMapping("/tipotrechos")
public class TipoTrechoController {

	@Autowired
	private TipoTrechosRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<TipoTrecho> getAllTipoTrechos() {
		return repository.findAll();
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
	}
}
