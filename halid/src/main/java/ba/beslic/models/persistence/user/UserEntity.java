package ba.beslic.models.persistence.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Author:  Admir Memic
 * Date:    21.10.15
 * E-Mail:  admir.memic@dmc.de
 */
@Entity(name = "User")
@Table(name = "kafana_user")
public class UserEntity extends PersonEntity {
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	private AccountEntity account;

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}
}
