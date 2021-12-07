package com.nttdata.credit.service;

import com.nttdata.credit.model.entity.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICreditService {
    public Mono<Credit> findById(String id);
    public Flux<Credit> findByCustomerDocumentNumber(String documentNumber);
    public Mono<Credit> save(Credit credit);
}
