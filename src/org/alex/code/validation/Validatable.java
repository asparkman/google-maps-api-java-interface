package org.alex.code.validation;

/**
 * Standard interface for objects to retrieve a ValidationResult object that
 * represents the validation state of the object.
 * 
 * @author Alex Sparkman
 * 
 */
public interface Validatable {
	/**
	 * @param name
	 *            The name of the object being validated.
	 * @return The result of validating the object's primitive and non-primitive
	 *         members.  This should never be null.
	 */
	public ValidationResult validate(String name);

	/**
	 * 
	 * @param parent
	 *            The parent of this object.
	 * @param name
	 *            The name of the object being validated.
	 * @return The result of validating the object's primitive and non-primitive
	 *         members.  This should never be null.
	 */
	public ValidationResult validate(ValidationResult parent, String name);
}
