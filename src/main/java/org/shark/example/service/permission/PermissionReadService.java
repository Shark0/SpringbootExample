package org.shark.example.service.permission;

import lombok.extern.slf4j.Slf4j;
import org.shark.example.aop.permission.RequiresPermission;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PermissionReadService {

    @RequiresPermission("admin:read") //FIXME
    public void start() {
        log.info("start work");
    }

}
