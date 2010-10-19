alter table RDS_DOCUM  add DOC_IDIOMA           VARCHAR2(2);

alter table RDS_DOCUM  add  DOC_REFGD            VARCHAR2(4000);

comment on column RDS_DOCUM.DOC_IDIOMA is
'PARA DOCUMENTOS ESTRUCTURADOS INDICA EL IDIOMA POR DEFECTO DE VISUALIZACIÓN. SI NO SE ESPECIFICA COGERA "CA".';

comment on column RDS_DOCUM.DOC_REFGD is
'EN CASO DE QUE EL RDS SE SINCRONIZE CON UN GESTOR DOCUMENTAL, INDICA LA REFERENCIA DEL DOCUMENTO EN EL GESTOR DOCUMENTAL.
PARA QUE NO SE MIGREN LOS DOCUMENTOS ANTIGUOS SE MARCARAN CON "#NOCONSOLIDABLE#", INDICANDO QUE NO SE MIGRARAN.';


update RDS_DOCUM  set  DOC_REFGD = '#NOCONSOLIDABLE#';


INSERT INTO RDS_MODELO (
   MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, 
   MOD_DESC, MOD_ESTRUC, MOD_CUSTOD) 
VALUES (RDS_SEQMOD.NEXTVAL , 'GE0012DELEGA','Autorización de delegación' ,
	   'Autorización de delegación', 'S', 'N');

INSERT INTO RDS_VERS (
   VER_CODIGO, 
   VER_CODMOD, 
   VER_VERSIO, 
   VER_DESC) 
VALUES (
	RDS_SEQVER.NEXTVAL , 
	(SELECT MOD_CODIGO FROM RDS_MODELO WHERE MOD_MODELO = 'GE0012DELEGA')  ,
	 1 ,
	 'Version 1' );	   
commit;	   

INSERT INTO RDS_TIUSO ( TIU_CODIGO, TIU_NOMBRE ) VALUES ( 
'DLG', 'DELEGACION'); 
COMMIT;


CREATE TABLE RDS_LOGEGD
(
  LOG_CODIGO  NUMBER(20)                        NOT NULL,
  LOG_SEYCON  VARCHAR2(1536 BYTE)               NOT NULL,
  LOG_DESERR  VARCHAR2(1000 BYTE)               NOT NULL,
  LOG_ERROR   BLOB                              NOT NULL,
  LOG_FECHA   DATE                              NOT NULL,
  LOG_CODDOC  NUMBER(20)                        NOT NULL
);
COMMENT ON TABLE RDS_LOGEGD IS 'LOG DE ERRORES DEL GESTOR DOCUMENTAL';
COMMENT ON COLUMN RDS_LOGEGD.LOG_CODIGO IS 'CODIGO';
COMMENT ON COLUMN RDS_LOGEGD.LOG_SEYCON IS 'USUARIO SEYCON';
COMMENT ON COLUMN RDS_LOGEGD.LOG_DESERR IS 'DESCRIPCION DEL ERROR';
COMMENT ON COLUMN RDS_LOGEGD.LOG_ERROR IS 'TRAZA DEL ERROR';
COMMENT ON COLUMN RDS_LOGEGD.LOG_FECHA IS 'FECHA DEL ERROR';

CREATE UNIQUE INDEX RDS_LOGEGD_PK ON RDS_LOGEGD  (LOG_CODIGO);

ALTER TABLE RDS_LOGEGD ADD CONSTRAINT RDS_LOGEGD_PK PRIMARY KEY (LOG_CODIGO);

ALTER TABLE RDS_LOGEGD ADD FOREIGN KEY (LOG_CODDOC)  REFERENCES RDS_DOCUM (DOC_CODIGO);
commit;

CREATE SEQUENCE RDS_SEQLGD;

ALTER TABLE RDS_MODELO MODIFY MOD_MODELO VARCHAR2(20);
