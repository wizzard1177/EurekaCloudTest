package com.app.modal;

import javax.persistence.*;

@Entity
@Table (schema = "microservices_task", name = "hello_counter")
public class HelloCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    int count;

    public HelloCounter() {
    }

    public HelloCounter(long id, int count) {
        this.id = id;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
