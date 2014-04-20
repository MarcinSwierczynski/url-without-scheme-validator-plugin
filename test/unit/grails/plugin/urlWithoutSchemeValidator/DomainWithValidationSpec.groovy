package grails.plugin.urlWithoutSchemeValidator

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(DomainWithValidation)
class DomainWithValidationSpec extends Specification {

	void "should consider valid domain valid"() {
		given:
		DomainWithValidation domain = new DomainWithValidation(url: 'www.google.com')

		expect:
		domain.validate()
	}

	void "should consider invalid domain invalid"() {
		given:
		DomainWithValidation domain = new DomainWithValidation(url: 'www.google')

		expect:
		!domain.validate()
		domain.errors.getFieldError('url')
	}

	void "should consider null URL valid"() {
		given:
		DomainWithValidation domain = new DomainWithValidation(url: null)

		expect:
		domain.validate()
	}

}
