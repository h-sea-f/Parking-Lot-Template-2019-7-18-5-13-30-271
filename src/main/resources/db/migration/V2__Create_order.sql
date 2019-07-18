CREATE TABLE `order`(
`id` INT primary key AUTO_INCREMENT,
`create_time` BIGINT NOT NULL ,
`finish_time` BIGINT  ,
`car_number` VARCHAR(255) NOT NULL,
`state` INT NOT NULL,
`name` VARCHAR(255) NOT NULL
)