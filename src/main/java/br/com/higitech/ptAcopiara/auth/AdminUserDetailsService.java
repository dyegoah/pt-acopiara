package br.com.higitech.ptAcopiara.auth;

import java.util.List;

import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminUserDetailsService implements UserDetailsService {

    private final AdminUserRepository repo;

    public AdminUserDetailsService(AdminUserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser u = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        if (!u.isEnabled()) {
            throw new DisabledException("Usuário desativado");
        }

        return new org.springframework.security.core.userdetails.User(
                u.getUsername(),
                u.getPasswordHash(),
                List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))
        );
    }
}
