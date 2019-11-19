/**
 * 
 */
package br.com.mecyo.coletora.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mecyo.coletora.models.Endereco;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
public interface EnderecosRepository  extends MongoRepository<Endereco, String> {
}
