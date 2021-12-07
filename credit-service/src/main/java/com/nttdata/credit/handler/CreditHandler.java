package com.nttdata.credit.handler;

import com.nttdata.credit.model.entity.Credit;
import com.nttdata.credit.service.ICreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class CreditHandler {

    private final ICreditService service;

    public Mono<ServerResponse> findById(ServerRequest request){
        String id = request.pathVariable("id");
        return service.findById(id)
                .flatMap(c -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(c)
                )
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findByCustomerDocumentNumber(ServerRequest request){
        String documentNumber = request.pathVariable("documentNumber");
        return service.findByCustomerDocumentNumber(documentNumber)
                .collectList()
                .flatMap(c -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(c)
                )
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> create(ServerRequest request){
        Mono<Credit> creditMono = request.bodyToMono(Credit.class);
        return creditMono
                .flatMap(service::save)
                .flatMap(c -> ServerResponse.created(URI.create("/credit/".concat(c.getId())))
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .bodyValue(c)
                );
    }
}
