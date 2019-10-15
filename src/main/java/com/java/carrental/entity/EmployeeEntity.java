package com.java.carrental.entity;

import com.java.carrental.entity.enums.EmployeePosition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String workPhoneNo;

    @Column
    @Enumerated(EnumType.STRING)
    private EmployeePosition position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRANCH_ID")
    private BranchEntity branch;

    @ManyToMany(mappedBy = "carKeepers", fetch = FetchType.LAZY)
    private List<CarEntity> cars = new ArrayList<>();

    public EmployeeEntity(String firstName, String lastName, EmployeePosition position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }
}
