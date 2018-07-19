Use SuperHeros;

INSERT INTO superpowers (superPowerID, name, description)
VALUES(1, 'Cleverness', 'buffedles enemies'),
(2, 'Baddie slayer', 'Kills bandits and bull-men'),
(3, 'Pomerium', 'sets boundry'),
(4, 'Spear mastery', 'skill with a spear'),
(5, 'Husband Slayer', 'husband killing action'),
(6, 'brotherly love', 'fight together well'),
(7, 'Prohpecy', 'Sees future well'),
(8, 'fortitude', 'Strong in adversity'),
(9, 'Perfect aim', 'shoots well with a bow'),
(10, 'Fidelity', 'can wait a long time'),
(11, 'Slander', 'writes mean poems about foes'),
(12, 'golden-tongue', 'unbelievable poem performer'),
(13, 'wisdom', 'wise past his years'),
(14, 'Strength', 'strong man-god'),
(15, 'listening', 'listens to Socrates'),
(16, 'stranger seeker', 'seeks out "the stranger"'),
(17, 'Bridge fighter', 'Holds The Milvian Bridge'),
(18, 'augery', 'read the birds!'),
(19, 'composition', 'poem writing action'),
(20, 'harp magic', 'unbelieveable talent at music');


INSERT INTO locations (locationID, locationName, address, longitude, latitude)
VALUES(1, 'Mt. Ida', 'Crete, Greece', 35.1336, 24.4621),
(2,  'Aventine Hill', 'Rome, Italy', 41.5347, 12.2847),
(3, 'Quirinal Hill', 'Rome, Italy', 41.5426, 12.2921),
(4,  'Cadmea', 'Thebes, Boiotia', 38.1900, 23.1921),
(5,  'Ithaca', 'Ionion Isles', 38.2200, 20.4300),
(6, 'Cures', 'The Sabina', 42.1300, 12.4400),
(7, 'Reiti', 'The Sabina', 42.2400, 12.5200),
(8, 'Tarentum', 'Apuilia', 40.2800, 17.1400),
(9, 'Lukabittos Hill', 'Athens', 37.5840, 23.4430),
(10, 'Mt Pelion', 'Thessaly', 39.2619, 23.247);

INSERT INTO organizations (orgID, orgName, orgDescription, locationID)
VALUES(1, 'Mt. Ida Horses', 'Centaur beaters', 1),
(2,  'Aventine Crew', 'Legionairies', 2),
(3, 'Quirinal Boys', 'Rome Founders', 3),
(4,  'Thebans', 'Theban Thugs', 4),
(5,  'Ithaca Crew', 'Ithacan Boys', 5);


INSERT INTO heros (superHeroID, name , description)
VALUES (1,'Odysseus', 'Ithaca King, Explorer'),
(2, 'Theseus', 'Athens King, Minataur slayer'),
(3, 'Romulus', 'Rome founder'),
(4, 'Ajax', 'Son of Telamon'),
(5, 'Clytemnestra', 'Spartan Queen'),
(6, 'Castor and Pollux','twin warriors'),
(7, 'Cassandra', 'Trojan Seeress'),
(8, 'Andromache', 'Trojan Queen'),
(9, 'Atalanta', 'Huntress, girlboss'),
(10, 'Penelope','Ithaca Queen, awesome wife'),
(11, 'Hipponax','Poem assasin, dope on the mic'),
(12, 'Sappho', 'Poetess, queen poet'),
(13, 'Nestor', 'Wise king, counselor'),
(14, 'Heracles', 'Hero of all trades'),
(15, 'Crito', 'Socrates pupil (victim)'),
(16, 'Pentheus', 'Thebes King, Bacchus victim'),
(17, 'Horatius Cocles','Milvian Bridge fighter'),
(18, 'Remus','Rome co-founder'),
(19, 'Corinna', 'Theban poetess, microphone assasin'),
(20, 'Orpheus', 'Baddest harpist of all time');



INSERT INTO sightings (sightingID, sightingDate, location)
VALUES (1, '2018-03-16', 1),
(2,  '2018-05-12', 2),
(3,  '2018-03-12', 3),
(4, '2018-05-14', 4),
(5, '2018-02-04', 5),
(6, '2018-05-10', 6),
(7, '2018-05-12', 7),
(8, '2018-05-14', 8),
(9, '2018-05-07', 9),
(10, '2018-04-01', 10),
(11, '2018-04-10', 9),
(12, '2018-04-12', 8),
(13,  '2018-05-06', 7),
(14, '2018-05-11', 6),
(15, '2018-05-16', 5),
(16, '2018-05-16', 4),
(17, '2018-04-12', 3),
(18, '2018-01-09', 2),
(19, '2018-03-02', 1),
(20, '2018-02-12', 9);

INSERT INTO superhero_organization (heroOrgID, superHeroID, orgID)
VALUES(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 2),
(7, 7, 1),
(8, 8, 4),
(9, 9, 5),
(10, 10, 2),
(11, 11, 1),
(12, 12, 3),
(13, 13, 4),
(14, 15, 5),
(15, 15, 1),
(16, 16, 5),
(17, 17, 2),
(18, 18, 5),
(19, 19, 4),
(20, 20, 3);

INSERT INTO superhero_superpower(heroPowerID, superHeroID, superPowerID)
VALUES (1, 1, 1), 
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6), 
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10),
(11, 11, 11), 
(12, 12, 12),
(13, 13, 13),
(14, 14, 14),
(15, 15, 15),
(16, 16, 16), 
(17, 17, 17),
(18, 18, 18),
(19, 19, 19),
(20, 20, 20);

INSERT INTO superhero_has_sighting(heroSightingID, superHeroID, sightingID)
VALUES (1, 1, 1), 
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 5), 
(7, 7, 5),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10),
(11, 11, 11), 
(12, 12, 12),
(13, 13, 13),
(14, 14, 14),
(15, 15, 15),
(16, 16, 16), 
(17, 17, 17),
(18, 18, 18),
(19, 19, 19),
(20, 20, 20);

 SELECT * 
FROM superhero_has_sighting hS 
inner join Sightings s on hS.sightingID = s.sightingID 
inner join Heros h on hS.superHeroID = h.superHeroID 
WHERE s.sightingID = 5 ;

SELECT * 
FROM superhero_organization so 
inner join Heros s on so.superHeroID = s.superHeroID 
WHERE so.orgID = 1 ;