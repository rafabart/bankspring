package com.invillia.bankspring.domain;

import com.invillia.bankspring.enums.AccountTipyEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account extends IdAbstract<Long> {

    @Column(nullable = false, length = 6)
    private String numberAccount;

    @Column(nullable = false, length = 4)
    private String agency;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double balance;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double limitAccount;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private AccountTipyEnum accountTipyEnum;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_person", nullable = false)
    private Person person;
}