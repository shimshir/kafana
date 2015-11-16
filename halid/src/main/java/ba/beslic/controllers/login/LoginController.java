package ba.beslic.controllers.login;

import ba.beslic.models.presentation.user.CredentialsData;
import ba.beslic.models.presentation.user.UserSessionData;
import ba.beslic.facades.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Admir Memić
 * Date:   19.10.2015
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserFacade userFacade;

	@RequestMapping
	public ResponseEntity<UserSessionData> login(@RequestBody CredentialsData credentials) {
		UserSessionData userSessionData = userFacade.createSession(credentials);
		return ResponseEntity.ok(userSessionData);
	}
}
