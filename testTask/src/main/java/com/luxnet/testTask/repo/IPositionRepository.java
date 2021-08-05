package com.luxnet.testTask.repo;

import com.luxnet.testTask.models.Position;
import org.springframework.data.repository.CrudRepository;

public interface IPositionRepository extends CrudRepository<Position, Long> {
}
