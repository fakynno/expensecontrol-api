package com.fakynno.expensecontrol.api.events.listeners;

import com.fakynno.expensecontrol.api.events.RecursoCriadoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {
    @Override
    public void onApplicationEvent(RecursoCriadoEvent event) {
        HttpServletResponse response = event.getResponse();
        Long codigo = event.getCodigo();

        adicionarHeaderLocation(response, codigo);
    }

    private static void adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{codigo]")
                .buildAndExpand(codigo)
                .toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}
