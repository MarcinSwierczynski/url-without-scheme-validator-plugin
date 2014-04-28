package grails.plugin.urlWithoutSchemeValidator.utils

import spock.lang.Specification

import static grails.plugin.urlWithoutSchemeValidator.utils.UrlScheme.COLON
import static grails.plugin.urlWithoutSchemeValidator.utils.UrlScheme.FTP

/**
 * Date: 20.04.2014 at 15:37
 *
 * @author Marcin Świerczyński
 */
class UrlValidatorUtilsSpec extends Specification {

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

	void "should return url with scheme as it is"() {
		expect:
		UrlValidatorUtils.prefixSchemeIfNecessary(scheme + COLON + 'www.google.com') == scheme + COLON + 'www.google.com'

		where:
		scheme  | _
		'http'  | _
		'https' | _
		'ftp'   | _
	}

	void "should add default scheme to url without scheme"() {
		expect:
		UrlValidatorUtils.prefixSchemeIfNecessary('www.google.com') == 'http://www.google.com'
	}

	void "should add provided scheme to url without scheme"() {
		expect:
		UrlValidatorUtils.prefixSchemeIfNecessary('www.google.com', FTP) == 'ftp://www.google.com'
	}

	void "should add default scheme to any string"() {
		expect:
		UrlValidatorUtils.prefixSchemeIfNecessary('www.google') == 'http://www.google'
	}

	void "should return null on null input"() {
		expect:
		UrlValidatorUtils.prefixSchemeIfNecessary(null) == null
	}

}
