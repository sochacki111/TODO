package com.todo.my.todo.model;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;


public class Todo {

    private int id;
    private String user;
    @Size(min=5, message="Enter at least 5 characters...")
    private String description;


    public Todo() {
        super();
    }

    public Todo(int id, String user, String description, Date targetDate, boolean isDone) {
        this.id = id;
        this.user = user;
        this.description = description;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id &&
                Objects.equals(user, todo.user) &&
                Objects.equals(description, todo.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, description);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
