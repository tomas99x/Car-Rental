package com.java.carrental.mappers;

import com.java.carrental.dto.EmployeeDTO;
import com.java.carrental.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class EmployeeMapperDecorator implements EmployeeMapper{

    @Autowired
    @Qualifier("delegate")
    private EmployeeMapper delegate;

    @Autowired
    private  CarMapper carMapper;

    @Override
    public EmployeeDTO employeeToEmployeeDTO(EmployeeEntity employeeEntity){
        EmployeeDTO employeeDTO = delegate.employeeToEmployeeDTO(employeeEntity);
        employeeDTO.setCars(carMapper.listCarToCarDTOs(employeeEntity.getCars()));
        return employeeDTO;
    }
}
