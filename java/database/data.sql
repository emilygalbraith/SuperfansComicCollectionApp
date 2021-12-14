INSERT INTO publishers (publisher_name)
VALUES ('Marvel'), ('DC');

INSERT INTO series (series_name)
VALUES ('Empyre'), ('Spider-Man'), ('Marvel Knigths'), ('Storm'), ('Batman'), ('Wonder Woman');

INSERT INTO comics (comic_name, author, image, release_date, publisher_id, series_id)
VALUES ('Empyre #1', 'Al Ewing', 'http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada/portrait_xlarge.jpg', '2020-07-15', (SELECT publisher_id FROM publishers WHERE publisher_name='Marvel'), (SELECT series_id FROM series WHERE series_name='Empyre')),
       ('Marvel Age Spider-Man #8', 'Todd Dezago', 'http://i.annihil.us/u/prod/marvel/i/mg/6/90/5a664c954a55b/portrait_xlarge.jpg', '2004-07-21', (SELECT publisher_id FROM publishers WHERE publisher_name='Marvel'), (SELECT series_id FROM series WHERE series_name='Spider-Man')),
       ('Official Handbook of the Marvel Universe', 'Eric J. Moreels, Barry Reese, Ronald Byrd, Jeff Christiansen', 'http://i.annihil.us/u/prod/marvel/i/mg/9/30/4bc64df4105b9/portrait_xlarge.jpg', '2004-12-31', (SELECT publisher_id FROM publishers WHERE publisher_name='Marvel'), (SELECT series_id FROM series WHERE series_name='Marvel Knigths')),
       ('Storm Vol 2 #1', 'Eric Jerome Dickey', 'http://i.annihil.us/u/prod/marvel/i/mg/c/80/4bc5fe7a308d7/portrait_xlarge.jpg', '2008-01-16', (SELECT publisher_id FROM publishers WHERE publisher_name='Marvel'), (SELECT series_id FROM series WHERE series_name='Storm')),
       ('Batman: Knightfall Vol. 1', 'Alan Grant, Chuck Dixon, Doug Moench, Jo Duffy', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWXiPXpET1LjUQcdI2eL9YSJZQy0BHg4UxpA&usqp=CAU', '2012-05-01', (SELECT publisher_id FROM publishers WHERE publisher_name='DC'), (SELECT series_id FROM series WHERE series_name='Batman')),
       ('Wonder Woman Vol. 5', 'Greg Rucka, Liam Sharp, Nicola Scott, James Robinson, Steve Orlando, G. Willow Wilson', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDPgzvwrIhUCOUwypmi_BX84djp8_ngPsGxQ&usqp=CAU', '2016-08-01', (SELECT publisher_id FROM publishers WHERE publisher_name='DC'), (SELECT series_id FROM series WHERE series_name='Wonder Woman'));

INSERT INTO superheroes (superhero)
VALUES ('Spider-Man'), ('Storm'), ('Black Panther'), ('Human Torch'), ('The Thing'), ('Invisible Woman'), ('Mister Fantastic'), ('Iron Man'), ('Captain America'), ('Thor'), ('Captain Marvel'), ('Ghost Rider'), ('She-Hulk'), 
       ('Blade'), ('Luke Cage'), ('Cloak'), ('Daredevil'), ('District X'), ('Dr. Strange'), ('Nick Fury'), ('Iron Fist'), ('Madrox'), ('Man-Thing'), ('Marvel Knights'), ('Moon Knight'), ('Punisher'), ('Shang-Chi'), ('White Tiger'),
       ('Batman'), ('Robin'), ('Nightwing'), ('Azrael'), ('Wonder Woman');

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
       ((SELECT comic_id FROM comics WHERE comic_name='Wonder Woman Vol. 5'), (SELECT superhero_id FROM superheroes WHERE superhero='Wonder Woman'));

INSERT INTO collections (collection_name, private, user_id)
VALUES ('User Collection 1', FALSE, (SELECT user_id FROM users WHERE username='testuser')),
       ('User Collection 2', FALSE, (SELECT user_id FROM users WHERE username='DCFan'));

INSERT INTO collection_comic (comic_id, collection_id)
VALUES ((SELECT comic_id FROM comics WHERE comic_name='Empyre #1'), (SELECT collection_id FROM collections WHERE collection_name='User Collection 1')),
       ((SELECT comic_id FROM comics WHERE comic_name='Marvel Age Spider-Man #8'), (SELECT collection_id FROM collections WHERE collection_name='User Collection 1')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT collection_id FROM collections WHERE collection_name='User Collection 1')),
       ((SELECT comic_id FROM comics WHERE comic_name='Storm Vol 2 #1'), (SELECT collection_id FROM collections WHERE collection_name='User Collection 1')),
       ((SELECT comic_id FROM comics WHERE comic_name='Batman: Knightfall Vol. 1'), (SELECT collection_id FROM collections WHERE collection_name='User Collection 2')),
       ((SELECT comic_id FROM comics WHERE comic_name='Wonder Woman Vol. 5'), (SELECT collection_id FROM collections WHERE collection_name='User Collection 2'));

INSERT INTO profiles (profile_img, profile_img_name)
VALUES ('https://blogger.googleusercontent.com/img/a/AVvXsEhOs8au_vMzAFMLfq_Y2YuW0K7iwHkvszLBGS3XQlF7pZkm-88oZs-Ki15UoNbXmvXun9qp6bPTXNgLWumP5BYhysAi8H3vIsam-vWkE0zR2-h-RWseGz4QD5fc9J0n6u6EjhQ9rrxqJtR1nygnjENFbKWPX2jSIDqGUKDRs4jPdyuh6971lg9sxS_Gyw=s2048', 'avatar-1');
