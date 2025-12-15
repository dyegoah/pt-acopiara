package br.com.higitech.ptAcopiara.auth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminBootstrap implements CommandLineRunner {

    private final AdminUserRepository repo;
    private final PasswordEncoder encoder;

    public AdminBootstrap(AdminUserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) {
        String user = System.getenv().getOrDefault("ADMIN_USER", "admin");
        String pass = System.getenv().getOrDefault("ADMIN_PASS", "admin123");

        if (!repo.existsByUsername(user)) {
            repo.save(new AdminUser(user, encoder.encode(pass), true));
            System.out.println("[BOOTSTRAP] Admin criado: " + user + " (troque a senha via env em produção)");
        }
    }
}
