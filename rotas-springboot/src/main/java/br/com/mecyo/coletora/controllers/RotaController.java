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

import br.com.mecyo.coletora.interfaces.RotasRepository;
import br.com.mecyo.coletora.models.Rota;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
@RestController
@RequestMapping("/rotas")
public class RotaController {

	@Autowired
	private RotasRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Rota> getAllRotas() {
		return repository.findAll();
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
	}
}
