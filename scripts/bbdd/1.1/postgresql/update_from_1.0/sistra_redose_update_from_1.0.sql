alter table RDS_DOCUM add DOC_IDIOMA VARCHAR(2);
alter table RDS_DOCUM add DOC_REFGD VARCHAR(4000);
update RDS_DOCUM set DOC_REFGD = '#NOCONSOLIDABLE#';

INSERT INTO RDS_MODELO (
   MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, 
   MOD_DESC, MOD_ESTRUC, MOD_CUSTOD) 
VALUES (nextval('RDS_SEQMOD'), 'GE0012DELEGA','Autorización de delegación' ,
	   'Autorización de delegación', 'S', 'N');
	   
INSERT INTO RDS_VERS (
   VER_CODIGO, 
   VER_CODMOD, 
   VER_VERSIO, 
   VER_DESC) 
VALUES (
	nextval('RDS_SEQVER'), 
	(SELECT MOD_CODIGO FROM RDS_MODELO WHERE MOD_MODELO = 'GE0012DELEGA'),
	 1, 'Version 1');	   
	   
INSERT INTO RDS_TIUSO ( TIU_CODIGO, TIU_NOMBRE ) VALUES ('DLG', 'DELEGACION'); 

CREATE TABLE RDS_LOGEGD
(
  LOG_CODIGO  INT8                        NOT NULL,
  LOG_SEYCON  VARCHAR(1536)               NOT NULL,
  LOG_DESERR  VARCHAR(4000)               NOT NULL,
  LOG_ERROR   bytea                       NOT NULL,
  LOG_FECHA   timestamp                   NOT NULL,
  LOG_CODDOC  INT8                        NOT NULL
);

ALTER TABLE RDS_LOGEGD ADD CONSTRAINT RDS_LOGEGD_PK PRIMARY KEY (LOG_CODIGO);
ALTER TABLE RDS_LOGEGD ADD FOREIGN KEY (LOG_CODDOC) REFERENCES RDS_DOCUM (DOC_CODIGO);

CREATE SEQUENCE RDS_SEQLGD;

ALTER TABLE RDS_MODELO ALTER COLUMN MOD_MODELO TYPE VARCHAR(20);

-- From 1.1.6

INSERT INTO RDS_MODELO (
   MOD_CODIGO, 
   MOD_MODELO, 
   MOD_NOMBRE, 
   MOD_DESC, 
   MOD_ESTRUC, 
   MOD_CUSTOD) 
VALUES (
  NEXTVAL('RDS_SEQMOD'), 
'GE0013NOTIFEXT', 
'Modelo documento externo notificacion', 
'Usado para documentos externos de anexos de notificaciones y avisos en los que se indica una url al documento. En el redose se almacenara un xml con la url de acceso',
'S',
'N');

INSERT INTO RDS_VERS (
   VER_CODIGO, VER_CODMOD, VER_VERSIO, 
   VER_DESC) 
VALUES ( NEXTVAL('RDS_SEQVER'),
 (SELECT MOD_CODIGO FROM RDS_MODELO WHERE MOD_MODELO = 'GE0013NOTIFEXT'),
 1,
 'VERSION 1');

 
 alter table RDS_USOS alter column USO_REF type VARCHAR(100);

