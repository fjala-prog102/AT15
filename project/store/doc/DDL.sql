CREATE TABLE `clients` (
  `client_id` LONG,
  `first_name` VARCHAR(100),
  `last_name` VARCHAR(100),
  `identification_number` VARCHAR(15),
  `address` VARCHAR(250),
  PRIMARY KEY (`client_id`)
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

CREATE TABLE `products_categories` (
  `product_id` LONG,
  `category_name` VARCHAR(150),
  FOREIGN KEY (`product_id`) REFERENCES `products`(`product_id`),
  FOREIGN KEY (`category_name`) REFERENCES `categories`(`name`)
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
