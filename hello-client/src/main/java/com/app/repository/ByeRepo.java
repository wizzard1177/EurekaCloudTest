package com.app.repository;

import com.app.modal.ByeCounter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ByeRepo extends CrudRepository<ByeCounter,Long> {
}
