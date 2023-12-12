package com.lizana.mssaldo.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "saldo")
public class SaldoEntity {

    @Id
    private String id;
    private String producto;
    private String cliente;
    private Number titular;
    private Number firmante;
    private Number saldo;



}
