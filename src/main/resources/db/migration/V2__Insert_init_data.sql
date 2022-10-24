INSERT INTO genre (name)
VALUES ('Action'),
       ('Drama'),
       ('Comedy'),
       ('Fantasy'),
       ('Mystery'),
       ('Sci-Fi'),
       ('Animation'),
       ('Thriller'),
       ('Crime'),
       ('Romance'),
       ('Horror');

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Interstellar',
       genre.id,
       '2014',
       '8.6',
       'Christopher Nolan',
       'Matthew McConaughey, Anne Hathaway, Jessica Chastain',
       'In Earth''s future, a global crop blight and second Dust Bowl are slowly rendering the planet uninhabitable. Professor Brand (Michael Caine), a brilliant NASA physicist, is working on plans to save mankind by transporting Earth''s population to a new home via a wormhole. But first, Brand must send former NASA pilot Cooper (Matthew McConaughey) and a team of researchers through the wormhole and across the galaxy to find out which of three planets could be mankind''s new home.',
       'https://cdn.shopify.com/s/files/1/0057/3728/3618/products/interstellar3_480x.progressive.jpg?v=1585846947',
       '2022-09-24 12:09:20 +00:00',
       '2022-09-24 12:09:20 +00:00'
FROM genre
WHERE genre.name = 'Sci-Fi';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'The Shawshank Redemption',
       genre.id,
       '1994',
       '9.3',
       'Frank Darabont',
       'Tim Robbins, Morgan Freeman, Bob Gunton',
       'Andy Dufresne (Tim Robbins) is sentenced to two consecutive life terms in prison for the murders of his wife and her lover and is sentenced to a tough prison. However, only Andy knows he didn''t commit the crimes. While there, he forms a friendship with Red (Morgan Freeman), experiences brutality of prison life, adapts, helps the warden, etc., all in 19 years.',
       'https://cdn.shopify.com/s/files/1/0057/3728/3618/products/shawshank.128000_480x.progressive.jpg?v=1590097750',
       '2022-09-24 13:45:05 +00:00',
       '2022-09-24 13:45:05 +00:00'
FROM genre
WHERE genre.name = 'Drama';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'WALL·E',
       genre.id,
       '2008',
       '8.4',
       'Andrew Stanton',
       'Ben Burtt (voice), Elissa Knight (voice), Jeff Garlin (voice)',
       'WALL-E, short for Waste Allocation Load Lifter Earth-class, is the last robot left on Earth. He spends his days tidying up the planet, one piece of garbage at a time. But during 700 years, WALL-E has developed a personality, and he''s more than a little lonely. Then he spots EVE (Elissa Knight), a sleek and shapely probe sent back to Earth on a scanning mission. Smitten WALL-E embarks on his greatest adventure yet when he follows EVE across the galaxy.',
       'https://cdn.shopify.com/s/files/1/0057/3728/3618/products/3ce3fe68028e5909a68f9ad5c069ca72_480x.progressive.jpg?v=1573652340',
       '2022-09-24 13:45:05 +00:00',
       '2022-09-24 13:45:05 +00:00'
FROM genre
WHERE genre.name = 'Animation';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Fall',
       genre.id,
       '2022',
       '6.4',
       'Scott Mann',
       'Grace Caroline Currey, Virginia Gardner, Mason Gooding',
       'For best friends Becky (Grace Caroline Currey) and Hunter (Virginia Gardner), life is all about conquering fears and pushing limits. But after they climb 2,000 feet to the top of a remote, abandoned radio tower, they find themselves stranded with no way down. Now Becky and Hunter''s expert climbing skills will be put to the ultimate test as they desperatingly fight to survive the elements, a lack of supplies, and vertigo-inducing heights in this adrenaline-fueled thriller co-starring Jeffery Dean Morgan.',
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
       'moviewadmin',
       'Admin',
       'Moview',
       'admin123456',
       'moviewadmin@gmail.com',
       '2022-09-25 00:24:20 +00:00',
       '2022-09-25 00:24:20 +00:00'
FROM role
WHERE role.role_type = 'admin';

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

-- movies update
INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'John Wick',
       genre.id,
       '2014',
       '7.4',
       'Chad Stahelski',
       'Keanu Reeves, Michael Nyqvist, Alfie Allen',
       'An ex-hit-man comes out of retirement to track down the gangsters that killed his dog and took his car.',
       'https://resizing.flixster.com/QGPwIXiwNuSqZX0Uuc88PXtEYfo=/206x305/v2/https://flxt.tmsimg.com/assets/p11016518_p_v8_as.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Action';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Mission: Impossible',
       genre.id,
       '1996',
       '7.1',
       'Brian De Palma',
       'Tom Cruise, Jon Voight, Emmanuelle Béart',
       'An American agent, under false suspicion of disloyalty, must discover and expose the real spy without the help of his organization.',
       'https://resizing.flixster.com/Rk7B2MLPK1tOlniRUmMfO5b9U-Y=/206x305/v2/https://flxt.tmsimg.com/assets/p18045_p_v8_az.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Action';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Wrath of Man',
       genre.id,
       '2021',
       '7.1',
       'Guy Ritchie',
       'Jason Statham, Holt McCallany, Jeffrey Donovan',
       'The plot follows H, a cold and mysterious character working at a cash truck company responsible for moving hundreds of millions of dollars around Los Angeles each week.',
       'https://resizing.flixster.com/2JenTBjfS0-lZyU78P5s4MllGOc=/206x305/v2/https://flxt.tmsimg.com/assets/p18774021_p_v7_am.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Action';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Extraction',
       genre.id,
       '2020',
       '6.7',
       'Sam Hargrave',
       'Chris Hemsworth, Rudhraksh Jaiswal, Randeep Hooda',
       'Tyler Rake, a fearless black market mercenary, embarks on the most deadly extraction of his career when he is enlisted to rescue the kidnapped son of an imprisoned international crime lord.',
       'https://resizing.flixster.com/tPA0WA5GoxdL5LFoaFCx8VhPZ20=/206x305/v2/https://flxt.tmsimg.com/assets/p18111715_p_v8_aa.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Action';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Mulan',
       genre.id,
       '2020',
       '5.7',
       'Niki Caro',
       'Yifei Liu, Donnie Yen, Tzi Ma',
       'A young Chinese maiden disguises herself as a male warrior in order to save her father.',
       'https://resizing.flixster.com/3Daao3cOXegGXtlAcehkxfU5_GY=/206x305/v2/https://flxt.tmsimg.com/assets/p17133396_p_v8_ai.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Action';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Nobody',
       genre.id,
       '2021',
       '7.4',
       'Ilya Naishuller',
       'Bob Odenkirk, Connie Nielsen, Robert Fitzgerald Diggs',
       'A docile family man slowly reveals his true character after his house gets burgled by two petty thieves, which, coincidentally, leads him into a bloody war with a Russian crime boss.',
       'https://resizing.flixster.com/_ACV2X6adM-EbB7118H2S3urTLg=/206x305/v2/https://flxt.tmsimg.com/assets/p17851008_p_v12_ah.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Action';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Shooter',
       genre.id,
       '2007',
       '7.1',
       'Antoine Fuqua',
       'Mark Wahlberg, Michael Peña, Danny Glover',
       'A marksman living in exile is coaxed back into action after hearing of a plot to kill the President. After being-double crossed for the attempt and on the run, he sets out for the real killer and the truth.',
       'https://resizing.flixster.com/3HEtta5GVrqcDKempgnC4A0RKUE=/206x305/v2/https://flxt.tmsimg.com/assets/p163566_p_v8_av.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Action';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Rumble in the Bronx',
       genre.id,
       '1995',
       '6.7',
       'Stanley Tong',
       'Jackie Chan, Anita Mui, Françoise Yip',
       'A young man visiting and helping his uncle in New York City finds himself forced to fight a street gang and the mob with his martial art skills.',
       'https://resizing.flixster.com/smXy82Epxczs8ytNdvrrvb0BAvg=/206x305/v2/https://flxt.tmsimg.com/NowShowing/86668/86668_aa.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Action';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Kiss of the Dragon',
       genre.id,
       '2001',
       '6.6',
       'Chris Nahon',
       'Jet Li, Bridget Fonda, Tchéky Karyo',
       'A betrayed intelligence officer enlists the aid of a prostitute to prove his innocence from a deadly conspiracy while returning a favor to her.',
       'https://resizing.flixster.com/JJL9JeeUisSUey0-C2mCIPZ6n0k=/206x305/v2/https://flxt.tmsimg.com/assets/p27982_p_v12_an.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Action';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'First Blood',
       genre.id,
       '1982',
       '7.7',
       'Ted Kotcheff',
       'Sylvester Stallone, Richard Crenna, Brian Dennehy',
       'A veteran Green Beret is forced by a cruel Sheriff and his deputies to flee into the mountains and wage an escalating one-man war against his pursuers.',
       'https://resizing.flixster.com/npqs6O9jGZuwllaZbeGRYHxlv_E=/206x305/v2/https://flxt.tmsimg.com/assets/p6343_p_v8_ar.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Action';

-- Drama--------------------------------------------------------------

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'The Bucket List',
       genre.id,
       '2007',
       '7.4',
       'Rob Reiner',
       'Jack Nicholson, Morgan Freeman, Sean Hayes',
       'Two terminally ill men escape from a cancer ward and head off on a road trip with a wish list of to-dos before they die.',
       'https://resizing.flixster.com/LcofFB9PEZNQknUSjRMBuKXqIr4=/206x305/v2/https://flxt.tmsimg.com/assets/p172507_p_v8_az.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Drama';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'The Pursuit of Happyness',
       genre.id,
       '2006',
       '8.0',
       'Gabriele Muccino',
       'Will Smith, Todd Black, Jason Blumenthal',
       'A struggling salesman takes custody of his son as he is poised to begin a life-changing professional career.',
       'https://resizing.flixster.com/oTy3aFhNBQmo1XeeXYMwMX8CcIA=/206x305/v2/https://flxt.tmsimg.com/assets/p162523_p_v8_ad.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Drama';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'The Imitation Game',
       genre.id,
       '2014',
       '8.0',
       'Morten Tyldum',
       'Benedict Cumberbatch, Keira Knightley, Matthew Goode',
       'During World War II, the English mathematical genius Alan Turing tries to crack the German Enigma code with help from fellow mathematicians while attempting to come to terms with his troubled private life.',
       'https://resizing.flixster.com/BkFrnkz1SCXdNNuaYHVaFkFv6IA=/206x305/v2/https://flxt.tmsimg.com/assets/p10771057_p_v12_au.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Drama';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Green Book',
       genre.id,
       '2018',
       '8.2',
       'Peter Farrelly',
       'Viggo Mortensen, Mahershala Ali, Linda Cardellini',
       'A working-class Italian-American bouncer becomes the driver for an African-American classical pianist on a tour of venues through the 1960s American South.',
       'https://resizing.flixster.com/40iBeECgEX_flncONtTFv-cWx5k=/206x305/v2/https://flxt.tmsimg.com/assets/p15674164_p_v12_am.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Drama';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'The Wolf of Wall Street',
       genre.id,
       '2013',
       '8.2',
       'Martin Scorsese',
       'Leonardo DiCaprio, Jonah Hill, Margot Robbie',
       'Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.',
       'https://resizing.flixster.com/5sDJkJ3tWO0tFl7mtqvfWGXzgtE=/206x305/v2/https://flxt.tmsimg.com/assets/p9991602_p_v12_aj.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Drama';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'The Godfather',
       genre.id,
       '1972',
       '9.2',
       'Francis Ford Coppola',
       'Marlon Brando, Al Pacino, James Caan',
       'The aging patriarch of an organized crime dynasty in postwar New York City transfers control of his clandestine empire to his reluctant youngest son.',
       'https://resizing.flixster.com/DuGwTf1oZLyO-gJBjQLwVDUAFFU=/206x305/v2/https://flxt.tmsimg.com/NowShowing/43177/43177_aa.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Drama';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Bohemian Rhapsody',
       genre.id,
       '2018',
       '7.9',
       'Bryan Singer',
       'Rami Malek, Lucy Boynton, Gwilym Lee',
       'The story of the legendary British rock band Queen and lead singer Freddie Mercury, leading up to their famous performance at Live Aid (1985).',
       'https://resizing.flixster.com/cQ7foOI5SN18GOmq-S-jdSixyuI=/206x305/v2/https://flxt.tmsimg.com/NowShowing/185586/185586_aa.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Drama';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Catch Me If You Can',
       genre.id,
       '2002',
       '8.1',
       'Steven Spielberg',
       'Leonardo DiCaprio, Tom Hanks, Christopher Walken',
       'Barely 21 yet, Frank is a skilled forger who has passed as a doctor, lawyer and pilot. FBI agent Carl becomes obsessed with tracking down the con man, who only revels in the pursuit.',
       'https://cdn.shopify.com/s/files/1/0057/3728/3618/products/9ee6589ab8f630a57bf015a38c060cbb_425dee06-9688-44f4-9a52-ca11cf1c195f_500x749.jpg?v=1573588605',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Drama';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'The Truman Show',
       genre.id,
       '1998',
       '8.2',
       'Peter Weir',
       'Jim Carrey, Laura Linney, Noah Emmerich',
       'An insurance salesman discovers his whole life is actually a reality TV show.',
       'https://resizing.flixster.com/OlyEIi7HH-hwUeKyaOuQNWGgwjw=/206x305/v2/https://flxt.tmsimg.com/assets/p20974_p_v8_aa.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Drama';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Forrest Gump',
       genre.id,
       '1994',
       '8.8',
       'Robert Zemeckis',
       'Tom Hanks, Robin Wright, Gary Sinise',
       'The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.',
       'https://resizing.flixster.com/9P3vaa2sAoH6_3EtUcAX0KIUf-w=/206x305/v2/https://flxt.tmsimg.com/assets/p15829_p_v8_as.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Drama';

-- Comedy--------------------------------------------------------------

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Kingsman: The Secret Service',
       genre.id,
       '2014',
       '7.7',
       'Matthew Vaughn',
       'Colin Firth, Samuel L. Jackson, Mark Strong',
       'A spy organisation recruits a promising street kid into training program of the agency, while a global threat emerges from a twisted tech genius.',
       'https://resizing.flixster.com/XE_60WHQKgtmLHTZEC3YChDbvgw=/206x305/v2/https://flxt.tmsimg.com/assets/p10672282_p_v8_ap.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Comedy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Home Alone',
       genre.id,
       '1990',
       '7.7',
       'Chris Columbus',
       'Macaulay Culkin, Joe Pesci, Daniel Stern',
       'An eight-year-old troublemaker must protect his house from a pair of burglars when he is accidentally left home alone by his family during Christmas vacation.',
       'https://resizing.flixster.com/q8w72w3qaS0K-RH7WF6cQsARNJ8=/206x305/v2/https://flxt.tmsimg.com/assets/p12872_p_v8_ba.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Comedy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Night at the Museum',
       genre.id,
       '2006',
       '6.4',
       'Shawn Levy',
       'Ben Stiller, Carla Gugino, Dick Van Dyke',
       'A newly recruited night security guard at the Museum of Natural History discovers that an ancient curse causes the animals and exhibits on display to come to life and wreak havoc.',
       'https://resizing.flixster.com/gc1KWpPvc2S2y0sZHYV57kVwDeg=/206x305/v2/https://flxt.tmsimg.com/assets/p162718_p_v8_ah.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Comedy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Johnny English',
       genre.id,
       '2003',
       '6.2',
       'Peter Howitt',
       'Rowan Atkinson, Natalie Imbruglia, Ben Miller',
       'The film tells the story of Johnny Ingrid, an overzealous but clumsy rookie intelligence officer who battles wits and courage with evil forces.',
       'https://resizing.flixster.com/_T1fp697hVuYm1BZ_3mL6-9J804=/206x305/v2/https://flxt.tmsimg.com/assets/p32279_p_v8_ac.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Comedy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Hitch',
       genre.id,
       '2005',
       '6.6',
       'Andy Tennant',
       'Will Smith, Eva Mendes, Kevin James',
       'A smooth-talking man falls for a hardened columnist while helping a shy accountant woo a beautiful heiress.',
       'https://resizing.flixster.com/DZze_Nf5o3p_3P6bCC2tI02tX2w=/206x305/v2/https://flxt.tmsimg.com/assets/p35562_p_v11_bc.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Comedy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Liar Liar',
       genre.id,
       '1997',
       '6.9',
       'Tom Shadyac',
       'Jim Carrey, Maura Tierney, Amanda Donohoe',
       'A pathological liar-lawyer finds his career turned upside down when he inexplicably cannot physically lie for 24 whole hours.',
       'https://resizing.flixster.com/ivp0SJxPkUBtzT9ZDWllXY934BA=/206x305/v2/https://flxt.tmsimg.com/assets/p19140_p_v8_ah.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Comedy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'The Gold Rush',
       genre.id,
       '1925',
       '8.2',
       'Charles Chaplin',
       'Charles Chaplin, Mack Swain, Tom Murray',
       'A prospector goes to the Klondike during the 1890s gold rush in hopes of making his fortune, and is smitten with a girl he sees in a dance hall.',
       'https://resizing.flixster.com/aLKPOCZQc86qOFsv_CN-QeSwh0k=/206x305/v2/https://flxt.tmsimg.com/assets/p341_p_v8_ab.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Comedy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Spy',
       genre.id,
       '2015',
       '7.0',
       'Paul Feig',
       'Jude Law, Raad Rawi, Melissa McCarthy',
       'A desk-bound CIA analyst volunteers to go undercover to infiltrating the world of a deadly arms dealer, and prevent diabolical global disaster.',
       'https://resizing.flixster.com/ThkoxQdZffRQ_cL1A0NvxttVY_0=/206x305/v2/https://flxt.tmsimg.com/assets/p11421676_p_v8_ab.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Comedy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Me, Myself & Irene',
       genre.id,
       '2000',
       '6.6',
       'Bobby Farrelly, Peter Farrelly',
       'Jim Carrey, Renée Zellweger, Anthony Anderson',
       'A nice-guy cop with Dissociative Identity Disorder must protect a woman on the run from a corrupt ex-boyfriend and his associates.',
       'https://resizing.flixster.com/REvn2PcApuuLFwmlv17X0o7bZn0=/206x305/v2/https://flxt.tmsimg.com/assets/p25564_p_v8_ad.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Comedy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Mr. & Mrs. Smith',
       genre.id,
       '2005',
       '6.5',
       'Robert Zemeckis',
       'Brad Pitt, Angelina Jolie, Adam Brody',
       'A bored married couple is surprised to learn that they are both assassins hired by competing agencies to kill each other.',
       'https://resizing.flixster.com/Z1jE6pLPf6w_Iws2uU-3digHb2A=/206x305/v2/https://flxt.tmsimg.com/assets/p35901_p_v8_an.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Comedy';

-- Fantasy--------------------------------------------------------------

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Doctor Strange',
       genre.id,
       '2016',
       '7.5',
       'Scott Derrickson',
       'Benedict Cumberbatch, Chiwetel Ejiofor, Rachel McAdams',
       'While on a journey of physical and spiritual healing, a brilliant neurosurgeon is drawn into the world of the mystic arts.',
       'https://cdn.shopify.com/s/files/1/0057/3728/3618/products/b3417f526a4b1b492c2c0c96e5e4c6c6_69fdf06c-4d45-45fc-b566-95e0a1b50124_500x749.jpg?v=1573653734',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Fantasy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Twilight',
       genre.id,
       '2008',
       '5.3',
       'Catherine Hardwicke',
       'Kristen Stewart, Robert Pattinson, Billy Burke',
       'When Bella Swan moves to a small town in the Pacific Northwest, she falls in love with Edward Cullen, a mysterious classmate who reveals himself to be a 108-year-old vampire.',
       'https://resizing.flixster.com/C1cU-cmYd1QbCZNLgSpEs93CdAk=/206x305/v2/https://flxt.tmsimg.com/NowShowing/69138/69138_aa.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Fantasy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Mortal Kombat',
       genre.id,
       '2021',
       '6.1',
       'Simon McQuoid',
       'Lewis Tan, Jessica McNamee, Josh Lawson',
       'MMA fighter Cole Young seeks out Earth greatest champions in order to stand against the enemies of Outworld in a high stakes battle for the universe.',
       'https://cdn.shopify.com/s/files/1/0057/3728/3618/products/mortal_kombat_ver4_480x.progressive.jpg?v=1619197295',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Fantasy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Life of Pi',
       genre.id,
       '2012',
       '7.9',
       'Ang Lee',
       'Suraj Sharma, Irrfan Khan, Adil Hussain',
       'A young man who survives a disaster at sea is hurtled into an epic journey of adventure and discovery. While cast away, he forms an unexpected connection with another survivor: a fearsome Bengal tiger.',
       'https://resizing.flixster.com/sykrqakE28lP5zYphifPjrFeBLw=/206x305/v2/https://flxt.tmsimg.com/assets/p9227710_p_v8_ac.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Fantasy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Piratings of the Caribbean: The Curse of the Black Pearl',
       genre.id,
       '2003',
       '8.1',
       'Gore Verbinski',
       'Johnny Depp, Geoffrey Rush, Orlando Bloom',
       'Blacksmith Will Turner teams up with eccentric pirating "Captain" Jack Sparrow to save his love, daughter of the governor, from former pirating allies, who are now undead.',
       'https://resizing.flixster.com/1nw9GbNdPavAIOjDP8T0oEdgGXU=/206x305/v2/https://flxt.tmsimg.com/assets/p32093_p_v8_aa.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Fantasy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Edward Scissorhands',
       genre.id,
       '1990',
       '7.9',
       'Tim Burton',
       'Johnny Depp, Winona Ryder, Dianne Wiest',
       'An artificial man, who was incompletely constructed and has scissors for hands, leads a solitary life. Then one day, a suburban lady meets him and introduces him to her world.',
       'https://resizing.flixster.com/tLFO05xiJ_5uW7BgpHL4EHJM_3c=/206x305/v2/https://flxt.tmsimg.com/assets/p12902_p_v8_ar.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Fantasy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'About Time',
       genre.id,
       '2013',
       '7.8',
       'Richard Curtis',
       'Domhnall Gleeson, Rachel McAdams, Bill Nighy',
       'At the age of 21, Tim discovers he can travel in time and change what happens and has happened in his own life. His decision to make his world a better place by getting a girlfriend turns out not to be as easy as you might think.',
       'https://resizing.flixster.com/0-iWXBhhRMpiJcKz2zHFl8walmk=/206x305/v2/https://flxt.tmsimg.com/assets/p9564054_p_v8_ak.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Fantasy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Aquaman',
       genre.id,
       '2018',
       '6.8',
       'James Wan',
       'Jason Momoa, Amber Heard, Willem Dafoe',
       'Arthur Curry, the human-born heir to the underwater kingdom of Atlantis, goes on a quest to prevent a war between the worlds of ocean and land.',
       'https://resizing.flixster.com/wh1IBKPpCLU7kcfockZgrNlM6Zk=/206x305/v2/https://flxt.tmsimg.com/NowShowing/169521/169521_ae.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Fantasy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Maleficent ',
       genre.id,
       '2014',
       '6.9',
       'Robert Stromberg',
       'Angelina Jolie, Elle Fanning, Sharlto Copley',
       'A vengeful fairy is driven to curse an infant princess, only to discover that the child may be the one person who can restore peace to their troubled land.',
       'https://resizing.flixster.com/3BRJl0T44vAYR4htn1jGOH-WY7Y=/206x305/v2/https://flxt.tmsimg.com/assets/p10086642_p_v8_af.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Fantasy';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Aladdin',
       genre.id,
       '2019',
       '6.9',
       'Guy Ritchie',
       'Will Smith, Mena Massoud, Naomi Scott',
       'A kind-hearted street urchin and a power-hungry Grand Vizier vie for a magic lamp that has the power to make their deepest wishes come true.',
       'https://resizing.flixster.com/rRbXVX9ecMWpCTcILF_woRWf_nc=/206x305/v2/https://flxt.tmsimg.com/assets/p14596224_p_v12_am.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Fantasy';

-- Mystery--------------------------------------------------------------

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Inception',
       genre.id,
       '2010',
       '8.8',
       'Christopher Nolan',
       'Leonardo DiCaprio, Joseph Gordon-Levitt, Elliot Page',
       'A thief who steals corporating secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.',
       'https://resizing.flixster.com/8X8J8sNXmCWDBaxo3vueONLRj00=/206x305/v2/https://flxt.tmsimg.com/assets/p7825626_p_v8_af.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Mystery';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'The Butterfly Effect',
       genre.id,
       '2004',
       '7.6',
       'Eric BressJ, Mackye Gruber',
       'Ashton Kutcher, Amy Smart, Melora Walters',
       'Evan Treborn suffers blackouts during significant events of his life. As he grows up, he finds a way to remember these lost memories and a supernatural way to alter his life by reading his journal.',
       'https://resizing.flixster.com/5JrWsTMGg23nSOILucW7bPEeXSQ=/206x305/v2/https://flxt.tmsimg.com/assets/p31722_p_v8_ab.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Mystery';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Se7en',
       genre.id,
       '1995',
       '8.6',
       'David Fincher',
       'Morgan Freeman, Brad Pitt, Kevin Spacey',
       'Two detectives, a rookie and a veteran, hunt a serial killer who uses the seven deadly sins as his motives.',
       'https://resizing.flixster.com/45blvnZjYobIB8zC7r5e2WEaTtI=/206x305/v2/https://flxt.tmsimg.com/assets/p17198_p_v12_an.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Mystery';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Now You See Me',
       genre.id,
       '2013',
       '7.2',
       'Louis Leterrier',
       'Jesse Eisenberg, Common, Mark Ruffalo',
       'An F.B.I. Agent and an Interpol Detective track a team of illusionists who pull off bank heists during their performances, and reward their audiences with the money.',
       'https://resizing.flixster.com/12CO5fl9-79PJeGhmsC9ULGiAmY=/206x305/v2/https://flxt.tmsimg.com/assets/p9418112_p_v8_am.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Mystery';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Saw',
       genre.id,
       '2003',
       '7.6',
       'James Wan',
       'Cary Elwes, Leigh Whannell, Danny Glover',
       'Two strangers awaken in a room with no recollection of how they got there, and soon discover they''re pawns in a deadly game perpetratingd by a notorious serial killer.',
       'https://resizing.flixster.com/BvN7zBIDzzPw41T6dm_cApbRGEE=/206x305/v2/https://flxt.tmsimg.com/assets/p34813_p_v8_aw.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Mystery';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Memento',
       genre.id,
       '2000',
       '8.4',
       'Christopher Nolan',
       'Guy Pearce, Carrie-Anne Moss, Joe Pantoliano',
       'A man with short-term memory loss attempts to track down his wife''s murderer.',
       'https://resizing.flixster.com/qjs39UDuFOkoxXL8nq8p6lKtsBU=/206x305/v2/https://flxt.tmsimg.com/assets/p28578_p_v8_ap.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Mystery';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Das Leben der Anderen',
       genre.id,
       '2006',
       '8.4',
       'Florian Henckel von Donnersmarck',
       'Ulrich Mühe, Martina Gedeck, Sebastian Koch',
       'In 1984 East Berlin, an agent of the secret police, conducting surveillance on a writer and his lover, finds himself becoming increasingly absorbed by their lives.',
       'https://resizing.flixster.com/QkYQiBp8M176FDcsXeNctTEhhTE=/206x305/v2/https://flxt.tmsimg.com/assets/p163183_p_v8_ah.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Mystery';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Murder on the Orient Express',
       genre.id,
       '2017',
       '6.5',
       'Kenneth Branagh',
       'Kenneth Branagh, Penélope Cruz, Willem Dafoe',
       'When a murder occurs on the train on which he''s travelling, celebratingd detective Hercule Poirot is recruited to solve the case.',
       'https://cdn.shopify.com/s/files/1/0057/3728/3618/products/49339ba854abebfeb4700b9ffbb759a5_2195350e-5e2c-47d3-a8e8-84c0a3db68b0_480x.progressive.jpg?v=1573618701',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Mystery';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Death on the Nile',
       genre.id,
       '1978',
       '7.2',
       'John Guillermin',
       'Peter Ustinov, Mia Farrow, Simon MacCorkindale',
       'As Hercule Poirot enjoys a luxurious cruise down the Nile, a newlywed heiress is found murdered on board. Can Poirot identify the killer before the ship reaches the end of its journey?',
       'https://resizing.flixster.com/_4qJNAPjeJgtWC3pCdoLIu0Sz9s=/206x305/v2/https://flxt.tmsimg.com/assets/p3256_p_v8_ai.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Mystery';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Sherlock Holmes',
       genre.id,
       '2009',
       '7.6',
       'Guy Ritchie',
       'Robert Downey Jr., Jude Law, Rachel McAdams',
       'Detective Sherlock Holmes and his stalwart partner Watson engage in a battle of wits and brawn with a nemesis whose plot is a threat to all of England.',
       'https://resizing.flixster.com/7ZkshXYtzu-v-jJqLI6lE0t6YC4=/206x305/v2/https://flxt.tmsimg.com/assets/p3547340_p_v8_af.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Mystery';

-- Sci-Fi--------------------------------------------------------------

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'District 9',
       genre.id,
       '2009',
       '7.9',
       'Neill Blomkamp',
       'Sharlto Copley, David James, Jason Cope',
       'Violence ensues after an extratingrrestrial race forced to live in slum-like conditions on Earth finds a kindred spirit in a government agent exposed to their biotechnology.',
       'https://resizing.flixster.com/hARzywszK8m6o09VG41yW9ISStY=/206x305/v2/https://flxt.tmsimg.com/assets/p177953_p_v8_ae.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Sci-Fi';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Resident Evil',
       genre.id,
       '2002',
       '6.6',
       'Paul W.S. Anderson',
       'Milla Jovovich, Michelle Rodriguez, Ryan McCluskey',
       'A special military unit fights a powerful, out-of-control supercomputer and hundreds of scientists who have mutated into flesh-eating creatures after a laboratory accident.',
       'https://cdn.shopify.com/s/files/1/0057/3728/3618/products/234979442fa93251d17527fe4116427c_df3e7bb9-aab1-4eb7-b453-5233c6f8c095_480x.progressive.jpg?v=1573592827',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Sci-Fi';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT '2012',
       genre.id,
       '2009',
       '5.8',
       'Roland Emmerich',
       'John Cusack, Thandiwe Newton, Chiwetel Ejiofor',
       'A frustratingd writer struggles to keep his family alive when a series of global catastrophes threatens to annihilate mankind.',
       'https://resizing.flixster.com/p6R9NAHdVXF3o_4hUuuUhwUZoMU=/206x305/v2/https://flxt.tmsimg.com/assets/p193479_p_v8_aa.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Sci-Fi';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Lucy',
       genre.id,
       '2014',
       '6.4',
       'Luc Besson',
       'Scarlett Johansson, Morgan Freeman, Choi Min-sik',
       'A woman, accidentally caught in a dark deal, turns the tables on her captors and transforms into a merciless warrior evolved beyond human logic.',
       'https://resizing.flixster.com/jiWox2YIroK_lCdPLhCeJE9Fkrc=/206x305/v2/https://flxt.tmsimg.com/assets/p10479310_p_v8_an.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Sci-Fi';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Dune',
       genre.id,
       '2021',
       '8.0',
       'Denis Villeneuve',
       'Timothée Chalamet, Rebecca Ferguson, Zendaya',
       'A noble family becomes embroiled in a war for control over the galaxy''s most valuable asset while its heir becomes troubled by visions of a dark future.',
       'https://cdn.shopify.com/s/files/1/0057/3728/3618/products/dunenew_500x749.jpg?v=1646940429',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Sci-Fi';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'The Dark Knight Rises',
       genre.id,
       '2012',
       '8.4',
       'Christopher Nolan',
       'Christian Bale, Tom Hardy, Anne Hathaway',
       'Eight years after the Joker''s reign of anarchy, Batman, with the help of the enigmatic Selina Kyle, is forced from his exile to save Gotham City from the brutal guerrilla terrorist Bane.',
       'https://resizing.flixster.com/Ev6G8Z0H3SFepS-SDY0X-OsVpmQ=/206x305/v2/https://flxt.tmsimg.com/NowShowing/108806/108806_ac.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Sci-Fi';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'The Matrix',
       genre.id,
       '1999',
       '8.7',
       'Lana Wachowski, Lilly Wachowski',
       'Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss',
       'When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborating deception of an evil cyber-intelligence.',
       'https://resizing.flixster.com/q1aWnhA588SmGiAht_9L3KXFUMA=/206x305/v2/https://flxt.tmsimg.com/assets/p22804_p_v8_av.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Sci-Fi';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'The Avengers',
       genre.id,
       '2012',
       '8.0',
       'Joss Whedon',
       'Robert Downey Jr., Chris Evans, Scarlett Johansson',
       'Earth''s mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.',
       'https://resizing.flixster.com/4QmGJFR39jMm8uYSeMv4Aop8w6I=/206x305/v2/https://flxt.tmsimg.com/assets/p8815512_p_v8_ax.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Sci-Fi';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Iron Man',
       genre.id,
       '2008',
       '7.9',
       'Jon Favreau',
       'Robert Downey Jr., Gwyneth Paltrow, Terrence Howard',
       'After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.',
       'https://resizing.flixster.com/jTU4RAjnwcZAconup5QZkH2Emb8=/206x305/v2/https://flxt.tmsimg.com/assets/p170620_p_v8_az.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Sci-Fi';

-- Animation--------------------------------------------------------------

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Ice Age',
       genre.id,
       '2002',
       '7.5',
       'Chris Wedge, Carlos Saldanha(co-director)',
       'Denis Leary(voice), John Leguizamo(voice), Ray Romano(voice)',
       'The story revolves around sub-zero heroes: a woolly mammoth, a saber-toothed tiger, a sloth and a prehistoric combination of a squirrel and rat, known as Scrat.',
       'https://cdn.shopify.com/s/files/1/0057/3728/3618/products/45fb0d6c6beb5715f7b2328b66f8c4aa_f4dc0613-5738-477c-a433-c243c685b2fc_500x749.jpg?v=1573591296',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Animation';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Zootopia',
       genre.id,
       '2016',
       '8.0',
       'Byron Howard, Rich Moore, Jared Bush(co-director)',
       'Ginnifer Goodwin(voice), Jason Bateman(voice), Idris Elba(voice)',
       'In a city of anthropomorphic animals, a rookie bunny cop and a cynical con artist fox must work together to uncover a conspiracy.',
       'https://resizing.flixster.com/9VnR4p2oYzIgXn3Nx0YvesQfgjk=/206x305/v2/https://flxt.tmsimg.com/assets/p11993845_p_v8_am.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Animation';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Sen to Chihiro no kamikakushi',
       genre.id,
       '2001',
       '8.6',
       'Hayao Miyazaki',
       'Daveigh Chase(English version), Suzanne Pleshette(English version), Miyu Irino(voice)',
       'During her family''s move to the suburbs, a sullen 10-year-old girl wanders into a world ruled by gods, witches, and spirits, and where humans are changed into beasts.',
       'https://resizing.flixster.com/IIKXvP0JRYHDLTh_jD4wOm0ap2w=/206x305/v2/https://flxt.tmsimg.com/assets/p30673_p_v8_ag.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Animation';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Kimi no na wa.',
       genre.id,
       '2016',
       '8.4',
       'Makoto Shinkai',
       'Ryûnosuke Kamiki(voice), Mone Kamishiraishi(voice), Ryô Narita(voice)',
       'Two strangers find themselves linked in a bizarre way. When a connection forms, will distance be the only thing to keep them apart?',
       'https://resizing.flixster.com/b-XH1KvexB4fZC4W77m6T9NYZcU=/206x305/v2/https://flxt.tmsimg.com/assets/p13207488_p_v8_aa.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Animation';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'The Secert World Of Arrietty',
       genre.id,
       '2010',
       '7.6',
       'Hiromasa Yonebayashi',
       'Amy Poehler, Will Arnett, Mirai Shida(voice)',
       'The Clock family are four-inch-tall people who live anonymously in another family''s residence, borrowing simple items to make their home. Life changes for the Clocks when their teenage daughter, Arrietty, is discovered.',
       'https://resizing.flixster.com/YmPEWasDT2cOnQ_TaaHg4Xkv71U=/206x305/v2/https://flxt.tmsimg.com/NowShowing/109188/109188_aa.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Animation';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Frozen',
       genre.id,
       '2013',
       '7.4',
       'Chris Buck, Jennifer Lee',
       'Kristen Bell(voice), Idina Menzel(voice), Jonathan Groff(voice)',
       'When the newly crowned Queen Elsa accidentally uses her power to turn things into ice to curse her home in infinite winter, her sister Anna teams up with a mountain man, his playful reindeer, and a snowman to change the weather condition.',
       'https://resizing.flixster.com/UswpJWyntUYFMJIAhQsX3FgutMA=/206x305/v2/https://flxt.tmsimg.com/assets/p9991822_p_v8_ah.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Animation';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Monsters, Inc.',
       genre.id,
       '2001',
       '8.1',
       'Pete Docter, David Silverman(co-director), Lee Unkrich(co-director)',
       'Billy Crystal(voice), John Goodman(voice), Mary Gibbs(voice)',
       'In order to power the city, monsters have to scare children so that they scream. However, the children are toxic to the monsters, and after a child gets through, two monsters realize things may not be what they think.',
       'https://resizing.flixster.com/sEytFk1ipX1cbvb-fVGkwc3P0Pk=/206x305/v2/https://flxt.tmsimg.com/assets/p27462_p_v12_an.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Animation';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Kung Fu Panda',
       genre.id,
       '2008',
       '7.6',
       'Mark Osborne, John Stevenson',
       'Jack Black(voice), Ian McShane(voice), Angelina Jolie(voice)',
       'To everyone''s surprise, including his own, Po, an overweight, clumsy panda, is chosen as protector of the Valley of Peace. His suitability will soon be tested as the valley''s arch-enemy is on his way.',
       'https://resizing.flixster.com/SF5Yt4vJEUO_UeFUNvloEIGW64o=/206x305/v2/https://flxt.tmsimg.com/assets/p23193232_v_v8_aa.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Animation';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'The Lion King',
       genre.id,
       '2019',
       '6.8',
       'Jon Favreau',
       'Donald Glover(voice), Beyoncé(voice), Seth Rogen(voice)',
       'After the murder of his father, a young lion prince flees his kingdom only to learn the true meaning of responsibility and bravery.',
       'https://cdn.shopify.com/s/files/1/0057/3728/3618/products/a367af8b717f224288f8664c7cf100f3_97fe025c-7bb8-41e2-bc39-8387f905d075_500x749.jpg?v=1573572646',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Animation';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Toy Story',
       genre.id,
       '1995',
       '8.3',
       'John Lasseter',
       'Tom Hanks(voice), Tim Allen(voice), Don Rickles(voice)',
       'A cowboy doll is profoundly threatened and jealous when a new spaceman action figure supplants him as top toy in a boy''s bedroom.',
       'https://resizing.flixster.com/KgDQ9KRICCH_A5aHNER72PoRyBc=/206x305/v2/https://flxt.tmsimg.com/assets/p17420_p_v12_bc.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Animation';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Finding Nemo',
       genre.id,
       '2003',
       '8.2',
       'Andrew Stanton, Lee Unkrich(co-director)',
       'Albert Brooks(voice), Ellen DeGeneres(voice), Alexander Gould(voice)',
       'After his son is captured in the Great Barrier Reef and taken to Sydney, a timid clownfish sets out on a journey to bring him home.',
       'https://resizing.flixster.com/5TOxT-RfeF6bCjKWDB_xxlHeXWw=/206x305/v2/https://flxt.tmsimg.com/NowShowing/34125/34125_ac.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Animation';

-- Thriller--------------------------------------------------------------

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Triangle',
       genre.id,
       '2009',
       '6.9',
       'Christopher Smit',
       'Melissa George, Joshua McIvor, Jack Taylor',
       'Five friends set sail and their yacht is overturned by a strange and sudden storm. A mysterious ship arrives to rescue them, and what happens next cannot be explained.',
       'https://resizing.flixster.com/PfZJcqwJL5NolOoBeXW_Q8hQ5a4=/206x305/v2/https://flxt.tmsimg.com/assets/p7879524_p_v8_ab.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Thriller';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Orphan',
       genre.id,
       '2009',
       '7.0',
       'Jaume Collet-Serra',
       'Vera Farmiga, Peter Sarsgaard, Isabelle Fuhrman',
       'A husband and wife who recently lost their baby adopt a 9-year-old girl who is not nearly as innocent as she appears.',
       'https://resizing.flixster.com/9z7zrw4mJigVWdWRqRHvGOByj9U=/206x305/v2/https://flxt.tmsimg.com/assets/p193289_p_v8_aa.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Thriller';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'The Conjuring',
       genre.id,
       '2013',
       '7.5',
       'James Wan',
       'Patrick Wilson, Vera Farmiga, Ron Livingston',
       'Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by a dark presence in their farmhouse.',
       'https://resizing.flixster.com/g96ZK8bkJAkQIAdSJ5QKm6fIoNU=/206x305/v2/https://flxt.tmsimg.com/NowShowing/120409/120409_aa.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Thriller';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Final Destination',
       genre.id,
       '2000',
       '6.7',
       'James Wong',
       'Devon Sawa, Ali Larter, Kerr Smith',
       'Alex Browning is among a group of high school students readying themselves for a trip to Europe. When he suddenly has a premonition their airplane will crash, he screams to warn the others but instead he is thrown off of the plane along others, but the plane actually crashes after they get off. Weeks later one of the survivors mysteriously dies, and Alex realizes that things just got more complex.',
       'https://resizing.flixster.com/-hwbTApOUS9em2KlBOVSVK8T5U0=/206x305/v2/https://flxt.tmsimg.com/assets/p25022_p_v8_aa.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Thriller';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Escape Plan',
       genre.id,
       '2013',
       '6.7',
       'Mikael Håfström',
       'Sylvester Stallone, Arnold Schwarzenegger, Curtis James Jackson',
       'When a structural-security authority finds himself set up and incarceratingd in the world''s most secret and secure prison, he has to use his skills to escape with help from the inside.',
       'https://resizing.flixster.com/PPNwU-FmIyiDW2P4F7lrgW9QE44=/206x305/v2/https://flxt.tmsimg.com/assets/p9911264_p_v8_ab.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Thriller';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Skyscraper',
       genre.id,
       '2018',
       '5.8',
       'Rawson Marshall Thurber',
       'Dwayne Johnson, Neve Campbell, Chin Han',
       'A security expert must infiltrating a burning skyscraper, 225 stories above ground, when his family is trapped inside by criminals.',
       'https://cdn.shopify.com/s/files/1/0057/3728/3618/products/38b88202bea3288115a48edb5052a569_05c774c6-f2e1-47ca-ac08-ea5b8d2237ec_500x749.jpg?v=1573588851',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Thriller';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'The Mist',
       genre.id,
       '2007',
       '7.1',
       'Frank Darabont',
       'Thomas Jane, Marcia Gay Harden, Laurie Holden',
       'A freak storm unleashes a species of bloodthirsty creatures on a small town, where a small band of citizens hole up in a supermarket and fight for their lives.',
       'https://resizing.flixster.com/colYv4xiGH9yeOjmaI1o_nb_y4s=/206x305/v2/https://flxt.tmsimg.com/assets/p170178_p_v8_af.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Thriller';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'Hannibal',
       genre.id,
       '2001',
       '6.8',
       'Ridley Scott',
       'Anthony Hopkins, Julianne Moore, Gary Oldman',
       'Living in exile, Dr. Hannibal Lecter tries to reconnect with now disgraced F.B.I. Agent Clarice Starling, and finds himself a target for revenge from a powerful victim.',
       'https://resizing.flixster.com/v0qim_yLLTr1pc-AIvwlUiS_vlg=/206x305/v2/https://flxt.tmsimg.com/assets/p24118_p_v8_af.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Thriller';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'The Meg ',
       genre.id,
       '2018',
       '5.6',
       'Jon Turteltaub',
       'Jason Statham, Bingbing Li, Rainn Wilson',
       'A group of scientists exploring the Marianas Trench encounter the largest marine predator that has ever existed - the Megalodon.',
       'https://upload.wikimedia.org/wikipedia/zh/2/29/The_Meg_Poster.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Thriller';

INSERT INTO movie (name, genre_id, year, rating, director, actor, description, poster_img_url, created_time,
                   updated_time)
SELECT 'A Quiet Place',
       genre.id,
       '2018',
       '7.5',
       'John Krasinski',
       'Emily Blunt, John Krasinski, Millicent Simmonds',
       'In a post-apocalyptic world, a family is forced to live in silence while hiding from monsters with ultra-sensitive hearing.',
       'https://resizing.flixster.com/nRgpuCbBOmvyrCPmYI2ah6z_Jx4=/206x305/v2/https://flxt.tmsimg.com/assets/p14660087_p_v8_ad.jpg',
       '2022-10-16 22:05:05 +00:00',
       '2022-10-16 22:05:05 +00:00'
FROM genre
WHERE genre.name = 'Thriller';