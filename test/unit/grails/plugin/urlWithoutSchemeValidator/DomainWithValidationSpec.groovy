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
		DomainWithValidation domain = new DomainWithValidation(url: 'www.google.notexistingtld')

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

	void "should get HTTP url"() {
		given:
		DomainWithValidation domain = new DomainWithValidation(url: 'www.google.com')

		expect:
		domain.url == 'www.google.com'
		domain.httpUrl == 'http://www.google.com'
	}

	void "should get FTP url"() {
		given:
		DomainWithValidation domain = new DomainWithValidation(url: 'www.google.com')

		expect:
		domain.url == 'www.google.com'
		domain.ftpUrl == 'ftp://www.google.com'
	}

	void "should leave url scheme if already there"() {
		given:
		DomainWithValidation domain = new DomainWithValidation(url: 'http://www.google.com')

		expect:
		domain.url == 'http://www.google.com'
		domain.httpUrl == 'http://www.google.com'
		domain.ftpUrl == 'http://www.google.com'
	}

	void "should validate .swiss domain as valid"() {
		given:
		DomainWithValidation domain = new DomainWithValidation(url: 'http://dot.swiss')

		expect:
		domain.validate()
	}

}
