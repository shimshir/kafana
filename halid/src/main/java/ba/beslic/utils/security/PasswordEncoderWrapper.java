package ba.beslic.utils.security;

/**
 * Author:  Admir Memic
 * Date:    16.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface PasswordEncoderWrapper {
	String encode(String username, String password);
}
