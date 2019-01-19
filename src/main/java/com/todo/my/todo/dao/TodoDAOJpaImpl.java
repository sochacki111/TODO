package com.todo.my.todo.dao;

import com.todo.my.todo.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TodoDAOJpaImpl implements TodoDAO{

    private EntityManager entityManager;

    @Autowired
    public TodoDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Todo> findAll() {

        Query theQuery = entityManager.createQuery("from Todo");

        List<Todo> todos = theQuery.getResultList();

        return todos;

    }

    @Override
    public Todo findById(int theId) {

        Todo theTodo = entityManager.find(Todo.class, theId);
        return theTodo;
    }

    @Override
    public void save(Todo theTodo) {
        // save or update the todo
        Todo dbTodo = entityManager.merge(theTodo); // If id == 0 then (insert/save) else (update)

        theTodo.setId(dbTodo.getId());
    }

    @Override
    public void deleteById(int theId) {

        Query theQuery = entityManager.createQuery("delete from Todo where id=:todoId");

        theQuery.setParameter("todoId", theId);

        theQuery.executeUpdate();
    }
}
