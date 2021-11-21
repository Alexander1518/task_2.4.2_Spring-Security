package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> listRoles() {
        TypedQuery<Role> query=entityManager.createQuery("select u from Role u", Role.class);
        return query.getResultList();
    }

    @Override
    public Set<Role> getRoleById(List<Long> id) {
        TypedQuery<Role> query = entityManager.createQuery("select u from Role u where u.id in :id", Role.class);
        return new HashSet<>(query.setParameter("id", id).getResultList());
    }
}