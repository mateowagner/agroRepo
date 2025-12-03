package com.example.demo_agro.dto;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

// 1. Clase Principal que captura el JSON completo
@Data
@JsonIgnoreProperties(ignoreUnknown = true) // Ignora campos que no vamos a mapear (ej: "id", "timestamp")
public class WebhookRequestDTO {
    private String object; // Ej: "whatsapp_business_account"
    private List<Entry> entry;

    // --- Clases Anidadas (Reflejan el anidamiento del JSON) ---

    // 2. Nivel "entry"
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Entry {
        private List<Change> changes;
    }

    // 3. Nivel "changes"
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Change {
        private String field; // Usamos esto para confirmar que es un evento de "messages"
        private Value value;
    }

    // 4. Nivel "value"
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Value {
        private List<Message> messages;
    }

    // 5. Nivel "messages"
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Message {
        // Campo clave: el número de teléfono del Peón (el ID de usuario)
        private String from;

        // Campo clave: el contenido del texto
        private Text text;

        private String type; // Para confirmar que es un mensaje de tipo "text"
    }

    // 6. Nivel "text"
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Text {
        // Campo clave: el mensaje que el Peón escribió
        private String body;
    }
}