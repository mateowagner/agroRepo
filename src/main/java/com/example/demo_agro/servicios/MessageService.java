package com.example.demo_agro.servicios;

import com.example.demo_agro.dto.WebhookRequestDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MessageService {

    public void manejarMensaje(WebhookRequestDTO  payload) {
        //System.out.println(payload.getEntry().size());
        System.out.println(payload.getEntry().
                get(0).
                getChanges().
                get(0).
                getValue().
                getMessages().
                get(0).
                getFrom());

        //System.out.println(payload.getObject());
        //System.out.println(getClass());
    }

}
