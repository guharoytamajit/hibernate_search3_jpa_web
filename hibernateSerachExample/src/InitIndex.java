import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.search.jpa.Search;

import com.mylibrary.action.db.entitys.Book;


public class InitIndex {
public static void main(String[] args) {
	  EntityManagerFactory emf =  
	          Persistence.createEntityManagerFactory("customerManager");
		  EntityManager em = emf.createEntityManager(); 
	 Search.getFullTextEntityManager(em).createIndexer(Book.class).start();
}
}
