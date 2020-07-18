package database;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Inventory;

public interface IInventoryDatabase extends JpaRepository<Inventory,Integer>  {

}


