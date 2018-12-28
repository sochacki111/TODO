package com.todo.my.todo.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name="todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
//    private String user;
//    @Size(min=5, message="Enter at least 5 characters...")
    @Column(name="description")
    private String description;


    public Todo() { }

/*    public Todo(int id, String user, String description) {
        this.id = id;
        this.user = user;
        this.description = description;

    }*/

    public Todo(int id, String description) {
        this.id = id;
        this.description = description;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*@Override
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
*/
    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
