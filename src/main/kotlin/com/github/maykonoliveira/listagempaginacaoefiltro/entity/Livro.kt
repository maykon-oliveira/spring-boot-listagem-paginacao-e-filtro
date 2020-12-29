package com.github.maykonoliveira.listagempaginacaoefiltro.entity

import org.springframework.format.annotation.DateTimeFormat
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
class Livro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    @Column
    private val isbn: String,
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private val dataLancamento: LocalDate,
    @Column
    private val preco: BigDecimal,
    @Column
    @Enumerated(EnumType.STRING)
    private val genero: Genero,
    @OneToMany(mappedBy = "livro")
    private val autores: List<Autor>
)