-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 12, 2020 at 09:53 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ncms`
--
CREATE DATABASE `ncms` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ncms`;

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE IF NOT EXISTS `doctor` (
  `id` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `hospital_id` varchar(100) DEFAULT NULL,
  `is_director` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hospital_id` (`hospital_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE IF NOT EXISTS `hospital` (
  `id` varchar(50) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `district` varchar(45) DEFAULT NULL,
  `location_x` int(11) DEFAULT NULL,
  `location_y` int(11) DEFAULT NULL,
  `build_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hospital`
--

INSERT INTO `hospital` (`id`, `name`, `district`, `location_x`, `location_y`, `build_date`) VALUES
('0399f41d-2a90-4186-96f9-3b8d1c73103d', 'test4', 'test4', 125, 325, '2020-09-12'),
('2d8f4a73-496a-4665-9b3c-f46180c3bcd1', 'test443', 'test443', 125, 325, '2020-09-12'),
('2fe5eb0e-8878-423b-bf85-24b2b591d33a', 'test', 'test', 125, 325, '2020-09-12'),
('3e053ba9-1dd3-425c-99ce-becff9f32339', 'test4433', 'test4433', 125, 325, '2020-09-12'),
('5b176dc7-4b5f-4991-9564-f8371dca8702', 'General Hospital, Kalutara', 'Kalutara', 300, 200, '2020-08-31'),
('6feab14a-cacd-44d0-9f02-65baac65b2ba', 'colombo', 'colombo', 335, 545, '2020-09-13'),
('812ab6e2-c2a8-4f1e-a42e-b3f87c558b01', 'test3', 'test3', 125, 325, '2020-09-12'),
('9626adc9-cf4e-4200-b2a6-38c030ad8cc4', 'test2', 'test2', 125, 325, '2020-09-12'),
('a90ecb21-cf03-4f34-be2a-d8243df5fed3', 'test2', 'test2', 125, 325, '2020-09-12'),
('a9ea7dcd-1d26-4ac6-a2af-600de5ff7345', 'test44', 'test44', 125, 325, '2020-09-12'),
('b14248f0-4b0a-428f-b7d5-7150eedb5fbc', 'test44', 'test44', 125, 325, '2020-09-12'),
('cf7c333c-8ded-4033-90cd-9606a0869921', 'test4', 'test4', 125, 325, '2020-09-12'),
('d48a8c18-573d-412f-b190-cc5a96b296c4', 'test', 'test', 125, 325, '2020-09-12'),
('d4b0289a-8b29-4e26-aa83-98f526a752bb', 'general hospital, kandy', 'kandy', 300, 500, '2020-08-31'),
('d59a05a0-f9bd-4f8f-bf48-4c4cd43b606c', 'test4', 'test4', 125, 325, '2020-09-12'),
('f5831261-8ce8-4733-9eba-f5686eb7fee1', 'galle', 'galle', 135, 245, '2020-09-13');

-- --------------------------------------------------------

--
-- Table structure for table `hospital_bed`
--

CREATE TABLE IF NOT EXISTS `hospital_bed` (
  `id` int(11) NOT NULL DEFAULT '0',
  `hospital_id` varchar(50) NOT NULL,
  `patient_id` varchar(50) DEFAULT NULL,
  KEY `hospital_id` (`hospital_id`),
  KEY `patient_id` (`patient_id`),
  KEY `id` (`id`,`hospital_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hospital_bed`
--

INSERT INTO `hospital_bed` (`id`, `hospital_id`, `patient_id`) VALUES
(0, '2d8f4a73-496a-4665-9b3c-f46180c3bcd1', NULL),
(1, '3e053ba9-1dd3-425c-99ce-becff9f32339', NULL),
(2, '3e053ba9-1dd3-425c-99ce-becff9f32339', NULL),
(3, '3e053ba9-1dd3-425c-99ce-becff9f32339', NULL),
(4, '3e053ba9-1dd3-425c-99ce-becff9f32339', NULL),
(5, '3e053ba9-1dd3-425c-99ce-becff9f32339', NULL),
(6, '3e053ba9-1dd3-425c-99ce-becff9f32339', NULL),
(7, '3e053ba9-1dd3-425c-99ce-becff9f32339', NULL),
(8, '3e053ba9-1dd3-425c-99ce-becff9f32339', NULL),
(9, '3e053ba9-1dd3-425c-99ce-becff9f32339', NULL),
(10, '3e053ba9-1dd3-425c-99ce-becff9f32339', NULL),
(1, 'f5831261-8ce8-4733-9eba-f5686eb7fee1', NULL),
(2, 'f5831261-8ce8-4733-9eba-f5686eb7fee1', NULL),
(3, 'f5831261-8ce8-4733-9eba-f5686eb7fee1', NULL),
(4, 'f5831261-8ce8-4733-9eba-f5686eb7fee1', NULL),
(5, 'f5831261-8ce8-4733-9eba-f5686eb7fee1', NULL),
(6, 'f5831261-8ce8-4733-9eba-f5686eb7fee1', NULL),
(7, 'f5831261-8ce8-4733-9eba-f5686eb7fee1', NULL),
(8, 'f5831261-8ce8-4733-9eba-f5686eb7fee1', NULL),
(9, 'f5831261-8ce8-4733-9eba-f5686eb7fee1', NULL),
(10, 'f5831261-8ce8-4733-9eba-f5686eb7fee1', NULL),
(1, '6feab14a-cacd-44d0-9f02-65baac65b2ba', NULL),
(2, '6feab14a-cacd-44d0-9f02-65baac65b2ba', NULL),
(3, '6feab14a-cacd-44d0-9f02-65baac65b2ba', NULL),
(4, '6feab14a-cacd-44d0-9f02-65baac65b2ba', NULL),
(5, '6feab14a-cacd-44d0-9f02-65baac65b2ba', NULL),
(6, '6feab14a-cacd-44d0-9f02-65baac65b2ba', NULL),
(7, '6feab14a-cacd-44d0-9f02-65baac65b2ba', NULL),
(8, '6feab14a-cacd-44d0-9f02-65baac65b2ba', NULL),
(9, '6feab14a-cacd-44d0-9f02-65baac65b2ba', NULL),
(10, '6feab14a-cacd-44d0-9f02-65baac65b2ba', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE IF NOT EXISTS `patient` (
  `id` varchar(50) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `district` varchar(10) DEFAULT NULL,
  `location_x` int(11) DEFAULT NULL,
  `location_y` int(11) DEFAULT NULL,
  `severity_level` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `admit_date` date DEFAULT NULL,
  `admitted_by` varchar(45) DEFAULT NULL,
  `discharge_date` date DEFAULT NULL,
  `discharged_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `admitted_by` (`admitted_by`),
  KEY `discharged_by` (`discharged_by`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`id`, `first_name`, `last_name`, `district`, `location_x`, `location_y`, `severity_level`, `gender`, `contact`, `email`, `age`, `admit_date`, `admitted_by`, `discharge_date`, `discharged_by`) VALUES
('021accb8-f077-4221-9878-39c34a66e30e', 'aa', 'fffv', 'gdgdgdg', 150, 335, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL),
('143659d2-717a-4c95-8b5c-249f26c952ee', 'aa', 'fffv', 'gdgdgdg', 150, 335, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL),
('1ad3c730-5bb3-4daf-9f57-2c10d0f4cf71', 'aa', 'fffv', 'gdgdgdg', 150, 335, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL),
('4525eccb-b5e0-4195-9806-7c75df18fe85', 'aa', 'fffv', 'gdgdgdg', 150, 335, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL),
('53d356d3-48b2-4578-8c6a-fc45cdf02b72', 'aaavf', 'fffvf', 'gdgdg', 434343, 322332, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL),
('56858812-de34-47eb-a366-e2a3ed067e3b', 'aaavf', 'fffvf', 'gdgdg', 434343, 322332, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL),
('59cbbf05-85eb-49cd-a233-b84cf0fe813b', 'aaav', 'fffv', 'gdgdg', 434343, 322332, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL),
('5e93260d-d885-4ee9-9399-e8100cf2dd52', 'aaa', 'fff', 'gdgdg', 434343, 322332, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL),
('858c1bde-b057-4ee2-b8c5-122999bf5e62', 'aaavf', 'fffvf', 'gdgdg', 434343, 322332, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL),
('8d89b607-e161-48d2-b83d-00d591c9d530', 'aa', 'fffv', 'gdgdgdg', 150, 335, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL),
('b11bc982-6b1d-4c02-8574-b07ab7c563c0', 'aaavffg', 'fffvfgd', 'gdgdgdg', 125, 235, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL),
('b3ceb616-aeb1-4860-a3db-c86edd83a16b', 'aaav', 'fffv', 'gdgdg', 434343, 322332, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL),
('bc6629a3-3f2e-4baf-b396-378d748b3f5a', 'aaa', 'fff', 'gdgdg', 434343, 322332, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL),
('c253ac3a-1d02-4d91-bcd2-f57fce33ca1b', 'aa', 'fffv', 'gdgdgdg', 150, 335, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL),
('ccb80f24-9dc6-4e00-91c5-7b163f9c556a', 'aa', 'fffv', 'gdgdgdg', 150, 335, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL),
('d20476e8-9f22-4415-aa65-fd5571ee945c', 'aa', 'fffv', 'gdgdgdg', 150, 335, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL),
('e78ba985-8542-4bca-bdd9-a78f29621051', 'aa', 'fffv', 'gdgdgdg', 150, 335, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL),
('f9f20a0c-969c-4008-b1cf-c13c9018c881', 'aaav', 'fffv', 'gdgdg', 434343, 322332, NULL, 'male', '45454454', 'hasitha@gmail.com', 20, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `patient_queue`
--

CREATE TABLE IF NOT EXISTS `patient_queue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_id` (`patient_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `patient_queue`
--

INSERT INTO `patient_queue` (`id`, `patient_id`) VALUES
(2, '56858812-de34-47eb-a366-e2a3ed067e3b'),
(1, '858c1bde-b057-4ee2-b8c5-122999bf5e62');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `moh` tinyint(4) DEFAULT NULL,
  `hospital` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `name`, `moh`, `hospital`) VALUES
('abc', '123', 'hasitha', 0, 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `hospital_bed`
--
ALTER TABLE `hospital_bed`
  ADD CONSTRAINT `hospital_bed_ibfk_1` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`id`),
  ADD CONSTRAINT `hospital_bed_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`);

--
-- Constraints for table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `patient_ibfk_1` FOREIGN KEY (`admitted_by`) REFERENCES `doctor` (`id`),
  ADD CONSTRAINT `patient_ibfk_2` FOREIGN KEY (`discharged_by`) REFERENCES `doctor` (`id`);

--
-- Constraints for table `patient_queue`
--
ALTER TABLE `patient_queue`
  ADD CONSTRAINT `patient_queue_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
