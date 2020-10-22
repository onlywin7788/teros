-- --------------------------------------------------------
-- 호스트:                          10.10.2.102
-- 서버 버전:                        10.4.15-MariaDB - MariaDB Server
-- 서버 OS:                        Linux
-- HeidiSQL 버전:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 TEROS_METADB.api 구조 내보내기
CREATE TABLE IF NOT EXISTS `api` (
  `API_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'API_ID',
  `API_NAME` varchar(64) DEFAULT NULL COMMENT 'API명',
  `VERSION` varchar(32) DEFAULT NULL COMMENT 'API_버전',
  `TARGET_URL` varchar(2048) DEFAULT NULL COMMENT 'TARGET_URL',
  `DESCRIPTION` text DEFAULT NULL COMMENT 'API_설명',
  `CREATE_DTIME` datetime DEFAULT NULL COMMENT '생성시각',
  `MODIFY_DTIME` datetime DEFAULT NULL COMMENT '수정시각',
  PRIMARY KEY (`API_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='API';

-- 테이블 데이터 TEROS_METADB.api:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `api` DISABLE KEYS */;
INSERT INTO `api` (`API_ID`, `API_NAME`, `VERSION`, `TARGET_URL`, `DESCRIPTION`, `CREATE_DTIME`, `MODIFY_DTIME`) VALUES
	(1, 'api-int-test', '1.0.0', '10.10.2.102:8090', 'API 통합 테스트', '2020-10-14 13:14:02', '2020-10-14 13:14:02'),
	(2, 'ㄹㅇㄴㅁ', 'ㄹㅇㄴㅁ', 'ㄹㅇㄴㅁ', 'ㄹㅇㄴㅁ', '2020-10-14 14:00:25', '2020-10-14 14:00:25'),
	(3, 'ㄹㅇㄴㅁ', 'ㄹㅇㄴㅁ', 'ㄹㅇㄴㅁ', 'ㄹㅇㄴㅁ', '2020-10-14 14:00:26', '2020-10-14 14:00:26');
/*!40000 ALTER TABLE `api` ENABLE KEYS */;

-- 테이블 TEROS_METADB.api_method 구조 내보내기
CREATE TABLE IF NOT EXISTS `api_method` (
  `API_METHOD_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'API_METHOD_ID',
  `METHOD_NAME` varchar(64) DEFAULT NULL COMMENT 'MEHTOD 명',
  `DESCRIPTION` text DEFAULT NULL COMMENT '설명',
  PRIMARY KEY (`API_METHOD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='API_METHOD';

-- 테이블 데이터 TEROS_METADB.api_method:~4 rows (대략적) 내보내기
/*!40000 ALTER TABLE `api_method` DISABLE KEYS */;
INSERT INTO `api_method` (`API_METHOD_ID`, `METHOD_NAME`, `DESCRIPTION`) VALUES
	(1, 'GET', NULL),
	(2, 'POST', NULL),
	(3, 'PUT', NULL),
	(4, 'DELETE', NULL);
/*!40000 ALTER TABLE `api_method` ENABLE KEYS */;

-- 테이블 TEROS_METADB.api_path 구조 내보내기
CREATE TABLE IF NOT EXISTS `api_path` (
  `API_PATH_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'API_경로_ID',
  `API_ID` bigint(20) DEFAULT NULL COMMENT 'API_ID',
  `API_METHOD_ID` bigint(20) DEFAULT NULL COMMENT 'API_METHOD_ID',
  `SOURCE_URI` varchar(2048) DEFAULT NULL COMMENT 'SOURCE URI',
  `TARGET_URI` varchar(2048) DEFAULT NULL COMMENT 'TARGET URI',
  `DESCRIPTION` text DEFAULT NULL COMMENT 'API_PATH_설명',
  `CREATE_DTIME` datetime DEFAULT NULL COMMENT '생성시각',
  `MODIFY_DTIME` datetime DEFAULT NULL COMMENT '수정시각',
  PRIMARY KEY (`API_PATH_ID`),
  KEY `FK_API_TO_API_PATH` (`API_ID`),
  KEY `FK_API_METHOD_TO_API_PATH` (`API_METHOD_ID`),
  CONSTRAINT `FK_API_METHOD_TO_API_PATH` FOREIGN KEY (`API_METHOD_ID`) REFERENCES `api_method` (`API_METHOD_ID`),
  CONSTRAINT `FK_API_TO_API_PATH` FOREIGN KEY (`API_ID`) REFERENCES `api` (`API_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='API_경로';

-- 테이블 데이터 TEROS_METADB.api_path:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `api_path` DISABLE KEYS */;
INSERT INTO `api_path` (`API_PATH_ID`, `API_ID`, `API_METHOD_ID`, `SOURCE_URI`, `TARGET_URI`, `DESCRIPTION`, `CREATE_DTIME`, `MODIFY_DTIME`) VALUES
	(2, 1, 1, '/source', '/target', 'API 경로 테스트', '2020-10-14 13:15:52', '2020-10-14 13:15:52');
/*!40000 ALTER TABLE `api_path` ENABLE KEYS */;

-- 테이블 TEROS_METADB.catalog 구조 내보내기
CREATE TABLE IF NOT EXISTS `catalog` (
  `CATALOG_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '카탈로그_ID',
  `CATALOG_NAME` varchar(64) DEFAULT NULL COMMENT '카탈로그명',
  `DESCRIPTION` text DEFAULT NULL COMMENT '카탈로그_설명',
  `CREATE_DTIME` datetime DEFAULT NULL COMMENT '생성시각',
  `MODIFY_DTIME` datetime DEFAULT NULL COMMENT '수정시각',
  PRIMARY KEY (`CATALOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='카탈로그';

-- 테이블 데이터 TEROS_METADB.catalog:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `catalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `catalog` ENABLE KEYS */;

-- 테이블 TEROS_METADB.plan 구조 내보내기
CREATE TABLE IF NOT EXISTS `plan` (
  `PLAN_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '계획_ID',
  `PLAN_NAME` varchar(64) DEFAULT NULL COMMENT '계획명',
  `DESCRIPTION` text DEFAULT NULL COMMENT '계획_설명',
  `PRODUCT_ID` bigint(20) DEFAULT NULL COMMENT '제품_ID',
  `CREATE_DTIME` datetime DEFAULT NULL COMMENT '생성시각',
  `MODIFY_DTIME` datetime DEFAULT NULL COMMENT '수정시각',
  PRIMARY KEY (`PLAN_ID`),
  KEY `FK_PRODUCT_TO_PLAN` (`PRODUCT_ID`),
  CONSTRAINT `FK_PRODUCT_TO_PLAN` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='계획';

-- 테이블 데이터 TEROS_METADB.plan:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `plan` ENABLE KEYS */;

-- 테이블 TEROS_METADB.plan_api_map 구조 내보내기
CREATE TABLE IF NOT EXISTS `plan_api_map` (
  `PLAN_ID` bigint(20) DEFAULT NULL COMMENT '계획_ID',
  `API_ID` bigint(20) DEFAULT NULL COMMENT 'API_ID',
  KEY `FK_PLAN_TO_PLAN_API_MAP` (`PLAN_ID`),
  KEY `FK_API_TO_PLAN_API_MAP` (`API_ID`),
  CONSTRAINT `FK_API_TO_PLAN_API_MAP` FOREIGN KEY (`API_ID`) REFERENCES `api` (`API_ID`),
  CONSTRAINT `FK_PLAN_TO_PLAN_API_MAP` FOREIGN KEY (`PLAN_ID`) REFERENCES `plan` (`PLAN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='계획_API_MAP';

-- 테이블 데이터 TEROS_METADB.plan_api_map:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `plan_api_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `plan_api_map` ENABLE KEYS */;

-- 테이블 TEROS_METADB.product 구조 내보내기
CREATE TABLE IF NOT EXISTS `product` (
  `PRODUCT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '제품_ID',
  `PRODUCT_NAME` varchar(64) DEFAULT NULL COMMENT '제품명',
  `DESCRIPTION` text DEFAULT NULL COMMENT '제품_설명',
  `CATALOG_ID` bigint(20) DEFAULT NULL COMMENT '카탈로그_ID',
  `CREATE_DTIME` datetime DEFAULT NULL COMMENT '생성시각',
  `MODIFY_DTIME` datetime DEFAULT NULL COMMENT '수정시각',
  PRIMARY KEY (`PRODUCT_ID`),
  KEY `FK_CATALOG_TO_PRODUCT` (`CATALOG_ID`),
  CONSTRAINT `FK_CATALOG_TO_PRODUCT` FOREIGN KEY (`CATALOG_ID`) REFERENCES `catalog` (`CATALOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='제품';

-- 테이블 데이터 TEROS_METADB.product:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
