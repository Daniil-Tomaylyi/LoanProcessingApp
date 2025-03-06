package org.example.loanprocessingapp.LoanProcessingApp.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persons")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "passport_number", nullable = false, unique = true)
    private String passportNumber;
    @Column(name = "marital_status", nullable = false)
    private String maritalStatus;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "position_job")
    private String positionJob;
    @Column(name = "work_period")
    private String workPeriod;
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
    @Column(name = "desired_loan_amount")
    private Double desiredLoanAmount;
}
