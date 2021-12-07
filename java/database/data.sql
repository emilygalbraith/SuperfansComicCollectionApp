INSERT INTO publishers (publisher_name)
VALUES ('Marvel');

INSERT INTO series (series_name)
VALUES ('Empyre'), ('Spider-Man'), ('Marvel Knigths'), ('Astonishing X-Men');

INSERT INTO comics (comic_name, author, image, release_date, publisher_id, series_id)
VALUES ('Empyre #1', 'Al Ewing', 'http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada/portrait_xlarge.jpg', '2020-07-15', (SELECT publisher_id FROM publishers WHERE publisher_name='Marvel'), (SELECT series_id FROM series WHERE series_name='Empyre')),
       ('Marvel Age Spider-Man #8', 'Todd Dezago', 'http://i.annihil.us/u/prod/marvel/i/mg/6/90/5a664c954a55b/portrait_xlarge.jpg', '2004-07-21', (SELECT publisher_id FROM publishers WHERE publisher_name='Marvel'), (SELECT series_id FROM series WHERE series_name='Spider-Man')),
       ('Official Handbook of the Marvel Universe', 'Eric J. Moreels, Barry Reese, Ronald Byrd, Jeff Christiansen', 'http://i.annihil.us/u/prod/marvel/i/mg/9/30/4bc64df4105b9/portrait_xlarge.jpg', '2004-12-31', (SELECT publisher_id FROM publishers WHERE publisher_name='Marvel'), (SELECT series_id FROM series WHERE series_name='Marvel Knigths')),
       ('Storm', 'Eric Jerome Dickey', 'http://i.annihil.us/u/prod/marvel/i/mg/c/80/4bc5fe7a308d7/portrait_xlarge.jpg', '2008-01-16', (SELECT publisher_id FROM publishers WHERE publisher_name='Marvel'), (SELECT series_id FROM series WHERE series_name='Astonishing X-Men'));

INSERT INTO collections (collection_name, private, user_id)
VALUES ('User Collection', FALSE, (SELECT user_id FROM users WHERE username='user'));

INSERT INTO collection_comic (comic_id, collection_id)
VALUES ((SELECT comic_id FROM comics WHERE comic_name='Empyre #1'), (SELECT collection_id FROM collections WHERE collection_name='User Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Marvel Age Spider-Man #8'), (SELECT collection_id FROM collections WHERE collection_name='User Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Official Handbook of the Marvel Universe'), (SELECT collection_id FROM collections WHERE collection_name='User Collection')),
       ((SELECT comic_id FROM comics WHERE comic_name='Storm'), (SELECT collection_id FROM collections WHERE collection_name='User Collection'));


