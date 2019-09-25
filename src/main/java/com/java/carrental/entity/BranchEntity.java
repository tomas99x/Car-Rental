package com.java.carrental.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BRANCH")
public class BranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "BRANCH_ID")
    private Set<EmployeeEntity> employees = new HashSet<>();

    @Embedded
    private Address address;

}
