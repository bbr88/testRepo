package ru.ibisarnov.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibisarnov.test.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
