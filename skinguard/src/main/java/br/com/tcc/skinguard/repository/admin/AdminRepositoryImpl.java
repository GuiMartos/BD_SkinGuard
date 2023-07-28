package br.com.tcc.skinguard.repository.admin;

import br.com.tcc.skinguard.model.Admin;
import br.com.tcc.skinguard.repository.filter.AdminFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Predicates;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

        return null;
    }
}
