package com.felpsmac.bookapi.entity

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "covers")
data class Cover(
    @Id
    @Column(name = "id")
    val id: UUID?,

    @JsonProperty("small")
    @Column(name = "small")
    val smallUrl: String,

    @JsonProperty("medium")
    @Column(name = "medium")
    val mediumUrl: String,

    @JsonProperty("large")
    @Column(name = "large")
    val largeUrl: String,
)
