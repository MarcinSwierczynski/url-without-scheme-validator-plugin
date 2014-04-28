package grails.plugin.urlWithoutSchemeValidator.utils

import org.codehaus.groovy.grails.validation.routines.UrlValidator

import static grails.plugin.urlWithoutSchemeValidator.utils.UrlScheme.*

/**
 * Date: 20.04.2014 at 15:36
 *
 * @author Marcin Świerczyński
 */
class UrlValidatorUtils {

	/**
	 * Checks if the provided URL is valid, no matter it starts with scheme or not
	 * @param url The URL to be validated
	 * @return true if the URL is valid, false otherwise
	 */
	public static boolean isValid(final String url) {
		String urlToCheck = prefixSchemeIfNecessary(url)
		new UrlValidator().isValid(urlToCheck)
	}

	/**
	 * Adds scheme prefix to a given String if necessary, ie. there is no prefix yet.
	 * By default, adds "http://" but it can be overridden.
	 * @param url The URL that should be prefixed
	 * @param scheme The scheme that should be added to the URL. HTTP by default.
	 * @return The prefixed URL
	 */
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
