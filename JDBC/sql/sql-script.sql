-- Drop table if it exists
DROP TABLE personnen;

-- Create table
CREATE TABLE personnen (
    id INT PRIMARY KEY,
    vorname VARCHAR(100),
    nachname VARCHAR(100),
    geburtsjahr INT
);

-- Insert data
INSERT INTO personnen (id, vorname, nachname, geburtsjahr) 
VALUES  (1, 'Max', 'Müller', 1985),
		(2, 'Anna', 'Schmidt', 1990),
		(3, 'Leo', 'Weber', 2000),
		(4, 'Leo', 'Merzaros', 2020);
