INSERT INTO genre (name)
VALUES ('Action'),
       ('Drama'),
       ('Comedy'),
       ('Fantasy'),
       ('Mystery'),
       ('Sci-Fi'),
       ('Animation'),
       ('Thriller');

INSERT INTO movie (name, genre_id, year, director, actor, description, poster_img_url, created_time, updated_time)
SELECT 'Interstellar',
       genre.id,
       2014,
       'Christopher Nolan',
       'Matthew McConaughey, Anne Hathaway, Jessica Chastain',
       'In Earth''s future, a global crop blight and second Dust Bowl are slowly rendering the planet uninhabitable. Professor Brand (Michael Caine), a brilliant NASA physicist, is working on plans to save mankind by transporting Earth''s population to a new home via a wormhole. But first, Brand must send former NASA pilot Cooper (Matthew McConaughey) and a team of researchers through the wormhole and across the galaxy to find out which of three planets could be mankind''s new home.',
       'https://cdn.shopify.com/s/files/1/0057/3728/3618/products/interstellar3_480x.progressive.jpg?v=1585846947',
       '2022-09-24 12:09:20 +00:00',
       '2022-09-24 12:09:20 +00:00'
FROM genre
WHERE genre.name = 'Sci-Fi';

INSERT INTO movie (name, genre_id, year, director, actor, description, poster_img_url, created_time, updated_time)
SELECT 'The Shawshank Redemption',
       genre.id,
       1994,
       'Frank Darabont',
       'Tim Robbins, Morgan Freeman, Bob Gunton',
       'Andy Dufresne (Tim Robbins) is sentenced to two consecutive life terms in prison for the murders of his wife and her lover and is sentenced to a tough prison. However, only Andy knows he didn''t commit the crimes. While there, he forms a friendship with Red (Morgan Freeman), experiences brutality of prison life, adapts, helps the warden, etc., all in 19 years.',
       'https://cdn.shopify.com/s/files/1/0057/3728/3618/products/shawshank.128000_480x.progressive.jpg?v=1590097750',
       '2022-09-24 13:45:05 +00:00',
       '2022-09-24 13:45:05 +00:00'
FROM genre
WHERE genre.name = 'Drama';

INSERT INTO movie (name, genre_id, year, director, actor, description, poster_img_url, created_time, updated_time)
SELECT 'WALL·E',
       genre.id,
       2008,
       'Andrew Stanton',
       'Ben Burtt (voice), Elissa Knight (voice), Jeff Garlin (voice)',
       'WALL-E, short for Waste Allocation Load Lifter Earth-class, is the last robot left on Earth. He spends his days tidying up the planet, one piece of garbage at a time. But during 700 years, WALL-E has developed a personality, and he''s more than a little lonely. Then he spots EVE (Elissa Knight), a sleek and shapely probe sent back to Earth on a scanning mission. Smitten WALL-E embarks on his greatest adventure yet when he follows EVE across the galaxy.',
       'https://cdn.shopify.com/s/files/1/0057/3728/3618/products/3ce3fe68028e5909a68f9ad5c069ca72_480x.progressive.jpg?v=1573652340',
       '2022-09-24 13:45:05 +00:00',
       '2022-09-24 13:45:05 +00:00'
FROM genre
WHERE genre.name = 'Animation';

INSERT INTO movie (name, genre_id, year, director, actor, description, poster_img_url, created_time, updated_time)
SELECT 'Fall',
       genre.id,
       2022,
       'Scott Mann',
       'Grace Caroline Currey, Virginia Gardner, Mason Gooding',
       'For best friends Becky (Grace Caroline Currey) and Hunter (Virginia Gardner), life is all about conquering fears and pushing limits. But after they climb 2,000 feet to the top of a remote, abandoned radio tower, they find themselves stranded with no way down. Now Becky and Hunter''s expert climbing skills will be put to the ultimate test as they desperately fight to survive the elements, a lack of supplies, and vertigo-inducing heights in this adrenaline-fueled thriller co-starring Jeffery Dean Morgan.',
       'https://cdn.shopify.com/s/files/1/0057/3728/3618/products/fall_lp0sphrl_480x.progressive.jpg?v=1662663929',
       '2022-09-24 13:45:05 +00:00',
       '2022-09-24 13:45:05 +00:00'
FROM genre
WHERE genre.name = 'Thriller';

INSERT INTO role (role_type)
VALUES ('admin'),
       ('general');

INSERT INTO "user" (role_id, username, first_name, last_name, password, email, profile_img_url, created_time,
                    updated_time)
SELECT role.id,
       'fingerbomb',
       'David',
       'John',
       'fingerbomb123',
       'fingerbomb@gmail.com',
       'https://t3.ftcdn.net/jpg/03/91/19/22/360_F_391192211_2w5pQpFV1aozYQhcIw3FqA35vuTxJKrB.jpg',
       '2022-09-25 00:24:20 +00:00',
       '2022-09-25 00:24:20 +00:00'
FROM role
WHERE role.role_type = 'admin';

INSERT INTO "user" (role_id, username, first_name, last_name, password, email, created_time, updated_time)
SELECT role.id,
       'moviewadmin',
       'Admin',
       'Moview',
       'admin123456',
       'moviewadmin@gmail.com',
       '2022-09-25 00:24:20 +00:00',
       '2022-09-25 00:24:20 +00:00'
FROM role
WHERE role.role_type = 'admin';

INSERT INTO "user" (role_id, username, first_name, last_name, password, email, profile_img_url, created_time,
                    updated_time)
SELECT role.id,
       'rosemaryisle',
       'Kim',
       'Sally',
       'rosemaryisle123',
       'rosemaryisle@gmail.com',
       'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxqMcwpt4bGb4Zd486baWHsccUtOhr6tfraw&usqp=CAU',
       '2022-09-25 09:59:20 +00:00',
       '2022-09-25 09:59:20 +00:00'
FROM role
WHERE role.role_type = 'general';

INSERT INTO "user" (role_id, username, first_name, last_name, password, email, created_time, updated_time)
SELECT role.id,
       'moviewuser',
       'User',
       'Moview',
       'user123456',
       'moviewuser@gmail.com',
       '2022-09-25 00:24:20 +00:00',
       '2022-09-25 00:24:20 +00:00'
FROM role
WHERE role.role_type = 'general';