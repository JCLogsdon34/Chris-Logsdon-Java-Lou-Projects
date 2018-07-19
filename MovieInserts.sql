INSERT INTO ActorID (ActorID, FirstName, LastName, BirthDay)
VALUES (1,'Bill', 'Murray', '1950/09/21'),
(2,'Dan', 'Aykroyd', '1952/07/01'),
(3,'John', 'Candy', '1950/10/31'),
(4,'Steve', 'Martin', NULL),
(5,'Sylvester', 'Stallone', NULL);

INSERT INTO Director (DirectorID, FirstName, LastName, BirthDay)
VALUES (1,'Ivan', 'Reitmann', '1946/10/26'),
(2,'Ted', 'Kotcheff', NULL);

INSERT INTO Rating (RatingID, RatingName)
VALUES (1, 'G'),
(2, 'PG'),
(3, 'PG-13'),
(4, 'R');

INSERT INTO Genre (GenreID, GenreName)
VALUES (1, 'Action'),
(2, 'Comedy'),
(3, 'Drama'),
(4, 'Horror');

INSERT INTO Movie (MovieID, GenreID, DirectorID, Rating, Title, ReleaseDate)
VALUES (1,1,2,4,'Rambo: First Blood', '1982/10/22'),
(2,2, NULL,4,'Planes, Trains, and Automobiles', '1987/11/25'),
(3,2,1,2,'Ghostbusters', NULL),
(4,2,2, NULL,'The Great Outdoors', '1988/06/1988');

INSERT INTO Castmembers (CastMemberID, ActorID, MovieID, Role)
VALUES (1,5, 1, 'John Rambo'),
(2,4,2, 'Neil Page'),
(3,3, 2, 'Del Griffith'),
(4,1, 3,'Dr. Peter Venkman'),
(5,2, 3, 'Dr. Raymond Stanz'),
(6,2, 4,'Roman Craig'),
(7,3, 4, 'Chet Ripley');


