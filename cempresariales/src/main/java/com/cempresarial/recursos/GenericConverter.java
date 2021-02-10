package com.cempresarial.recursos;

import javax.faces.convert.FacesConverter;

import com.cempresarial.entities.ZonaEstructural;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


@FacesConverter(value = "genericConverter", forClass = GenericConverter.class)
public class GenericConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		if (value != null) {
            return component.getAttributes().get(value);
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (value != null && value instanceof ZonaEstructural) {
			ZonaEstructural generalCollDTO = (ZonaEstructural) value;

            if (generalCollDTO.getNombreZonaEstructural() != null) {
                component.getAttributes().put(generalCollDTO.getNombreZonaEstructural(), value);
                return generalCollDTO.getNombreZonaEstructural();
            }
        }
        return null;
	}

	public Long getAsLong(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub

		long num = 0L;
		if (value.isEmpty()) {
			return null;
		}
		try {
			 num = Long.valueOf(value);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return num;
	}

}
