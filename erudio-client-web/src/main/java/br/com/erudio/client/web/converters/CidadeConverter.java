package br.com.erudio.client.web.converters;



import br.com.erudio.client.web.factory.Factory;
import br.com.erudio.utils.database.beans.BeanCidade;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


@ManagedBean
public class CidadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		Integer id = Integer.parseInt(value);

		return Factory.getServices().findAllCidades();
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}

		Integer id = ((BeanCidade) value).getIdCidade();

		return (id != null) ? id.toString() : null;
	}

}
