package ru.mip.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mip.database.models.Groups;

@Repository
public interface GroupsRepository extends CrudRepository<Groups,Long> {
}
