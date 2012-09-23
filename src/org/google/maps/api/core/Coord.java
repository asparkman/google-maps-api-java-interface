package org.google.maps.api.core;

import java.util.ArrayList;
import java.util.Hashtable;

import org.alex.code.validation.Validatable;
import org.alex.code.validation.ValidationResult;

/**
 * This class encapsulates the properties of a single point in a spherical
 * coordinate system.
 * 
 * @author Alex Sparkman
 * 
 */
public class Coord implements Validatable {
	protected double lat;
	protected double lng;

	/**
	 * 
	 * @param lat
	 *            The latitude of the Coord in degrees.
	 * @param lng
	 *            The longitude of the Coord in degrees.
	 */
	public Coord(double lat, double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}

	/**
	 * 
	 * @return The latitude of this Coord in degrees.
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * 
	 * @return The longitude of this Coord in degrees.
	 */
	public double getLng() {
		return lng;
	}

	/**
	 * 
	 * @param lat
	 *            The latitude of this Coord in degrees.
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * 
	 * @param lng
	 *            The longitude of this Coord in degrees.
	 */
	public void setLng(double lng) {
		this.lng = lng;
	}

	@Override
	public ValidationResult validate(String name) {
		return validate(null, name);
	}

	@Override
	public ValidationResult validate(ValidationResult parent, String name) {
		Hashtable<String, String> errors = new Hashtable<String, String>();

		if (lat >= 90.0 || lat <= -90.0) {
			errors.put("lat", "Must be between 90.0 and -90.0 degrees.");
		}

		if (lng >= 180.0 || lng <= -180.0) {
			errors.put("lng", "Must be between 180.0 and 180.0 degrees.");
		}

		return new ValidationResult(name, new ArrayList<String>(),
				new ArrayList<String>(), errors,
				new Hashtable<String, String>(),
				new ArrayList<ValidationResult>(), parent);
	}

}
