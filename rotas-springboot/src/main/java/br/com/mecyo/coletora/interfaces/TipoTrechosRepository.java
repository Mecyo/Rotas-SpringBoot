/**
 * 
 */
package br.com.mecyo.coletora.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mecyo.coletora.models.TipoTrecho;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
public interface TipoTrechosRepository  extends MongoRepository<TipoTrecho, String> {
}
