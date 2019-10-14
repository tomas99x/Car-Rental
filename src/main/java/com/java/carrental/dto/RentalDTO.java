package com.java.carrental.dto;

import com.java.carrental.entity.CarEntity;
import com.java.carrental.entity.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalDTO {

    private Long id;

    @NotNull
    private CarEntity car;

    @NotNull
    private ClientEntity client;

    @NotNull(message="Wpisz poprawną wartość")
    private BigDecimal totalPrice;

    @NotNull
    private BranchDTO startBranch;

    @NotNull
    private BranchDTO endBranch;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime startDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime endDate;

}
