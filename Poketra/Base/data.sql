acreate database poketra;
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

create table prixmatiere(
    idMatiere varchar(255) PRIMARY KEY,
    prix numeric(10,2)
);

create table PrixSac(
    idPrixSac serial PRIMARY KEY,
    idsac varchar(255) references sac(idsac),
    nomSac varchar(255),
    taille varchar(255),
    PrixSac numeric(10,2)
);
--resaka reste
create table matiere_qte(
    idMatiere_qte serial PRIMARY KEY,
    idMatiere VARCHAR(255) references matiere(idMatiere),
    qte numeric(10,2),
    achat date
);

create table Historique(
    idHistorique serial PRIMARY KEY,
    dateh date,
    idMatiere VARCHAR(255) references matiere(idMatiere),
    reste numeric(10,2)
);

--resaka benefice
create sequence seqouvrier increment by 1;
create table ouvrier(
    idOuvrier VARCHAR(255) primary KEY,
    ouvrier VARCHAR(255)
);

create table salaireOuvrier(
    idSalaireOuvrier serial primary KEY,
    idOuvrier varchar(255) references ouvrier(idOuvrier),
    salaire numeric(10,2)
);

create table sacOuvrier(
    idSacOuvrier serial primary KEY,
    idSac varchar(255) references sac(idsac),
    idOuvrier varchar(255) references ouvrier(idOuvrier),
    nombre int,
    temp numeric(10,2)
);

create table benefice(
    idBenefice serial primary key,
    idSac varchar(255),
    taille varchar(255),
    benefice numeric(10,2)
);
--resaka promotion employe
create sequence seqemploye increment by 1;
create table employe(
    idEmploye varchar(255) primary key,
    nom varchar(255),
    prenom varchar(255),
    dtn date,
    dateEmbauche date
);

create table poste(
    idPoste serial primary key,
    idOuvrier varchar(255) references ouvrier(idOuvrier),
    idEmploye varchar(255) references employe(idEmploye)
);
--resaka statistique 

create table client(
    idClient serial primary key,
    nom varchar(255),
    prenom varchar(255),
    genre int -- 1 si fille 0 si garcon
);

create table vente (
    idVente serial primary key,
    idClient int references client(idClient),
    idSac VARCHAR (255) references sac(idSac),
    nombre int,
    dateAchat date
);

--insertion

insert into prixmatiere (idMatiere, prix) values
('M0010',25.5),
('M0011',35.5),
('M0012',45.5),
('M0013',55.5),
('M0014',65.5),
('M0015',75.5),
('M0016',85.5),
('M0018',95.5);

--view

create or replace view Ventes AS 
select
    c.idClient,
    c.nom,
    c.prenom,
    c.genre,
    v.idVente,
    v.idSac,
    s.nomSac,
    v.nombre,
    v.dateAchat
from vente v
join client c on v.idClient = c.idClient
join sac s on v.idSac = s.idSac;

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

create or replace view sacBenefice AS
select 
    s.idsac,
    s.nomsac,
    b.taille,
    b.benefice
FROM
    benefice b
JOIN sac s on b.idsac = s.idsac;

create or replace view postes AS
select
    p.idPoste,
    p.idOuvrier,
    o.ouvrier,
    p.idEmploye,
    e.nom,
    e.prenom,
    e.dateEmbauche,
    e.dtn
from poste p
join ouvrier o on p.idOuvrier = o.idOuvrier
join employe e on p.idEmploye = e.idEmploye;

