package com.java.carrental.entity;

import com.java.carrental.entity.enums.EmployeePosition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EmployeePosition position;

    @ManyToOne
    private BranchEntity branch;

    @ManyToMany(mappedBy = "carKeepers")
    private List<CarEntity> cars;

    public EmployeeEntity(String firstName, String lastName, EmployeePosition position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }
}
