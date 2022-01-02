package com.felpsmac.bookapi.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "book_authors",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")]
    )
    val authors: Set<Author>?,

    @JsonIgnoreProperties("id")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "book_identifiers",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "identifier_id")]
    )
    val identifiers: Set<Identifier>?,

    @JsonIgnoreProperties("id")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "book_publishers",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "publisher_id")]
    )
    val publishers: Set<Publisher>?,

    @JsonProperty("publish_places")
    @JsonIgnoreProperties("id")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "book_publish_places",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "publish_place_id")]
    )
    val publishPlaces: Set<PublishPlace>?,

    @JsonIgnoreProperties("id")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "book_subjects",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "subject_id")]
    )
    val subjects: Set<Subject>?,

    @JsonIgnoreProperties("id")
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "cover_id", referencedColumnName = "id")
    val cover: Cover?,
)