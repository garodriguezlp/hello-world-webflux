package com.example.helloworldwebflux

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration.ofSeconds
import java.util.*

@RestController
class HelloController {

    @GetMapping("/hello")
    fun hello(): Flux<Hello> = Flux.just("Gustavo", "Maria", "Pedro", "Paulo")
        .delayElements(ofSeconds(2))
        .map { it.uppercase(Locale.getDefault()) }
        .map { Hello("Hello $it") }
}

data class Hello(val message: String)
