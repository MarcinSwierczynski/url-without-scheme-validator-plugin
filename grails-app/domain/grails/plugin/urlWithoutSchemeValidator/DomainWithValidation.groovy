package grails.plugin.urlWithoutSchemeValidator

import grails.plugin.urlWithoutSchemeValidator.utils.UrlScheme
import grails.plugin.urlWithoutSchemeValidator.utils.UrlValidatorUtils

class DomainWithValidation {

	static transients = ['httpUrl', 'ftpUrl']

	String url

	static constraints = {
	    url nullable: true, urlWithoutScheme: true
	}

	String getHttpUrl() {
		UrlValidatorUtils.prefixSchemeIfNecessary(url)
	}

	String getFtpUrl() {
		UrlValidatorUtils.prefixSchemeIfNecessary(url, UrlScheme.FTP)
	}

}
