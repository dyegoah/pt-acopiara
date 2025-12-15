package br.com.higitech.ptAcopiara.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.higitech.ptAcopiara.dto.ChangePasswordRequest;

@RestController
@RequestMapping("/api/admin")
public class AdminAccountController {

    private final AdminUserRepository repo;
    private final PasswordEncoder encoder;

    public AdminAccountController(AdminUserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest req, Authentication auth) {

        if (auth == null || auth.getName() == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Não autenticado.");
        }

        if (req.getCurrentPassword() == null || req.getNewPassword() == null || req.getConfirmNewPassword() == null) {
            return ResponseEntity.badRequest().body("Preencha todos os campos.");
        }

        if (!req.getNewPassword().equals(req.getConfirmNewPassword())) {
            return ResponseEntity.badRequest().body("A nova senha e a confirmação não conferem.");
        }

        // Regra mínima (pode reforçar depois)
        if (req.getNewPassword().length() < 8) {
            return ResponseEntity.badRequest().body("A nova senha deve ter pelo menos 8 caracteres.");
        }

        AdminUser user = repo.findByUsername(auth.getName())
                .orElse(null);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não encontrado.");
        }

        if (!encoder.matches(req.getCurrentPassword(), user.getPasswordHash())) {
            return ResponseEntity.badRequest().body("Senha atual inválida.");
        }

        user.setPasswordHash(encoder.encode(req.getNewPassword()));
        repo.save(user);

        return ResponseEntity.ok("Senha alterada com sucesso.");
    }

    // Opcional: útil para mostrar no admin quem está logado
    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication auth) {
        if (auth == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        return ResponseEntity.ok(auth.getName());
    }
}
