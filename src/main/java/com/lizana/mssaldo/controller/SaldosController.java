package com.lizana.mssaldo.controller;



import com.lizana.mssaldo.model.dto.SaldoDto;
import com.lizana.mssaldo.services.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(SaldosController.SALDOS)
public class SaldosController {
    public static final String SALDOS = "/saldos";

    @Autowired
    SaldoService saldoService;

    @RequestMapping()
    public Flux<SaldoDto> findAll() {
        return saldoService.findAll();
    }







}
