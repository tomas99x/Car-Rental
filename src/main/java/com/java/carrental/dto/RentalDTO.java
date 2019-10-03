package com.java.carrental.dto;

import com.java.carrental.entity.BranchEntity;
import com.java.carrental.entity.CarEntity;
import com.java.carrental.entity.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalDTO {

    private Long id;

    private CarEntity car;

    private ClientEntity client;

    private BigDecimal totalPrice;

    private BranchEntity startBranch;

    private BranchEntity endBranch;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

}
