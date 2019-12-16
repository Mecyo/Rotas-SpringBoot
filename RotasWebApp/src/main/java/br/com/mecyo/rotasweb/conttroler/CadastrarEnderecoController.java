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
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.ReverseGeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import br.com.mecyo.rotasweb.entity.Endereco;
import br.com.mecyo.rotasweb.repository.EnderecoRepository;
import br.com.mecyo.rotasweb.util.Uteis;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
@Named(value = "cadastrarEnderecoController")
@RequestScoped
public class CadastrarEnderecoController {
	private MapModel mapModel;
	private Marker marker;
	private String centerMap = "-12.967759526672301, -38.42942025299328";

	private String title;

	@Inject
	private Endereco endereco;

	@Inject
	private EnderecoRepository webService;

	@PostConstruct
	public void init() {
		mapModel = new DefaultMapModel();
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		this.endereco = (Endereco) request.getSession().getAttribute("endereco"); 
	}

	public void onMarkerSelect(OverlaySelectEvent event) {
		marker = (Marker) event.getOverlay();

		Uteis.MensagemInfo("Marker Selected", marker.getTitle());
	}

	public void addMarker() {
		Marker marker = new Marker(new LatLng(endereco.getLatitude(), endereco.getLongitude()), title);
		mapModel.addOverlay(marker);
		
		Uteis.MensagemInfo("Marker Added",
				"Lat:" + endereco.getLatitude() + ", Lng:" + endereco.getLongitude());
	}

	public void onReverseGeocode(ReverseGeocodeEvent event) {
		List<String> addresses = event.getAddresses();
		LatLng coord = event.getLatlng();

		if (addresses != null && !addresses.isEmpty()) {
			centerMap = coord.getLat() + "," + coord.getLng();
			mapModel.addOverlay(new Marker(coord, addresses.get(0)));
		}
	}

	public void Salvar() {

		webService.cadastrar(endereco);

		this.endereco = null;

		Uteis.MensagemInfo("Sucesso!", "Endereço cadastrado com sucesso!");
		Voltar();
	}

	public void Editar() {

		webService.editar(endereco);

		this.endereco = null;

		Uteis.MensagemInfo("Sucesso!", "Endereço alterado com sucesso!");
		Voltar();
	}

	public void Voltar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("listaEnderecos.xhtml");
		} catch (IOException e) {
			Uteis.MensagemAtencao(e.getMessage());
		}
	}

	/**
	 * @return the mapModel
	 */
	public MapModel getMapModel() {
		return mapModel;
	}

	/**
	 * @param mapModel the mapModel to set
	 */
	public void setMapModel(MapModel mapModel) {
		this.mapModel = mapModel;
	}

	/**
	 * @return the marker
	 */
	public Marker getMarker() {
		return marker;
	}

	/**
	 * @param marker the marker to set
	 */
	public void setMarker(Marker marker) {
		this.marker = marker;
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
}