package com.accolite.BookStore.repository;

import com.accolite.BookStore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
