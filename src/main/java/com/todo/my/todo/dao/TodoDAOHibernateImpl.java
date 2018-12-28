package com.todo.my.todo.dao;

import com.todo.my.todo.entity.Todo;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoDAOHibernateImpl implements TodoDAO{

    private EntityManager entityManager;

    @Autowired
    TodoDAOHibernateImpl(EntityManager theEntityManager) {entityManager = theEntityManager;}

    @Override
    public List<Todo> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Todo> theQuery = currentSession.createQuery("from Todo", Todo.class);
        List<Todo> todos = theQuery.getResultList();
        return todos;
    }

    @Override
    public Todo findById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);
        Todo theTodo = currentSession.get(Todo.class, theId);

        return theTodo;
    }

    @Override
    public void save(Todo theTodo) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theTodo);
    }

    @Override
    public void deleteById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery =
                currentSession.createQuery(
                        "delete from Todo where id=:todoId");
        theQuery.setParameter("todoId", theId);

        theQuery.executeUpdate();
    }
}
