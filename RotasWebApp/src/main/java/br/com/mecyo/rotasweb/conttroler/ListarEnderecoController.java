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
import javax.servlet.http.HttpServletRequest;

import br.com.mecyo.rotasweb.entity.Endereco;
import br.com.mecyo.rotasweb.repository.EnderecoRepository;
import br.com.mecyo.rotasweb.util.Uteis;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
@Named(value = "listarEnderecoController")
@RequestScoped
public class ListarEnderecoController {

	private List<Endereco> enderecos;

	@Inject
	private Endereco selectedEndereco;

	@Inject
	private EnderecoRepository webService;
	
	@PostConstruct
	public void init() {
		if (enderecos == null) {
			enderecos = webService.findAll();
		}
	}

	public String Editar(Endereco selectedEndereco) {
		if(selectedEndereco != null){
			HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			request.getSession().setAttribute("endereco", selectedEndereco);
		}
		return "cadastroEndereco.xhtml";
	}

	public void Excluir() {
		webService.excluir(selectedEndereco);
	}

	public void Cadastrar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroEndereco.xhtml");
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
	 * @return the enderecos
	 */
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	/**
	 * @param enderecos the enderecos to set
	 */
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	/**
	 * @return the selectedEndereco
	 */
	public Endereco getSelectedEndereco() {
		return selectedEndereco;
	}

	/**
	 * @param selectedEndereco the selectedEndereco to set
	 */
	public void setSelectedEndereco(Endereco selectedEndereco) {
		this.selectedEndereco = selectedEndereco;
	}
}