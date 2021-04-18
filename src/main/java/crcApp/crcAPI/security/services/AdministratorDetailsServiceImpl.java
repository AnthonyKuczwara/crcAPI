package crcApp.crcAPI.security.services;


import crcApp.crcAPI.data.model.Administrator;
import crcApp.crcAPI.data.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdministratorDetailsServiceImpl implements UserDetailsService {
	@Autowired
	AdministratorRepository administratorRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Administrator administrator = administratorRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return AdministratorDetailsImpl.build(administrator);
	}

}
