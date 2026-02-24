package org.shark.example.aop.permission

import org.springframework.stereotype.Service

@Service
class PermissionService {
    fun hasRedPermission(permission: String): Boolean {
        return "admin:read" == permission
    }
}
