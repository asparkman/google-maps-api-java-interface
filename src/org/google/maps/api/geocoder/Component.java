package org.google.maps.api.geocoder;

import java.util.ArrayList;
import java.util.Hashtable;

import org.alex.code.validation.Validatable;
import org.alex.code.validation.ValidationResult;

/**
 * Encapsulates a name value pair with a toString method that will return the
 * Component formatted for encoding into a URL.
 * 
 * @author Alex Sparkman
 * 
 */
public class Component implements Validatable {
	protected ComponentName name;
	protected String value;

	public Component(ComponentName name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public ComponentName getComponent() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public void setComponent(ComponentName name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return name + ":" + value;
	}

	@Override
	public ValidationResult validate(String name) {
		return validate(null, name);
	}

	@Override
	public ValidationResult validate(ValidationResult parent, String name) {
		return new ValidationResult(name, new ArrayList<String>(),
				new ArrayList<String>(), new Hashtable<String, String>(),
				new Hashtable<String, String>(),
				new ArrayList<ValidationResult>(), parent);
	}
}
