package com.google.maps.api;

import java.net.URL;
import java.util.ArrayList;

import com.aetna.amss.meeting.Coord;

public class Geocoder {
	public static enum Status {
		OK, ZERO_RESULTS, OVER_QUERY_LIMIT, REQUEST_DENIED, INVALID_REQUEST
	}
	
	public static class Context {
		protected URL xmlUrl;
		protected URL jsonUrl;
		protected int queryLimit;
		
		
	}
	
	public static class Parameters {
		// Required parameters
		protected String address;
		protected Coord latlng;
		protected Components components;
		protected boolean sensor;
		
		// Optional parameters
		protected Bounds bounds;
		protected String language;
		protected String region;
	}
	
	public static class Bounds {
		protected Coord maxMax;
		protected Coord minMin;
	}
	
	public static class Components extends ArrayList<Component> {
		
	}
	
	public static enum ComponentName {
		route, locality, administrative_area, postal_code, country
	}
	
	public static class Component {
		protected ComponentName component;
		protected String value;
		public ComponentName getComponent() {
			return component;
		}
		public void setComponent(ComponentName component) {
			this.component = component;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public Component(ComponentName component, String value) {
			super();
			this.component = component;
			this.value = value;
		}
		@Override
		public String toString() {
			return component + ":" + value;
		}
	}
}
