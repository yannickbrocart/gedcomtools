package com.yannick.gedcomtools.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yannick.gedcomtools.model.Gedcom;
import com.yannick.gedcomtools.repository.GedcomRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping
public class GedcomControler {

	@Autowired
	GedcomRepository gedcomRepository;

	@PostMapping("/gedcoms")
	public ResponseEntity<Gedcom> createGedcoms(@RequestBody Gedcom gedcom) {
		try {
			Gedcom gedcomFile = gedcomRepository.save(new Gedcom(gedcom.getName(), getCreatedBy()));
			return new ResponseEntity<>(gedcomFile, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/gedcoms/{id}")
	public ResponseEntity<Gedcom> updateGedcoms(@RequestBody Gedcom gedcom, @PathVariable("id") Long id) {
		try {
			Gedcom gedcomFile = gedcomRepository.save(new Gedcom(gedcom.getName(), getCreatedBy()));
			return new ResponseEntity<>(gedcomFile, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/gedcoms")
	public ResponseEntity<List<Gedcom>> getAllGedcoms(@RequestParam(required = false) String name) {
		try {
			List<Gedcom> gedcomFilesList = new ArrayList<Gedcom>();
			gedcomRepository.findAll().forEach(gedcomFilesList::add);
			if (gedcomFilesList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(gedcomFilesList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/gedcoms/{id}")
	public ResponseEntity<Gedcom> getGedcomById(@PathVariable("id") Long id) {
		try {
			Optional<Gedcom> gedcom = gedcomRepository.findById(id);
			if (!gedcom.isPresent())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			else
				return new ResponseEntity<>(gedcom.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/gedcoms")
	public ResponseEntity<Gedcom> deletteAllGedcoms() {
		try {
			gedcomRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/gedcoms/{id}")
	public ResponseEntity<Gedcom> gdeleteGedcomById(@PathVariable("id") Long id) {
		try {
			gedcomRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	@GetMapping("/findgedcombystatus/{status}")
//	public ResponseEntity<List<Gedcom>> findGedcomByStatus(@PathVariable("status") String status) {
//		try {
//			List<Gedcom> gedcomFilesList = new ArrayList<Gedcom>();
//			gedcomRepository.findByStatus(status).forEach(gedcomFilesList::add);
//			if (gedcomFilesList.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//			return new ResponseEntity<>(gedcomFilesList, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

//	@GetMapping("/gedcoms/{creator}")
//	public ResponseEntity<List<Gedcom>> findGedcomByCreator(@PathVariable("creator") long creatorId) {
//		try {
//			List<Gedcom> gedcomFilesList = new ArrayList<Gedcom>();
//			gedcomRepository.findByCreator(creatorId).forEach(gedcomFilesList::add);
//			if (gedcomFilesList.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//			return new ResponseEntity<>(gedcomFilesList, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	@GetMapping("/gedcoms/{modifier}")
//	public ResponseEntity<List<Gedcom>> findGedcomByLastModifier(@PathVariable("modifier") long lastModifierId) {
//		try {
//			List<Gedcom> gedcomFilesList = new ArrayList<Gedcom>();
//			gedcomRepository.findByLastModifier(lastModifierId).forEach(gedcomFilesList::add);
//			if (gedcomFilesList.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//			return new ResponseEntity<>(gedcomFilesList, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

}
