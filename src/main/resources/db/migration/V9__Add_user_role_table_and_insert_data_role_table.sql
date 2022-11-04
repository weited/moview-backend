CREATE TABLE "user_role"
(
    user_id BIGINT REFERENCES "user" (id),
    role_id BIGINT REFERENCES "role" (id),
    PRIMARY KEY (user_id, role_id)
);

DELETE
FROM "role"
WHERE role_type IN ('admin', 'general');

INSERT INTO "role" ("role_type")
VALUES ('ROLE_USER'),
       ('ROLE_MANAGER'),
       ('ROLE_ADMIN');