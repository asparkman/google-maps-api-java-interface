package org.alex.code.validation;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * This class is intended for provide validation for primitive and non-primitive
 * members of a class. The class mirrors the tree-like aggregation model.
 * Warnings and errors in validating primitive members can be captured in the
 * errors and warnings fields, while non-primitive warnings and errors can be
 * captured in the memberValidationResults fields. The name provides an
 * identifier for the object or class name, as does the key in the errors and
 * warnings hashtables.
 * 
 * @author Alex Sparkman
 * 
 */
public class ValidationResult {
	protected String name;
	protected ArrayList<String> globalErrors;
	protected ArrayList<String> globalWarnings;
	protected Hashtable<String, String> errors;
	protected Hashtable<String, String> warnings;
	protected ArrayList<ValidationResult> memberValidationResults;
	protected ValidationResult parentValidationResult;

	/**
	 * 
	 * @param name
	 *            The name of the non-primitive member that this
	 *            ValidationResult object represents.
	 * @param globalErrors
	 *            The global errors found during the validation of the object as
	 *            a whole.
	 * @param globalWarning
	 *            The global warnings found during the validation of the object
	 *            as a whole.
	 * @param errors
	 *            The errors found on the primitive types of the object
	 *            validated.
	 * @param warnings
	 *            The warnings found on the primitive types of the object
	 *            validated.
	 * @param memberValidationResults
	 *            The ValidationResult objects for each non-primitive member of
	 *            the object that failed validation.
	 * @param parentValidationResult
	 *            The parent ValidationResult of this ValidationResult. This
	 *            should be null if this is the root of the tree.
	 */
	public ValidationResult(String name, ArrayList<String> globalErrors,
			ArrayList<String> globalWarnings, Hashtable<String, String> errors,
			Hashtable<String, String> warnings,
			ArrayList<ValidationResult> memberValidationResults,
			ValidationResult parentValidationResult) {
		super();
		this.name = name;
		this.globalErrors = globalErrors;
		this.globalWarnings = globalWarnings;
		this.errors = errors;
		this.warnings = warnings;
		this.memberValidationResults = memberValidationResults;
		this.parentValidationResult = parentValidationResult;
	}

	/**
	 * 
	 * @return The errors found on the primitive types of the object validated.
	 */
	public Hashtable<String, String> getErrors() {
		return errors;
	}

	/**
	 * 
	 * @return The identifier that this ValidationResult represents.
	 */
	public String getKey() {
		return (parentValidationResult == null ? this.name
				: parentValidationResult.getName() + "." + this.name);
	}

	/**
	 * 
	 * @return The ValidationResult objects for each non-primitive member of the
	 *         object validated. This should be empty if all non-primitive
	 *         members contain no warnings or errors.
	 */
	public ArrayList<ValidationResult> getMemberValidationResults() {
		return memberValidationResults;
	}

	/**
	 * 
	 * @return The name of the non-primitive member that this ValidationResult
	 *         object represents.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return The global errors that are found during the validation of the
	 *         object as a whole.
	 */
	public ArrayList<String> getGlobalErrors() {
		return globalErrors;
	}

	/**
	 * 
	 * @return The global warnings that are found during the validation of the
	 *         object as a whole.
	 */
	public ArrayList<String> getGlobalWarnings() {
		return globalWarnings;
	}

	/**
	 * 
	 * @return The parent ValidationResult of this ValidationResult.
	 */
	public ValidationResult getParentValidationResult() {
		return parentValidationResult;
	}

	/**
	 * 
	 * @return The warnings found on the primitive types of the object
	 *         validated.
	 */
	public Hashtable<String, String> getWarnings() {
		return warnings;
	}
	
	/**
	 * 
	 * @return Whether any errors are contained in this object's various
	 *         warning lists.
	 */
	public boolean hasErrors() {
		boolean hasNoErrors = errors.isEmpty() && globalErrors.isEmpty();
		for (int i = 0; i < memberValidationResults.size() && hasNoErrors; i++) {
			ValidationResult memberValidationResult = memberValidationResults
					.get(i);
			hasNoErrors = hasNoErrors && !memberValidationResult.hasErrors();
		}
		return !hasNoErrors;
	}

	/**
	 * 
	 * @return Whether any warnings are contained in this object's various
	 *         warning lists.
	 */
	public boolean hasWarnings() {
		boolean hasNoWarnings = warnings.isEmpty() && globalWarnings.isEmpty();
		for (int i = 0; i < memberValidationResults.size() && hasNoWarnings; i++) {
			ValidationResult memberValidationResult = memberValidationResults
					.get(i);
			hasNoWarnings = hasNoWarnings
					&& !memberValidationResult.hasWarnings();
		}
		return !hasNoWarnings;
	}

	/**
	 * 
	 * @return Whether the object was found to be valid or not.
	 */
	public boolean isValid() {
		return hasErrors();
	}
}
