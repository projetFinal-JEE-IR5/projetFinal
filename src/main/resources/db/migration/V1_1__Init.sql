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
	id_probleme          INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
	contenu              Varchar NOT NULL  ,
	date_heure_probleme  BIGINT NOT NULL  ,
	objet                Varchar NOT NULL  ,
	id_personne          Int NOT NULL  ,
	id_status            Int NOT NULL  ,
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
	id_personne       INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
	login             Varchar ,
	nom               Varchar NOT NULL  ,
	prenom            Varchar NOT NULL  ,
	password          Varchar NOT NULL  ,
	nb_vote_autorise  Int ,
	id_filiere        Int ,
	id_role           Int NOT NULL  ,
	PRIMARY KEY (id_personne) ,
	UNIQUE (login)
);


------------------------------------------------------------
-- Table: notification
------------------------------------------------------------
CREATE TABLE notification(
	id_notification   INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
	date_heure_notif  BIGINT NOT NULL  ,
	contenu           Varchar NOT NULL  ,
	id_personne       Int NOT NULL  ,
	PRIMARY KEY (id_notification)
);


------------------------------------------------------------
-- Table: voter
------------------------------------------------------------
CREATE TABLE voter(
	date_heure_vote  BIGINT NOT NULL  ,
	id_personne      Int ,
	id_probleme      Int ,
	PRIMARY KEY (id_personne,id_probleme)
);


------------------------------------------------------------
-- Table: recevoir
------------------------------------------------------------
CREATE TABLE recevoir(
	id_notification  Int ,
	id_personne      Int ,
	PRIMARY KEY (id_notification,id_personne)
);


ALTER TABLE probleme ADD FOREIGN KEY (id_personne) REFERENCES personne(id_personne);
ALTER TABLE probleme ADD FOREIGN KEY (id_status) REFERENCES status(id_status);
ALTER TABLE personne ADD FOREIGN KEY (id_filiere) REFERENCES filiere(id_filiere);
ALTER TABLE personne ADD FOREIGN KEY (id_role) REFERENCES role(id_role);
ALTER TABLE notification ADD FOREIGN KEY (id_personne) REFERENCES personne(id_personne);
ALTER TABLE voter ADD FOREIGN KEY (id_personne) REFERENCES personne(id_personne);
ALTER TABLE voter ADD FOREIGN KEY (id_probleme) REFERENCES probleme(id_probleme);
ALTER TABLE recevoir ADD FOREIGN KEY (id_notification) REFERENCES notification(id_notification);
ALTER TABLE recevoir ADD FOREIGN KEY (id_personne) REFERENCES personne(id_personne);

INSERT INTO ROLE (LIBELLE) VALUES ('Étudiant');
INSERT INTO ROLE (LIBELLE) VALUES ('Directeur Établissement');
INSERT INTO ROLE (LIBELLE) VALUES ('Directeur Études');

INSERT INTO FILIERE (ABREVIATION, NOM_FILIERE)VALUES('IR', 'Informatique et Réseaux');
INSERT INTO FILIERE (ABREVIATION, NOM_FILIERE)VALUES('SEP', 'Sécurité, Environnement et Prévention');

INSERT INTO STATUS (LIBELLE)VALUES('En cours');
INSERT INTO STATUS (LIBELLE)VALUES('Résolu');

INSERT INTO PERSONNE (NOM,PRENOM,LOGIN,PASSWORD,NB_VOTE_AUTORISE,ID_FILIERE,ID_ROLE) VALUES ('Daniels', 'Jack', 'jdaniel', 'whisky', 10, 2, 1);
INSERT INTO PERSONNE (NOM,PRENOM,LOGIN,PASSWORD,NB_VOTE_AUTORISE,ID_FILIERE,ID_ROLE) VALUES ('RICHARD', 'Antoine', 'arichard', 'arichard', null, null, 2);
INSERT INTO PERSONNE (NOM,PRENOM,LOGIN,PASSWORD,NB_VOTE_AUTORISE,ID_FILIERE,ID_ROLE) VALUES ('SABARON', 'Benjamin', 'bsabaron', 'bsabaron', 10, 1, 1);
INSERT INTO PERSONNE (NOM,PRENOM,LOGIN,PASSWORD,NB_VOTE_AUTORISE,ID_FILIERE,ID_ROLE) VALUES ('MARTY', 'Benjamin', 'bmarty', 'bmarty', null, null, 3);
INSERT INTO PERSONNE (NOM,PRENOM,LOGIN,PASSWORD,NB_VOTE_AUTORISE,ID_FILIERE,ID_ROLE) VALUES ('Morgan', 'Captain', 'cmorgan', 'rhum', 10, 1, 1);
INSERT INTO PERSONNE (NOM,PRENOM,LOGIN,PASSWORD,NB_VOTE_AUTORISE,ID_FILIERE,ID_ROLE) VALUES ('Meister', 'Jager', 'jmeister', 'liqueur', 10, 2, 1);

INSERT INTO PROBLEME (CONTENU, DATE_HEURE_PROBLEME, OBJET, ID_PERSONNE, ID_STATUS)VALUES('contenu du probleme 1', 1509380153, 'probleme 1', 1, 1);
INSERT INTO PROBLEME (CONTENU, DATE_HEURE_PROBLEME, OBJET, ID_PERSONNE, ID_STATUS)VALUES('contenu du probleme 2', 1509380153, 'probleme 2', 5, 1);
INSERT INTO PROBLEME (CONTENU, DATE_HEURE_PROBLEME, OBJET, ID_PERSONNE, ID_STATUS) VALUES ('contenu du probleme 3', 1509380153, 'probleme 3', 2, 2);

INSERT INTO NOTIFICATION (CONTENU, DATE_HEURE_NOTIF, ID_PERSONNE) VALUES ('contenu du notif 1', 1512685926, 2);
INSERT INTO NOTIFICATION (CONTENU, DATE_HEURE_NOTIF, ID_PERSONNE) VALUES ('contenu du notif 2', 1512685944, 4);

INSERT INTO VOTER (DATE_HEURE_VOTE, ID_PERSONNE, ID_PROBLEME) VALUES (1512686191, 1, 1);
INSERT INTO VOTER (DATE_HEURE_VOTE, ID_PERSONNE, ID_PROBLEME) VALUES (1512686191, 3, 1);
INSERT INTO VOTER (DATE_HEURE_VOTE, ID_PERSONNE, ID_PROBLEME) VALUES (1512686191, 5, 2);
INSERT INTO VOTER (DATE_HEURE_VOTE, ID_PERSONNE, ID_PROBLEME) VALUES (1512686191, 6, 2);
INSERT INTO VOTER (DATE_HEURE_VOTE, ID_PERSONNE, ID_PROBLEME) VALUES (1512686191, 3, 3);
INSERT INTO VOTER (DATE_HEURE_VOTE, ID_PERSONNE, ID_PROBLEME) VALUES (1512686191, 6, 3);

INSERT INTO RECEVOIR (ID_NOTIFICATION, ID_PERSONNE) VALUES (1, 2);
INSERT INTO RECEVOIR (ID_NOTIFICATION, ID_PERSONNE) VALUES (1, 3);
INSERT INTO RECEVOIR (ID_NOTIFICATION, ID_PERSONNE) VALUES (2, 5);
INSERT INTO RECEVOIR (ID_NOTIFICATION, ID_PERSONNE) VALUES (2, 6);
