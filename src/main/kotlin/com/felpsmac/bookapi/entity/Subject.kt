package com.felpsmac.bookapi.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "subjects")
data class Subject(
    @Id
    @Column(name = "id")
    val id: UUID?,

    @Column(name = "name")
    val name: String,

    @Column(name = "url")
    val url: String,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "book_subjects",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "subject_id")]
    )
    val books: Set<Book>?,
)
