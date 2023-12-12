package com.lizana.mssaldo.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusResponse {
    private Integer code;
    private String description;
    private SaldoDto detail;

}


