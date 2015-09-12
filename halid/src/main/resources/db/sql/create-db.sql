CREATE TABLE sidebar (
  id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  path VARCHAR (256) NOT NULL,
  UNIQUE (path)
);

CREATE TABLE sidebar_nav_link (
  id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name VARCHAR (64),
  url VARCHAR (256),
  parent_id INT,
  sidebar_path VARCHAR (256) NOT NULL,
  FOREIGN KEY (parent_id) REFERENCES sidebar_nav_link(id),
  FOREIGN KEY (sidebar_path) REFERENCES sidebar(path)
);
