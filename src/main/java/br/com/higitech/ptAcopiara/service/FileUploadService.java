package br.com.higitech.ptAcopiara.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class FileUploadService {

    @Autowired
    private Cloudinary cloudinary;

    public String uploadFile(MultipartFile file) throws IOException {
        // Envia o arquivo para o Cloudinary.
        // O parametro "resource_type": "auto" permite que o Cloudinary identifique se é imagem ou vídeo automaticamente.
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
        
        // Retorna a URL segura (https) para ser salva no banco
        return uploadResult.get("secure_url").toString();
    }
}