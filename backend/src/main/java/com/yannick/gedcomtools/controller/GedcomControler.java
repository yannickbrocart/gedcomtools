package com.yannick.gedcomtools.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yannick.gedcomtools.model.Gedcom;
import com.yannick.gedcomtools.model.GedcomStatusType;
import com.yannick.gedcomtools.model.User;
import com.yannick.gedcomtools.repository.GedcomRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping
public class GedcomControler {

	@Autowired
	GedcomRepository gedcomRepository;

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

	@GetMapping("/gedcoms/{status}")
	public ResponseEntity<List<Gedcom>> findGedcomByStatus(@PathVariable("status") GedcomStatusType status) {
		try {
			List<Gedcom> gedcomFilesList = new ArrayList<Gedcom>();
			gedcomRepository.findAll().forEach(gedcomFilesList::add);
			return new ResponseEntity<>(gedcomFilesList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/gedcoms/{creator}")
	public ResponseEntity<List<Gedcom>> findGedcomByCreator(@PathVariable("creator") User createdBy) {
		try {
			List<Gedcom> gedcomFilesList = new ArrayList<Gedcom>();
			return new ResponseEntity<>(gedcomFilesList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/gedcoms/{modifier}")
	public ResponseEntity<List<Gedcom>> findGedcomByLastModifier(@PathVariable("modifier") User lastModifiedBy) {
		try {
			List<Gedcom> gedcomFilesList = new ArrayList<Gedcom>();
			return new ResponseEntity<>(gedcomFilesList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
