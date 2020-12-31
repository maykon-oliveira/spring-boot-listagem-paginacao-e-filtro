package com.github.maykonoliveira.listagempaginacaoefiltro.service.criteria

import com.github.maykonoliveira.listagempaginacaoefiltro.entity.Autor
import com.github.maykonoliveira.listagempaginacaoefiltro.entity.Genero
import com.github.maykonoliveira.listagempaginacaoefiltro.entity.Livro
import org.springframework.data.jpa.domain.Specification
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.format.annotation.DateTimeFormat.ISO
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.criteria.JoinType

class LivroCriteria(
    val isbn: String?,
    @DateTimeFormat(iso = ISO.DATE)
    val minDataLancamento: LocalDate?,
    val maxDataLancamento: LocalDate?,
    val minPreco: BigDecimal?,
    val maxPreco: BigDecimal?,
    val genero: Genero?,
    val autores: List<Long>?
) {
    companion object {
        fun isbn(isbn: String): Specification<Livro> {
            return Specification<Livro> { root, _, criteriaBuilder ->
                criteriaBuilder.equal(
                    root.get<Any>("isbn"),
                    isbn
                )
            }
        }

        fun minDataLancamento(minDataLancamento: LocalDate): Specification<Livro> {
            return Specification<Livro> { root, _, criteriaBuilder ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("dataLancamento"), minDataLancamento)
            }
        }

        fun maxDataLancamento(maxDataLancamento: LocalDate): Specification<Livro> {
            return Specification<Livro> { root, _, criteriaBuilder ->
                criteriaBuilder.lessThanOrEqualTo(root.get("dataLancamento"), maxDataLancamento)
            }
        }

        fun minPreco(minPreco: BigDecimal): Specification<Livro> {
            return Specification<Livro> { root, _, criteriaBuilder ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("preco"), minPreco)
            }
        }

        fun maxPreco(maxPreco: BigDecimal): Specification<Livro> {
            return Specification<Livro> { root, _, criteriaBuilder ->
                criteriaBuilder.lessThanOrEqualTo(root.get("preco"), maxPreco)
            }
        }

        fun genero(genero: Genero): Specification<Livro> {
            return Specification<Livro> { root, _, criteriaBuilder ->
                criteriaBuilder.equal(
                    root.get<Any>("genero"),
                    genero
                )
            }
        }

        fun autores(autores: List<Long>): Specification<Livro> {
            return Specification<Livro> { root, _, criteriaBuilder ->
                val join = root.join<Livro, Autor>("autores", JoinType.INNER)
                criteriaBuilder.isTrue(join.get<Any>("id").`in`(autores))
            }
        }
    }
}
