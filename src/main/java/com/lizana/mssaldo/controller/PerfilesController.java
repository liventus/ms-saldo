package com.lizana.mssaldo.controller;



import com.lizana.mssaldo.model.dto.SaldoDto;
import com.lizana.mssaldo.services.SaldoService;
import io.reactivex.rxjava3.core.Flowable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(PerfilesController.SALDOS)
public class PerfilesController {
    public static final String SALDOS = "/saldos";

    @Autowired
    SaldoService saldoService;



    @RequestMapping()
    public Flowable<SaldoDto> findAll() {
        return saldoService.getProductAll();
    }







}
