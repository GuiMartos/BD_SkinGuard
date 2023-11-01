package br.com.tcc.skinguard.repository.clima;

import br.com.tcc.skinguard.model.Clima;
import br.com.tcc.skinguard.model.Fps;
import br.com.tcc.skinguard.repository.filter.ClimaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ClimaRepositoryImpl implements ClimaRepositoryQuery {

    private EntityManager manager;
    @Override
    public Page<Clima> filtrar(ClimaFilter climaFilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Clima> criteria = builder.createQuery(Clima.class);
        Root<Clima> root =  criteria.from(Clima.class);

        Predicate[] predicates = criarRestricoes(climaFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("dia")));
        TypedQuery<Clima> query = manager .createQuery(criteria);
        adicionaRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getSingleResult(), pageable, total(climaFilter));
    }

    private Long total(ClimaFilter climaFilter){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Clima> criteria = builder.createQuery(Long.class);
        Root<Clima> root =  criteria.from(Long.class);

        Predicate[] predicates = criarRestricoes(climaFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("dia")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }

    public void adicionaRestricoesDePaginacao(TypedQuery<Clima> query, Pageable pageable){
        int paginaAtual = pageable.getPageNumber();
        int totalRegistros = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistros;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistros);
    }

    private Predicate[] criarRestricoes(ClimaFilter climaFilter, CriteriaBuilder builder, Root<Clima> root){

        return null;
    }
}
