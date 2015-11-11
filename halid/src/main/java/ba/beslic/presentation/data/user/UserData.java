package ba.beslic.presentation.data.user;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public class UserData extends PersonData {
	private AccountData account;

	public AccountData getAccount() {
		return account;
	}

	public void setAccount(AccountData account) {
		this.account = account;
	}
}
