package com.invillia.bankspring.domain;

import com.invillia.bankspring.enums.AccountTipyEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public Account(String agency, String numberAccount, Double balance, AccountTipyEnum accountTipyEnum, Person person) {
        this.agency = agency;
        this.numberAccount = numberAccount;
        this.limitAccount = accountTipyEnum.accountLimit;
        this.balance = balance;
        this.accountTipyEnum = accountTipyEnum;
        this.person = person;
    }

    public Account() {
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public Double getBalance() {
        return balance;
    }

    public AccountTipyEnum getAccountTipyEnum() {
        return accountTipyEnum;
    }

    public void setAccountTipyEnum(AccountTipyEnum accountTipyEnum) {
        this.accountTipyEnum = accountTipyEnum;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Account{");
        sb.append(super.toString()).append('\'');
        sb.append(", agency='").append(agency).append('\'');
        sb.append(", numberAccount='").append(numberAccount).append('\'');
        sb.append(", balance=").append(balance);
        sb.append(", limitAccount=").append(limitAccount);
        sb.append(", accountType=").append(accountTipyEnum.type);
        sb.append(", person=").append(person);
        sb.append('}');
        return sb.toString();
    }
}