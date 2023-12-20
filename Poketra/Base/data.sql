create database poketra;
\c poketra

create sequence SEQLook increment by 1;
create table look(
    idLook varchar(255) PRIMARY KEY,
    look varchar(255)
);

create sequence SEQMatiere increment by 1;
create table Matiere(
    idMatiere varchar(255) PRIMARY KEY,
    matiere varchar(255)
);

create table matiere_look(
    idMatiere_look serial PRIMARY KEY,
    idLook varchar(255) references look(idLook),
    idMatiere varchar(255) references matiere(idMatiere)
); 

create sequence SEQSac increment by 1;
create table Sac(
    idSac varchar(255) PRIMARY KEY,
    nomSac varchar(255)
);

create table Taille(
    idTaille serial PRIMARY KEY,
    taille varchar(255)
);


-- create table unite(
--     idUnite serial PRIMARY KEY,
--     unite varchar(255)
-- );

create table matiere_sac(
    idMatiere_sac serial PRIMARY KEY,
    idSac varchar(255) references sac(idSac),
    idMatiere varchar(255) references matiere(idMatiere),
    idTaille int references taille(idTaille),
    quantie numeric(10,2)
);

CREATE OR REPLACE VIEW sac_matiere AS
SELECT
    sac.idSac,
    sac.nomSac,
    matiere.matiere,
    matiere.idMatiere,
    taille.taille,
    matiere_sac.quantie
FROM matiere_sac
JOIN sac on matiere_sac.idSac = sac.idSac
JOIN matiere on matiere_sac.idMatiere = matiere.idMatiere
JOIN taille on taille.idTaille = matiere_sac.idTaille;


CREATE OR REPLACE VIEW type_matiere AS
SELECT
    ml.idMatiere_look,
    l.idLook,
    l.look,
    m.idMatiere,
    m.matiere
FROM
    matiere_look ml
JOIN
    look l ON ml.idLook = l.idLook
JOIN
    Matiere m ON ml.idMatiere = m.idMatiere;

