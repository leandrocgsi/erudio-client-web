package br.com.erudio.client.web.controller;

import br.com.erudio.client.web.factory.Factory;
import br.com.erudio.client.web.utils.FacesMessageUtil;
import br.com.erudio.utils.database.beans.BeanCidade;
import br.com.erudio.utils.service.interfaces.IServices;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.apache.log4j.Logger;

@ManagedBean(name = "mbCidade")
@RequestScoped
public class MbCidade implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Logger logger = Logger.getLogger(this.getClass());
    
    private BeanCidade cidade = new BeanCidade();
    
    private List<BeanCidade> cidades = new ArrayList<BeanCidade>();
    private IServices services = Factory.getServices();
    

    public MbCidade() {
    }

    public String limpCidade() {
        cidades = new ArrayList<BeanCidade>();
        cidade = new BeanCidade();
        return "/restrict/cadastrarcidades.faces";
    }
    
    public String addCidade() {
        if ((cidade.getIdCidade() == null) || (cidade.getIdCidade() == 0)) {
            //services.saveCidade(cidade);
            FacesMessageUtil.message("INFO", "Gravação efetuada com sucesso", null);
        } else {
            //services.updateCidade(cidade);
            FacesMessageUtil.message("INFO", "Informações atualizadas com sucesso", null);
        }
        return limpCidade();
    }
    
    public String deleteCidade(BeanCidade cidade) {
        //services.deleteCidade(cidade);
        FacesMessageUtil.message("INFO", "Cidade excluída com sucesso", null);
        return limpCidade();
    }

    public List<BeanCidade> getCidades() {
        this.logger.info(services);
        if (cidades == null || cidades.isEmpty()) {            
                cidades = services.findAllCidades();
        }        
        return cidades;
    }

    public BeanCidade getCidade() {
        return cidade;
    }

    public void setCidade(BeanCidade cidade) {
        this.cidade = cidade;
    }

}