package org.example.loanprocessingapp.LoanProcessingApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "contracts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(name = "approved_amount")
    private Integer approvedAmount;

    @Column(name = "term")
    private Integer term;

    @Column(name = "sign_date")
    private String signDate;

    @Column(name = "status")
    private String status;


    public Contract(Person person, Integer approvedAmount, Integer term, String signDate, String status) {
        this.person = person;
        this.approvedAmount = approvedAmount;
        this.term = term;
        this.signDate = signDate;
        this.status = status;
    }
}
