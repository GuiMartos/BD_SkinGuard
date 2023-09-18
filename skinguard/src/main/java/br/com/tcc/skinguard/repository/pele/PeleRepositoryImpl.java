package br.com.tcc.skinguard.repository.pele;

import br.com.tcc.skinguard.model.Pele;
import br.com.tcc.skinguard.repository.filter.PeleFilter;
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

public class PeleRepositoryImpl implements PeleRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Pele> filtar(PeleFilter peleFilter, Pageable pageable){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Pele> criteria = builder.createQuery(Pele.class);
        Root<Pele> root = criteria.from(Pele.class);

        Predicate[] predicates = criarRestricoes(peleFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("tom")));
        TypedQuery<Pele> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(peleFilter));
    }

    private Long total(PeleFilter peleFilter){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Pele> root = criteria.from(Pele.class);

        Predicate[] predicates = criarRestricoes(peleFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("tom")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<Pele> query, Pageable pageable){
        int paginaAtual = pageable.getPageNumber();
        int totalRegistros = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistros;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistros);
    }

    private Predicate[] criarRestricoes(PeleFilter peleFilter, CriteriaBuilder builder, Root<Pele> root){
        List<Predicate> predicates = new ArrayList<>();

        return null;
    }
}
