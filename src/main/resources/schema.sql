CREATE TABLE IF NOT EXISTS `query` (
    `query_id` INT AUTO_INCREMENT PRIMARY KEY,
    `mentee_id` INT NOT NULL,
    `mentor_id` INT NOT NULL,
    `question` VARCHAR(100) NOT NULL,
    `answer` VARCHAR(100) NULL
);
