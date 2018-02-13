package ru.ibisarnov.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibisarnov.test.domain.Parameter;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {

}
