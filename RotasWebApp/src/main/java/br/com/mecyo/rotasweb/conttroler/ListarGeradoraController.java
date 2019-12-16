/**
 * 
 */
package br.com.mecyo.rotasweb.conttroler;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mecyo.rotasweb.entity.Geradora;
import br.com.mecyo.rotasweb.repository.GeradoraRepository;
import br.com.mecyo.rotasweb.util.Uteis;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
@Named(value="listarGeradoraController")
@RequestScoped
public class ListarGeradoraController implements Serializable {
    
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	private List<Geradora> geradoras;

	private Geradora selectedGeradora;

	@Inject
	private GeradoraRepository webService;
	
	@PostConstruct
	public void init() {
		if (geradoras == null) {
			geradoras = webService.findAll();
		}
	}

	public String Editar() {
		return null;
	}

	public void Excluir() {
		webService.excluir(selectedGeradora);
	}

	public void Cadastrar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroGeradora.xhtml");
		} catch (IOException e) {
			Uteis.MensagemAtencao(e.getMessage());
		}
	}

	public void Voltar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		} catch (IOException e) {
			Uteis.MensagemAtencao(e.getMessage());
		}
	}

	/**
	 * @return the geradoras
	 */
	public List<Geradora> getGeradoras() {
		return geradoras;
	}

	/**
	 * @param geradoras the geradoras to set
	 */
	public void setGeradoras(List<Geradora> geradoras) {
		this.geradoras = geradoras;
	}
}