package grails.plugin.urlWithoutSchemeValidator

class DomainWithValidationTurnedOff {

	String url

	static constraints = {
		url urlWithoutScheme: false
	}
}
