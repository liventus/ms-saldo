package com.lizana.mssaldo.controller;



import com.lizana.mssaldo.model.dto.SaldoDto;
import com.lizana.mssaldo.model.dto.StatusResponse;
import com.lizana.mssaldo.services.SaldoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(SaldoController.SALDO)
public class SaldoController {
    public static final String SALDO = "/saldo";

    @Autowired
    SaldoService saldoService;

    @PostMapping
    public Mono<StatusResponse> create(@RequestBody SaldoDto product) {
        return saldoService.create(product);
    }

    @GetMapping
    public Mono<StatusResponse> findById(@RequestHeader String productId) {
        return saldoService.findById(productId);
    }


    @PutMapping
    public Mono<StatusResponse> update(@RequestBody SaldoDto product) {
        return saldoService.update(product);
    }

    @DeleteMapping
    public Mono<StatusResponse> delete(@RequestHeader String productId) {
        return saldoService.delete(productId);
    }





}
