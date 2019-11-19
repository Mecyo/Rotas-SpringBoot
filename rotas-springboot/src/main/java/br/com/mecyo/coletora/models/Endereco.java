/**
 * 
 */
package br.com.mecyo.coletora.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
@Document(collection = "enderecos")
public class Endereco {
	@Id
	private ObjectId _id;
	private double latitude;
	private double longitude;
	
	
	
	/**
	 * @param id
	 * @param latitude
	 * @param longitude
	 */
	public Endereco(ObjectId _id, double latitude, double longitude) {
		super();
		this._id = _id;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * @return the _id
	 */
	public ObjectId get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
