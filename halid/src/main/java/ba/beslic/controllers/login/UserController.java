package ba.beslic.controllers.login;

import ba.beslic.models.presentation.user.CredentialsData;
import ba.beslic.models.presentation.user.UserSessionData;
import ba.beslic.facades.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Admir Memić
 * Date:   19.10.2015
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserFacade userFacade;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseEntity<UserSessionData> login(@RequestBody CredentialsData credentials) {
		try {
			UserSessionData userSessionData = userFacade.createSession(credentials);
			return ResponseEntity.ok(userSessionData);
		} catch (AuthenticationCredentialsNotFoundException exception) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(path = "/session/{uuid}")
	public ResponseEntity<UserSessionData> getUserSessionByUUID(@PathVariable String uuid)
	{
		UserSessionData userSessionData = userFacade.getUserSessionByUUID(uuid);
		return ResponseEntity.ok(userSessionData);
	}
}
