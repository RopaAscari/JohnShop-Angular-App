package database;
import org.springframework.data.jpa.repository.JpaRepository;

import entities.Order;

public interface IOrderDatabase 
extends JpaRepository<Order,Integer>   {

}
