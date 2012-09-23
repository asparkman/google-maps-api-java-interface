package org.google.maps.api.geocoder;

import java.util.ArrayList;
import java.util.Hashtable;

import org.alex.code.validation.Validatable;
import org.alex.code.validation.ValidationResult;

/**
 * Evolves the toString method of the <code>ArrayList</code> class to return a
 * string ready for encoding into a URL.
 * 
 * Refer to the
 * <link>https://developers.google.com/maps/documentation/geocoding/
 * #ComponentFiltering</link> page for more information on this parameter.
 * 
 * @author Alex Sparkman
 * 
 */
@SuppressWarnings("serial")
public class Components extends ArrayList<Component> implements Validatable {

	@Override
	public String toString() {
		String out = "";
		for (int i = 0; i < this.size(); i++) {
			out += this.get(i).toString();
			if (i != this.size() - 1) {
				out += "|";
			}
		}
		return out;
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
				new Hashtable<String, String>(), memberValidationResults,
				parent);
		for (int i = 0; i < this.size(); i++) {
			memberValidationResults.add(this.get(i).validate(
					Integer.valueOf(i).toString()));
		}

		return validationResult;
	}
}
