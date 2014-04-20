package grails.plugin.urlWithoutSchemeValidator

class DomainWithValidation {

	String url

	static constraints = {
	    url nullable: true, urlWithoutScheme: true
	}

}
