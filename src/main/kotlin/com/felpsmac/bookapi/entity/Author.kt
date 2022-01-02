package com.felpsmac.bookapi.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "authors")
data class Author(
    @Id
    @Column(name = "id")
    val id: UUID?,

    @Column(name = "name")
    val name: String,

    @Column(name = "url")
    val url: String,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "book_authors",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")]
    )
    val books: Set<Book>?,
)
