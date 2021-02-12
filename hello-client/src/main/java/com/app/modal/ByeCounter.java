package com.app.modal;

import javax.persistence.*;

@Entity
@Table (schema = "microservices_task", name = "bye_counter")
public class ByeCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    int count;

    public ByeCounter() {
    }

    public ByeCounter(Long id, int count) {
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
