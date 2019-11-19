/**
 * 
 */
package br.com.mecyo.rotasweb.conttroler;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import br.com.mecyo.rotasweb.entity.Endereco;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
@Named(value="cadastrarRotaController")
@RequestScoped
public class CadastrarRotaController {
 
	private MapModel emptyModel;
    
    private String title;
      
    @Inject
    private Endereco endereco;
      
    @PostConstruct
    public void init() {
        emptyModel = new DefaultMapModel();
    }
      
    public MapModel getEmptyModel() {
        return emptyModel;
    }
      
    public String getTitle() {
        return title;
    }
  
    public void setTitle(String title) {
        this.title = title;
    }
  
      
    /**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void addMarker() {
        Marker marker = new Marker(new LatLng(endereco.getLatitude(), endereco.getLongitude()), title);
        emptyModel.addOverlay(marker);
          
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + endereco.getLatitude() + ", Lng:" + endereco.getLongitude()));
    }
}