package org.shark.example.service.cassandra

import org.shark.example.datasource.cassandra.AccountRepository
import org.shark.example.datasource.cassandra.pojo.AccountDo
import org.shark.example.service.cassandra.pojo.SaveAccountDto
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import java.util.UUID

@Service
class SaveAccountService(
    private val accountRepository: AccountRepository
) {
    fun saveAccount(@Validated saveAccountDto: SaveAccountDto): AccountDo {
        var accountDo = AccountDo(
            id = UUID.randomUUID(),
            account = saveAccountDto.account,
            password = saveAccountDto.password
        )
        accountDo = accountRepository.save(accountDo)
        return accountDo
    }
}
