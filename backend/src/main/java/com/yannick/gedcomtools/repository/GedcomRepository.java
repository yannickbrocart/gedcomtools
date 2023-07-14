package com.yannick.gedcomtools.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yannick.gedcomtools.model.Gedcom;
import com.yannick.gedcomtools.model.GedcomStatusType;

public interface GedcomRepository extends JpaRepository<Gedcom, Long> {

//	public List<Gedcom> findByStatus(GedcomStatusType status);

	public List<Gedcom> findByCreatedBy(User createdBy);

//	List<Gedcom> findByLastModifier(long lastModifierId);
}