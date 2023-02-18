package it.giaquinto.springberry.spring.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.sql.Timestamp

@Entity
class Note {
    @Id
    var id: Long = 0

    @Column(name = "NAME")
    var name: String = ""

    @Column(name = "DATE")
    var date: Timestamp? = null

    @Column(name = "BODY")
    var body: String = ""
}