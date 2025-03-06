package org.example.loanprocessingapp.LoanProcessingApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "credit_decisions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreditDecision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(name = "status")
    private String status;

    @Column(name = "approved_amount")
    private Integer approvedAmount;

    @Column(name = "term")
    private Integer term;

    public CreditDecision(Person person, String status, Integer approvedAmount, Integer term) {
        this.person = person;
        this.status = status;
        this.approvedAmount = approvedAmount;
        this.term = term;
    }

}

