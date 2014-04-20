package grails.plugin.urlWithoutSchemeValidator

class DomainWithWrongValidatorParameter {

	String url

	static constraints = {
		url urlWithoutScheme: 5
	}

}
