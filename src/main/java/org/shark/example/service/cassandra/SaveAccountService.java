package org.shark.example.service.cassandra;

import lombok.RequiredArgsConstructor;
import org.shark.example.datasource.cassandra.AccountRepository;
import org.shark.example.datasource.cassandra.pojo.AccountDo;
import org.shark.example.service.cassandra.pojo.SaveAccountDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class SaveAccountService {

    private final AccountRepository accountRepository;

    public AccountDo saveAccount(@Validated SaveAccountDto saveAccountDto) {
        AccountDo accountDo = new AccountDo();
        accountDo.setId(UUID.randomUUID());
        accountDo.setAccount(saveAccountDto.getAccount());
        accountDo.setPassword(saveAccountDto.getPassword());
        accountDo = accountRepository.save(accountDo);
        return accountDo;
    }
}
