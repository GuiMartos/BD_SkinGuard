package br.com.tcc.skinguard.repository.fps;

import br.com.tcc.skinguard.model.Fps;
import br.com.tcc.skinguard.repository.filter.FpsFilter;
import org.apache.commons.lang3.StringUtils;
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

public class FpsRepositoryImpl implements FpsRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Fps> filtrar(FpsFilter fpsFilter, Pageable pageable){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Fps> criteria = builder.createQuery(Fps.class);
        Root<Fps> root = criteria.from(Fps.class);

        Predicate[] predicates = criarRestricoes(fpsFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("fps")));
        TypedQuery<Fps> query = manager.createQuery(criteria);
        adicionaRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(fpsFilter));
    }

    private Long total(FpsFilter fpsFilter){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root <Fps> root = criteria.from(Fps.class);

        Predicate[] predicates = criarRestricoes(fpsFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("fps")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }

    public void adicionaRestricoesDePaginacao(TypedQuery<Fps> query, Pageable pageable){
        int paginaAtual = pageable.getPageNumber();
        int totalRegistros = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistros;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistros);
    }

    private Predicate[] criarRestricoes(FpsFilter fpsFilter, CriteriaBuilder builder, Root<Fps> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (fpsFilter.getFps() != null) {
            predicates.add(builder.equal(root.get("fps"), fpsFilter.getFps()));
        }
        return predicates.toArray(new Predicate[0]);
    }
}
