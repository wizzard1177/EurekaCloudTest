package com.app.service;

import com.app.modal.ByeCounter;
import com.app.repository.ByeRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountService {

    private final ByeRepo repo;

    public CountService(ByeRepo repo) {
        this.repo = repo;
    }

    @Transactional
    public ByeCounter getCounter(){
        ByeCounter counter = repo.findById(1L).orElseThrow(() -> new IllegalArgumentException("Empty"));
        return counter;
    }

    @Transactional
    public void increment(){
        ByeCounter counter = getCounter();
        counter.setCount(counter.getCount()+1);
        repo.save(counter);
    }
}
