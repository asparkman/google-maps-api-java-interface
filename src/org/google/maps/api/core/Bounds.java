package org.google.maps.api.core;

import java.util.ArrayList;
import java.util.Hashtable;

import org.alex.code.validation.Validatable;
import org.alex.code.validation.ValidationResult;

/**
 * This class encapsulates the information for the bounds of a viewport over a
 * spherical coordinate system.
 * 
 * @author Alex Sparkman
 * 
 */
public class Bounds implements Validatable {
	protected Coord northEast;
	protected Coord southWest;

	/**
	 * 
	 * @param northEast The north east coordinate of the viewport.
	 * @param southWest The south west coordinate of the viewport.
	 */
	public Bounds(Coord northEast, Coord southWest) {
		super();
		this.northEast = northEast;
		this.southWest = southWest;
	}

	/**
	 * 
	 * @return The north east coordinate of the viewport.
	 */
	public Coord getNorthEast() {
		return northEast;
	}

	/**
	 * 
	 * @return The south west coordinate of the viewport.
	 */
	public Coord getSouthWest() {
		return southWest;
	}

	/**
	 * 
	 * @param northEast The north east coordinate of the viewport.
	 */
	public void setNorthEast(Coord northEast) {
		this.northEast = northEast;
	}

	/**
	 * 
	 * @param southWest The south west coordinate of the viewport.
	 */
	public void setSouthWest(Coord southWest) {
		this.southWest = southWest;
	}

	@Override
	public ValidationResult validate(String name) {
		return validate(null, name);
	}

	@Override
	public ValidationResult validate(ValidationResult parent, String name) {
		ArrayList<ValidationResult> memberValidationResults = new ArrayList<ValidationResult>();
		ValidationResult validationResult = new ValidationResult(name,
				new ArrayList<String>(), new ArrayList<String>(),
				new Hashtable<String, String>(),
				new Hashtable<String, String>(),
				new ArrayList<ValidationResult>(), parent);
		memberValidationResults.add(northEast.validate(validationResult,
				"northEast"));
		memberValidationResults.add(southWest.validate(validationResult,
				"southWest"));
		return validationResult;
	}
}
