package org.shark.example.service.permission

import org.shark.example.aop.permission.RequiresPermission
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PermissionReadService {

    private val log = LoggerFactory.getLogger(PermissionReadService::class.java)

    @RequiresPermission("admin:read") //FIXME
    fun start() {
        log.info("start work")
    }
}
