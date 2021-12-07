package com.nttdata.credit.service.Impl;

import com.nttdata.credit.model.entity.Credit;
import com.nttdata.credit.repository.ICreditRepository;
import com.nttdata.credit.service.ICreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements ICreditService {

    private final ICreditRepository repository;

    @Override
    public Mono<Credit> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Flux<Credit> findByCustomerDocumentNumber(String documentNumber) {
        return repository.findByCustomerDocumentNumber(documentNumber);
    }

    @Override
    public Mono<Credit> save(Credit credit) {
        return repository.save(credit);
    }
}
