package org.shark.example.controller.bucket

import io.github.bucket4j.BucketConfiguration
import io.github.bucket4j.distributed.proxy.ProxyManager
import org.shark.example.exception.TooManyRequestException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.function.Supplier

@RestController
@RequestMapping("bucket")
class BucketController(
    private val bucketConfiguration: Supplier<BucketConfiguration>,
    private val proxyManager: ProxyManager<String>
) {

    @GetMapping
    fun test(@RequestParam key: String): String {
        val bucket = proxyManager.builder().build(key, bucketConfiguration)
        val consumptionProbe = bucket.tryConsumeAndReturnRemaining(1)
        if (!consumptionProbe.isConsumed) {
            throw TooManyRequestException()
        }
        return "Key: $key"
    }
}
