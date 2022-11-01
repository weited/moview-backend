CREATE TABLE "user_favorites_post"
(
    user_id BIGINT REFERENCES "user" (id),
    post_id BIGINT REFERENCES "post" (id),
    PRIMARY KEY (user_id, post_id)
);

CREATE TABLE "user_likes_post"
(
    user_id BIGINT REFERENCES "user" (id),
    post_id BIGINT REFERENCES "post" (id),
    PRIMARY KEY (user_id, post_id)
);

CREATE TABLE "post_tag"
(
    post_id BIGINT REFERENCES "post" (id),
    tag_id  BIGINT REFERENCES "tag" (id),
    PRIMARY KEY (post_id, tag_id)
);