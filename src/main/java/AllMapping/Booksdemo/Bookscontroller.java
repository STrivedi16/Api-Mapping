package AllMapping.Booksdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping("/Addbook")
	public Booksinfo addbook(@RequestBody Booksinfo bok) {

		return br.save(bok);

	}

}
