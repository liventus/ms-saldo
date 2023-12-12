package com.lizana.mssaldo.util;


import com.lizana.mssaldo.model.dto.SaldoDto;
import com.lizana.mssaldo.model.dto.StatusResponse;

public class ValidatorException extends RuntimeException {


    private StatusResponse statusResponse;

    public ValidatorException(int codigo, String descripcion, SaldoDto clientObject) {

        this.statusResponse = new StatusResponse();
        this.statusResponse.setCode(codigo);
        this.statusResponse.setDescription(descripcion);
        this.statusResponse.setDetail(clientObject);
    }

    public StatusResponse getStatusResponse() {
        return statusResponse;
    }
}
