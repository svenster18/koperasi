package com.yanti.koperasi.repository;

import com.yanti.koperasi.model.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Integer> {
    Menu findByIdMenu(Integer idMenu);
}
