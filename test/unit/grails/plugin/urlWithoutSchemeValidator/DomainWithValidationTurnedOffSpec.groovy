package grails.plugin.urlWithoutSchemeValidator

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(DomainWithValidationTurnedOff)
class DomainWithValidationTurnedOffSpec extends Specification {

	void "should consider valid domain valid"() {
		given:
		DomainWithValidationTurnedOff domain = new DomainWithValidationTurnedOff(url: 'www.google.com')

		expect:
		domain.validate()
	}

	void "should consider invalid domain valid"() {
		given:
		DomainWithValidationTurnedOff domain = new DomainWithValidationTurnedOff(url: 'www.google')

		expect:
		domain.validate()
	}

}
