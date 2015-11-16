package ba.beslic.utils.security.impl;

import ba.beslic.HalidConstants;
import ba.beslic.utils.security.PasswordEncoderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Author:  Admir Memic
 * Date:    16.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("passwordEncoder")
public class PasswordEncoderWrapperImpl implements PasswordEncoderWrapper {
	@Autowired
	private ShaPasswordEncoder passwordEncoder;
	@Override
	public String encode(String username, String password) {
		return passwordEncoder.encodePassword(password, username + HalidConstants.PASSWORD_SALT + password);
	}
}
