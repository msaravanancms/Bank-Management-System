package com.bms.customer.web;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bms.customer.model.User;
import com.bms.customer.service.UserService;
import com.bms.customer.web.dto.LoginDto;

import io.swagger.annotations.Api;
@Api(tags = { "login Controller and REST endpoints" })
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
    private UserService userService;
	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> login(@Valid @RequestBody LoginDto loginDto) {
		User dbUser = userService.login(loginDto.getCustomerId());

        if (dbUser==null) {
        	logger.error(HttpStatus.NOT_FOUND+">>"+"User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        String hash  = dbUser.getPassword();

        if (!BCrypt.checkpw(loginDto.getPassword(), hash)) {
        	logger.error(HttpStatus.FORBIDDEN+">>"+"\"Wrong Password!\"");
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Wrong Password!");
        }
        logger.info(HttpStatus.CREATED+">>Welcome " + dbUser.getCustomerId());
        return ResponseEntity.ok("Welcome " + dbUser.getCustomerId());
    }
}
