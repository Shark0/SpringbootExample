package org.shark.example.service.cassandra

import org.shark.example.datasource.cassandra.AccountRepository
import org.shark.example.datasource.cassandra.pojo.AccountDo
import org.springframework.stereotype.Service

@Service
class GetAccountListService(
    private val accountRepository: AccountRepository
) {
    fun getAccountList(): List<AccountDo> {
        return accountRepository.findAll()
    }
}
