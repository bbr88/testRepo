package ru.ibisarnov.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibisarnov.test.domain.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

}
