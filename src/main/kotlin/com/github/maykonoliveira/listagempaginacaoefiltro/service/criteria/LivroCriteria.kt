package com.github.maykonoliveira.listagempaginacaoefiltro.service.criteria

import com.github.maykonoliveira.listagempaginacaoefiltro.entity.Autor
import com.github.maykonoliveira.listagempaginacaoefiltro.entity.Genero
import com.github.maykonoliveira.listagempaginacaoefiltro.entity.Livro
import org.springframework.data.jpa.domain.Specification
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.criteria.JoinType

class LivroCriteria(
    val isbn: String?,
    val dataLancamento: LocalDate?,
    val preco: BigDecimal?,
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

        fun autores(autores: List<Long>): Specification<Livro> {
            return Specification<Livro> { root, _, criteriaBuilder ->
                val join = root.join<Livro, Autor>("autores", JoinType.INNER)
                criteriaBuilder.isTrue(join.get<Any>("id").`in`(autores))
            }
        }
    }
}
