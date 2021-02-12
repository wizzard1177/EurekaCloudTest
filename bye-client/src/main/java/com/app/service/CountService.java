package com.app.service;

import com.app.modal.HelloCounter;
import com.app.repository.HelloRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountService {

    private final HelloRepo repo;

    public CountService(HelloRepo repo) {
        this.repo = repo;
    }

    @Transactional
    public HelloCounter getCounter(){
        HelloCounter counter = repo.findById(1L).orElseThrow(() -> new IllegalArgumentException("Empty"));
        return counter;
    }

    @Transactional
    public void increment(){
        HelloCounter counter = getCounter();
        counter.setCount(counter.getCount()+1);
        repo.save(counter);
    }
}
