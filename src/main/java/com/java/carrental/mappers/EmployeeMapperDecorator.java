package com.java.carrental.mappers;

import com.java.carrental.dto.EmployeeDTO;
import com.java.carrental.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

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

    @Override
    public EmployeeEntity employeeDtoToEmployee(EmployeeDTO employeeDTO){
        EmployeeEntity employeeEntity = delegate.employeeDtoToEmployee(employeeDTO);
        employeeEntity.setCars(carMapper.listCarDtoToCars(employeeDTO.getCars()));
        return employeeEntity;
    }

    @Override
    public List<EmployeeDTO> listEmployeesToEmployeeDTOs(List<EmployeeEntity> employeeEntityList)  {
        List<EmployeeDTO> employeeDTOS = delegate.listEmployeesToEmployeeDTOs( employeeEntityList );
        for (int i=0; i < employeeDTOS.size(); i++) {
            employeeDTOS.get(i).setCars(carMapper.listCarToCarDTOs(employeeEntityList.get(i).getCars()));
        }
        return  employeeDTOS;
    }
}
