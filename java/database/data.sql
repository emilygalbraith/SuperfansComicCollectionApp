INSERT INTO publishers (publisher_name)
VALUES ('Marvel'), ('DC'), ('Image');

INSERT INTO series (series_name)
VALUES ('Empyre'), ('Spider-Man'), ('Marvel Knigths'), ('Storm'), ('Batman'), ('Wonder Woman'), ('Superman'), ('The Flash'), ('Justice League'), ('Spawn');

INSERT INTO comics (comic_name, author, image, release_date, publisher_id, series_id)
VALUES ('Empyre #1', 'Al Ewing', 'http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada/portrait_xlarge.jpg', '2020-07-15', (SELECT publisher_id FROM publishers WHERE publisher_name='Marvel'), (SELECT series_id FROM series WHERE series_name='Empyre')),
       ('Marvel Age Spider-Man #8', 'Todd Dezago', 'http://i.annihil.us/u/prod/marvel/i/mg/6/90/5a664c954a55b/portrait_xlarge.jpg', '2004-07-21', (SELECT publisher_id FROM publishers WHERE publisher_name='Marvel'), (SELECT series_id FROM series WHERE series_name='Spider-Man')),
       ('Official Handbook of the Marvel Universe', 'Eric J. Moreels, Barry Reese, Ronald Byrd, Jeff Christiansen', 'http://i.annihil.us/u/prod/marvel/i/mg/9/30/4bc64df4105b9/portrait_xlarge.jpg', '2004-12-31', (SELECT publisher_id FROM publishers WHERE publisher_name='Marvel'), (SELECT series_id FROM series WHERE series_name='Marvel Knigths')),
       ('Storm Vol 2 #1', 'Eric Jerome Dickey', 'http://i.annihil.us/u/prod/marvel/i/mg/c/80/4bc5fe7a308d7/portrait_xlarge.jpg', '2008-01-16', (SELECT publisher_id FROM publishers WHERE publisher_name='Marvel'), (SELECT series_id FROM series WHERE series_name='Storm')),
       ('Batman: Knightfall Vol. 1', 'Alan Grant, Chuck Dixon, Doug Moench, Jo Duffy', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWXiPXpET1LjUQcdI2eL9YSJZQy0BHg4UxpA&usqp=CAU', '2012-05-01', (SELECT publisher_id FROM publishers WHERE publisher_name='DC'), (SELECT series_id FROM series WHERE series_name='Batman')),
       ('Wonder Woman Vol. 5', 'Greg Rucka, Liam Sharp, Nicola Scott, James Robinson, Steve Orlando, G. Willow Wilson', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDPgzvwrIhUCOUwypmi_BX84djp8_ngPsGxQ&usqp=CAU', '2016-08-01', (SELECT publisher_id FROM publishers WHERE publisher_name='DC'), (SELECT series_id FROM series WHERE series_name='Wonder Woman')),
       ('Superman Vol. 5', 'Brian Michael Bendis, Ivan Reis', 'https://pbs.twimg.com/media/Dh2ihdcVQAAPmQl.jpg:large', '2018-09-01', (SELECT publisher_id FROM publishers WHERE publisher_name='DC'), (SELECT series_id FROM series WHERE series_name='Superman')),
       ('Flashpoint', 'Geoff Johns', 'https://upload.wikimedia.org/wikipedia/en/f/fa/Flashpoint_%28DC_Comics%29.png', '2011-08-01', (SELECT publisher_id FROM publishers WHERE publisher_name='DC'), (SELECT series_id FROM series WHERE series_name='The Flash')),
       ('Justice League Vol. 1: Origin', 'Geoff Johns', 'https://m.media-amazon.com/images/P/B008J2GFV4.01._SCLZZZZZZZ_SX500_.jpg', '2013-02-05', (SELECT publisher_id FROM publishers WHERE publisher_name='DC'), (SELECT series_id FROM series WHERE series_name='Justice League')),
       ('Spawn #1', 'Todd Mcfarlane', 'https://images-na.ssl-images-amazon.com/images/I/61XaC4WLwxL._SX326_BO1,204,203,200_.jpg', '1992-01-01', (SELECT publisher_id FROM publishers WHERE publisher_name='Image'), (SELECT series_id FROM series WHERE series_name='Spawn'));

INSERT INTO superheroes (superhero)
VALUES ('Spider-Man'), ('Storm'), ('Black Panther'), ('Human Torch'), ('The Thing'), ('Invisible Woman'), ('Mister Fantastic'), ('Iron Man'), ('Captain America'), ('Thor'), ('Captain Marvel'), ('Ghost Rider'), ('She-Hulk'), 
       ('Blade'), ('Luke Cage'), ('Cloak'), ('Daredevil'), ('District X'), ('Dr. Strange'), ('Nick Fury'), ('Iron Fist'), ('Madrox'), ('Man-Thing'), ('Marvel Knights'), ('Moon Knight'), ('Punisher'), ('Shang-Chi'), ('White Tiger'),
       ('Batman'), ('Robin'), ('Nightwing'), ('Azrael'), ('Wonder Woman'), ('Superman'), ('Flash'), ('Cyborg'), ('Booster Gold'), ('Aquaman'), ('Green Lantern'), ('Spawn');

INSERT INTO comic_superheroes (comic_id, superhero_id)
VALUES ((SELECT comic_id FROM comics WHERE comic_name='Empyre #1'), (SELECT superhero_id FROM superheroes WHERE superhero='Human Torch')),
       ((SELECT comic_id FROM comics WHERE comic_name='Empyre #1'), (SELECT superhero_id FROM superheroes WHERE superhero='The Thing')),
       ((SELECT comic_id FROM comics WHERE comic_name='Empyre #1'), (SELECT superhero_id FROM superheroes WHERE superhero='Invisible Woman')),
       ((SELECT comic_id FROM comics WHERE comic_name='Empyre #1'), (SELECT superhero_id FROM superheroes WHERE superhero='Mister Fantastic')),
       ((SELECT comic_id FROM comics WHERE comic_name='Empyre #1'), (SELECT superhero_id FROM superheroes WHERE superhero='Iron Man')),
       ((SELECT comic_id FROM comics WHERE comic_name='Empyre #1'), (SELECT superhero_id FROM superheroes WHERE superhero='Captain America')),
       ((SELECT comic_id FROM comics WHERE comic_name='Empyre #1'), (SELECT superhero_id FROM superheroes WHERE superhero='Thor')),
       ((SELECT comic_id FROM comics WHERE comic_name='Empyre #1'), (SELECT superhero_id FROM superheroes WHERE superhero='Black Panther')),
       ((SELECT comic_id FROM comics WHERE comic_name='Empyre #1'), (SELECT superhero_id FROM superheroes WHERE superhero='Captain Marvel')),
       ((SELECT comic_id FROM comics WHERE comic_name='Empyre #1'), (SELECT superhero_id FROM superheroes WHERE superhero='Ghost Rider')),
       ((SELECT comic_id FROM comics WHERE comic_name='Empyre #1'), (SELECT superhero_id FROM superheroes WHERE superhero='She-Hulk')),
       ((SELECT comic_id FROM comics WHERE comic_name='Marvel Age Spider-Man #8'), (SELECT superhero_id FROM superheroes WHERE superhero='Spider-Man')),
       ((SELECT comic_id FROM comics WHERE comic_name='Storm Vol 2 #1'), (SELECT superhero_id FROM superheroes WHERE superhero='Black Panther')),
       ((SELECT comic_id FROM comics WHERE comic_name='Storm Vol 2 #1'), (SELECT superhero_id FROM superheroes WHERE superhero='Storm')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT superhero_id FROM superheroes WHERE superhero='Black Panther')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT superhero_id FROM superheroes WHERE superhero='Blade')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT superhero_id FROM superheroes WHERE superhero='Luke Cage')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT superhero_id FROM superheroes WHERE superhero='Cloak')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT superhero_id FROM superheroes WHERE superhero='Daredevil')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT superhero_id FROM superheroes WHERE superhero='District X')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT superhero_id FROM superheroes WHERE superhero='Dr. Strange')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT superhero_id FROM superheroes WHERE superhero='Nick Fury')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT superhero_id FROM superheroes WHERE superhero='Ghost Rider')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT superhero_id FROM superheroes WHERE superhero='Iron Fist')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT superhero_id FROM superheroes WHERE superhero='Madrox')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT superhero_id FROM superheroes WHERE superhero='Man-Thing')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT superhero_id FROM superheroes WHERE superhero='Marvel Knights')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT superhero_id FROM superheroes WHERE superhero='Moon Knight')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT superhero_id FROM superheroes WHERE superhero='Punisher')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT superhero_id FROM superheroes WHERE superhero='Shang-Chi')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT superhero_id FROM superheroes WHERE superhero='White Tiger')),
       ((SELECT comic_id FROM comics WHERE comic_name='Batman: Knightfall Vol. 1'), (SELECT superhero_id FROM superheroes WHERE superhero='Batman')),
       ((SELECT comic_id FROM comics WHERE comic_name='Batman: Knightfall Vol. 1'), (SELECT superhero_id FROM superheroes WHERE superhero='Robin')),
       ((SELECT comic_id FROM comics WHERE comic_name='Batman: Knightfall Vol. 1'), (SELECT superhero_id FROM superheroes WHERE superhero='Nightwing')),
       ((SELECT comic_id FROM comics WHERE comic_name='Batman: Knightfall Vol. 1'), (SELECT superhero_id FROM superheroes WHERE superhero='Azrael')),
       ((SELECT comic_id FROM comics WHERE comic_name='Wonder Woman Vol. 5'), (SELECT superhero_id FROM superheroes WHERE superhero='Wonder Woman')),
       ((SELECT comic_id FROM comics WHERE comic_name='Superman Vol. 5'), (SELECT superhero_id FROM superheroes WHERE superhero='Superman')),
       ((SELECT comic_id FROM comics WHERE comic_name='Flashpoint'), (SELECT superhero_id FROM superheroes WHERE superhero='Flash')),
       ((SELECT comic_id FROM comics WHERE comic_name='Flashpoint'), (SELECT superhero_id FROM superheroes WHERE superhero='Batman')),
       ((SELECT comic_id FROM comics WHERE comic_name='Flashpoint'), (SELECT superhero_id FROM superheroes WHERE superhero='Cyborg')),
       ((SELECT comic_id FROM comics WHERE comic_name='Flashpoint'), (SELECT superhero_id FROM superheroes WHERE superhero='Booster Gold')),
       ((SELECT comic_id FROM comics WHERE comic_name='Flashpoint'), (SELECT superhero_id FROM superheroes WHERE superhero='Wonder Woman')),
       ((SELECT comic_id FROM comics WHERE comic_name='Flashpoint'), (SELECT superhero_id FROM superheroes WHERE superhero='Aquaman')),
       ((SELECT comic_id FROM comics WHERE comic_name='Justice League Vol. 1: Origin'), (SELECT superhero_id FROM superheroes WHERE superhero='Superman')),
       ((SELECT comic_id FROM comics WHERE comic_name='Justice League Vol. 1: Origin'), (SELECT superhero_id FROM superheroes WHERE superhero='Wonder Woman')),
       ((SELECT comic_id FROM comics WHERE comic_name='Justice League Vol. 1: Origin'), (SELECT superhero_id FROM superheroes WHERE superhero='Batman')),
       ((SELECT comic_id FROM comics WHERE comic_name='Justice League Vol. 1: Origin'), (SELECT superhero_id FROM superheroes WHERE superhero='Aquaman')),
       ((SELECT comic_id FROM comics WHERE comic_name='Justice League Vol. 1: Origin'), (SELECT superhero_id FROM superheroes WHERE superhero='Flash')),
       ((SELECT comic_id FROM comics WHERE comic_name='Justice League Vol. 1: Origin'), (SELECT superhero_id FROM superheroes WHERE superhero='Cyborg')),
       ((SELECT comic_id FROM comics WHERE comic_name='Justice League Vol. 1: Origin'), (SELECT superhero_id FROM superheroes WHERE superhero='Green Lantern')),
       ((SELECT comic_id FROM comics WHERE comic_name='Spawn #1'), (SELECT superhero_id FROM superheroes WHERE superhero='Spawn'));

INSERT INTO collections (collection_name, private, user_id)
VALUES ('Marvel Collection', FALSE, (SELECT user_id FROM users WHERE username='testuser')),
       ('DC Collection', FALSE, (SELECT user_id FROM users WHERE username='DCFan')),
       ('Image Collection', FALSE, (SELECT user_id FROM users WHERE username='ImageFan')),
       ('Super Collection', FALSE, (SELECT user_id FROM users WHERE username='SuperFan100'));

INSERT INTO collection_comic (comic_id, collection_id)
VALUES ((SELECT comic_id FROM comics WHERE comic_name='Empyre #1'), (SELECT collection_id FROM collections WHERE collection_name='User Collection 1')),
       ((SELECT comic_id FROM comics WHERE comic_name='Marvel Age Spider-Man #8'), (SELECT collection_id FROM collections WHERE collection_name='User Collection 1')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT collection_id FROM collections WHERE collection_name='User Collection 1')),
       ((SELECT comic_id FROM comics WHERE comic_name='Storm Vol 2 #1'), (SELECT collection_id FROM collections WHERE collection_name='User Collection 1')),
       ((SELECT comic_id FROM comics WHERE comic_name='Batman: Knightfall Vol. 1'), (SELECT collection_id FROM collections WHERE collection_name='User Collection 2')),
       ((SELECT comic_id FROM comics WHERE comic_name='Wonder Woman Vol. 5'), (SELECT collection_id FROM collections WHERE collection_name='User Collection 2')),
       ((SELECT comic_id FROM comics WHERE comic_name='Empyre #1'), (SELECT collection_id FROM collections WHERE collection_name='Marvel Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Marvel Age Spider-Man #8'), (SELECT collection_id FROM collections WHERE collection_name='Marvel Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT collection_id FROM collections WHERE collection_name='Marvel Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Storm Vol 2 #1'), (SELECT collection_id FROM collections WHERE collection_name='Marvel Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Batman: Knightfall Vol. 1'), (SELECT collection_id FROM collections WHERE collection_name='DC Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Wonder Woman Vol. 5'), (SELECT collection_id FROM collections WHERE collection_name='DC Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Superman Vol. 5'), (SELECT collection_id FROM collections WHERE collection_name='DC Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Flashpoint'), (SELECT collection_id FROM collections WHERE collection_name='DC Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Justice League Vol. 1: Origin'), (SELECT collection_id FROM collections WHERE collection_name='DC Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Spawn #1'), (SELECT collection_id FROM collections WHERE collection_name='Image Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Empyre #1'), (SELECT collection_id FROM collections WHERE collection_name='Super Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Marvel Age Spider-Man #8'), (SELECT collection_id FROM collections WHERE collection_name='Super Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT collection_id FROM collections WHERE collection_name='Super Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Storm Vol 2 #1'), (SELECT collection_id FROM collections WHERE collection_name='Super Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Batman: Knightfall Vol. 1'), (SELECT collection_id FROM collections WHERE collection_name='Super Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Wonder Woman Vol. 5'), (SELECT collection_id FROM collections WHERE collection_name='Super Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Superman Vol. 5'), (SELECT collection_id FROM collections WHERE collection_name='Super Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Flashpoint'), (SELECT collection_id FROM collections WHERE collection_name='Super Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Justice League Vol. 1: Origin'), (SELECT collection_id FROM collections WHERE collection_name='Super Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Spawn #1'), (SELECT collection_id FROM collections WHERE collection_name='Super Collection'));

INSERT INTO profiles (profile_img, profile_img_name)
VALUES ('https://blogger.googleusercontent.com/img/a/AVvXsEhOs8au_vMzAFMLfq_Y2YuW0K7iwHkvszLBGS3XQlF7pZkm-88oZs-Ki15UoNbXmvXun9qp6bPTXNgLWumP5BYhysAi8H3vIsam-vWkE0zR2-h-RWseGz4QD5fc9J0n6u6EjhQ9rrxqJtR1nygnjENFbKWPX2jSIDqGUKDRs4jPdyuh6971lg9sxS_Gyw=s2048', 'avatar-1'),
       ('https://blogger.googleusercontent.com/img/a/AVvXsEioLIcVjCUD9SQkCXMnI-thUDwF_7E9i1ART_Wtq7cvzVUVNCvACXagy4a2FY2sQXwkfjMadfv5OKFPQe74x9tsAhpGJYr4ZjB_E2n2_1366x5cLZcNR7WvXfDakTXHCduFfsYxoRSso4pYmANHyZjFQp_v9_NYNO61o-wgV7sbhFaJH7YzHzpYMJWZow=s2048', 'avatar-2'),
       ('https://blogger.googleusercontent.com/img/a/AVvXsEjitPfNOF7zspVGG_TxvtuKywVy-9bBHeLDkkYMZoHJyzkkdavP22evvw6FUO78AbScC8PXAw57i-t5BkeCv1EcsFPjvcW0_yFvd_8OSynpMXAJ-y-Hh0_0Y2pikNWQ2EbqYrjmw9sgoOvynd6ZhAWDbY_YUvt9B26a2gMgTLvXCipMB8T_FrWcfYtD7A=s2048', 'avatar-3'),
       ('https://blogger.googleusercontent.com/img/a/AVvXsEhcpFcqll_fG_42MNIfjBsjP44IVSeluhrUUF33x-qrdXZvio3F-HSmL9-DpkTqu161UQDEX4qvzIFH6x-7wNemdCAnvoSxdL_XudlITA_jkCjzRIfb5HSIC9h2iggTibP5QyDXs-INZumgovPDjgM2yGxx7-BOV3nNpo-YKX7I3v8VpAxn60tNDYjPqg=s2048', 'avatar-4'),
       ('https://blogger.googleusercontent.com/img/a/AVvXsEh8ujpAAZS-UedUOsXhmKQYtT09wgzm55RiGm6Li1cjoWvGIjuMNWi6_D8NxHnonYC-qupylBfx3DvmvmCbhhJ7MVmnGHPwhi9V6l7YlGYJW7xgRk0fS5UOyP-7W0pjgfLMaWZ1GsQDBquTEYu5b4DY4hl2hqqs6t7vc6OIhLONyFy3MzBIIVbZX9yeOw=s2048', 'avatar-5'),
       ('https://blogger.googleusercontent.com/img/a/AVvXsEgfH4qHVoC7xCaZtxZIGPZEt8bYtsi1e1wuWKoTzETeVDLnw2fdyVWaO3VNeOWLE2A-4byrchbXd4YW99ZaKSlJ7Gl90AsePMYKNM9Dqv0BAPEevCvUw1hXVmV9eEWQWq-etxAWTqaVoVyJupQwXcpLK97Aj42b34k3QG466K6VXVMutYifEgTTjqETUw=s2048', 'avatar-6'),
       ('https://blogger.googleusercontent.com/img/a/AVvXsEizJG-MgzwcSBVkAVQzdmoQTLzgOWY10C_qUDEHcPGTyf1ss_OmZoEk_vb7-XpzkcuKlH_eRzt5WPy7KbWh2Rvpcx2OdKfXXwEGyZalScdeKRsj2BAhNTxAxlRHxO1gcIVVPeT5y7sEmrrGCjTq3g6VrazPWP-zmk-rldzyB--9D-9kRjB2ULS5rmq_QQ=s2048', 'avatar-7');