package com.j2ee.j2eetdspring.repositories;

import com.j2ee.j2eetdspring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
