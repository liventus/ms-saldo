package com.lizana.mssaldo.services;


import com.lizana.mssaldo.model.dto.SaldoDto;
import com.lizana.mssaldo.model.dto.Status;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;


public interface SaldoService {

    Maybe<SaldoDto> saveProduct(SaldoDto ProductObject);

    Maybe<Status> deleteProduct(String idProducto);

    Maybe<SaldoDto>  getProduct(String idProduct);


    Maybe<SaldoDto> updateProduct(SaldoDto ProductObject);

    Flowable<SaldoDto> getProductAll();




}
