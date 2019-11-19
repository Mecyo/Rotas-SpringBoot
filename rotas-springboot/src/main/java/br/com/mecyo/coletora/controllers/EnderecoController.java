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

import br.com.mecyo.coletora.interfaces.EnderecosRepository;
import br.com.mecyo.coletora.models.Endereco;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecosRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Endereco> getAllEnderecos() {
		return repository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Endereco getEnderecoById(@PathVariable("id") String id) {
		return repository.findById(id).get();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyEnderecoById(@PathVariable("id") ObjectId id, @Valid @RequestBody Endereco endereco) {
		endereco.set_id(id);
		repository.save(endereco);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Endereco createEndereco(@Valid @RequestBody Endereco endereco) {
		endereco.set_id(ObjectId.get());
		repository.save(endereco);
		return endereco;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteEndereco(@PathVariable ObjectId id) {
		repository.deleteById(id.toString());
	}
}
