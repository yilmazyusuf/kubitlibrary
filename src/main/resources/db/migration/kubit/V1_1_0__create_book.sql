CREATE TABLE IF NOT EXISTS `books` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(100),
    `media` varchar(150),
    `description` text
)