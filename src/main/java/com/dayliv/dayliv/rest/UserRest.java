package com.dayliv.dayliv.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.config.CurrentUser;
import com.dayliv.dayliv.dto.LocalUser;
import com.dayliv.dayliv.service.ConsumerService;
import com.dayliv.dayliv.service.UserService;
import com.dayliv.dayliv.util.GeneralUtils;
@RestController
@RequestMapping("/dayliv-api")
public class UserRest {
	@Autowired
	UserService userService;
	@Autowired
	ConsumerService consumerService;
	  @GetMapping("/user/me")
	    @PreAuthorize("hasRole('USER')")
	    public ResponseEntity<?> getCurrentUser(@CurrentUser LocalUser user) {
	        return ResponseEntity.ok(GeneralUtils.buildUserInfo(user));
	    }

		@GetMapping("/all")
		public ResponseEntity<?> getContent() {
			return ResponseEntity.ok("Public content goes here");
		}

		@GetMapping("/user")
		@PreAuthorize("hasRole('USER')")
		public ResponseEntity<?> getUserContent() {
			return ResponseEntity.ok("User content goes here");
		}

		@GetMapping("/admin")
		@PreAuthorize("hasRole('ADMIN')")
		public ResponseEntity<?> getAdminContent() {
			return ResponseEntity.ok("Admin content goes here");
		}

		@GetMapping("/mod")
		@PreAuthorize("hasRole('MODERATOR')")
		public ResponseEntity<?> getModeratorContent() {
			return ResponseEntity.ok("Moderator content goes here");
		}
}
