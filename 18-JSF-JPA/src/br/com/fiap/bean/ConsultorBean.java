package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.ConsultorBO;
import br.com.fiap.entity.Consultor;

@ManagedBean
public class ConsultorBean {

	private Consultor consultor;
	private ConsultorBO bo;
	
	@PostConstruct
	private void init(){
		consultor  = new Consultor();
		bo = new ConsultorBO();
	}
	
	public String cadastrar(){
		FacesMessage msg;
		try {
			bo.cadastrar(consultor);
			msg = new FacesMessage("Consultor cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao cadastrar");
			return "cadastro_consultor"; //Nome da pagina 
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Manter a msg de sucesso
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "lista_consultor?faces-redirect=true"; //Nome da pagina 
	}
	
	public Consultor getConsultor() {
		return consultor;
	}

	public void setConsultor(Consultor consultor) {
		this.consultor = consultor;
	}
	
}
