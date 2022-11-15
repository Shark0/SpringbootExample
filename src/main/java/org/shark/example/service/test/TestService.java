package org.shark.example.service.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService {
    public void start() {
        log.info("start!");
    }
}
