/**
 * 
 */
package br.com.mecyo.coletora.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mecyo.coletora.models.Geradora;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
public interface GeradorasRepository  extends MongoRepository<Geradora, String> {
}
