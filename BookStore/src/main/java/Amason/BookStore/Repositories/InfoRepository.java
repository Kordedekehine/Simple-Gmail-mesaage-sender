package Amason.BookStore.Repositories;


import Amason.BookStore.Model.Info;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends CrudRepository<Info,Integer> {

}
