package cmccarthyirl.controllers;

import cmccarthyirl.storage.ResultsContainer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultsController {

	@GetMapping("/results")
	public ResponseEntity<?> results() {
		return new ResponseEntity<>(ResultsContainer.getResult(), HttpStatus.OK);
	}

	@GetMapping("/results/{id}")
	public ResponseEntity<?> results(@PathVariable int id) {
		return new ResponseEntity<>(ResultsContainer.getResult(id), HttpStatus.OK);
	}
}