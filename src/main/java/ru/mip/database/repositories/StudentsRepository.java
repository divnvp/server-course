package ru.mip.database.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mip.database.models.Groups;
import ru.mip.database.models.Students;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Students,Long> {
}
