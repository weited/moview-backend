CREATE TABLE "genre"
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE "movie"
(
    id             BIGSERIAL PRIMARY KEY,
    name           VARCHAR(255) UNIQUE      NOT NULL,
    genre_id       BIGINT                   NOT NULL REFERENCES "genre" (id),
    year           CHAR(4),
    rating         VARCHAR(3),
    director       VARCHAR(128),
    actor          VARCHAR(255),
    description    VARCHAR(1000),
    poster_img_url VARCHAR(255),
    created_time   TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_time   TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE "role"
(
    id        BIGSERIAL PRIMARY KEY,
    role_type VARCHAR(20) NOT NULL
);

CREATE TABLE "user"
(
    id              BIGSERIAL PRIMARY KEY,
    role_id         BIGINT                   NOT NULL REFERENCES "role" (id),
    username        VARCHAR(255) UNIQUE      NOT NULL,
    first_name      VARCHAR(128),
    last_name       VARCHAR(128),
    password        VARCHAR(64)              NOT NULL,
    email           VARCHAR(255) UNIQUE      NOT NULL,
    profile_img_url VARCHAR(255),
    created_time    TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_time    TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE "tag"
(
    id           BIGSERIAL PRIMARY KEY,
    tag_name     VARCHAR(255)             NOT NULL,
    created_time TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_time TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE "post"
(
    id           BIGSERIAL PRIMARY KEY,
    movie_id     BIGINT                   NOT NULL REFERENCES "movie" (id),
    author_id    BIGINT                   NOT NULL REFERENCES "user" (id),
    tag_id       BIGINT                   NOT NULL REFERENCES "tag" (id),
    contents     VARCHAR(2000)            NOT NULL,
    created_time TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_time TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE "comment"
(
    id           BIGSERIAL PRIMARY KEY,
    text         VARCHAR(800),
    parent_id    BIGINT,
    post_id      BIGINT REFERENCES "post" (id),
    user_id      BIGINT REFERENCES "user" (id),
    created_time TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_time TIMESTAMP WITH TIME ZONE NOT NULL
);