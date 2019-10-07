package com.java.carrental.dto;

import com.java.carrental.entity.CarEntity;
import com.java.carrental.entity.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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

    private BranchDTO startBranch;

    private BranchDTO endBranch;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    private LocalDateTime startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    private LocalDateTime endDate;

}
