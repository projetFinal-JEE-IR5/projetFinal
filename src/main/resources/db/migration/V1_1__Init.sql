------------------------------------------------------------
--        Script SQL_Derby.  
------------------------------------------------------------


------------------------------------------------------------
-- Table: filiere
------------------------------------------------------------
CREATE TABLE filiere(
	id_filiere   INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
	abreviation  Varchar NOT NULL  ,
	nom_filiere  Varchar NOT NULL  ,
	PRIMARY KEY (id_filiere)
);


------------------------------------------------------------
-- Table: role
------------------------------------------------------------
CREATE TABLE role(
	id_role  INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
	libelle  Varchar NOT NULL  ,
	PRIMARY KEY (id_role)
);


------------------------------------------------------------
-- Table: probleme
------------------------------------------------------------
CREATE TABLE probleme(
	id_probleme  INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
	contenu      Varchar ,
	date_heure   BIGINT ,
	objet        Varchar ,
	vote         Integer ,
	id_personne  Int NOT NULL  ,
	id_status    Int NOT NULL  ,
	PRIMARY KEY (id_probleme)
);


------------------------------------------------------------
-- Table: status
------------------------------------------------------------
CREATE TABLE status(
	id_status  INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
	libelle    Varchar NOT NULL  ,
	PRIMARY KEY (id_status)
);


------------------------------------------------------------
-- Table: personne
------------------------------------------------------------
CREATE TABLE personne(
	id_personne  INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
	login        Varchar ,
	nom          Varchar NOT NULL  ,
	prenom       Varchar NOT NULL  ,
	password     Varchar NOT NULL  ,
	id_filiere   Int ,
	id_role      Int NOT NULL  ,
	PRIMARY KEY (id_personne)
);

ALTER TABLE probleme ADD FOREIGN KEY (id_personne) REFERENCES personne(id_personne);
ALTER TABLE probleme ADD FOREIGN KEY (id_status) REFERENCES status(id_status);
ALTER TABLE personne ADD FOREIGN KEY (id_filiere) REFERENCES filiere(id_filiere);
ALTER TABLE personne ADD FOREIGN KEY (id_role) REFERENCES role(id_role);

INSERT INTO ROLE (LIBELLE) VALUES ('Étudiant');
INSERT INTO ROLE (LIBELLE) VALUES ('Directeur Établissement');
INSERT INTO ROLE (LIBELLE) VALUES ('Directeur Études');

INSERT INTO FILIERE (ABREVIATION, NOM_FILIERE)VALUES('IR','Informatique et Réseaux');
INSERT INTO FILIERE (ABREVIATION, NOM_FILIERE)VALUES('SEP','Sécurité, Environnement et Prévention');

INSERT INTO STATUS (LIBELLE)VALUES('En cours');
INSERT INTO STATUS (LIBELLE)VALUES('Résolu');

INSERT INTO PERSONNE (NOM,PRENOM,LOGIN,PASSWORD,ID_FILIERE,ID_ROLE) VALUES ('Daniels','Jack','jdaniel','whisky',2,1);
INSERT INTO PERSONNE (NOM,PRENOM,LOGIN,PASSWORD,ID_FILIERE,ID_ROLE) VALUES ('RICHARD','Antoine','arichard','arichard',1,2);
INSERT INTO PERSONNE (NOM,PRENOM,LOGIN,PASSWORD,ID_FILIERE,ID_ROLE) VALUES ('SABARON','Benjamin','bsabaron','bsabaron',1,1);
INSERT INTO PERSONNE (NOM,PRENOM,LOGIN,PASSWORD,ID_FILIERE,ID_ROLE) VALUES ('MARTY','Benjamin','bmarty','bmarty',2,3);
INSERT INTO PERSONNE (NOM,PRENOM,LOGIN,PASSWORD,ID_FILIERE,ID_ROLE) VALUES ('Morgan','Captain','cmorgan','rhum',null,3);
INSERT INTO PERSONNE (NOM,PRENOM,LOGIN,PASSWORD,ID_FILIERE,ID_ROLE) VALUES ('Meister','Jager','jmeister','liqueur',null,2);

INSERT INTO PROBLEME (CONTENU, DATE_HEURE, OBJET, VOTE, ID_PERSONNE, ID_STATUS)VALUES('contenu du probleme 1', 1509380153,'probleme 1',4,1,1);
INSERT INTO PROBLEME (CONTENU, DATE_HEURE, OBJET, VOTE, ID_PERSONNE, ID_STATUS)VALUES('contenu du probleme 2', 1509380153,'probleme 2',0,5,1);
INSERT INTO PROBLEME (CONTENU, DATE_HEURE, OBJET, VOTE, ID_PERSONNE, ID_STATUS) VALUES ('contenu du probleme 3', 1509380153, 'probleme 3',3,2,2);
