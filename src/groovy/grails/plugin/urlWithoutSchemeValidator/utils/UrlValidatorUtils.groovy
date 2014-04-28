package grails.plugin.urlWithoutSchemeValidator.utils

import org.codehaus.groovy.grails.validation.routines.UrlValidator

import static grails.plugin.urlWithoutSchemeValidator.utils.UrlScheme.*

/**
 * Date: 20.04.2014 at 15:36
 *
 * @author Marcin Świerczyński
 */
class UrlValidatorUtils {

	public static boolean isValid(final String url) {
		String urlToCheck = prefixSchemeIfNecessary(url)
		new UrlValidator().isValid(urlToCheck)
	}

	public static String prefixSchemeIfNecessary(final String url, final UrlScheme scheme = HTTP) {
		String urlToCheck = url
		if (urlToCheck && !startsWithKnownSchemes(urlToCheck)) {
			urlToCheck = scheme.addSuffixColon() + urlToCheck
		}
		urlToCheck
	}

	private static boolean startsWithKnownSchemes(final String url) {
		UrlScheme.values().any { url.startsWith(it.addSuffixColon()) }
	}

}
