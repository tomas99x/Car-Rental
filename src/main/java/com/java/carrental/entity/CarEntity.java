package com.java.carrental.entity;

import com.java.carrental.entity.enums.CarColor;
import com.java.carrental.entity.enums.CarType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CAR")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false, length = 40)
    private String carBrandModel;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarType carType;

    @Column(nullable = false)
    private LocalDate productionYear;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarColor carColor;

    @Column(nullable = false)
    private Long engineCapacity;

    @Column(nullable = false)
    private Long horsePower;

    @Column(nullable = false)
    private Long mileage;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
            },
            fetch = FetchType.LAZY)
    @JoinTable(name = "CAR_TO_EMPLOYEE",
            joinColumns = @JoinColumn(name = "CAR_ID"),
            inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
    private List<EmployeeEntity> carKeepers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRANCH_ID")
    private BranchEntity branch;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "CAR_ID")
//    private List<RentalEntity> rentals;

    @OneToMany(cascade = {CascadeType.REMOVE},
        mappedBy = "car",
        fetch = FetchType.LAZY)
    private List<RentalEntity> rentals;

    public CarEntity(String carBrandModel, CarType carType, LocalDate productionYear, CarColor carColor, Long engineCapacity, Long horsePower, Long mileage) {
        this.carType = carType;
        this.carBrandModel = carBrandModel;
        this.productionYear = productionYear;
        this.carColor = carColor;
        this.engineCapacity = engineCapacity;
        this.horsePower = horsePower;
        this.mileage = mileage;
    }
}
