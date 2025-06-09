package org.shark.example.aop.permission;

import org.springframework.stereotype.Service;

@Service
public class PermissionService {
    public boolean hasRedPermission(String permission) {
        return "admin:read".equals(permission);
    }
}
