package ru.ibisarnov.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibisarnov.test.domain.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
