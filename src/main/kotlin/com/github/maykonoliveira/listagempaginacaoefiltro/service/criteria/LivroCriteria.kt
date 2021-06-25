package com.github.maykonoliveira.listagempaginacaoefiltro.service.criteria

import com.github.maykonoliveira.listagempaginacaoefiltro.entity.Autor
import com.github.maykonoliveira.listagempaginacaoefiltro.entity.Genero
import com.github.maykonoliveira.listagempaginacaoefiltro.entity.Livro
import org.springframework.data.jpa.domain.Specification
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.format.annotation.DateTimeFormat.ISO
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
import javax.persistence.criteria.JoinType

class LivroCriteria(
    private val isbn: String?,
    @DateTimeFormat(iso = ISO.DATE)
    private val minDataLancamento: LocalDate?,
    private val maxDataLancamento: LocalDate?,
    private val minPreco: BigDecimal?,
    private val maxPreco: BigDecimal?,
    private val genero: Genero?,
    private val autores: List<Long>?
) : CriteriaSpecification<Livro> {
    override fun toSpecification(): Specification<Livro> {
        var specification = Specification.where<Livro>(null)

        if (Objects.nonNull(isbn)) {
            specification = specification.and { root, _, criteriaBuilder ->
                criteriaBuilder.equal(
                    root.get<Any>("isbn"),
                    isbn
                )
            }
        }

        if (Objects.nonNull(minDataLancamento)) {
            specification = specification.and { root, _, criteriaBuilder ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("dataLancamento"), minDataLancamento)
            }
        }

        if (Objects.nonNull(maxDataLancamento)) {
            specification = specification.and { root, _, criteriaBuilder ->
                criteriaBuilder.lessThanOrEqualTo(root.get("dataLancamento"), maxDataLancamento)
            }
        }

        if (Objects.nonNull(minPreco)) {
            specification = specification.and { root, _, criteriaBuilder ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("preco"), minPreco)
            }
        }

        if (Objects.nonNull(maxPreco)) {
            specification = specification.and { root, _, criteriaBuilder ->
                criteriaBuilder.lessThanOrEqualTo(root.get("preco"), maxPreco)
            }
        }

        if (Objects.nonNull(genero)) {
            specification = specification.and { root, _, criteriaBuilder ->
                criteriaBuilder.equal(
                    root.get<Any>("genero"),
                    genero
                )
            }
        }

        if (Objects.nonNull(autores)) {
            specification = specification.and { root, _, criteriaBuilder ->
                val join = root.join<Livro, Autor>("autores", JoinType.INNER)
                criteriaBuilder.isTrue(join.get<Any>("id").`in`(autores))
            }
        }

        return specification
    }
}
