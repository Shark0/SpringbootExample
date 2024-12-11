package org.shark.example.service.cassandra;

import lombok.RequiredArgsConstructor;
import org.shark.example.datasource.cassandra.AccountRepository;
import org.shark.example.datasource.cassandra.pojo.AccountDo;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAccountListService {

    private final AccountRepository accountRepository;

    public List<AccountDo> getAccountList() {
        return accountRepository.findAll();
    }

}
