package com.smarthr.smarthrbackend.domain;

import com.smarthr.smarthrbackend.domain.enums.ContractType;
import com.smarthr.smarthrbackend.domain.enums.EmployeeStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employees")
public class Employee extends BaseEntity{

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, unique = true, length = 20)
    private String cin;

    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private ContractType contractType;

    @Column(nullable = false,precision = 12, scale = 2)
    private BigDecimal salary;

    @Column(nullable = false, length = 100)
    private String position;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EmployeeStatus employeeStatus = EmployeeStatus.ACTIVE;

    @Column(length = 500)
    private String photo_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

}