package com.example.demo_agro.controladores;
import com.example.demo_agro.dto.WebhookRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/whatsapp/webhook")
public class WebHookController {

    // ⚠️ ¡IMPORTANTE! Reemplaza este valor con tu token secreto.
    private static final String VERIFY_TOKEN = "tokenwebhook";

    // Método que maneja la solicitud GET de verificación
    @GetMapping
    public ResponseEntity<String> verifyWebhook(
            @RequestParam(name = "hub.mode") String mode,
            @RequestParam(name = "hub.verify_token") String token,
            @RequestParam(name = "hub.challenge") String challenge) {

        // 1. Validar el modo y el token secreto
        if ("subscribe".equals(mode) && VERIFY_TOKEN.equals(token)) {
            // 2. Si es válido, devolver el challenge para completar la verificación
            System.out.println("Webhook verificado exitosamente!");
            return ResponseEntity.ok(challenge);
        } else {
            // 3. Fallo en la verificación
            System.err.println("Error de verificación: Token o modo inválido.");
            return ResponseEntity.status(403).body("Verificación fallida.");
        }
    }
    @PostMapping
    public ResponseEntity<Void> recibirMensaje(@RequestBody WebhookRequestDTO payload) {

        // 1. Logica de Deserialización: Spring hizo esto automáticamente gracias a @RequestBody

        // 2. Aquí iría la llamada a la capa Service para procesar el mensaje
        System.out.println("Mensaje POST recibido del Peón: " + payload.toString());

        // 3. Confirmación: Devolver siempre 200 OK para evitar reenvíos de Meta.
        return ResponseEntity.ok().build();
    }

}
