package br.com.higitech.ptAcopiara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.higitech.ptAcopiara.service.FileUploadService;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("Erro: O arquivo está vazio.");
            }
            
            // Chama o serviço que envia para o Cloudinary
            String url = fileUploadService.uploadFile(file);
            
            // Retorna a URL da imagem para o frontend
            return ResponseEntity.ok(url);
            
        } catch (Exception e) {
            e.printStackTrace(); // Imprime o erro no console do Java para ajudar a debugar
            return ResponseEntity.internalServerError().body("Erro ao fazer upload: " + e.getMessage());
        }
    }
}