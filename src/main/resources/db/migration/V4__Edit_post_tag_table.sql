ALTER TABLE post DROP tag_id;
ALTER TABLE post ADD title VARCHAR(200)  NOT NULL;
ALTER TABLE tag DROP tag_name;
ALTER TABLE tag ADD tag_name VARCHAR(30)  UNIQUE NOT NULL;
