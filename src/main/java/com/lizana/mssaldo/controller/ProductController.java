package com.lizana.mssaldo.controller;



import com.lizana.mssaldo.model.dto.SaldoDto;
import com.lizana.mssaldo.model.dto.Status;
import com.lizana.mssaldo.services.SaldoService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(ProductController.PRODUCTS)
public class ProductController {
    public static final String PRODUCTS = "/products";

    @Autowired
    SaldoService saldoService;

    @PostMapping(produces = {"application/json"})
    public Maybe<SaldoDto> create(@RequestBody SaldoDto product) {
        return saldoService.saveProduct(product);
    }


    @RequestMapping("/all")
    public Flowable<SaldoDto> findAll() {
        return saldoService.getProductAll();
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
    public Maybe<Status> delete(@RequestHeader String productId) {
        return saldoService.deleteProduct(productId);
    }





}
