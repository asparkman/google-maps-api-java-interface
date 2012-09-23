package org.google.maps.api.geocoder;

import org.google.maps.api.core.Coord;

/**
 * This class evolves the toString method of the <code>Coord</code> to return a
 * String that is ready for encoding into a URL.
 * 
 * @author Alex Sparkman
 * 
 */
public class LatLng extends Coord {
	/**
	 * 
	 * @param lat
	 *            The latitude of the <code>Coord</code> in degrees.
	 * @param lng
	 *            The longitude of the <code>Coord</code> in degrees.
	 */
	public LatLng(double lat, double lng) {
		super(lat, lng);
	}
	
	public LatLng(Coord coord) {
		super(coord.getLat(), coord.getLng());
	}

	@Override
	public String toString() {
		return lat + "," + lng;
	}

}
