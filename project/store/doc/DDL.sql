CREATE TABLE `clients` (
  `identification_number` LONG,
  `first_name` VARCHAR(100),
  `last_name` VARCHAR(100),
  `address` VARCHAR(250),
  PRIMARY KEY (`identification_number`)
);

CREATE TABLE `brands` (
  `name` VARCHAR(150),
  `description` VARCHAR(300),
  `web_site` VARCHAR(200),
  PRIMARY KEY (`name`)
);

CREATE TABLE `products` (
  `product_id` LONG,
  `name` VARCHAR(150),
  `presentation` VARCHAR(100),
  `description` VARCHAR(300),
  `price` DECIMAL(9,2),
  `active` BOOLEAN,
  `brand_name` VARCHAR(150),
  PRIMARY KEY (`product_id`),
  FOREIGN KEY (`brand_name`) REFERENCES `brands`(`name`)
);

CREATE TABLE `categories` (
  `name` VARCHAR(150),
  `description` VARCHAR(300),
  PRIMARY KEY (`name`)
);

CREATE TABLE `discounts` (
  `discount_id` LONG,
  `percentage` NUMERIC(2,0),
  `start_date` DATE,
  `end_date` DATE,
  `description` VARCHAR(300),
  `category_name` VARCHAR(150),
  `brand_name` VARCHAR(150),
  `product_id` LONG,
  PRIMARY KEY (`discount_id`),
  FOREIGN KEY (`product_id`) REFERENCES `products`(`product_id`),
  FOREIGN KEY (`brand_name`) REFERENCES `brands`(`name`),
  FOREIGN KEY (`category_name`) REFERENCES `categories`(`name`)
);

CREATE TABLE `products_categories` (
  `product_id` LONG,
  `category_name` VARCHAR(150),
  FOREIGN KEY (`product_id`) REFERENCES `products`(`product_id`),
  FOREIGN KEY (`category_name`) REFERENCES `categories`(`name`)
);

CREATE TABLE `quotes` (
  `quote_id` LONG,
  `quote_date` DATE,
  `expiration_date` DATE,
  `client_address` VARCHAR(250),
  `description` VARCHAR(200),
  `total_cost` DECIMAL(11,2),
  `client_identification_number` LONG,
  PRIMARY KEY (`quote_id`),
  FOREIGN KEY (`client_identification_number`) REFERENCES `clients`(`identification_number`)
);

CREATE TABLE `quote_lines` (
  `quote_line_id` LONG,
  `quote_id` LONG,
  `product_id` LONG,
  `quantity` INTEGER,
  `subtotal_cost` DECIMAL(11,2),
  PRIMARY KEY (`quote_line_id`),
  FOREIGN KEY (`quote_id`) REFERENCES `quotes`(`quote_id`),
  FOREIGN KEY (`product_id`) REFERENCES `products`(`product_id`)
);
