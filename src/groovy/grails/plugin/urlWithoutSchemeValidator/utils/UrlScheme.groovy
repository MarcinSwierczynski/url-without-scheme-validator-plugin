package grails.plugin.urlWithoutSchemeValidator.utils
/**
 * Date: 28.04.2014 at 19:25
 *
 * @author Marcin Świerczyński
 */
public enum UrlScheme {

	HTTP('http'), HTTPS('https'), FTP('ftp')

	static final String COLON = '://'

	String name

	UrlScheme(final String name) {
		this.name = name
	}

	@Override
	public String toString() {
		name
	}

	public String addSuffixColon() {
		this.name + COLON
	}

}