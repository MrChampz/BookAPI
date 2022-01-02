package com.felpsmac.bookapi.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Id
    @Column(name = "id")
    val id: UUID?,

    @Column(name = "title")
    val title: String,

    @Column(name = "subtitle")
    val subtitle: String,

    @Column(name = "url")
    val url: String,

    @JsonProperty("number_of_pages")
    @Column(name = "number_of_pages")
    val numberOfPages: Int,

    @Column(name = "pagination")
    val pagination: String,

    @JsonProperty("by_statement")
    @Column(name = "by_statement")
    val byStatement: String,

    @JsonProperty("publish_date")
    @Column(name = "publish_date")
    val publishDate: Date,

    @Column(name = "notes", nullable = true)
    val notes: String?,

    @JsonIgnoreProperties("id")
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "cover_id", referencedColumnName = "id")
    val cover: Cover?,
)