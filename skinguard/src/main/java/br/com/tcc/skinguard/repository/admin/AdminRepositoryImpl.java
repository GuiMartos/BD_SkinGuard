package br.com.tcc.skinguard.repository.admin;

import br.com.tcc.skinguard.model.Admin;
import br.com.tcc.skinguard.repository.filter.AdminFilter;
import br.com.tcc.skinguard.repository.filter.UsuarioFilter;
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
import java.util.Locale;

public class AdminRepositoryImpl implements AdminRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Admin> filtrar(AdminFilter adminFilter, Pageable pageable){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Admin> criteria = builder.createQuery(Admin.class);
        Root<Admin> root = criteria.from(Admin.class);

        Predicate[] predicates = criarRestricoes(adminFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("login")));
        TypedQuery<Admin> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(adminFilter));
    }

    private Long total(AdminFilter adminFilter){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Admin> root = criteria.from(Admin.class);

        Predicate[] predicates = criarRestricoes(adminFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("login")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<Admin> query, Pageable pageable){
        int paginaAtual = pageable.getPageNumber();
        int totalRegistros = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistros;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistros);
    }

    private Predicate[] criarRestricoes(AdminFilter adminFilter, CriteriaBuilder builder, Root<Admin> root){
        List<Predicate> predicates = new ArrayList<>();

        if(!StringUtils.isEmpty(adminFilter.getLogin())){
        predicates.add(builder.like(builder.lower(root.get("login")),
                "%"+adminFilter.getLogin().toLowerCase()+"%"));
        }

        return predicates.toArray((new Predicate[predicates.size()]));
    }
}
