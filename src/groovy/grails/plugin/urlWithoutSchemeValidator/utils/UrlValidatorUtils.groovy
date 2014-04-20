package grails.plugin.urlWithoutSchemeValidator.utils

import org.codehaus.groovy.grails.validation.routines.UrlValidator

/**
 * Date: 20.04.2014 at 15:36
 *
 * @author Marcin Świerczyński
 */
class UrlValidatorUtils {

	private static final String HTTP_SCHEME = "http"
	private static final String COLON = '://'
	private static final String[] DEFAULT_SCHEMES = [HTTP_SCHEME, "https", "ftp"];

	public static boolean isValid(String url) {
		String urlToCheck = url

		if (!startsWithKnownSchemes(urlToCheck)) {
			urlToCheck = suffixColon(HTTP_SCHEME) + urlToCheck
		}

		new UrlValidator().isValid(urlToCheck)
	}

	private static boolean startsWithKnownSchemes(String url) {
		DEFAULT_SCHEMES.any { url?.startsWith(suffixColon(it)) }
	}

	private static String suffixColon(String scheme) {
		scheme + COLON
	}

}
