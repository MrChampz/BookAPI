package com.felpsmac.bookapi.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "identifiers")
data class Identifier(
    @Id
    @Column(name = "id")
    val id: UUID?,

    @Column(name = "type")
    val type: String,

    @Column(name = "number")
    val number: String,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "book_identifiers",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "identifier_id")]
    )
    val books: Set<Book>?,
)
