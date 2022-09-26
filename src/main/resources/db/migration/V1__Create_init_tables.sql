CREATE TABLE genre
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE movie
(
    id             BIGSERIAL PRIMARY KEY,
    name           VARCHAR(255)             NOT NULL,
    genre_id       INTEGER                  NOT NULL REFERENCES genre (id),
    year           INTEGER,
    director       VARCHAR(128),
    actor          VARCHAR(255),
    description    VARCHAR(1000),
    poster_img_url VARCHAR(255),
    created_time   TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_time   TIMESTAMP WITH TIME ZONE NOT NULL
);
