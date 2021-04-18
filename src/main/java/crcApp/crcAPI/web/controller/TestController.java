package crcApp.crcAPI.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/base")
	@PreAuthorize("hasRole('BASE') or hasRole('SUPER') or hasRole('MASTER')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/super")
	@PreAuthorize("hasRole('SUPER') or hasRole('MASTER')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/master")
	@PreAuthorize("hasRole('MASTER')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
