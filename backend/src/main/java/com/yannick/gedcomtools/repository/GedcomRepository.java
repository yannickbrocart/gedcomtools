package com.yannick.gedcomtools.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yannick.gedcomtools.model.Gedcom;

public interface GedcomRepository extends JpaRepository<Gedcom, Long> {

	@Query("SELECT g FROM Gedcom g WHERE g.status = ?1")
	List<Gedcom> findByStatus(GedcomStatusType status);

//	@Query("SELECT * FROM gedcom_files g WHERE g.created_by = ?1")
//	List<Gedcom> findByCreator(long creatorId);
//
//	@Query("SELECT * FROM gedcom_files g WHERE g.last_modified_by = ?1")
//	List<Gedcom> findByLastModifier(long lastModifierId);
}