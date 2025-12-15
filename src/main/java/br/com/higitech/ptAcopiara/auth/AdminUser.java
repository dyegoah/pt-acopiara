package br.com.higitech.ptAcopiara.auth;

import jakarta.persistence.*;

@Entity
@Table(name = "admin_users")
public class AdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 80)
    private String username;

    @Column(nullable = false, length = 255)
    private String passwordHash;

    @Column(nullable = false)
    private boolean enabled = true;

    public AdminUser() {}

    public AdminUser(String username, String passwordHash, boolean enabled) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.enabled = enabled;
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }
    public boolean isEnabled() { return enabled; }

    public void setId(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}
