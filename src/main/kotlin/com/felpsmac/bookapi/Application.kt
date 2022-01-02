package com.felpsmac.bookapi

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("com.felpsmac.bookapi")
        .start()
}
