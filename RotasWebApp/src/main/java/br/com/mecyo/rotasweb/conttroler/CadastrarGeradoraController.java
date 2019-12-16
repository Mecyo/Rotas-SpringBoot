/**
 * 
 */
package br.com.mecyo.rotasweb.conttroler;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import br.com.mecyo.rotasweb.entity.Endereco;
import br.com.mecyo.rotasweb.entity.Geradora;
import br.com.mecyo.rotasweb.repository.GeradoraRepository;
import br.com.mecyo.rotasweb.util.Uteis;

@Named
@SessionScoped
public class CadastrarGeradoraController implements Serializable {
    
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MapModel geoModel;
    private String centerGeoMap = "41.850033, -87.6500523";
    private String endereco;
    
    private boolean exibir;
    
    @Inject
    private Geradora geradora;

	@Inject
	private GeradoraRepository webService;
	
     
    @PostConstruct
    public void init() {
        geoModel = new DefaultMapModel();
        exibir = false;
    }
     
    public void onGeocode(GeocodeEvent event) {
    	List<GeocodeResult> results = event.getResults();
         
        if (results != null && !results.isEmpty()) {
            LatLng center = results.get(0).getLatLng();
            centerGeoMap = center.getLat() + "," + center.getLng();
            geradora.setEndereco(new Endereco(center.getLat(), center.getLng()));
            Marker marker = new Marker(new LatLng(geradora.getEndereco().getLatitude(), geradora.getEndereco().getLongitude()), geradora.getNome());
            geoModel.addOverlay(marker);
            
            exibir = true;
        }
    }
	
	public void Salvar(){
		 
		webService.cadastrar(geradora);
		
		LimparCampos();
 
		Uteis.MensagemInfo("", "Geradora cadastrada com sucesso!");
		Voltar();
	}
	
	public void Cancelar(){
		 
		LimparCampos();
	}
	
	private void LimparCampos() {
		this.geradora.set_id(null);
		this.geradora.setEndereco(null);
		this.geradora.setNome(null);
		this.endereco = null;
 
		geoModel.getMarkers().clear();
		exibir = false;
	}
	
	public void Voltar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("listaGeradoras.xhtml");
		} catch (IOException e) {
			Uteis.MensagemAtencao(e.getMessage());
		}
	}
	
	/**
	 * @return the geradora
	 */
	public Geradora getGeradora() {
		return geradora;
	}

	/**
	 * @param geradora the geradora to set
	 */
	public void setGeradora(Geradora geradora) {
		this.geradora = geradora;
	}

	/**
	 * @return the geoModel
	 */
	public MapModel getGeoModel() {
		return geoModel;
	}

	/**
	 * @param geoModel the geoModel to set
	 */
	public void setGeoModel(MapModel geoModel) {
		this.geoModel = geoModel;
	}

	/**
	 * @return the centerGeoMap
	 */
	public String getCenterGeoMap() {
		return centerGeoMap;
	}

	/**
	 * @param centerGeoMap the centerGeoMap to set
	 */
	public void setCenterGeoMap(String centerGeoMap) {
		this.centerGeoMap = centerGeoMap;
	}

	/**
	 * @return the exibir
	 */
	public boolean isExibir() {
		return exibir;
	}

	/**
	 * @param exibir the exibir to set
	 */
	public void setExibir(boolean exibir) {
		this.exibir = exibir;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}