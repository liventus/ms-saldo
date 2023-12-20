package com.lizana.mssaldo.services.impl;


import com.lizana.mssaldo.model.dto.SaldoDto;
import com.lizana.mssaldo.model.dto.StatusResponse;
import com.lizana.mssaldo.model.entity.SaldoEntity;
import com.lizana.mssaldo.repository.SaldoRepository;
import com.lizana.mssaldo.services.SaldoService;
import com.lizana.mssaldo.util.ValidatorException;
import com.lizana.mssaldo.util.SaldoUtil;
import com.lizana.mssaldo.util.SaldoValidator;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class ProductServiceImpl implements SaldoService {

    @Autowired
    private SaldoRepository productRepository;


    @Override
    public Maybe<StatusResponse> saveProduct(SaldoDto saldoDto) {

        try {
            SaldoValidator.validateClientObject(saldoDto);
        } catch (ValidatorException ex) {
            return Maybe.just(ex.getStatusResponse());
        }

        //guarda el producto

        return Maybe.fromPublisher(productRepository
                .save(SaldoUtil.dtoToEntity(saldoDto))
                .map(SaldoUtil::entityToDto))
                .map(x -> SaldoUtil.setStatusResponse(HttpStatus.CREATED, x));
    }

    @Override
    public Maybe<StatusResponse> deleteProduct(String idProduct) {
        return Maybe.fromPublisher(
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
        );

    }

    @Override
    public Maybe<StatusResponse> getProduct(String idProduct) {
        //extrae el producto
        Mono<SaldoEntity> para = productRepository.findById(idProduct);
        return Maybe.fromPublisher(para.map(SaldoUtil::entityToDto).map(x -> SaldoUtil.setStatusResponse(HttpStatus.OK, x)));
    }

    @Override
    public Maybe<StatusResponse> updateProduct(SaldoDto ProductObject) {
        Mono<SaldoEntity> updateEntity = productRepository.save(SaldoUtil.dtoToEntity(ProductObject));
        return Maybe.fromPublisher(updateEntity.map(SaldoUtil::entityToDto).map(x -> SaldoUtil.setStatusResponse(HttpStatus.OK, x)));
    }

    @Override
    public Flowable<SaldoDto> getProductAll() {
        return Flowable
                .fromPublisher(productRepository.findAll().map(SaldoUtil::entityToDto));
    }


}
