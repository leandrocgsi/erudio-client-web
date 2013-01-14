package br.com.erudio.client.web.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesMessageUtil {

    public static void errorMessage(String clientId, String message, String title) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                message, title));
    }

    public static void fatalMessage(String clientId, String message, String title) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                message, title));
    }

    public static void infoMessage(String clientId, String message, String title) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_INFO,
                message, title));
    }

    public static void warnMessage(String clientId, String message, String title) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_WARN,
                message, title));
    }
}
