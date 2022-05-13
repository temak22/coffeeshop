package ru.mirea.coffeeshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.coffeeshop.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
