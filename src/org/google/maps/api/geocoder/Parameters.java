package org.google.maps.api.geocoder;

import java.util.ArrayList;
import java.util.Hashtable;

import org.alex.code.validation.Validatable;
import org.alex.code.validation.ValidationResult;
import org.google.maps.api.core.Bounds;
import org.google.maps.api.core.Coord;

/**
 * Encapsulates the validation and properties needed for Google Geocoding API
 * requests.
 * 
 * Refer to the
 * <link>https://developers.google.com/maps/documentation/geocoding/</link> page
 * for details on each parameter.
 * 
 * @author Alex Sparkman
 * 
 */
public class Parameters implements Validatable {
	// Required parameters
	protected String address;
	protected LatLng latlng;
	protected Components components;
	protected boolean sensor;

	// Optional parameters
	protected Bounds bounds;
	protected String language;
	protected String region;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Coord getLatlng() {
		return latlng;
	}

	public void setLatlng(Coord latlng) {
		this.latlng = new LatLng(latlng);
	}

	public Components getComponents() {
		return components;
	}

	public void setComponents(Components components) {
		this.components = components;
	}

	public boolean isSensor() {
		return sensor;
	}

	public void setSensor(boolean sensor) {
		this.sensor = sensor;
	}

	public Bounds getBounds() {
		return bounds;
	}

	public void setBounds(Bounds bounds) {
		this.bounds = bounds;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Parameters(String address, Coord latlng, Components components,
			boolean sensor, Bounds bounds, String language, String region) {
		super();
		this.address = address;
		this.latlng = new LatLng(latlng);
		this.components = components;
		this.sensor = sensor;
		this.bounds = bounds;
		this.language = language;
		this.region = region;
	}

	@Override
	public ValidationResult validate(ValidationResult parent, String name) {
		ArrayList<String> globalErrors = new ArrayList<String>();
		ArrayList<String> globalWarnings = new ArrayList<String>();
		Hashtable<String, String> errors = new Hashtable<String, String>();
		Hashtable<String, String> warnings = new Hashtable<String, String>();
		ArrayList<ValidationResult> memberValidationResults = new ArrayList<ValidationResult>();
		ValidationResult validationResult = new ValidationResult(name,
				globalErrors, globalWarnings, errors, warnings,
				memberValidationResults, parent);

		if (address == null && latlng == null && components == null) {
			globalErrors
					.add("The address, latlng, or components parameters must be provided.");
		}

		if (address != null && latlng != null) {
			globalWarnings
					.add("A request with both the address and latlng parameters provided may cause undesired results.");
		}

		if (components != null) {
			ValidationResult componentsValidationResult = components.validate(
					validationResult, "components");
			if (componentsValidationResult.hasErrors()
					|| componentsValidationResult.hasWarnings())
				memberValidationResults.add(componentsValidationResult);
		}

		if (bounds != null) {
			ValidationResult boundsValidationResult = components.validate(
					validationResult, "bounds");
			if (boundsValidationResult.hasErrors()
					|| boundsValidationResult.hasWarnings())
				memberValidationResults.add(boundsValidationResult);
		}

		return validationResult;
	}

	@Override
	public ValidationResult validate(String name) {
		return validate(null, name);
	}

}
