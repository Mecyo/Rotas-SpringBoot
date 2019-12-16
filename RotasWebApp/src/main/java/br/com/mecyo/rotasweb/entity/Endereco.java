/**
 * 
 */
package br.com.mecyo.rotasweb.entity;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
public class Endereco {
	private ObjectId _id;
	private Double latitude = 0D;
	private Double longitude = 0D;
	
	
	public Endereco() {
	}
	
	/**
	 * @param id
	 * @param latitude
	 * @param longitude
	 */
	public Endereco(ObjectId id, Double latitude, Double longitude) {
		super();
		this._id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * @param latitude
	 * @param longitude
	 */
	public Endereco(Double latitude, Double longitude) {
		super();
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
	public void set_id(ObjectId id) {
		this._id = id;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return "Endereco [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
}
