package ru.domru.carrental.domain.system;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface UserRepository extends DataTablesRepository<User, Integer> {

	User findUserByName(String username);

}
