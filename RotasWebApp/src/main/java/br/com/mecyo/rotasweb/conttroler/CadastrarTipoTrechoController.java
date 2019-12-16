/**
 * 
 */
package br.com.mecyo.rotasweb.conttroler;

import java.io.IOException;

import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mecyo.rotasweb.entity.TipoTrecho;
import br.com.mecyo.rotasweb.repository.TipoTrechoRepository;
import br.com.mecyo.rotasweb.util.Uteis;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
@Named(value="cadastrarTipoTrechoController")
@RequestScoped
public class CadastrarTipoTrechoController {
 
	@Inject
	private TipoTrecho tipoTrecho;

	@Inject
	private TipoTrechoRepository webService;
	
	public void Salvar(){
		 
		webService.cadastrar(tipoTrecho);
		
		this.tipoTrecho = null;
 
		Uteis.MensagemInfo("", "TipoTrecho cadastrado com sucesso!");
		Voltar();
	}
	
	public void Editar(){
		 
		webService.editar(tipoTrecho);
		
		this.tipoTrecho = null;
 
		Uteis.MensagemInfo("", "TipoTrecho alterado com sucesso!");
		Voltar();
	}
	
	public void Voltar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("listaTipoTrechos.xhtml");
		} catch (IOException e) {
			Uteis.MensagemAtencao(e.getMessage());
		}
	}
	
	/**
	 * @return the tipoTrecho
	 */
	public TipoTrecho getTipoTrecho() {
		return tipoTrecho;
	}

	/**
	 * @param tipoTrecho the tipoTrecho to set
	 */
	public void setTipoTrecho(TipoTrecho tipoTrecho) {
		this.tipoTrecho = tipoTrecho;
	}
}