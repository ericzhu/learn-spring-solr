package com.booster.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booster.data.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
