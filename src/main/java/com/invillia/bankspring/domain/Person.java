package com.invillia.bankspring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person extends IdAbstract<Long> {

    @Column(nullable = false, length = 14)
    private String cpf;

    @Column(nullable = false)
    private String name;
}