package br.com.erudio.client.web.factory;

import br.com.erudio.utils.service.interfaces.IServices;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Factory {

	private static IServices services;

	@Inject
	public Factory(IServices services) {
		Factory.services = services;
	}

	public static IServices getServices() {
		return services;
	}

}
