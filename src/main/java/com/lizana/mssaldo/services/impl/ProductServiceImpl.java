package com.lizana.mssaldo.services.impl;


import com.lizana.mssaldo.model.dto.SaldoDto;
import com.lizana.mssaldo.model.dto.StatusResponse;
import com.lizana.mssaldo.model.entity.SaldoEntity;
import com.lizana.mssaldo.repository.SaldoRepository;
import com.lizana.mssaldo.services.SaldoService;
import com.lizana.mssaldo.util.SaldoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductServiceImpl implements SaldoService {

    @Autowired
    private SaldoRepository productRepository;


    @Override
    public Mono<StatusResponse> create(SaldoDto saldoDto) {

        return productRepository
                .save(SaldoUtil.dtoToEntity(saldoDto))
                .map(SaldoUtil::entityToDto)
                .map(x -> SaldoUtil.setStatusResponse(HttpStatus.CREATED, x));
    }

    @Override
    public Mono<StatusResponse> delete(String idProduct) {
        return
                productRepository.findById(idProduct)
                        .flatMap(product -> {
                            if (product != null) {
                                return productRepository.deleteById(product.getId())
                                        .then(Mono.just(new StatusResponse(1, "a",null)));
                            } else {
                                return Mono.empty();
                            }
                        })
                        .switchIfEmpty(Mono.just(new StatusResponse(1, "Product not found",null)))
        ;

    }

    @Override
    public Mono<StatusResponse> findById(String idProduct) {
        //extrae el producto
        Mono<SaldoEntity> para = productRepository.findById(idProduct);
        return para.map(SaldoUtil::entityToDto).map(x -> SaldoUtil.setStatusResponse(HttpStatus.OK, x));
    }

    @Override
    public Mono<StatusResponse> update(SaldoDto ProductObject) {
        Mono<SaldoEntity> updateEntity = productRepository.save(SaldoUtil.dtoToEntity(ProductObject));
        return updateEntity.map(SaldoUtil::entityToDto).map(x -> SaldoUtil.setStatusResponse(HttpStatus.OK, x));
    }

    @Override
    public Flux<SaldoDto> findAll() {
        return productRepository.findAll().map(SaldoUtil::entityToDto);
    }


}
