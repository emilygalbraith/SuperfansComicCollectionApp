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
VALUES ((SELECT comic_id FROM comics WHERE comic_name='Empyre #1'), (SELECT collection_id FROM collections WHERE collection_name='Marvel Collection')),
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