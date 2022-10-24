CREATE TABLE "tag_connect_post"
(
    id           BIGSERIAL                  PRIMARY KEY,
    post_id      BIGINT                     NOT NULL REFERENCES "post" (id),
    tag_id       BIGINT                     NOT NULL REFERENCES "tag" (id),
    created_time TIMESTAMP WITH TIME ZONE   NOT NULL,
    updated_time TIMESTAMP WITH TIME ZONE   NOT NULL
);