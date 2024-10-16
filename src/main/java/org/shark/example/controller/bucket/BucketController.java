package org.shark.example.controller.bucket;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.BucketConfiguration;
import io.github.bucket4j.ConsumptionProbe;
import io.github.bucket4j.distributed.proxy.ProxyManager;
import lombok.RequiredArgsConstructor;
import org.shark.example.exception.TooManyRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
@RequestMapping("bucket")
@RequiredArgsConstructor
public class BucketController {

    private final Supplier<BucketConfiguration> bucketConfiguration;

    private final ProxyManager<String> proxyManager;

    @GetMapping
    public String test(@RequestParam String key) {
        Bucket bucket = proxyManager.builder().build(key, bucketConfiguration);
        ConsumptionProbe consumptionProbe = bucket.tryConsumeAndReturnRemaining(1);
        if(!consumptionProbe.isConsumed()) {
            throw new TooManyRequestException();
        }
        return "Key: " + key;
    }
}
