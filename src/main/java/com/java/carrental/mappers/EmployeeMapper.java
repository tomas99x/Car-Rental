package com.java.carrental.mappers;

import com.java.carrental.dto.EmployeeDTO;
import com.java.carrental.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(ignore = true, target = "cars")
    @Mapping(source = "branch.address.city", target = "branch")
    EmployeeDTO employeeToEmployeeDTO(EmployeeEntity employeeEntity);

    @Mapping(source = "branch", target = "branch.address.city")
    EmployeeEntity employeeDtoToEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> listEmployeesToEmployeeDTOs(List<EmployeeEntity> employeeEntityList);

    List<EmployeeEntity> listEmployeeDtoToEntities(List<EmployeeDTO> employeeDTOS);
}
