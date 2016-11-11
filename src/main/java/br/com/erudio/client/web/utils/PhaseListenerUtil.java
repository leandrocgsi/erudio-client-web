package br.com.erudio.client.web.utils;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class PhaseListenerUtil implements PhaseListener {
                
    @Override
    public void beforePhase(PhaseEvent fase) {
        System.out.println("Antes da Fase: " + fase.getPhaseId());        
    }

    @Override
    public void afterPhase(PhaseEvent fase) {
        System.out.println("Depois da Fase: " + fase.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }    

}