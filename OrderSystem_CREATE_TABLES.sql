/* Drop existing tables, if needed */
DROP TABLE ARTICLES CASCADE CONSTRAINTS;
DROP TABLE COMMANDES CASCADE CONSTRAINTS;
DROP TABLE COMMANDES_ARTICLES CASCADE CONSTRAINTS;
DROP TABLE PROFILS CASCADE CONSTRAINTS;
DROP TABLE UTILISATEURS CASCADE CONSTRAINTS;
DROP TABLE EMPLOYES CASCADE CONSTRAINTS;

/* Create new tables */
CREATE TABLE ARTICLES (
  ID          number(10) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1), 
  CODE        varchar2(25) NOT NULL, 
  NOM         varchar2(100) NOT NULL, 
  DESCRIPTION varchar2(255), 
  PRIX        float(10) NOT NULL, 
  CONSTRAINT PK_ARTICLES 
    PRIMARY KEY (ID));
	
CREATE TABLE COMMANDES (
  ID             number(10) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1), 
  UTILISATEUR_ID number(10) NOT NULL, 
  NO_REFERENCE   varchar2(50) NOT NULL, 
  CALC_COUT      float(10), 
  CONSTRAINT PK_COMMANDES 
    PRIMARY KEY (ID));
	
CREATE TABLE COMMANDES_ARTICLES (
  COMMANDE_ID number(10) NOT NULL, 
  ARTICLE_ID  number(10) NOT NULL, 
  CONSTRAINT PK_COMMANDES_ARTICLES 
    PRIMARY KEY (COMMANDE_ID, 
  ARTICLE_ID));
  
CREATE TABLE PROFILS (
  ID                 number(10) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1), 
  UTILISATEUR_ID     number(10) NOT NULL, 
  INSCRIT_NEWSLETTER number DEFAULT 0 NOT NULL, 
  LANGUE             varchar2(5) NOT NULL, 
  CONSTRAINT ID_PROFILS 
    PRIMARY KEY (ID));
	
CREATE TABLE UTILISATEURS (
  ID       number(10) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1), 
  USERNAME varchar2(50) NOT NULL UNIQUE, 
  NOM      varchar2(50) NOT NULL, 
  PRENOM   varchar2(50) NOT NULL, 
  EMAIL    varchar2(150) NOT NULL, 
  CONSTRAINT PK_UTILISATEURS 
    PRIMARY KEY (ID));

CREATE TABLE EMPLOYES (
  ID     number(10) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1), 
  NOM    varchar2(50) NOT NULL, 
  PRENOM varchar2(50) NOT NULL, 
  RUE    varchar2(50) NOT NULL, 
  RUE_NO varchar2(5) NOT NULL, 
  CONSTRAINT PK_EMPLOYES 
    PRIMARY KEY (ID));

/* Add FK constraints */
ALTER TABLE COMMANDES_ARTICLES ADD CONSTRAINT FK_ARTICLES_CA FOREIGN KEY (ARTICLE_ID) REFERENCES ARTICLES (ID);
ALTER TABLE COMMANDES_ARTICLES ADD CONSTRAINT FK_COMMANDES_CA FOREIGN KEY (COMMANDE_ID) REFERENCES COMMANDES (ID);
ALTER TABLE COMMANDES ADD CONSTRAINT FK_UTILISATEURS_COMMANDES FOREIGN KEY (UTILISATEUR_ID) REFERENCES UTILISATEURS (ID);
ALTER TABLE PROFILS ADD CONSTRAINT FK_UTILISATEURS_PROFILS FOREIGN KEY (UTILISATEUR_ID) REFERENCES UTILISATEURS (ID);


