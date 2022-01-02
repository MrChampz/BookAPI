package com.felpsmac.bookapi.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "publishers")
data class Publisher(
    @Id
    @Column(name = "id")
    val id: UUID?,

    @Column(name = "name")
    val name: String,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "book_publishers",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "publisher_id")]
    )
    val books: Set<Book>?,
)
