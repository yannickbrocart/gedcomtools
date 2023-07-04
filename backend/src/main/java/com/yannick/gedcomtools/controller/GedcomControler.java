package com.yannick.gedcomtools.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yannick.gedcomtools.model.Gedcom;
import com.yannick.gedcomtools.repository.GedcomRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class GedcomControler {

	@Autowired
	GedcomRepository gedcomRepository;

	@GetMapping("/gedcoms")
	public ResponseEntity<List<Gedcom>> getAllGedcoms(@RequestParam(required = false) String name) {
		List<Gedcom> gedcoms = new ArrayList<Gedcom>();
		gedcomRepository.findAll().forEach(gedcoms::add);
		return new ResponseEntity<>(gedcoms, HttpStatus.OK);
	}

}
