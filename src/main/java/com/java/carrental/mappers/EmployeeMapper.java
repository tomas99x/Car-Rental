package com.java.carrental.mappers;

import com.java.carrental.dto.EmployeeDTO;
import com.java.carrental.entity.EmployeeEntity;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
@DecoratedWith(EmployeeMapperDecorator.class)
public interface EmployeeMapper {

    @Mapping(ignore = true, target = "cars")
    EmployeeDTO employeeToEmployeeDTO(EmployeeEntity employeeEntity);

    @Mapping(ignore = true, target = "cars")
    EmployeeEntity employeeDtoToEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> listEmployeesToEmployeeDTOs(List<EmployeeEntity> employeeEntityList);

    List<EmployeeEntity> listEmployeeDtoToEntities(List<EmployeeDTO> employeeDTOS);
}
