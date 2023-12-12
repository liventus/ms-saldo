package com.lizana.mssaldo.controller;



import com.lizana.mssaldo.model.dto.SaldoDto;
import com.lizana.mssaldo.model.dto.StatusResponse;
import com.lizana.mssaldo.services.SaldoService;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(PerfilController.SALDO)
public class PerfilController {
    public static final String SALDO = "/saldo";

    @Autowired
    SaldoService saldoService;

    @PostMapping
    public Maybe<StatusResponse> create(@RequestBody SaldoDto product) {

        return saldoService.saveProduct(product);
    }


    @GetMapping
    public Maybe<SaldoDto> buscarPor(@RequestHeader String productId) {
        return saldoService.getProduct(productId);
    }


    @PutMapping
    public Maybe<SaldoDto> update(@RequestBody SaldoDto product) {
        return saldoService.updateProduct(product);
    }


    @DeleteMapping
    public Maybe<StatusResponse> delete(@RequestHeader String productId) {
        return saldoService.deleteProduct(productId);
    }





}
