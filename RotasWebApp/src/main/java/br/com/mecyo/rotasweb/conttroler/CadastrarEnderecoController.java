/**
 * 
 */
package br.com.mecyo.rotasweb.conttroler;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mecyo.rotasweb.entity.Endereco;
import br.com.mecyo.rotasweb.repository.EnderecoRepository;
import br.com.mecyo.rotasweb.util.Uteis;

/**
 * @author Emerson Santos (Mecyo)
 *
 */
@Named(value="cadastrarEnderecoController")
@RequestScoped
public class CadastrarEnderecoController {
	
	@Inject
	private Endereco endereco;

	@Inject
	private EnderecoRepository webService;
	
	public String SalvarNovoEndereco(){
 
		webService.cadastrarEndereco(endereco);
		
		this.endereco = null;
 
		Uteis.MensagemInfo("Endereço cadastrado com sucesso!");
		return "listaEnderecos.xhtml";
	}
	
	public void Voltar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("listaEnderecos.xhtml");
		} catch (IOException e) {
			Uteis.MensagemAtencao(e.getMessage());
		}
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
}