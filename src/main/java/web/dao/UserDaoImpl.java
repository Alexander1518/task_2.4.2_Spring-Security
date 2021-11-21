package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        entityManager.remove(getUserById(id));

    }

    @Override
    @Transactional
    public User getUserById(long id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id = :id", User.class).setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        TypedQuery<User> query=entityManager.createQuery("select distinct u FROM User u LEFT JOIN FETCH u.roles", User.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public User getUserByName(String name) {
        Query query = entityManager.createQuery("select distinct u from User u LEFT JOIN FETCH u.roles where u.name =: name");
        query.setParameter("name", name);
        User user = (User) query.getSingleResult();
        return entityManager.find(User.class, user.getId());
    }
}