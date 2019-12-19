/**
 * 
 */
package br.com.mecyo.rotasweb.conttroler;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polyline;

import br.com.mecyo.rotasweb.entity.Endereco;
import br.com.mecyo.rotasweb.entity.Geradora;
import br.com.mecyo.rotasweb.entity.Rota;
import br.com.mecyo.rotasweb.repository.GeradoraRepository;
import br.com.mecyo.rotasweb.repository.RotaRepository;
import br.com.mecyo.rotasweb.util.Uteis;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
@Named(value = "cadastrarRotaController")
@SessionScoped
public class CadastrarRotaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MapModel mapModel;
	private Marker marker;
	private Polyline polyline;
	private String centerMap = "-12.967759526672301, -38.42942025299328";

	private String title;
	private String logradouro;
	private String cep;

	@Inject
	private Rota rota;

	@Inject
	private RotaRepository webService;

	@Inject
	private GeradoraRepository webServiceGeradora;

	@PostConstruct
	public void init() {
		mapModel = new DefaultMapModel();
	}

	public void onMarkerSelect(OverlaySelectEvent event) {
		if(event.getOverlay() instanceof Marker) {
			marker = (Marker) event.getOverlay();
			if (!(marker.getData() instanceof Geradora))
				marker = null;
			PrimeFaces.current().executeScript("openModal('dlgAddGeradora');");
		}
	}

	public void Adicionar() {
		if (marker != null) {
			Geradora geradora = (Geradora) marker.getData();
			if (rota.getGeradoras() == null)
				rota.setGeradoras(new ArrayList<Geradora>());
			rota.getGeradoras().add(geradora);

			addToPolyline(geradora.getEndereco().getLatitude(), geradora.getEndereco().getLongitude());
		}
	}

	private void addToPolyline(Double latitude, Double longitude) {
		if (polyline == null) {
			polyline = new Polyline();
			polyline.setStrokeWeight(5);
			polyline.setStrokeColor("#FF9900");
			polyline.setStrokeOpacity(0.7);
		}

		polyline.getPaths().add(new LatLng(latitude, longitude));

		mapModel.addOverlay(polyline);
	}

	public void Excluir(Geradora geradora) {
		rota.getGeradoras().remove(geradora);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Geradora " + marker.getTitle() + " removida."));
	}

	public void Salvar() {
		webService.cadastrar(rota);
	}

	public void carregarGeradoras() {
		List<Geradora> geradoras = webServiceGeradora.findAll();

		geradoras.forEach(geradora -> {
			Double latitude = geradora.getEndereco().getLatitude();
			Double longitude = geradora.getEndereco().getLongitude();
			String titulo = geradora.getNome();
			Marker marker = new Marker(new LatLng(latitude, longitude), geradora.getNome(), geradora);
			mapModel.addOverlay(marker);
			PrimeFaces.current().executeScript("addGeradora(" + latitude + "," + longitude + "," + titulo + ")");
		});
	}

	public void onGeocode(GeocodeEvent event) {
		List<GeocodeResult> results = event.getResults();

		if (results != null && !results.isEmpty()) {
			LatLng center = results.get(0).getLatLng();
			centerMap = center.getLat() + "," + center.getLng();
			Endereco endInicial = new Endereco(center.getLat(), center.getLng());
			rota.setEnderecoInicial(endInicial);
			Marker marker = new Marker(center, "Início da Rota", endInicial, "../resources/images/start.png");
			mapModel.addOverlay(marker);

			addToPolyline(center.getLat(), center.getLng());
		}

		carregarGeradoras();
	}

	public void voltar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("listaRotas.xhtml");
		} catch (IOException e) {
			Uteis.MensagemAtencao(e.getMessage());
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	 * @return the rota
	 */
	public Rota getRota() {
		return rota;
	}

	/**
	 * @param rota the rota to set
	 */
	public void setRota(Rota rota) {
		this.rota = rota;
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
}