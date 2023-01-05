package com.yanti.koperasi.repository;

import com.yanti.koperasi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    User findByNomorKTP(String nomorKTP);
    User findByUsername(String username);
}
