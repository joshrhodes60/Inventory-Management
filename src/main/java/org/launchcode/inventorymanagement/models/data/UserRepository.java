package org.launchcode.inventorymanagement.models.data;

import org.launchcode.inventorymanagement.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
