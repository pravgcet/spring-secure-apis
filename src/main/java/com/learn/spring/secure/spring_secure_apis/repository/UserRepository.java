package com.learn.spring.secure.spring_secure_apis.repository;

import com.learn.spring.secure.spring_secure_apis.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserName(String userName);

}
