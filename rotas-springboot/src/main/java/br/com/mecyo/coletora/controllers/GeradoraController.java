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

import br.com.mecyo.coletora.interfaces.GeradorasRepository;
import br.com.mecyo.coletora.models.Geradora;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
@RestController
@RequestMapping("/geradoras")
public class GeradoraController {

	@Autowired
	private GeradorasRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Geradora> getAllGeradoras() {
		return repository.findAll();
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
	}
}
