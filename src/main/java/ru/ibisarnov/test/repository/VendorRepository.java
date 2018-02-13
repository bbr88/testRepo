package ru.ibisarnov.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibisarnov.test.domain.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
