package ru.mip.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mip.database.models.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users,Long> {
}
