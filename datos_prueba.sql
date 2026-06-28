-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: 4bits
-- ------------------------------------------------------
-- Server version	8.0.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'mina clavero',1),(2,'rafaela',2),(3,'La Plata',3),(4,'Capital Federal',3),(5,'Parque Leloir',3),(6,'Indio Cua',3);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `historial_estado_contrato`
--

LOCK TABLES `historial_estado_contrato` WRITE;
/*!40000 ALTER TABLE `historial_estado_contrato` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial_estado_contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `historial_estado_factura`
--

LOCK TABLES `historial_estado_factura` WRITE;
/*!40000 ALTER TABLE `historial_estado_factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial_estado_factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `historial_estado_incidente`
--

LOCK TABLES `historial_estado_incidente` WRITE;
/*!40000 ALTER TABLE `historial_estado_incidente` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial_estado_incidente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `historial_estado_propiedad`
--

LOCK TABLES `historial_estado_propiedad` WRITE;
/*!40000 ALTER TABLE `historial_estado_propiedad` DISABLE KEYS */;
INSERT INTO `historial_estado_propiedad` VALUES (1,'ALQUILADA','2026-06-28 00:44:13.861224',2),(2,'DISPONIBLE','2026-06-28 00:45:15.950904',3),(3,'ALQUILADA','2026-06-28 00:46:32.545183',4);
/*!40000 ALTER TABLE `historial_estado_propiedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `historial_estado_publicacion`
--

LOCK TABLES `historial_estado_publicacion` WRITE;
/*!40000 ALTER TABLE `historial_estado_publicacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial_estado_publicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `incidente`
--

LOCK TABLES `incidente` WRITE;
/*!40000 ALTER TABLE `incidente` DISABLE KEYS */;
/*!40000 ALTER TABLE `incidente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (2,'Adorni','20666666','Asamblea 1466','madorni@ladron.com','Manuel','011575557',6),(3,'Solari','2966547','Echandias 223','indio@redondos.com','Carlos','0115555551',5),(4,'Bueno','25444666','sarandi 1879','potro@cuarteto.com','Rodrigo','0115448669',1);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `propiedad`
--

LOCK TABLES `propiedad` WRITE;
/*!40000 ALTER TABLE `propiedad` DISABLE KEYS */;
INSERT INTO `propiedad` VALUES (2,20,'flipper','pileta con cascada','Av. San Martín 1234','ALQUILADA',500,'CASA',6,2),(3,3,'cochera','Muy luminoso','Olavarria 444','DISPONIBLE',90,'DEPARTAMENTO',1,4),(4,5,'quincho con parrilla','100 mts de parque','Laprida 52','ALQUILADA',200,'CASA',5,3);
/*!40000 ALTER TABLE `propiedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` VALUES (3,'Buenos Aires'),(1,'Cordoba'),(2,'Santa Fe');
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `publicacion`
--

LOCK TABLES `publicacion` WRITE;
/*!40000 ALTER TABLE `publicacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `publicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `visita`
--

LOCK TABLES `visita` WRITE;
/*!40000 ALTER TABLE `visita` DISABLE KEYS */;
/*!40000 ALTER TABLE `visita` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-27 21:51:40
