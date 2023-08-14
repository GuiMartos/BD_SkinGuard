package br.com.tcc.skinguard.repository.esp;

import br.com.tcc.skinguard.model.Esp;
import br.com.tcc.skinguard.repository.filter.EspFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EspRepositoryImpl implements EspRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Esp> filtrar(EspFilter espFilter, Pageable pageable){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Esp> criteria = builder.createQuery(Esp.class);
        Root<Esp> root = criteria.from(Esp.class);

        Predicate[] predicates = criarRestricoes(espFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("uvIndex")));
        TypedQuery<Esp> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(espFilter));
    }

    private Long total(EspFilter espFilter){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Esp> root = criteria.from(Esp.class);

        Predicate[] predicates = criarRestricoes(espFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("uvIndex")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();

    }

    private void adicionarRestricoesDePaginacao(TypedQuery<Esp> query, Pageable pageable){
        int paginaAtual = pageable.getPageNumber();
        int totalRegistros = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistros;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistros);
    }

    private Predicate[] criarRestricoes(EspFilter espFilter, CriteriaBuilder builder, Root<Esp>root){
        List<Predicate> predicates = new ArrayList<>();

        return null;
    }
}
