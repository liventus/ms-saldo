package com.lizana.mssaldo.services.impl;


import com.lizana.mssaldo.model.dto.SaldoDto;
import com.lizana.mssaldo.model.dto.Status;
import com.lizana.mssaldo.model.entity.SaldoEntity;
import com.lizana.mssaldo.repository.SaldoRepository;
import com.lizana.mssaldo.services.SaldoService;
import com.lizana.mssaldo.util.SaldoUtil;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductServiceImpl implements SaldoService {

    @Autowired
    private SaldoRepository productRepository;


    @Override
    public Maybe<SaldoDto> saveProduct(SaldoDto productDto) {
        //guarda el producto
        Mono<SaldoEntity> savedEntity = productRepository.save(SaldoUtil.dtoToEntity(productDto));
        return Maybe.fromPublisher(savedEntity.map(SaldoUtil::entityToDto));
    }

    @Override
    public Maybe<Status> deleteProduct(String idProduct) {
        return Maybe.fromPublisher(
                productRepository.findById(idProduct)
                        .flatMap(product -> {
                            if (product != null) {
                                return productRepository.deleteById(product.getId())
                                        .then(Mono.just(new Status("asd", "a")));
                            } else {
                                return Mono.empty();
                            }
                        })
                        .switchIfEmpty(Mono.just(new Status("NOT_FOUND", "Product not found")))
        );

    }

    @Override
    public Maybe<SaldoDto> getProduct(String idProduct) {
        //extrae el producto
        Mono<SaldoEntity> para = productRepository.findById(idProduct);
        return Maybe.fromPublisher(para.map(SaldoUtil::entityToDto));
    }

    @Override
    public Maybe<SaldoDto> updateProduct(SaldoDto ProductObject) {
        Mono<SaldoEntity> updateEntity = productRepository.save(SaldoUtil.dtoToEntity(ProductObject));
        return Maybe.fromPublisher(updateEntity.map(SaldoUtil::entityToDto));
    }

    @Override
    public Flowable<SaldoDto> getProductAll() {
        return Flowable
                .fromPublisher(productRepository.findAll().map(SaldoUtil::entityToDto));
    }


}
