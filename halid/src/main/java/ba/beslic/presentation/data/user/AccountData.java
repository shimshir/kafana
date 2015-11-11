package ba.beslic.presentation.data.user;

import ba.beslic.persistence.entities.user.RoleEnum;
import ba.beslic.presentation.data.PresentationData;

import java.util.Collection;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public class AccountData implements PresentationData{
	private String username;
	private Collection<RoleEnum> roles;

	public Collection<RoleEnum> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RoleEnum> roles) {
		this.roles = roles;
	}

	public String getUsername() {

		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
