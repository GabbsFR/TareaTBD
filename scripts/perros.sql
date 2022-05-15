CREATE TABLE perror (id serial, name varchar, geom geometry(Point, 4326));

INSERT INTO perror (name, geom)
VALUES ('A', ST_GeomFromText('POINT(-72.928177 -41.474096)', 4326));
