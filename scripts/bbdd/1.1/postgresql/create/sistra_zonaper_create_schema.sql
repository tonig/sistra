﻿create table ZPE_DOCENT (
   DEN_CODIGO int8 not null,
   DEN_CODENT int8 not null,
   DEN_DOCIDE varchar(5) not null,
   DEN_DOCNUM int4 not null,
   DEN_DESC varchar(500) not null,
   DEN_RDSCOD int8 not null,
   DEN_RDSCLA varchar(10) not null,
   primary key (DEN_CODIGO)
);
create table ZPE_DPRBCK (
   DRB_CODIGO int8 not null,
   DRB_CODPRE int8 not null,
   DRB_PRESE char(1),
   DRB_DOCIDE varchar(5),
   DRB_DOCNUM int4,
   DRB_DESC varchar(500),
   DRB_RDSCOD int8,
   DRB_RDSCLA varchar(10),
   DRB_TIPDOC char(1),
   DRB_COMPUL char(1),
   DRB_FOTPIA char(1),
   DRB_FIRMA char(1),
   DRB_OK char(1),
   primary key (DRB_CODIGO)
);
create table ZPE_ENTTEL (
   ENT_CODIGO int8 not null,
   ENT_IDEPER varchar(255) not null unique,
   ENT_TIPO char(1) not null,
   ENT_NIVAUT char(1) not null,
   ENT_USER varchar(255),
   ENT_DESC varchar(255),
   ENT_NUMREG varchar(50) not null,
   ENT_FECHA timestamp not null,
   ENT_CODASI int8 not null,
   ENT_CLAASI varchar(10) not null,
   ENT_CODJUS int8 not null,
   ENT_CLAJUS varchar(10) not null,
   ENT_IDIOMA varchar(2) not null,
   ENT_NIFRTE varchar(255),
   ENT_NOMRTE varchar(255),
   ENT_NIFRDO varchar(255),
   ENT_NOMRDO varchar(255),
   ENT_TRAMOD varchar(20),
   ENT_TRAVER int4,
   ENT_AVISOS varchar(255),
   ENT_AVISMS varchar(255),
   ENT_AVIEMA varchar(255),
   ENT_NOTTEL varchar(255),
   ENT_NIFDLG VARCHAR(12),
   ENT_NOMDLG VARCHAR(500),
   ent_sbexid VARCHAR(50),
   ent_sbexua INT8,
   ENT_IDEPRO  VARCHAR(100),
   primary key (ENT_CODIGO)
);


comment on column ZPE_ENTTEL.ENT_IDEPRO is 'IDENTIFICADOR PROCEDIMIENTO';


create table ZPE_PREBCK (
   PRB_CODIGO int8 not null,
   PRB_NUMPRE varchar(255) not null unique,
   PRB_FECHA timestamp not null,
   PRB_FECCAD timestamp not null,
   PRB_IDEPER varchar(255) not null unique,
   PRB_TIPO char(1) not null,
   PRB_NIVAUT char(1) not null,
   PRB_USER varchar(255),
   PRB_DESC varchar(255),
   PRB_CODASI int8 not null,
   PRB_CLAASI varchar(10) not null,
   PRB_CODJUS int8 not null,
   PRB_CLAJUS varchar(10) not null,
   PRB_NUMREG varchar(50),
   PRB_FECREG timestamp,
   PRB_IDIOMA varchar(2) not null,
   PRB_NIFRTE varchar(255),
   PRB_NOMRTE varchar(255),
   PRB_NIFRDO varchar(255),
   PRB_NOMRDO varchar(255),
   PRB_TRAMOD varchar(20),
   PRB_TRAVER int4,
   PRB_CONAUT char(1) not null,
   PRB_AVISOS varchar(255),
   PRB_AVISMS varchar(255),
   PRB_AVIEMA varchar(255),
   PRB_NOTTEL char(1) not null,
   PRB_NIFDLG VARCHAR(12),
   PRB_NOMDLG VARCHAR(500),
   prb_sbexid VARCHAR(50),
   prb_sbexua INT8,
   PRB_IDEPRO VARCHAR(100),
   primary key (PRB_CODIGO)
);


comment on column ZPE_PREBCK.PRB_IDEPRO is 'IDENTIFICADOR PROCEDIMIENTO';


create table ZPE_TPEBCK (
   TPB_CODIGO int8 not null,
   TPB_IDEPER varchar(255) not null unique,
   TPB_TRAMOD varchar(20) not null,
   TPB_TRAVER int4 not null,
   TPB_TRADES varchar(200) not null,
   TPB_NIVAUT char(1) not null,
   TPB_USER varchar(255),
   TPB_FLUTRA varchar(255),
   TPB_FECINI timestamp not null,
   TPB_FECMOD timestamp not null,
   TPB_PARINI varchar(4000),
   TPB_FECCAD timestamp not null,
   TPB_IDIOMA varchar(2) not null,
   primary key (TPB_CODIGO)
);

create table ZPE_DOCHIE (
   DHE_CODIGO int8 not null,
   DHE_CODHIE int8 not null,
   DHE_RDSCOD int8,
   DHE_RDSCLA varchar(10),
   DHE_TITULO varchar(256) not null,
   DHE_ORDEN int4,
   primary key (DHE_CODIGO)
);
create table ZPE_DOCNOT (
   DNO_CODIGO int8 not null,
   DNO_CODNOT int8 not null,
   DNO_DOCIDE varchar(5) not null,
   DNO_DOCNUM int4 not null,
   DNO_DESC varchar(500) not null,
   DNO_RDSCOD int8 not null,
   DNO_RDSCLA varchar(10) not null,
   DNO_ORDEN int4,
   primary key (DNO_CODIGO)
);
create table ZPE_TRAPER (
   TPE_CODIGO int8 not null,
   TPE_IDEPER varchar(255) not null unique,
   TPE_TRAMOD varchar(20) not null,
   TPE_TRAVER int4 not null,
   TPE_TRADES varchar(200) not null,
   TPE_NIVAUT char(1) not null,
   TPE_USER varchar(255),
   TPE_FLUTRA varchar(255),
   TPE_FECINI timestamp not null,
   TPE_FECMOD timestamp not null,
   TPE_PARINI varchar(4000),
   TPE_FECCAD timestamp not null,
   TPE_IDIOMA varchar(2) not null,
   TPE_DELEGA VARCHAR(1536),
   TPE_DLGEST VARCHAR(2),
   primary key (TPE_CODIGO)
);

create table ZPE_DPEBCK (
   DPB_CODIGO int8 not null,
   DPB_CODTPB int8 not null,
   DPB_DOCIDE varchar(5) not null,
   DPB_DOCNUM int4 not null,
   DPB_ESTADO char(1) not null,
   DPB_RDSCOD int8,
   DPB_RDSCLA varchar(10),
   DPB_NOMFIC varchar(255),
   primary key (DPB_CODIGO)
);
create table ZPE_DOCPER (
   DPE_CODIGO int8 not null,
   DPE_CODTPE int8 not null,
   DPE_DOCIDE varchar(5) not null,
   DPE_DOCNUM int4 not null,
   DPE_ESTADO char(1) not null,
   DPE_RDSCOD int8,
   DPE_RDSCLA varchar(10),
   DPE_NOMFIC varchar(255),
   DPE_GENDES varchar(255),
   DPE_DLGEST VARCHAR(2),
   DPE_DLGFIR VARCHAR(4000),
   DPE_DLGFIP VARCHAR(4000),
   primary key (DPE_CODIGO)
);

create table ZPE_EXPEDI (
   EXP_CODIGO int8 not null,
   EXP_CLAVE varchar(50),
   EXP_IDIOMA varchar(2),
   EXP_FECEXP timestamp not null,
   EXP_FECCON timestamp,
   EXP_IDEXP varchar(50) not null unique,
   EXP_DESC varchar(512) not null,
   EXP_SEYCIU varchar(1536),
   EXP_USER varchar(1536) not null,
   EXP_NIFRDO varchar(255),
   EXP_NOMRDO varchar(255),
   EXP_UNIADM int8 not null,
   EXP_NUMBTE varchar(50),
   EXP_FECINI timestamp,
   EXP_FECULT timestamp,
   EXP_ESTADO varchar(255),
   EXP_AVISOS varchar(255) not null,
   EXP_AVISMS varchar(255),
   EXP_AVIEMA varchar(255),
   EXP_NIFRTE VARCHAR(12),
   EXP_IDEPRO VARCHAR(100) not null,
   primary key (EXP_CODIGO)
);


create table ZPE_DOCPRE (
   DPR_CODIGO int8 not null,
   DPR_CODPRE int8 not null,
   DPR_PRESE char(1),
   DPR_DOCIDE varchar(5),
   DPR_DOCNUM int4,
   DPR_DESC varchar(500),
   DPR_RDSCOD int8,
   DPR_RDSCLA varchar(10),
   DPR_TIPDOC char(1),
   DPR_COMPUL char(1),
   DPR_FOTPIA char(1),
   DPR_FIRMA char(1),
   primary key (DPR_CODIGO)
);
create table ZPE_ELEEX (
   ELE_CODIGO int8 not null,
   ELE_FECHA timestamp not null,
   ELE_TIPO varchar(1) not null,
   ELE_CODELE int8 not null,
   ELE_CODEXP int8 not null,
   ELE_CODAVI VARCHAR(50),
   primary key (ELE_CODIGO)
);
create table ZPE_PREREG (
   PRE_CODIGO int8 not null,
   PRE_NUMPRE varchar(255) not null unique,
   PRE_FECHA timestamp not null,
   PRE_FECCAD timestamp not null,
   PRE_IDEPER varchar(255) not null unique,
   PRE_TIPO char(1) not null,
   PRE_NIVAUT char(1) not null,
   PRE_USER varchar(255),
   PRE_DESC varchar(255),
   PRE_CODASI int8 not null,
   PRE_CLAASI varchar(10) not null,
   PRE_CODJUS int8 not null,
   PRE_CLAJUS varchar(10) not null,
   PRE_NUMREG varchar(50),
   PRE_FECREG timestamp,
   PRE_IDIOMA varchar(2) not null,
   PRE_NIFRTE varchar(255),
   PRE_NOMRTE varchar(255),
   PRE_NIFRDO varchar(255),
   PRE_NOMRDO varchar(255),
   PRE_TRAMOD varchar(20),
   PRE_TRAVER int4,
   PRE_CONAUT char(1) not null,
   PRE_AVISOS varchar(255),
   PRE_AVISMS varchar(255),
   PRE_AVIEMA varchar(255),
   PRE_NOTTEL varchar(255),
   PRE_NIFDLG VARCHAR(12),
   PRE_NOMDLG VARCHAR(500),
   pre_sbexid VARCHAR(50),
   pre_sbexua INT8,
   PRE_IDEPRO VARCHAR(100),
   primary key (PRE_CODIGO)
);

comment on column ZPE_PREREG.PRE_IDEPRO is 'IDENTIFICADOR PROCEDIMIENTO';


create table ZPE_NOTTEL (
   NOT_CODIGO int8 not null,
   NOT_USER varchar(255),
   NOT_NUMREG varchar(50) not null,
   NOT_FECHA timestamp not null,
   NOT_CODASI int8 not null,
   NOT_CLAASI varchar(10) not null,
   NOT_CODJUS int8 not null,
   NOT_CLAJUS varchar(10) not null,
   NOT_CODAVI int8 not null,
   NOT_CLAAVI varchar(10) not null,
   NOT_TITAVI varchar(10) not null,
   NOT_CODOFR int8 not null,
   NOT_CLAOFR varchar(10) not null,
   NOT_IDIOMA varchar(2) not null,
   NOT_NIFRTE varchar(255) not null,
   NOT_NOMRTE varchar(255) not null,
   NOT_NIFRDO varchar(255),
   NOT_NOMRDO varchar(255),
   NOT_CODACU int8,
   NOT_CLAACU varchar(10),
   NOT_FECACU timestamp,
   NOT_FIRACU bool not null,
   NOT_SEYGES varchar(255) not null,
   NOT_SUBDES VARCHAR(500),
   NOT_SUBIDE VARCHAR(20),
   NOT_SUBVER INT4,
   NOT_SUBPAR VARCHAR(4000),
   NOT_FECPLZ timestamp,
   NOT_RECHAZ bool not null,
   primary key (NOT_CODIGO)
);


create table ZPE_HISTEX (
   HIE_CODIGO int8 not null,
   HIE_FECEVE timestamp not null,
   HIE_FECCON timestamp,
   HIE_TITULO varchar(500) not null,
   HIE_TEXTO varchar(4000) not null,
   HIE_TXTSMS varchar(255),
   HIE_ENLCON varchar(512),
   HIE_USER varchar(1536) not null,
   primary key (HIE_CODIGO)
);
create table ZPE_PERSON (
   PER_CODIGO int8 not null,
   PER_SEYCON varchar(255) not null,
   PER_IDENTI varchar(12) not null,
   PER_NOMBRE varchar(50) not null,
   PER_APELL1 varchar(50),
   PER_APELL2 varchar(50),
   PER_TIPPER varchar(1) not null,
   PER_DIR varchar(200),
   PER_CPOSTAL varchar(5),
   PER_PROV varchar(2),
   PER_MUNI varchar(3),
   PER_TELF varchar(20),
   PER_TELM varchar(255),
   PER_EMAIL varchar(255),
   PER_AVIEXP bool,
   PER_FECALT timestamp not null,
   PER_FECULM timestamp not null,
   PER_DELEGA VARCHAR(1) default 'N' not null,
   PER_SEYMOD VARCHAR(4000),
   primary key (PER_CODIGO)
);

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

create table ZPE_SUBPAR  (
   SBP_CODIGO           VARCHAR(50)               not null,
   SBP_UNIADM           INT8                      not null,
   SBP_IDEXP            VARCHAR(50)               not null,
   SBP_PARAMS           VARCHAR(4000),
   SBP_FECHA            timestamp                 not null
);

alter table ZPE_SUBPAR
   add constraint ZPE_SBP_PK primary key (SBP_CODIGO);
   




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

alter table ZPE_DOCENT add constraint FK50D7D72398CD8905 foreign key (DEN_CODENT) references ZPE_ENTTEL;
alter table ZPE_DPRBCK add constraint FK50ECB39441B93B56 foreign key (DRB_CODPRE) references ZPE_PREBCK;
alter table ZPE_DOCHIE add constraint FK50D7E1BCAEB04CCA foreign key (DHE_CODHIE) references ZPE_HISTEX;
alter table ZPE_DOCNOT add constraint FK50D7F90B3716BED5 foreign key (DNO_CODNOT) references ZPE_NOTTEL;
alter table ZPE_DPEBCK add constraint FK50E6CAC119306C17 foreign key (DPB_CODTPB) references ZPE_TPEBCK;
alter table ZPE_DOCPER add constraint FK50D7FF5550D3F2B7 foreign key (DPE_CODTPE) references ZPE_TRAPER;
alter table ZPE_DOCPRE add constraint FK50D800DB97432B44 foreign key (DPR_CODPRE) references ZPE_PREREG;
alter table ZPE_ELEEX add constraint FK7E875541F40B7086 foreign key (ELE_CODEXP) references ZPE_EXPEDI;
create sequence ZPE_SEQDNO;
create sequence ZPE_SEQDHE;
create sequence ZPE_SEQELE;
create sequence ZPE_SEQPER;
create sequence ZPE_SEQTPE;
create sequence ZPE_SEQENT;
create sequence ZPE_SEQNOT;
create sequence ZPE_SEQHIE;
create sequence ZPE_SEQDPR;
create sequence ZPE_SEQEXP;
create sequence ZPE_SEQDPE;
create sequence ZPE_SEQPRE;
create sequence ZPE_SEQDEN;
create sequence ZPE_SEQDEL;

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
'Indices de busqueda asociadas a elementos de un expediente (solo para autenticados)';

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

