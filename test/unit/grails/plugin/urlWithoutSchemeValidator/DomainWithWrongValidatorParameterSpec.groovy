package grails.plugin.urlWithoutSchemeValidator

import grails.test.mixin.TestFor
import org.codehaus.groovy.grails.validation.exceptions.ConstraintException
import spock.lang.Specification

@TestFor(DomainWithWrongValidatorParameter)
class DomainWithWrongValidatorParameterSpec extends Specification {

	void "should throw exception is validator configuration is invalid"() {
		given:
		DomainWithWrongValidatorParameter domain = new DomainWithWrongValidatorParameter(url: 'www.google.com')

		when:
		domain.validate()

		then:
		thrown(ConstraintException)
	}

}
