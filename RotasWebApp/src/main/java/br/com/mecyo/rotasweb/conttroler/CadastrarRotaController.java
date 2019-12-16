/**
 * 
 */
package br.com.mecyo.rotasweb.conttroler;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.component.gmap.GMap;
import org.primefaces.context.PrimeFacesContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.ReverseGeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import br.com.mecyo.rotasweb.entity.Endereco;
import br.com.mecyo.rotasweb.entity.Geradora;
import br.com.mecyo.rotasweb.repository.EnderecoRepository;
import br.com.mecyo.rotasweb.repository.GeradoraRepository;
import br.com.mecyo.rotasweb.util.Uteis;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
@Named(value="cadastrarRotaController")
@RequestScoped
public class CadastrarRotaController {
 
	private MapModel mapModel;
	private Marker marker;
	private String centerMap = "-12.967759526672301, -38.42942025299328";
    
	private String title;
	private String logradouro;
	private String cep;
	
	private boolean modalVisible = true;
      
    @Inject
	private Endereco endereco;

    @Inject
	private EnderecoRepository webService;
    
    @Inject
	private GeradoraRepository webServiceGeradora;
	
	@PostConstruct
	public void init() {
		mapModel = new DefaultMapModel();
		PrimeFaces.current().executeScript("openModal();");
	}
	
	public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
         
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));
    }
	
	public void addMarker() {
        Marker marker = new Marker(new LatLng(endereco.getLatitude(), endereco.getLongitude()), title);
        mapModel.addOverlay(marker);
          
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + endereco.getLatitude() + ", Lng:" + endereco.getLongitude()));
    }
	
	public void onReverseGeocode(ReverseGeocodeEvent event) {
        List<String> addresses = event.getAddresses();
        LatLng coord = event.getLatlng();
         
        if (addresses != null && !addresses.isEmpty()) {
        	centerMap = coord.getLat() + "," + coord.getLng();
            mapModel.addOverlay(new Marker(coord, addresses.get(0)));
        }
    }
	
	public void Salvar(){
		 
		String latLongCenter = endereco.getLatitude() + "," + endereco.getLongitude();
		GMap map = new GMap();
		map.setCenter(latLongCenter);
		/*String msg = "Endereço cadastrado com sucesso!";
		
		if(endereco.get_Id() != null)
			webService.cadastrar(endereco);
		else {
			webService.editar(endereco);
			msg = "Endereço alterado com sucesso!";
		}
		
		this.endereco = null;
 
		Uteis.MensagemInfo(msg);
		Voltar();*/
	}
	
	public void carregarGeradoras() {
		List<Geradora> geradoras = webServiceGeradora.findAll();
		
		geradoras.forEach(geradora -> {
			Marker marker = new Marker(new LatLng(geradora.getEndereco().getLatitude(), geradora.getEndereco().getLongitude()), geradora.getNome());
			mapModel.addOverlay(marker);
		});
		
		PrimeFaces.current().executeScript("closeModal();");
	}
	
	public void voltar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("listaRotas.xhtml");
		} catch (IOException e) {
			Uteis.MensagemAtencao(e.getMessage());
		}
	}
      
    public MapModel getEmptyModel() {
        return mapModel;
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

	/**
	 * @return the centerMap
	 */
	public String getCenterMap() {
		return centerMap;
	}

	/**
	 * @param centerMap the centerMap to set
	 */
	public void setCenterMap(String centerMap) {
		this.centerMap = centerMap;
	}

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return the modalVisible
	 */
	public boolean isModalVisible() {
		return modalVisible;
	}

	/**
	 * @param modalVisible the modalVisible to set
	 */
	public void setModalVisible(boolean modalVisible) {
		this.modalVisible = modalVisible;
	}
	
	
}