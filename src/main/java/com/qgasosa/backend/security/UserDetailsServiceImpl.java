package com.qgasosa.backend.security;

import com.qgasosa.backend.exception.admin.AdminNotFoundException;
import com.qgasosa.backend.model.Admin;
import com.qgasosa.backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin user = this.adminRepository.findByUsername(username).orElseThrow(() -> new AdminNotFoundException(username));
        return new AdminPrincipal(user);
    }
}
