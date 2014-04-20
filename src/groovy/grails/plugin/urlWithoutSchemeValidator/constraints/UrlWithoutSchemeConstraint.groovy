package grails.plugin.urlWithoutSchemeValidator.constraints

import grails.plugin.urlWithoutSchemeValidator.utils.UrlValidatorUtils
import org.codehaus.groovy.grails.validation.AbstractConstraint
import org.springframework.validation.Errors

/**
 * Date: 20.04.2014 at 15:50
 *
 * @author Marcin Świerczyński
 */
class UrlWithoutSchemeConstraint extends AbstractConstraint {

	public static final String CONSTRAINT_NAME = "urlWithoutScheme"
	private static final String DEFAULT_MESSAGE_CODE = "default.url.without.schema.not.valid.message"

	private shouldValidate

	@Override
	void setParameter(final Object constraintParameter) {
		if (!(constraintParameter instanceof Boolean)) {
			throw new IllegalArgumentException("Parameter for constraint ["
					+ CONSTRAINT_NAME + "] of property ["
					+ constraintPropertyName + "] of class ["
					+ constraintOwningClass + "] must be a boolean value")
		}

		this.shouldValidate = ((Boolean) constraintParameter).booleanValue()
		super.setParameter(constraintParameter)
	}

	@Override
	protected void processValidate(final Object target, final Object propertyValue, final Errors errors) {
		if (shouldValidate && !UrlValidatorUtils.isValid(propertyValue as String)) {
			Object[] args = [constraintPropertyName, constraintOwningClass, propertyValue]
			super.rejectValue(target, errors, DEFAULT_MESSAGE_CODE, "not." + CONSTRAINT_NAME, args)
		}
	}

	@Override
	boolean supports(final Class type) {
		type && String.class.isAssignableFrom(type)
	}

	@Override
	String getName() {
		CONSTRAINT_NAME
	}

}
