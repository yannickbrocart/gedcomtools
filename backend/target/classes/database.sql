-- ------------------------------------------------------------------------------
-- DATABASE BUILDING                                                          ---
-- ------------------------------------------------------------------------------

DROP DATABASE IF EXISTS db_gedcomtools; 	-- delete if exist
CREATE DATABASE IF NOT EXISTS db_gedcomtools 
	CHARACTER SET utf8mb4 
	COLLATE utf8mb4_general_ci;
USE db_gedcomtools;

-- ------------------------------------------------------------------------------
-- TABLE BUILDING: GEDCOM_FILE_USERS                                              ---
-- ------------------------------------------------------------------------------

DROP TABLE IF EXISTS gedcom_file_users;			-- delete if exist
CREATE TABLE gedcom_file_users (
	PRIMARY KEY (gedcom_file_user_id),
	gedcom_file_user_id		bigint(20) UNSIGNED 		NOT NULL AUTO_INCREMENT,
	first_name				varchar(100)				NOT NULL,
 	     					INDEX c_ind_first_name (first_name),
	last_name				varchar(100)				NOT NULL,
    						INDEX c_ind_last_name (last_name),
	login					varchar(60)					NOT NULL,
      						UNIQUE c_uni_login (login),
    						INDEX c_ind_login (login),
	email				 	varchar(60)					NOT NULL,
      						UNIQUE c_uni_email (email),
      						INDEX c_ind_email (email),
	registration_date		datetime 					NOT NULL,
							UNIQUE c_uni_name (first_name, last_name)
);

INSERT INTO gedcom_file_users (gedcom_file_user_id, first_name, last_name, login, email, registration_date) 
VALUES	(1, 'Yannick', 'Brocart', 'yannickbrocart', 'mail@yannickbrocart.com', '2023-06-20 19:24:33'),
		(2, 'Susanne', 'Fouquet', 'SusanneFouquet', 'susannefouquet@gmail.com', '2023-06-21 15:22:11'),
		(3, 'David', 'Bazin', 'd_bazin', 'dbazin@sfr.fr.com', '2023-06-21 20:02:47'),
		(4, 'Hélène', 'Leclerc', 'helene', 'heleneleclerc@laposte.net', '2023-06-22 18:15:30'),
		(5, 'Gauthier', 'Leblanc', 'gauthierleblanc', 'gleblanc@gmail.com', '2023-06-22 20:11:23'),
		(6, 'Violette ', 'Roussel', 'violette-roussel', 'violette.roussel@free.fr', '2023-06-24 14:47:15');
		
SELECT * FROM gedcom_file_users;		

-- ------------------------------------------------------------------------------
-- TABLE BUILDING: GEDCOM_FILES                                                    ---
-- ------------------------------------------------------------------------------

DROP TABLE IF EXISTS gedcom_files; 				-- delete if exist
CREATE TABLE gedcom_files (
	PRIMARY KEY (gedcom_file_id),
	gedcom_file_id			bigint(20) UNSIGNED 		NOT NULL AUTO_INCREMENT,
	name					varchar(100)				NOT NULL,
  							UNIQUE c_uni_name (name),
  							INDEX c_ind_name (name),
  	creation_date			datetime 					NOT NULL,
  	last_access_date	 	datetime 					DEFAULT NULL,
  	last_modified_date		datetime 					DEFAULT NULL,
  	created_by 				bigint(20) UNSIGNED 		NOT NULL,
  	last_modified_by 		bigint(20) UNSIGNED 		DEFAULT NULL,
  	status 					ENUM('Created', 'in_progress', 'Pending', 'Ended', 'Canceled')
  							DEFAULT 'Created',
      						INDEX c_ind_status (status),
	FOREIGN KEY (created_by) 		REFERENCES gedcoms_users(gedcoms_users_id) ON DELETE CASCADE,
	FOREIGN KEY (last_modified_by) 	REFERENCES gedcoms_users(gedcoms_users_id) ON DELETE CASCADE
);

INSERT INTO gedcom_files (gedcom_file_id, name, creation_date, last_access_date, last_modified_date, created_by, last_modified_by, status) 
VALUES	(1, 'Famille Brocart', '2023-06-22 14:27:01', '2023-06-25 20:12:13', '2023-06-25 20:12:13', 1, 1, 'in_progress'),
		(2, 'Famille Lamarre-Joly', '2023-06-23 18:27:01', '2023-06-24 09:30:22', '2023-06-23 18:27:01', 6, NULL, 'created'),
		(3, 'Famille Hardouin', '2021-06-22 18:27:01', '2021-06-24 14:22:18', '2021-06-24 14:22:18', 3, 4, 'in_progress');
		
SELECT * FROM gedcom_files;		
