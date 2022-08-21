CREATE TABLE jaegers (
    id serial PRIMARY KEY,
    modelName text NOT NULL,
    mark text NOT NULL,
    height real NOT NULL,
    weight real NOT NULL,
    status text NOT NULL,
    origin text NOT NULL,
    launch date NOT NULL,
    kaijuKill integer,
);