package com.lizana.mssaldo.repository;



import com.lizana.mssaldo.model.entity.SaldoEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaldoRepository extends ReactiveMongoRepository<SaldoEntity,String> {

   // Mono<ProductEntity> findByTipoDeDocumentoAndNumeroDeDocumento(String tipoDeDocumento, String numeroDeDocumento);

}
