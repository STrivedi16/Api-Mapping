package AllMapping.Booksdemo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Booksinfo, Integer> {

	public List<Booksinfo> findByName(String name);
}
