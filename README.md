# UrlWithoutSchemeValidator Grails Plugin

## Summary
The Url Without Scheme Validator Plugin allows to use custom validator that validates the URLs but - different than standard validator - does not care if the scheme (ex. http, ftp) is provided or not. Moreover, it can be used like "first-class", built-in validator.

## Instalation
Add the following to your _grails-app/conf/BuildConfig.groovy_

	…
	plugins {
	…
		 compile ':url-without-scheme-validator:0.1'
	…
	}

## Description

### Purpose

It's a common requirement to save the URL a user provides. The standard Grails validatior accepts only URLs with scheme, like

	http://www.google.com

But users often provide the URL without scheme, ie.

	www.google.com

The goal of this plugin is to provide a URL validator that allows you to validate the URL, no matter if the scheme was provided or not.


### Usage

The plugin can be used the same way as [built-in domain-level validators](http://grails.org/doc/latest/ref/Domain%20Classes/constraints.html), like `url: true`, `blank: false`, etc.

So to make sure the URL is valid, no matter if user put the scheme or not, just use `urlWithoutScheme: true`.

Example:

	class Domain {
	
		String url
	
		static constraints = {
		    url urlWithoutScheme: true
		}
	
	}
