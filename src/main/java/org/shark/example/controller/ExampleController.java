package org.shark.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/example")
@Slf4j
public class ExampleController {

    @GetMapping("/log")
    public Map<String, String> check(@RequestParam("value") String value) {
        log.debug("value: " + value);
        Map<String, String> result = new HashMap<>();
        result.put("result", "success");
        return result;
    }

    @GetMapping("/error")
    public Map<String, String> error(@RequestParam("value") String value) throws Exception {
        log.error("value: " + value);
        throw new Exception(value);
    }
}
