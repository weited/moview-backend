UPDATE "user"
SET email    = 'admin@moview.com',
    password = '$2a$10$SgPTVWnAo9ja1ZTG5gq35O1j/PAoD2GNYw2XHb1j6PZ25.16AlZHi'
WHERE username = 'moviewadmin';

UPDATE "user"
SET email    = 'user@moview.com',
    password = '$2a$10$zBWPyo53m9VnM4/l18OlU.5D3bd0MvDS0NkJs.BBRxI2v.IAufjme'
WHERE username = 'moviewuser';

INSERT INTO "user_role" (user_id, role_id)
VALUES ((SELECT id FROM "user" WHERE username = 'moviewadmin'),
        (SELECT id FROM "role" WHERE role_type = 'ROLE_USER'));

INSERT INTO "user_role" (user_id, role_id)
VALUES ((SELECT id FROM "user" WHERE username = 'moviewadmin'),
        (SELECT id FROM "role" WHERE role_type = 'ROLE_ADMIN'));

INSERT INTO "user_role" (user_id, role_id)
VALUES ((SELECT id FROM "user" WHERE username = 'moviewuser'),
        (SELECT id FROM "role" WHERE role_type = 'ROLE_USER'));