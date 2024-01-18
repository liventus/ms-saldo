package com.lizana.mssaldo.services;


import com.lizana.mssaldo.model.dto.SaldoDto;
import com.lizana.mssaldo.model.dto.StatusResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface SaldoService {

    Mono<StatusResponse> create(SaldoDto ProductObject);

    Mono<StatusResponse> delete(String idProducto);

    Mono<StatusResponse> findById(String idProduct);


    Mono<StatusResponse> update(SaldoDto ProductObject);

    Flux<SaldoDto> findAll();




}
