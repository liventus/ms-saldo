package com.lizana.mssaldo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaldoDto {

    @Id
    private String id;
    private String tipoDeProducto;
    private String nombreDeProducto;



}
