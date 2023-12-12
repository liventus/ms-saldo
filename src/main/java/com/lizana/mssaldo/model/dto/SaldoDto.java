package com.lizana.mssaldo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaldoDto {


    private String id;
    private String producto;
    private String cliente;
    private Number titular;
    private Number firmante;
    private Number saldo;



}
