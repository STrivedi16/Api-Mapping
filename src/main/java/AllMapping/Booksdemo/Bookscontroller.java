package AllMapping.Booksdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Bookscontroller {

	@Autowired
	private BooksRepository br;

	List<Booksinfo> li = new ArrayList<>();

	@GetMapping("/Books")
	public Iterable<Booksinfo> getallbooks() {
		Iterable<Booksinfo> boks = br.findAll();
		return boks;

	}

	@GetMapping("/books/{id}")
	public Booksinfo Booksinfo(@PathVariable("id") int id) {
		Optional<Booksinfo> book = br.findById(id);

		return book.get();
	}

	@PostMapping("/Addbook")
	public Booksinfo addbook(@RequestBody Booksinfo bok) {

		return br.save(bok);

	}

	@DeleteMapping("books/{id}")
	public String Deletebook(@PathVariable("id") int bid) {

		br.deleteById(bid);

		return "your Data has delete";

	}

	@PutMapping("bookupdate/{id}")
	public Booksinfo updatebook(@RequestBody Booksinfo book, @PathVariable("id") int bid) {

		if (book.getBokid() == bid) {
			book.setName("The key of Success");
			book.setAuthor("Shubham Trivedi");

			return br.save(book);
		} else {
			return book;
		}

	}

	@GetMapping("findby/{bookname}")
	public Iterable<AllMapping.Booksdemo.Booksinfo> findbyname(@PathVariable("bookname") String name) {

		ArrayList<Booksinfo> list = new ArrayList<>();

		List<Booksinfo> bo = br.findByName(name);

		for (int i = 0; i < bo.size(); i++) {
			list.add(bo.get(i));
		}

		return list;

	}

}
