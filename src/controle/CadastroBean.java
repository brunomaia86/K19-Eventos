package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import modelo.Estado;

@ManagedBean
@SessionScoped
public class CadastroBean {

	private String nome;
	private String cidade;
	private String siglaDoEstadoEscolhido;

	private Estado estadoSelecionado = new Estado();
	private List<Estado> estados = new ArrayList<Estado>();

	public CadastroBean() {
		Estado sp = new Estado();
		sp.setSigla("SP");
		sp.setNome("S�o Paulo");
		sp.getCidades().add("S�o Paulo");
		sp.getCidades().add("Campinas");

		Estado rj = new Estado();
		rj.setSigla("RJ");
		rj.setNome("Rio de Janeiro");
		rj.getCidades().add("Rio de Janeiro");
		rj.getCidades().add("Niter�i");

		Estado rn = new Estado();
		rn.setSigla("RN");
		rn.setNome("Rio Grande do Norte");
		rn.getCidades().add("Natal");
		rn.getCidades().add("Mossor�");

		this.getEstados().add(sp);
		this.getEstados().add(rj);
		this.getEstados().add(rn);
	}

	public void mudaEstado(ValueChangeEvent event) {
		this.siglaDoEstadoEscolhido = event.getNewValue().toString();
		for (Estado e : this.getEstados()){
			if (e.getSigla().equals(this.siglaDoEstadoEscolhido)) {
				this.estadoSelecionado = e;
				break;
			}
		}
		FacesContext.getCurrentInstance().renderResponse();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getSiglaDoEstadoEscolhido() {
		return siglaDoEstadoEscolhido;
	}

	public void setSiglaDoEstadoEscolhido(String siglaDoEstadoEscolhido) {
		this.siglaDoEstadoEscolhido = siglaDoEstadoEscolhido;
	}

	public Estado getEstadoSelecionado() {
		return estadoSelecionado;
	}

	public void setEstadoSelecionado(Estado estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

}
