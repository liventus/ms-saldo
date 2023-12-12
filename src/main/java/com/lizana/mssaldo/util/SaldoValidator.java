package com.lizana.mssaldo.util;



import com.lizana.mssaldo.model.dto.SaldoDto;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@NoArgsConstructor
public class SaldoValidator {

    public static void validateClientObject(SaldoDto dto) {

        if (dto.getCliente().isEmpty() || dto.getProducto().isEmpty()) {
            throw new ValidatorException(HttpStatus.BAD_REQUEST.value(), "cliente o producto no pueden ser vacios ", dto);
        }
    }
}
