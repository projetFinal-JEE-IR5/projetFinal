------------------------------------------------------------
--        Script SQL_Derby.  
------------------------------------------------------------


------------------------------------------------------------
-- Table: filiere
------------------------------------------------------------
CREATE TABLE filiere(
	id_filiere     INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
	abreviation    Varchar NOT NULL  ,
	nom_filiere    Varchar NOT NULL  ,
	id_dir_etudes  Int NOT NULL  ,
	PRIMARY KEY (id_filiere)
);


------------------------------------------------------------
-- Table: probleme
------------------------------------------------------------
CREATE TABLE probleme(
	id_probleme          INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
	contenu              Varchar NOT NULL  ,
	date_heure_probleme  BIGINT NOT NULL  ,
	objet                Varchar NOT NULL  ,
	nb_vote              Int NOT NULL  ,
	id_etudiant          Int NOT NULL  ,
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
-- Table: etudiant
------------------------------------------------------------
CREATE TABLE etudiant(
	id_etudiant            INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
	login                  Varchar ,
	nom                    Varchar NOT NULL  ,
	prenom                 Varchar NOT NULL  ,
	password               Varchar NOT NULL  ,
	nb_prob_autorise_jour  Int NOT NULL  ,
	id_filiere             Int NOT NULL  ,
	PRIMARY KEY (id_etudiant) ,
	UNIQUE (login)
);


------------------------------------------------------------
-- Table: notification
------------------------------------------------------------
CREATE TABLE notification(
	id_notification       INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
	date_heure_notif      BIGINT NOT NULL  ,
	contenu               Varchar NOT NULL  ,
	id_dir_etudes         Int ,
	id_dir_etablissement  Int ,
	PRIMARY KEY (id_notification)
);


------------------------------------------------------------
-- Table: dir_etudes
------------------------------------------------------------
CREATE TABLE dir_etudes(
	id_dir_etudes  INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
	login          Varchar ,
	nom            Varchar NOT NULL  ,
	prenom         Varchar NOT NULL  ,
	password       Varchar NOT NULL  ,
	id_filiere     Int NOT NULL  ,
	PRIMARY KEY (id_dir_etudes) ,
	UNIQUE (login)
);


------------------------------------------------------------
-- Table: dir_etablissement
------------------------------------------------------------
CREATE TABLE dir_etablissement(
	id_dir_etablissement  INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  ,
	login                 Varchar ,
	nom                   Varchar NOT NULL  ,
	prenom                Varchar NOT NULL  ,
	password              Varchar NOT NULL  ,
	PRIMARY KEY (id_dir_etablissement) ,
	UNIQUE (login)
);


------------------------------------------------------------
-- Table: voter
------------------------------------------------------------
CREATE TABLE voter(
	id_etudiant      Int ,
	id_probleme      Int ,
	PRIMARY KEY (id_etudiant,id_probleme)
);


------------------------------------------------------------
-- Table: recevoir
------------------------------------------------------------
CREATE TABLE recevoir(
	id_notification  Int ,
	id_etudiant      Int ,
	PRIMARY KEY (id_notification,id_etudiant)
);


INSERT INTO FILIERE (ABREVIATION, NOM_FILIERE, ID_DIR_ETUDES)VALUES('IR', 'Informatique et Réseaux', 1);
INSERT INTO FILIERE (ABREVIATION, NOM_FILIERE, ID_DIR_ETUDES)VALUES('SEP', 'Sécurité, Environnement et Prévention', 2);

INSERT INTO DIR_ETABLISSEMENT (NOM, PRENOM, LOGIN, PASSWORD) VALUES ('RICHARD', 'Antoine', 'arichard', 'arichard');

INSERT INTO DIR_ETUDES (NOM, PRENOM, LOGIN, PASSWORD, ID_FILIERE) VALUES ('MARTY', 'Benjamin', 'bmarty', 'bmarty', 1);
INSERT INTO DIR_ETUDES (NOM, PRENOM, LOGIN, PASSWORD, ID_FILIERE) VALUES ('STALLMAN', 'Richard', 'rstallman', 'rstallman', 2);

INSERT INTO ETUDIANT (NOM, PRENOM, LOGIN, PASSWORD, NB_PROB_AUTORISE_JOUR, ID_FILIERE) VALUES ('SABARON', 'Benjamin', 'bsabaron', 'bsabaron', 10, 1);
INSERT INTO ETUDIANT (NOM, PRENOM, LOGIN, PASSWORD, NB_PROB_AUTORISE_JOUR, ID_FILIERE) VALUES ('GATES', 'Bill', 'bgates', 'bgates', 10, 1);
INSERT INTO ETUDIANT (NOM, PRENOM, LOGIN, PASSWORD, NB_PROB_AUTORISE_JOUR, ID_FILIERE) VALUES ('MUSK', 'Elon', 'emusk', 'emusk', 10, 2);
INSERT INTO ETUDIANT (NOM, PRENOM, LOGIN, PASSWORD, NB_PROB_AUTORISE_JOUR, ID_FILIERE) VALUES ('SNOWDEN', 'Edward', 'esnowden', 'esnowden', 10, 2);

INSERT INTO STATUS (LIBELLE)VALUES('En cours');
INSERT INTO STATUS (LIBELLE)VALUES('Résolu');

INSERT INTO PROBLEME (CONTENU, DATE_HEURE_PROBLEME, OBJET, NB_VOTE, ID_ETUDIANT, ID_STATUS) VALUES ('contenu du probleme 1', 111217154156, 'probleme 1', 2, 1, 1);
INSERT INTO PROBLEME (CONTENU, DATE_HEURE_PROBLEME, OBJET, NB_VOTE, ID_ETUDIANT, ID_STATUS) VALUES ('contenu du probleme 2', 111217154156, 'probleme 2', 1, 2, 1);
INSERT INTO PROBLEME (CONTENU, DATE_HEURE_PROBLEME, OBJET, NB_VOTE, ID_ETUDIANT, ID_STATUS) VALUES ('contenu du probleme 3', 111217154156, 'probleme 3', 2, 3, 1);
INSERT INTO PROBLEME (CONTENU, DATE_HEURE_PROBLEME, OBJET, NB_VOTE, ID_ETUDIANT, ID_STATUS) VALUES ('contenu du probleme 4', 111217154156, 'probleme 4', 1, 4, 1);
INSERT INTO PROBLEME (CONTENU, DATE_HEURE_PROBLEME, OBJET, NB_VOTE, ID_ETUDIANT, ID_STATUS) VALUES ('contenu du probleme 5', 111217154156, 'probleme 5', 0, 1, 2);
INSERT INTO PROBLEME (CONTENU, DATE_HEURE_PROBLEME, OBJET, NB_VOTE, ID_ETUDIANT, ID_STATUS) VALUES ('contenu du probleme 6', 111217154156, 'probleme 6', 1, 3, 2);

INSERT INTO NOTIFICATION (CONTENU, DATE_HEURE_NOTIF, ID_DIR_ETUDES, ID_DIR_ETABLISSEMENT) VALUES ('contenu du notif 1', 111217154156, 1, null);
INSERT INTO NOTIFICATION (CONTENU, DATE_HEURE_NOTIF, ID_DIR_ETUDES, ID_DIR_ETABLISSEMENT) VALUES ('contenu du notif 2', 111217154156, 2, null);
INSERT INTO NOTIFICATION (CONTENU, DATE_HEURE_NOTIF, ID_DIR_ETUDES, ID_DIR_ETABLISSEMENT) VALUES ('contenu du notif 3', 111217154156, null, 1);
INSERT INTO NOTIFICATION (CONTENU, DATE_HEURE_NOTIF, ID_DIR_ETUDES, ID_DIR_ETABLISSEMENT) VALUES ('contenu du notif 4', 111217154156, null, 1);

INSERT INTO VOTER (ID_ETUDIANT, ID_PROBLEME) VALUES (1, 1);
INSERT INTO VOTER (ID_ETUDIANT, ID_PROBLEME) VALUES (2, 1);
INSERT INTO VOTER (ID_ETUDIANT, ID_PROBLEME) VALUES (3, 2);
INSERT INTO VOTER (ID_ETUDIANT, ID_PROBLEME) VALUES (4, 3);
INSERT INTO VOTER (ID_ETUDIANT, ID_PROBLEME) VALUES (1, 6);
INSERT INTO VOTER (ID_ETUDIANT, ID_PROBLEME) VALUES (1, 3);
INSERT INTO VOTER (ID_ETUDIANT, ID_PROBLEME) VALUES (2, 4);

INSERT INTO RECEVOIR (ID_NOTIFICATION, ID_ETUDIANT) VALUES (1, 1);
INSERT INTO RECEVOIR (ID_NOTIFICATION, ID_ETUDIANT) VALUES (1, 2);
INSERT INTO RECEVOIR (ID_NOTIFICATION, ID_ETUDIANT) VALUES (2, 3);
INSERT INTO RECEVOIR (ID_NOTIFICATION, ID_ETUDIANT) VALUES (2, 4);
INSERT INTO RECEVOIR (ID_NOTIFICATION, ID_ETUDIANT) VALUES (3, 1);
INSERT INTO RECEVOIR (ID_NOTIFICATION, ID_ETUDIANT) VALUES (3, 2);
INSERT INTO RECEVOIR (ID_NOTIFICATION, ID_ETUDIANT) VALUES (3, 3);
INSERT INTO RECEVOIR (ID_NOTIFICATION, ID_ETUDIANT) VALUES (3, 4);
INSERT INTO RECEVOIR (ID_NOTIFICATION, ID_ETUDIANT) VALUES (4, 1);
INSERT INTO RECEVOIR (ID_NOTIFICATION, ID_ETUDIANT) VALUES (4, 2);
INSERT INTO RECEVOIR (ID_NOTIFICATION, ID_ETUDIANT) VALUES (4, 3);
INSERT INTO RECEVOIR (ID_NOTIFICATION, ID_ETUDIANT) VALUES (4, 4);


ALTER TABLE filiere ADD FOREIGN KEY (id_dir_etudes) REFERENCES dir_etudes(id_dir_etudes);
ALTER TABLE probleme ADD FOREIGN KEY (id_etudiant) REFERENCES etudiant(id_etudiant);
ALTER TABLE probleme ADD FOREIGN KEY (id_status) REFERENCES status(id_status);
ALTER TABLE etudiant ADD FOREIGN KEY (id_filiere) REFERENCES filiere(id_filiere);
ALTER TABLE notification ADD FOREIGN KEY (id_dir_etudes) REFERENCES dir_etudes(id_dir_etudes);
ALTER TABLE notification ADD FOREIGN KEY (id_dir_etablissement) REFERENCES dir_etablissement(id_dir_etablissement);
ALTER TABLE dir_etudes ADD FOREIGN KEY (id_filiere) REFERENCES filiere(id_filiere);
ALTER TABLE voter ADD FOREIGN KEY (id_etudiant) REFERENCES etudiant(id_etudiant);
ALTER TABLE voter ADD FOREIGN KEY (id_probleme) REFERENCES probleme(id_probleme);
ALTER TABLE recevoir ADD FOREIGN KEY (id_notification) REFERENCES notification(id_notification);
ALTER TABLE recevoir ADD FOREIGN KEY (id_etudiant) REFERENCES etudiant(id_etudiant);


