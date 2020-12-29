package com.github.maykonoliveira.listagempaginacaoefiltro.entity

import javax.persistence.*

@Entity
class Autor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    @Column
    private val nome: String,
    @ManyToOne
    private val livro: Livro,
)
