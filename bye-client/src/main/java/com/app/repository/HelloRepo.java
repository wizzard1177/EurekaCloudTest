package com.app.repository;

import com.app.modal.HelloCounter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepo extends CrudRepository<HelloCounter,Long> {
}
