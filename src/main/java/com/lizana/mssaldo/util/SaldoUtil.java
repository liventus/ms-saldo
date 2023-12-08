package com.lizana.mssaldo.util;




import com.lizana.mssaldo.model.dto.SaldoDto;
import com.lizana.mssaldo.model.entity.SaldoEntity;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;


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
}
