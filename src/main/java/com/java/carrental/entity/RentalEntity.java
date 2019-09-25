package com.java.carrental.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "RENTAL")
public class RentalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    private CarEntity car;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private ClientEntity client;

    @Column
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "BRANCH_START")
    private BranchEntity startBranch;

    @ManyToOne
    @JoinColumn(name = "BRANCH_END")
    private BranchEntity endBranch;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;
}
