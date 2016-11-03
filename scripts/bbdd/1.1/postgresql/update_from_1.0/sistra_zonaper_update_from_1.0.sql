create table ZPE_REGEXT  (
   REG_CODIGO           INT8                      not null,
   REG_NIVAUT           CHAR(1),
   REG_DESC             VARCHAR(200)              not null,
   REG_USER             VARCHAR(1536),
   REG_NUMREG           VARCHAR(50)               not null,
   REG_FECHA            timestamp                 not null,
   REG_CODASI           INT8                      not null,
   REG_CLAASI           VARCHAR(10)               not null,
   REG_CODJUS           INT8                      not null,
   REG_CLAJUS           VARCHAR(10)               not null,
   REG_IDIOMA           VARCHAR(2)                not null,
   REG_NIFRTE           VARCHAR(12),
   REG_NOMRTE           VARCHAR(500),
   REG_NIFRDO           VARCHAR(12),
   REG_NOMRDO           VARCHAR(500)
);

alter table ZPE_REGEXT
   add constraint ZPE_REG_PK primary key (REG_CODIGO);
  
create table ZPE_DOCREG  (
   DRE_CODIGO           INT8                      not null,
   DRE_CODREG           INT8                      not null,
   DRE_DOCIDE           VARCHAR(5)                not null,
   DRE_DOCNUM           INT4                      not null,
   DRE_DESC             VARCHAR(500)              not null,
   DRE_RDSCOD           INT8                      not null,
   DRE_RDSCLA           VARCHAR(10)               not null
);

alter table ZPE_DOCREG
   add constraint ZPE_DRE_PK primary key (DRE_CODIGO);
alter table ZPE_DOCREG
   add constraint ZPE_REREG_FK foreign key (DRE_CODREG)
      references ZPE_REGEXT (REG_CODIGO);
   
create table ZPE_REGLOG  (
   RLG_TIPREG           VARCHAR(1)                  not null,
   RLG_NUMREG           VARCHAR(50)                  not null,
   RLG_FECREG           timestamp                   not null,
   RLG_ERROR            VARCHAR(2000),
   RLG_ANULAD           VARCHAR(1)
);

alter table ZPE_REGLOG
   add constraint ZPE_RLG_PK primary key (RLG_TIPREG, RLG_NUMREG);

create sequence ZPE_SEQREG;
create sequence ZPE_SEQDRE;
 
ALTER TABLE ZPE_EXPEDI ADD EXP_NIFRTE VARCHAR(12);

ALTER TABLE ZPE_PERSON ADD PER_DELEGA VARCHAR(1) default 'N' not null;

UPDATE ZPE_EXPEDI
SET 
	EXP_NIFRTE = (SELECT PER_IDENTI FROM ZPE_PERSON WHERE PER_SEYCON = EXP_SEYCIU )
WHERE 
	EXP_SEYCIU IS NOT NULL;

create sequence ZPE_SEQDEL;

create table ZPE_DELEGA  (
   DEL_CODIGO           INT8                      not null,
   DEL_DLGTE            VARCHAR(12)               not null,
   DEL_DLGDO            VARCHAR(12)               not null,
   DEL_PERMIS           VARCHAR(10)               not null,
   DEL_INIDLG           timestamp                 not null,
   DEL_FINDLG           timestamp                 not null,
   DEL_CODRDS           INT8                      not null,
   DEL_CLARDS           VARCHAR(10)               not null,
   DEL_ANULAD           VARCHAR(1)                default 'N' not null
);

alter table ZPE_DELEGA
   add constraint ZPE_DEL_PK primary key (DEL_CODIGO);

-- En Postgresql vistes s'han de borrar perquè sinó no permet modificar llista de camps.
DROP VIEW ZPE_ESTEXP;
CREATE OR REPLACE VIEW ZPE_ESTEXP
(EST_ID, EST_TIPO, EST_CODIGO, EST_DESC, EST_FECINI, 
 EST_FECFIN, EST_ESTADO, EST_AUTENT, EST_USER, EST_NIFRTE, EST_NIFRDO, 
 EST_IDIOMA, EST_CODEXP, EST_UNIADM)
AS 
(
SELECT 'T' || ENT_CODIGO, 'T',ENT_CODIGO,ENT_DESC,ENT_FECHA,ENT_FECHA,'SE', 
	CASE WHEN ENT_NIVAUT = 'A' THEN 'N' ELSE 'S' END, 
	CASE WHEN ENT_NIVAUT = 'A' THEN ENT_IDEPER ELSE ENT_USER END,
	CASE WHEN ENT_NIVAUT = 'A' THEN NULL ELSE ENT_NIFRTE END,
	ENT_NIFRDO,ENT_IDIOMA,NULL,cast(NULL as int8)
FROM ZPE_ENTTEL
WHERE 
ENT_CODIGO NOT IN 
(
 SELECT ELE_CODELE FROM ZPE_ELEEX WHERE ELE_TIPO = 'T'
)

UNION

SELECT  'P' || PRE_CODIGO,'P',PRE_CODIGO,PRE_DESC,PRE_FECHA,PRE_FECHA, 
	CASE WHEN PRE_FECREG IS NOT NULL THEN 'SE' ELSE 'SP' END,
	CASE WHEN PRE_NIVAUT = 'A' THEN 'N' ELSE 'S' END, 
	CASE WHEN PRE_NIVAUT = 'A' THEN PRE_IDEPER ELSE PRE_USER END, 
	CASE WHEN PRE_NIVAUT = 'A' THEN NULL ELSE PRE_NIFRTE END,
	PRE_NIFRDO,PRE_IDIOMA,NULL,cast(NULL as int8)
FROM ZPE_PREREG
WHERE 
PRE_CODIGO NOT IN 
(
 SELECT ELE_CODELE FROM ZPE_ELEEX WHERE ELE_TIPO = 'P'
)

UNION

SELECT  'E' || EXP_CODIGO,'E',EXP_CODIGO,EXP_DESC,EXP_FECINI,EXP_FECULT,EXP_ESTADO,'S',EXP_SEYCIU, EXP_NIFRTE, EXP_NIFRDO,EXP_IDIOMA,EXP_IDEXP,EXP_UNIADM
FROM ZPE_EXPEDI
WHERE EXP_SEYCIU IS NOT NULL

UNION

SELECT 'E' || EXP_CODIGO,'E',EXP_CODIGO,EXP_DESC,EXP_FECINI,EXP_FECULT,EXP_ESTADO,'N',ENT_IDEPER, NULL, EXP_NIFRDO,EXP_IDIOMA,EXP_IDEXP,EXP_UNIADM
FROM ZPE_EXPEDI,ZPE_ELEEX,ZPE_ENTTEL
WHERE EXP_SEYCIU IS NULL AND
	  EXP_CODIGO = ELE_CODEXP AND
	  ELE_TIPO = 'T' AND ELE_CODELE = ENT_CODIGO
      
UNION
	  
SELECT 'E' || EXP_CODIGO,'E',EXP_CODIGO,EXP_DESC,EXP_FECINI,EXP_FECULT,EXP_ESTADO,'N',PRE_IDEPER, NULL, EXP_NIFRDO,EXP_IDIOMA,EXP_IDEXP,EXP_UNIADM
FROM ZPE_EXPEDI,ZPE_ELEEX,ZPE_PREREG
WHERE EXP_SEYCIU IS NULL AND
	  EXP_CODIGO = ELE_CODEXP AND
	  ELE_TIPO = 'P' AND ELE_CODELE = PRE_CODIGO      	  
);


ALTER table ZPE_TRAPER ADD TPE_DELEGA VARCHAR(1536);

ALTER table ZPE_ENTTEL ADD ENT_NIFDLG VARCHAR(12);
ALTER table ZPE_ENTTEL ADD ENT_NOMDLG VARCHAR(500);

ALTER table ZPE_PREBCK ADD PRB_NIFDLG VARCHAR(12);
ALTER table ZPE_PREBCK ADD PRB_NOMDLG VARCHAR(500);

ALTER table ZPE_TRAPER ADD TPE_DLGEST VARCHAR(2);

ALTER table ZPE_DOCPER ADD DPE_DLGEST VARCHAR(2);
ALTER table ZPE_DOCPER ADD DPE_DLGFIR VARCHAR(4000);
ALTER table ZPE_DOCPER ADD DPE_DLGFIP VARCHAR(4000);  

ALTER TABLE ZPE_PREREG ADD PRE_NIFDLG VARCHAR(12);
ALTER TABLE ZPE_PREREG ADD PRE_NOMDLG VARCHAR(500);

create table ZPE_SUBPAR  (
   SBP_CODIGO           VARCHAR(50)               not null,
   SBP_UNIADM           INT8                      not null,
   SBP_IDEXP            VARCHAR(50)               not null,
   SBP_PARAMS           VARCHAR(4000),
   SBP_FECHA            timestamp                 not null
);

alter table ZPE_SUBPAR
   add constraint ZPE_SBP_PK primary key (SBP_CODIGO);
   
ALTER TABLE ZPE_NOTTEL ADD NOT_SUBDES VARCHAR(500);
ALTER TABLE ZPE_NOTTEL ADD NOT_SUBIDE VARCHAR(10);
ALTER TABLE ZPE_NOTTEL ADD NOT_SUBVER INT4;
ALTER TABLE ZPE_NOTTEL ADD NOT_SUBPAR VARCHAR(4000);

ALTER TABLE zpe_enttel ADD ent_sbexid VARCHAR(50);
ALTER TABLE zpe_enttel ADD ent_sbexua INT8;

ALTER TABLE zpe_prebck ADD prb_sbexid VARCHAR(50);
ALTER TABLE zpe_prebck ADD prb_sbexua INT8;

ALTER TABLE zpe_prereg ADD pre_sbexid VARCHAR(50);
ALTER TABLE zpe_prereg ADD pre_sbexua INT8;

ALTER TABLE ZPE_PERSON ADD PER_SEYMOD VARCHAR(4000);

ALTER TABLE ZPE_TRAPER ALTER COLUMN TPE_TRAMOD TYPE VARCHAR(20);
ALTER TABLE ZPE_TPEBCK ALTER COLUMN TPB_TRAMOD TYPE VARCHAR(20);
ALTER TABLE ZPE_ENTTEL ALTER COLUMN ENT_TRAMOD TYPE VARCHAR(20);
ALTER TABLE ZPE_PREREG ALTER COLUMN PRE_TRAMOD TYPE VARCHAR(20);
ALTER TABLE ZPE_PREBCK ALTER COLUMN PRB_TRAMOD TYPE VARCHAR(20);
ALTER TABLE ZPE_NOTTEL ALTER COLUMN NOT_SUBIDE TYPE VARCHAR(20);

-- From 1.1.1 to 1.1.2

create table ZPE_RGPEXT  (
   RGP_RDSCOD           int8                      not null,
   RGP_RDSCLA           varchar(10)               not null,
   RGP_RDSANE           varchar(4000),
   RGP_IDEPER           varchar(50)               not null,
   RGP_FECINI           timestamp                 not null,
   RGP_FECFIN           timestamp                 not null,
   primary key (RGP_RDSCOD)
);

-- From 1.1.3 to 1.1.4

CREATE SEQUENCE ZPE_SEQIND;

create table ZPE_INDELE  (
   IND_CODIGO           BIGINT                          not null,
   IND_NIF              VARCHAR(10)                    not null,
   IND_TIPEL            VARCHAR(1)                     not null,
   IND_CODEL            BIGINT                      not null,
   IND_DESCR            VARCHAR(1000)                  not null,
   IND_VALOR            VARCHAR(4000)
);

comment on table ZPE_INDELE is
'Indices de búsqueda asociadas a elementos de un expediente (solo para autenticados)';

comment on column ZPE_INDELE.IND_CODIGO is
'Codigo interno';

comment on column ZPE_INDELE.IND_NIF is
'Nif asociado';

comment on column ZPE_INDELE.IND_TIPEL is
'Tipo elemento: Expediente (E) / Tramite telematico (T) / Tramite preregistro (P) / Notificacion (N) / Aviso (A)';

comment on column ZPE_INDELE.IND_CODEL is
'Codigo elemento';

comment on column ZPE_INDELE.IND_DESCR is
'Descripcion campo';

comment on column ZPE_INDELE.IND_VALOR is
'Valor campo';

alter table ZPE_INDELE
   add constraint ZPE_INDELE_PK primary key (IND_CODIGO);

create index ZPE_INDELE_IDX on ZPE_INDELE (
   IND_NIF ASC
);



/* ENTRADAS PREREGISTROS */

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
	SELECT NEXTVAL('ZPE_SEQIND'), PRE_NIFRTE, 'P', PRE_CODIGO, 'Número preregistro', PRE_NUMPRE
        FROM  ZPE_PREREG
        WHERE  PRE_NIVAUT <> 'A' AND PRE_NIFRTE IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
	SELECT NEXTVAL('ZPE_SEQIND'), PRE_NIFRTE, 'P', PRE_CODIGO, 'Número registro', PRE_NUMREG
        FROM  ZPE_PREREG
        WHERE  PRE_NIVAUT <> 'A'  AND PRE_NIFRTE IS NOT NULL AND PRE_NUMREG IS NOT NULL;
 
INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
	SELECT NEXTVAL('ZPE_SEQIND'), PRE_NIFRTE, 'P', PRE_CODIGO, 'Título trámite', PRE_DESC
        FROM  ZPE_PREREG
        WHERE  PRE_NIVAUT <> 'A'  AND PRE_NIFRTE IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
	SELECT NEXTVAL('ZPE_SEQIND'), PRE_NIFRTE, 'P', PRE_CODIGO, 'Nif representado', PRE_NIFRDO
        FROM  ZPE_PREREG
        WHERE  PRE_NIVAUT <> 'A' AND PRE_NIFRTE IS NOT NULL AND PRE_NIFRDO IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
	SELECT NEXTVAL('ZPE_SEQIND'), PRE_NIFRTE, 'P', PRE_CODIGO, 'Nombre representado', PRE_NOMRDO
        FROM  ZPE_PREREG
        WHERE  PRE_NIVAUT <> 'A' AND PRE_NIFRTE IS NOT NULL AND PRE_NOMRDO IS NOT NULL;

				
/* DOCS ENTRADAS PREREGISTROS */
INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR)
SELECT NEXTVAL('ZPE_SEQIND'), PRE_NIFRTE, 'P', PRE_CODIGO,  DPR_DOCIDE || '(' || to_char(DPR_DOCNUM, '999') || ')', DPR_DESC
FROM ZPE_DOCPRE, ZPE_PREREG 
WHERE PRE_CODIGO = DPR_CODPRE AND PRE_NIVAUT <> 'A' AND PRE_NIFRTE IS NOT NULL AND DPR_DOCIDE <> 'DTP';

/* ENTRADAS TELEMATICAS */
INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT NEXTVAL('ZPE_SEQIND'), ENT_NIFRTE, 'T', ENT_CODIGO, 'Número registro', ENT_NUMREG
    FROM ZPE_ENTTEL 
       WHERE ENT_NIVAUT <> 'A' AND ENT_NIFRTE IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT NEXTVAL('ZPE_SEQIND'), ENT_NIFRTE, 'T', ENT_CODIGO, 'Título trámite', ENT_DESC
    FROM ZPE_ENTTEL 
       WHERE ENT_NIVAUT <> 'A'  AND ENT_NIFRTE IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT NEXTVAL('ZPE_SEQIND'), ENT_NIFRTE, 'T', ENT_CODIGO, 'Nif representado', ENT_NIFRDO
    FROM ZPE_ENTTEL 
       WHERE ENT_NIVAUT <> 'A' AND ENT_NIFRTE IS NOT NULL AND ENT_NIFRDO IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT NEXTVAL('ZPE_SEQIND'), ENT_NIFRTE, 'T', ENT_CODIGO, 'Nombre representado', ENT_NOMRDO
    FROM ZPE_ENTTEL 
      WHERE ENT_NIVAUT <> 'A' AND ENT_NIFRTE IS NOT NULL AND ENT_NOMRDO IS NOT NULL;

/* DOCS ENTRADAS TELEMATICAS */
INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT NEXTVAL('ZPE_SEQIND'), ENT_NIFRTE, 'T', ENT_CODIGO, DEN_DOCIDE || '(' || to_char(DEN_DOCNUM,'999') || ')', DEN_DESC
    FROM ZPE_ENTTEL, ZPE_DOCENT
      WHERE 
        ENT_NIVAUT <> 'A'  AND ENT_NIFRTE IS NOT NULL  AND ENT_CODIGO =  DEN_CODENT AND DEN_DOCIDE <> 'DTP';

/* EVENTOS EXPEDIENTES */
INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT NEXTVAL('ZPE_SEQIND'), EXP_NIFRTE, 'A', HIE_CODIGO, 'Título', HIE_TITULO
    FROM ZPE_HISTEX, ZPE_EXPEDI, ZPE_ELEEX 
       WHERE EXP_SEYCIU IS NOT NULL AND EXP_NIFRTE IS NOT NULL AND
            EXP_CODIGO = ELE_CODEXP AND ELE_TIPO = 'A' AND ELE_CODELE = HIE_CODIGO AND HIE_TITULO IS NOT NULL;
					 
INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT NEXTVAL('ZPE_SEQIND'), EXP_NIFRTE, 'A', HIE_CODIGO, 'Texto', HIE_TEXTO
    FROM ZPE_HISTEX, ZPE_EXPEDI, ZPE_ELEEX 
       WHERE EXP_SEYCIU IS NOT NULL AND EXP_NIFRTE IS NOT NULL AND
            EXP_CODIGO = ELE_CODEXP AND ELE_TIPO = 'A' AND ELE_CODELE = HIE_CODIGO AND HIE_TEXTO IS NOT NULL;
			
/* INDICES EXPEDIENTES */
INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT NEXTVAL('ZPE_SEQIND'), EXP_NIFRTE, 'E', EXP_CODIGO, 'Número expediente', EXP_IDEXP FROM ZPE_EXPEDI
                    WHERE EXP_SEYCIU IS NOT NULL AND EXP_NIFRTE IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT NEXTVAL('ZPE_SEQIND'), EXP_NIFRTE, 'E', EXP_CODIGO, 'Título', EXP_DESC FROM ZPE_EXPEDI
                    WHERE EXP_SEYCIU IS NOT NULL  AND EXP_NIFRTE IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT NEXTVAL('ZPE_SEQIND'), EXP_NIFRTE, 'E', EXP_CODIGO, 'Nif representado', EXP_NIFRDO FROM ZPE_EXPEDI
                    WHERE EXP_SEYCIU IS NOT NULL  AND EXP_NIFRTE IS NOT NULL AND EXP_NIFRDO IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT NEXTVAL('ZPE_SEQIND'), EXP_NIFRTE, 'E', EXP_CODIGO, 'Nombre representado', EXP_NOMRDO FROM ZPE_EXPEDI
                    WHERE EXP_SEYCIU IS NOT NULL  AND EXP_NIFRTE IS NOT NULL AND EXP_NOMRDO IS NOT NULL;

-- From 1.1.6


alter table  ZPE_ENTTEL add ENT_IDEPRO  VARCHAR(100);

comment on column ZPE_ENTTEL.ENT_IDEPRO is 'IDENTIFICADOR PROCEDIMIENTO';

alter table  ZPE_PREREG add PRE_IDEPRO  VARCHAR(100);

comment on column ZPE_PREREG.PRE_IDEPRO is 'IDENTIFICADOR PROCEDIMIENTO';

alter table  ZPE_PREBCK add PRB_IDEPRO  VARCHAR(100);

comment on column ZPE_PREBCK.PRB_IDEPRO is 'IDENTIFICADOR PROCEDIMIENTO';

alter table ZPE_EXPEDI  add  EXP_IDEPRO   VARCHAR(100)  ;

UPDATE ZPE_ENTTEL SET ENT_IDEPRO = ENT_TRAMOD;
UPDATE  ZPE_PREREG SET PRE_IDEPRO = PRE_TRAMOD;
UPDATE ZPE_PREBCK SET PRB_IDEPRO = PRB_TRAMOD;

UPDATE ZPE_ENTTEL SET ENT_IDEPRO = '#DESCONOCIDO#' WHERE   ENT_IDEPRO IS NULL;
UPDATE  ZPE_PREREG SET PRE_IDEPRO = '#DESCONOCIDO#' WHERE  PRE_IDEPRO IS NULL;
UPDATE ZPE_PREBCK SET PRB_IDEPRO =  '#DESCONOCIDO#' WHERE  PRB_IDEPRO IS NULL; 

COMMIT;

CREATE VIEW TMP_TRAMITS_INI_EXPE (CODEXPE, TIPOTRAM, CODTRAM) AS
(
SELECT E1.ELE_CODEXP, E1.ELE_TIPO, E1.ELE_CODELE
FROM ZPE_ELEEX E1
WHERE E1.ELE_TIPO IN ('T', 'P') AND
 E1.ELE_FECHA = (SELECT MIN(E2.ELE_FECHA) FROM  ZPE_ELEEX E2 WHERE E2.ELE_CODEXP = E1.ELE_CODEXP) 
);

CREATE VIEW TMP_IDEPRO_EXPE (CODEXPE, IDEPRO) AS 
(
   select EXP_CODIGO, ENT_IDEPRO  FROM TMP_TRAMITS_INI_EXPE, ZPE_ENTTEL, ZPE_EXPEDI WHERE  CODEXPE =  EXP_CODIGO AND TIPOTRAM = 'T' AND ENT_CODIGO = CODTRAM
    UNION
     select EXP_CODIGO, PRE_IDEPRO  FROM TMP_TRAMITS_INI_EXPE, ZPE_PREREG, ZPE_EXPEDI WHERE  CODEXPE =  EXP_CODIGO AND TIPOTRAM = 'P'  AND PRE_CODIGO = CODTRAM  
);

update  ZPE_EXPEDI 
set EXP_IDEPRO = (SELECT IDEPRO FROM TMP_IDEPRO_EXPE WHERE CODEXPE =  EXP_CODIGO )
where EXP_NUMBTE IS NOT null;

COMMIT;

DROP VIEW TMP_IDEPRO_EXPE;
DROP VIEW TMP_TRAMITS_INI_EXPE;

update  ZPE_EXPEDI 
set EXP_IDEPRO = '#DESCONOCIDO#'
where EXP_IDEPRO IS NULL ;

COMMIT;

alter table ZPE_EXPEDI  alter column  EXP_IDEPRO set not null;

--

UPDATE ZPE_EXPEDI  SET EXP_AVISOS = 'N' WHERE EXP_AVISOS IS NULL; 


ALTER TABLE ZPE_EXPEDI ALTER COLUMN EXP_AVISOS SET NOT NULL;

