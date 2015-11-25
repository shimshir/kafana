package ba.beslic.models.presentation.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public class UserData extends PersonData {
	private AccountData account;
	private Integer accountId;

	@JsonIgnore
	public AccountData getAccount() {
		return account;
	}

	@JsonProperty
	public void setAccount(AccountData account) {
		this.account = account;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
}
