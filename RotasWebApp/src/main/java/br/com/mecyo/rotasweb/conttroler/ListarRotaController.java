/**
 * 
 */
package br.com.mecyo.rotasweb.conttroler;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mecyo.rotasweb.entity.Rota;
import br.com.mecyo.rotasweb.repository.RotaRepository;
import br.com.mecyo.rotasweb.util.Uteis;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
@Named(value="listarRotaController")
@RequestScoped
public class ListarRotaController {
 
	private List<Rota> rotas;

	private Rota selectedRota;

	@Inject
	private RotaRepository webService;

	@PostConstruct
	public void init() {
		if (rotas == null) {
			rotas = webService.findAll();
		}
	}

	public String Editar() {
		return null;
	}

	public void Excluir() {
		webService.excluir(selectedRota);
	}

	public void Cadastrar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroRota.xhtml");
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
	 * @return the rotas
	 */
	public List<Rota> getRotas() {
		return rotas;
	}

	/**
	 * @param rotas the rotas to set
	 */
	public void setRotas(List<Rota> rotas) {
		this.rotas = rotas;
	}

	/**
	 * @return the selectedRota
	 */
	public Rota getSelectedRota() {
		return selectedRota;
	}

	/**
	 * @param selectedRota the selectedRota to set
	 */
	public void setSelectedRota(Rota selectedRota) {
		this.selectedRota = selectedRota;
	}
}