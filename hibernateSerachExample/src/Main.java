import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.WildcardQuery;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;

import com.mylibrary.action.db.entitys.Book;




public class Main {
public static void main(String[] args) {

    
	  EntityManagerFactory emf =  
	          Persistence.createEntityManagerFactory("customerManager");
		  EntityManager em = emf.createEntityManager();  

		  
		  
}
}
