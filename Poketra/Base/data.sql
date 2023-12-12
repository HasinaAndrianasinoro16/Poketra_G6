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

