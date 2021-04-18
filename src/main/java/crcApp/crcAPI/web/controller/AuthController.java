package crcApp.crcAPI.web.controller;


import crcApp.crcAPI.data.model.Administrator;
import crcApp.crcAPI.data.model.ERole;
import crcApp.crcAPI.data.model.Role;
import crcApp.crcAPI.data.repository.AdministratorRepository;
import crcApp.crcAPI.data.repository.RoleRepository;
import crcApp.crcAPI.security.jwt.JwtUtils;
import crcApp.crcAPI.security.services.AdministratorDetailsImpl;
import crcApp.crcAPI.web.payload.request.LoginRequest;
import crcApp.crcAPI.web.payload.request.SignupRequest;
import crcApp.crcAPI.web.payload.response.JwtResponse;
import crcApp.crcAPI.web.payload.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	AdministratorRepository administratorRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		AdministratorDetailsImpl administratorDetails = (AdministratorDetailsImpl) authentication.getPrincipal();
		List<String> roles = administratorDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
												 administratorDetails.getId(),
												 administratorDetails.getUsername(),
												 administratorDetails.getEmail(),
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (administratorRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (administratorRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new administrator's account
		Administrator administrator = new Administrator(signUpRequest.getUsername(),
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role administratorRole = roleRepository.findByName(ERole.ROLE_BASE)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(administratorRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_MASTER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_SUPER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role administratorRole = roleRepository.findByName(ERole.ROLE_BASE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(administratorRole);
				}
			});
		}

		administrator.setRoles(roles);
		administratorRepository.save(administrator);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
