USE test;

DROP TABLE IF EXISTS article;
CREATE TABLE article (
  id          INT(10) AUTO_INCREMENT,
  title       VARCHAR(100) NOT NULL,
  description VARCHAR(200),
  PRIMARY KEY (id)
);