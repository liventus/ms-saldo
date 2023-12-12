package com.lizana.mssaldo.services;


import com.lizana.mssaldo.model.dto.SaldoDto;
import com.lizana.mssaldo.model.dto.StatusResponse;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;


public interface SaldoService {

    Maybe<StatusResponse> saveProduct(SaldoDto ProductObject);

    Maybe<StatusResponse> deleteProduct(String idProducto);

    Maybe<SaldoDto>  getProduct(String idProduct);


    Maybe<SaldoDto> updateProduct(SaldoDto ProductObject);

    Flowable<SaldoDto> getProductAll();




}
