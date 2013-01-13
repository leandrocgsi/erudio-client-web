package br.com.erudio.client.web.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesMessageUtil {

    public static void message(String type, String message, String title) {
        if ("INFO".equals(type)) {
            infoMessage(message, title);
        } else if ("ERROR".equals(type)) {
            errorMessage(message, title);
        } else if ("FATAL".equals(type)) {
            fatalMessage(message, title);
        } else if ("WARN".equals(type)){//Por fim  
            warnMessage(message, title);
        } else {
            fatalMessage("Por verifique os parâmetros passados.", "Tipo de mensagem não encontrado!");
        }
    }

    private static void errorMessage(String message, String title) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                message, title));
    }

    private static void fatalMessage(String message, String title) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                message, title));
    }

    private static void infoMessage(String message, String title) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                message, title));
    }

    private static void warnMessage(String message, String title) {         
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                message, title));
    }

}
