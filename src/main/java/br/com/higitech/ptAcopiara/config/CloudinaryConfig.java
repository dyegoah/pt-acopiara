package br.com.higitech.ptAcopiara.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cloudinary.Cloudinary;

@Configuration
@Profile({"render", "local"})
public class CloudinaryConfig {

    @Value("${cloudinary.cloud_name:}")
    private String cloudName;

    @Value("${cloudinary.api_key:}")
    private String apiKey;

    @Value("${cloudinary.api_secret:}")
    private String apiSecret;

    @Bean
    public Cloudinary cloudinary() {

        if (cloudName.isBlank() || apiKey.isBlank() || apiSecret.isBlank()) {
            System.out.println("⚠️ Cloudinary NÃO configurada — aplicação seguirá sem upload.");
            return null; // NÃO derruba o sistema
        }

        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", cloudName);
        config.put("api_key", apiKey);
        config.put("api_secret", apiSecret);

        return new Cloudinary(config);
    }
}
