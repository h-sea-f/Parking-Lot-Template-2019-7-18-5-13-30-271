CREATE TABLE `order`(
`id` INT AUTO_INCREMENT primary key,
`create_time` BIGINT NOT NULL ,
`finish_time` BIGINT  ,
`car_number` VARCHAR(255) NOT NULL,
`state` INT NOT NULL,
`name` VARCHAR(255) NOT NULL
)