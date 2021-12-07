package com.nttdata.credit.repository;

import com.nttdata.credit.model.entity.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICreditRepository extends ReactiveMongoRepository<Credit, String> {
    public Flux<Credit> findByCustomerDocumentNumber(String documentNumber);
}
