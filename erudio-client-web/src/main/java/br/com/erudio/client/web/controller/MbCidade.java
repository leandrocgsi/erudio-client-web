package br.com.erudio.client.web.controller;

import br.com.erudio.client.web.factory.Factory;
import br.com.erudio.client.web.utils.FacesMessageUtil;
import br.com.erudio.utils.database.beans.BeanCidade;
import br.com.erudio.utils.service.interfaces.ICidadeUtilServices;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.log4j.Logger;

@ManagedBean(name = "mbCidade")
@SessionScoped
public class MbCidade implements Serializable {

    private static final long serialVersionUID = 1L;
    private final Logger logger = Logger.getLogger(this.getClass());
    private BeanCidade cidade = new BeanCidade();
    private ICidadeUtilServices serviceCidade  = Factory.getServiceCidade();
    private List<BeanCidade> cidades = new LinkedList<BeanCidade>();

    public List<BeanCidade> getCidades() {
        this.logger.info(serviceCidade);
        if (cidades == null || cidades.isEmpty()) {
            cidades = serviceCidade.findAllCidades();
        }
        return cidades;
    }

    public String save() {
        if (cidade.getIdCidade() == null || cidade.getIdCidade() == 0) {
            serviceCidade.saveCidade(cidade);
            FacesMessageUtil.infoMessage(null, "Informação gravada com sucesso!", null);
        } else {
            serviceCidade.updateCidade(cidade);
            FacesMessageUtil.infoMessage(null, "Informação atualizada com sucesso!", null);
        }
        return limpCidade();
    }

    public void editar(BeanCidade cidadeBean) {
        this.cidade = cidadeBean;
    }

    public String delete() {
        serviceCidade.deleteCidade(cidade);
        FacesMessageUtil.infoMessage(null, "Informação excuída com sucesso!", null);
        return limpCidade();        
    }

    public String limpCidade() {
        cidades = null;
        cidade = new BeanCidade();
        return "/restrict/cidade.xhtml";
    }

    public BeanCidade getCidade() {
        return cidade;
    }

    public void setCidade(BeanCidade cidade) {
        this.cidade = cidade;
    }
}
