package grails.plugin.urlWithoutSchemeValidator.utils

import spock.lang.Specification

/**
 * Date: 20.04.2014 at 15:37
 *
 * @author Marcin Świerczyński
 */
class UrlValidatorUtilsSpec extends Specification {

	private static final String COLON = '://'

	void "should consider url starting with known schemes valid"() {
		expect:
		UrlValidatorUtils.isValid(scheme + COLON + 'www.google.com')

		where:
		scheme  | _
		'http'  | _
		'https' | _
		'ftp'   | _
	}

	void "should consider url starting with unknown scheme invalid"() {
		expect:
		!UrlValidatorUtils.isValid('scheme' + COLON + 'www.google.com')
	}

	void "should consider url with no scheme valid"() {
		expect:
		UrlValidatorUtils.isValid('www.google.com')
	}

	void "should consider invalid url with scheme invalid"() {
		expect:
		!UrlValidatorUtils.isValid('http://www.google')
	}

	void "should consider null invalid"() {
		expect:
		!UrlValidatorUtils.isValid(null)
	}

}
