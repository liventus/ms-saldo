package com.lizana.mssaldo.util;




import com.lizana.mssaldo.model.dto.SaldoDto;
import com.lizana.mssaldo.model.dto.StatusResponse;
import com.lizana.mssaldo.model.entity.SaldoEntity;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;


@NoArgsConstructor
public class SaldoUtil {

    public static SaldoDto entityToDto(SaldoEntity entity) {
        SaldoDto dto= new SaldoDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static SaldoEntity dtoToEntity(SaldoDto dto) {
        SaldoEntity entity = new SaldoEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public  static StatusResponse setStatusResponse(HttpStatus http, SaldoDto dto){
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setCode(http.value());
        statusResponse.setDescription(http.name());
        statusResponse.setDetail(dto);


        return statusResponse;
    }


}
