DROP TABLE IF EXISTS `GT_gedcom`;
CREATE TABLE IF NOT EXISTS `GT_gedcom` (
  `gedcomId` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL,
  `creationTime` datetime NOT NULL,
  `lastAccessTime` datetime DEFAULT NULL,
  `lastModifiedTime` datetime DEFAULT NULL,
  `createdBy` bigint(20) UNSIGNED NOT NULL,
  `lastModifiedBy` bigint(20) UNSIGNED DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`gedcomId`),
  UNIQUE KEY `U_NAME` (`name`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;




INSERT INTO `GT_gedcom` (`gedcomId`, `name`, `creationTime`, `lastAccessTime`, `lastModifiedTime`, `createdBy`, `lastModifiedBy`, `status`) VALUES
(1, 'Yannick', '2023-06-22 18:27:01', '2023-06-22 18:27:01', '2023-06-22 18:27:01', 1, NULL, 'created'),
(2, 'Luz', '2023-06-22 18:27:01', '2023-06-22 18:27:01', '2023-06-22 18:27:01', 1, NULL, 'created');
COMMIT;