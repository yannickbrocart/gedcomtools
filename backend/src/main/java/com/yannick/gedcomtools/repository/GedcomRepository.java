package com.yannick.gedcomtools.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yannick.gedcomtools.model.Gedcom;
import com.yannick.gedcomtools.model.GedcomStatusType;
import com.yannick.gedcomtools.model.User;

public interface GedcomRepository extends JpaRepository<Gedcom, Long> {
	List<Gedcom> findByStatus(GedcomStatusType status);

	List<Gedcom> findByCreated(User createdBy);

	List<Gedcom> findByLastModified(User lastModifiedBy);
}
