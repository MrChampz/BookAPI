package com.felpsmac.bookapi.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "publish_places")
data class PublishPlace(
    @Id
    @Column(name = "id")
    val id: UUID?,

    @Column(name = "name")
    val name: String,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "book_publish_places",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "publish_place_id")]
    )
    val books: Set<Book>?,
)
