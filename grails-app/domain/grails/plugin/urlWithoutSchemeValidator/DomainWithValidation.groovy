package grails.plugin.urlWithoutSchemeValidator

class DomainWithValidation {

	String url

	static constraints = {
	    url urlWithoutScheme: true
	}

}
