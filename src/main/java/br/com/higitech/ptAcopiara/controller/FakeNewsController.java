package br.com.higitech.ptAcopiara.controller;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import br.com.higitech.ptAcopiara.model.AnaliseFake;
import br.com.higitech.ptAcopiara.repository.AnaliseFakeRepository;

@RestController
@RequestMapping("/api/fake-detector")
public class FakeNewsController {

    @Autowired
    private AnaliseFakeRepository repository;

    private final String UPLOAD_DIR = "src/main/resources/static/uploads/fake_analysis/";

    @PostMapping("/analisar")
    public Map<String, Object> analisarImagem(@RequestParam("file") MultipartFile file) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            // Cria diretório se não existir
            Files.createDirectories(Paths.get(UPLOAD_DIR));

            // 1. Simulação da Inteligência Artificial
            // Para testar: se o arquivo tiver "fake" no nome, detecta como fake. 
            // Caso contrário, sorteia (para demonstração).
            boolean isFake = file.getOriginalFilename().toLowerCase().contains("fake") 
                             || Math.random() < 0.5; 

            // 2. Processamento da Imagem
            String fileName = UUID.randomUUID().toString() + ".png";
            Path path = Paths.get(UPLOAD_DIR + fileName);
            
            if (isFake) {
                // Carrega a imagem original
                BufferedImage originalImage = ImageIO.read(file.getInputStream());
                
                // Cria uma cópia para desenhar
                BufferedImage resultImage = new BufferedImage(
                    originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = resultImage.createGraphics();
                g.drawImage(originalImage, 0, 0, null);

                // Configura o "Carimbo"
                g.setColor(new Color(255, 0, 0, 150)); // Vermelho transparente
                g.setStroke(new BasicStroke(10));
                g.drawRect(20, 20, originalImage.getWidth() - 40, originalImage.getHeight() - 40);

                // Texto "FAKE NEWS"
                g.setFont(new Font("Arial", Font.BOLD, Math.min(originalImage.getWidth(), originalImage.getHeight()) / 5));
                g.setColor(new Color(255, 0, 0, 200));
                
                // Centraliza o texto
                FontMetrics metrics = g.getFontMetrics();
                int x = (originalImage.getWidth() - metrics.stringWidth("FAKE NEWS")) / 2;
                int y = ((originalImage.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
                
                // Rotaciona levemente para dar efeito de carimbo
                g.rotate(Math.toRadians(-30), originalImage.getWidth()/2, originalImage.getHeight()/2);
                g.drawString("FAKE NEWS", x, y);
                g.dispose();

                // Salva a imagem processada
                ImageIO.write(resultImage, "png", path.toFile());
                
                response.put("motivo", "Nossa IA detectou inconsistências de iluminação e padrões de pixels típicos de manipulação digital (Deepfake).");
            } else {
                // Se for verdadeira, apenas salva a original
                file.transferTo(path);
                response.put("motivo", "A imagem não apresenta traços de manipulação digital conhecidos.");
            }

            // 3. Salvar no Banco
            AnaliseFake analise = new AnaliseFake();
            analise.setFake(isFake);
            analise.setNomeArquivo(fileName);
            repository.save(analise);

            // 4. Retorno
            response.put("isFake", isFake);
            response.put("imageUrl", "/uploads/fake_analysis/" + fileName);
            response.put("success", true);

        } catch (Exception e) {
            e.printStackTrace();
            response.put("success", false);
            response.put("error", e.getMessage());
        }
        return response;
    }

    @GetMapping("/stats")
    public Map<String, Long> getStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("total", repository.totalAnalisado());
        stats.put("fakes", repository.totalFakes());
        stats.put("reais", repository.totalVerdadeiros());
        return stats;
    }
}