package br.com.tcc.skinguard.repository.usuario;

import br.com.tcc.skinguard.model.Usuario;
import br.com.tcc.skinguard.repository.filter.UsuarioFilter;
import br.com.tcc.skinguard.repository.projections.ResumoUsuario;
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

public class UsuarioRepositoryImpl implements UsuarioRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<ResumoUsuario> filtrar(UsuarioFilter usuarioFilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ResumoUsuario> criteria = builder.createQuery(ResumoUsuario.class);
        Root<Usuario> root = criteria.from(Usuario.class);

        criteria.select(builder.construct(ResumoUsuario.class
                ,root.get("id")
                ,root.get("login")
                ,root.get("senha")
                ,root.get("pele").get("tom")
                ,root.get("fps").get("fps")

        ));

        Predicate[] predicates = criarRestricoes (usuarioFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("usuario")));

        TypedQuery<ResumoUsuario> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(),pageable, total(usuarioFilter));
    }

    private Long total(UsuarioFilter usuarioFilter){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Usuario> root = criteria.from(Usuario.class);

        Predicate[] predicates = criarRestricoes(usuarioFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("usuario")));

        return manager.createQuery(criteria).getSingleResult();
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable){
        int paginaAtual = pageable.getPageNumber();
        int totalRegistros = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistros;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistros);
    }

    private Predicate[] criarRestricoes(UsuarioFilter usuarioFilter, CriteriaBuilder builder, Root<Usuario> root){
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(usuarioFilter.getLogin())){
            predicates.add(builder.like(builder.lower(root.get("login")),
                    "%"+usuarioFilter.getLogin().toLowerCase()));
        }

        if (!StringUtils.isEmpty(usuarioFilter.getPele())){
            predicates.add(builder.like(builder.lower(root.get("pele").get("tom")),
                    "%"+ usuarioFilter.getPele().toLowerCase() +"%"));
        }

        return predicates.toArray((new Predicate[predicates.size()]));
    }
}
