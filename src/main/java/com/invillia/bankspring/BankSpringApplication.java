package com.invillia.bankspring;

import com.invillia.bankspring.domain.Account;
import com.invillia.bankspring.domain.Person;
import com.invillia.bankspring.enums.AccountTipyEnum;
import com.invillia.bankspring.service.AccountService;
import com.invillia.bankspring.service.PersonService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BankSpringApplication {

    public static void main(String[] args) {

        final var applicationContext = new AnnotationConfigApplicationContext("com.invillia.bankspring");

        PersonService personService = applicationContext.getBean(PersonService.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);

        Person person = new Person("111.222.333-44", "Cespedes Bart");
        personService.insert(person);

        Account account = new Account(
                "111111",
                "9999",
                500.00,
                AccountTipyEnum.CHECKING_ACCOUNT.accountLimit,
                AccountTipyEnum.CHECKING_ACCOUNT,
                person
        );

        accountService.insert(account);

        if (accountService.withdraw(account, 1100D)) {
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo e limites insuficientes!");
        }

        accountService.deposit(account, 10000D);
    }
}