CREATE TABLE "tag_connect_user"
(
    id           BIGSERIAL                  PRIMARY KEY,
    user_id      BIGINT                     NOT NULL REFERENCES "user" (id),
    tag_id       BIGINT                     NOT NULL REFERENCES "tag" (id),
    created_time TIMESTAMP WITH TIME ZONE   NOT NULL,
    updated_time TIMESTAMP WITH TIME ZONE   NOT NULL
);

INSERT INTO tag_connect_user(user_id, tag_id, created_time, updated_time)
VALUES(1, 1, '2022-10-24 21:19:25 +00:00','2022-10-24 21:19:25 +00:00');
INSERT INTO tag_connect_user(user_id, tag_id, created_time, updated_time)
VALUES(1, 2,  '2022-10-24 21:19:25 +00:00','2022-10-24 21:19:25 +00:00');
INSERT INTO tag_connect_user(user_id, tag_id, created_time, updated_time)
VALUES(1, 3,  '2022-10-24 21:19:25 +00:00','2022-10-24 21:19:25 +00:00');
INSERT INTO tag_connect_user(user_id, tag_id, created_time, updated_time)
VALUES(2, 1,  '2022-10-24 21:19:25 +00:00','2022-10-24 21:19:25 +00:00');
INSERT INTO tag_connect_user(user_id, tag_id, created_time, updated_time)
VALUES(2, 2,  '2022-10-24 21:19:25 +00:00','2022-10-24 21:19:25 +00:00');
INSERT INTO tag_connect_user(user_id, tag_id, created_time, updated_time)
VALUES(2, 3,  '2022-10-24 21:19:25 +00:00','2022-10-24 21:19:25 +00:00');

INSERT INTO tag_connect_post(post_id, tag_id, created_time, updated_time)
VALUES(2, 1,  '2022-10-24 21:19:25 +00:00','2022-10-24 21:19:25 +00:00');
INSERT INTO tag_connect_post(post_id, tag_id, created_time, updated_time)
VALUES(2, 2,  '2022-10-24 21:19:25 +00:00','2022-10-24 21:19:25 +00:00');
INSERT INTO tag_connect_post(post_id, tag_id, created_time, updated_time)
VALUES(2, 3,  '2022-10-24 21:19:25 +00:00','2022-10-24 21:19:25 +00:00');
INSERT INTO tag_connect_post(post_id, tag_id, created_time, updated_time)
VALUES(2, 4,  '2022-10-24 21:19:25 +00:00','2022-10-24 21:19:25 +00:00');
INSERT INTO tag_connect_post(post_id, tag_id, created_time, updated_time)
VALUES(2, 5,  '2022-10-24 21:19:25 +00:00','2022-10-24 21:19:25 +00:00');
INSERT INTO tag_connect_post(post_id, tag_id, created_time, updated_time)
VALUES(2, 6,  '2022-10-24 21:19:25 +00:00','2022-10-24 21:19:25 +00:00');
INSERT INTO tag_connect_post(post_id, tag_id, created_time, updated_time)
VALUES(1, 1,  '2022-10-24 21:19:25 +00:00','2022-10-24 21:19:25 +00:00');
INSERT INTO tag_connect_post(post_id, tag_id, created_time, updated_time)
VALUES(3, 1,  '2022-10-24 21:19:25 +00:00','2022-10-24 21:19:25 +00:00');
INSERT INTO tag_connect_post(post_id, tag_id, created_time, updated_time)
VALUES(4, 2,  '2022-10-24 21:19:25 +00:00','2022-10-24 21:19:25 +00:00');