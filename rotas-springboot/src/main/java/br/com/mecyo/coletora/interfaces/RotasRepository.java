/**
 * 
 */
package br.com.mecyo.coletora.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mecyo.coletora.models.Rota;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
public interface RotasRepository  extends MongoRepository<Rota, String> {
}
