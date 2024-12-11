package org.shark.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.shark.example.datasource.cassandra.pojo.AccountDo;
import org.shark.example.service.base.pojo.ResponseDto;
import org.shark.example.service.cassandra.GetAccountListService;
import org.shark.example.service.cassandra.SaveAccountService;
import org.shark.example.service.cassandra.pojo.SaveAccountDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/cassandra")
@RestController
public class CassandraController {

    private final SaveAccountService saveAccountService;

    @PostMapping
    public ResponseDto<AccountDo> saveAccount(@RequestBody @Valid SaveAccountDto saveAccountDto) {
        AccountDo accountDo = saveAccountService.saveAccount(saveAccountDto);
        return ResponseDto.<AccountDo>builder().data(accountDo).status(true).build();
    }

    private final GetAccountListService getAccountListService;

    @GetMapping
    public ResponseDto<List<AccountDo>> getAccount() {
        List<AccountDo> accountDoList = getAccountListService.getAccountList();
        return ResponseDto.<List<AccountDo>>builder().data(accountDoList).status(true).build();
    }
}
