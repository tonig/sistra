-- ALTER SESSION SET NLS_LENGTH_SEMANTICS = 'CHAR';

create sequence RFR_SECARC;

create sequence RFR_SECAYU;

create sequence RFR_SECCOM;

create sequence RFR_SECFOR;

create sequence RFR_SECMAS;

create sequence RFR_SECPAL;

create sequence RFR_SECPAN;

create sequence RFR_SECPAT;

create sequence RFR_SECPER;

create sequence RFR_SECPRS;

create sequence RFR_SECPSA;

create sequence RFR_SECSAL;

create sequence RFR_SECTNF;

create sequence RFR_SECVAP;

create sequence RFR_SECVFI;

create sequence RFR_SEQVAL;

create table RFR_ARCHIV  (
   ARC_CODI             BIGINT                      not null,
   ARC_NOMBRE           VARCHAR(128)                   not null,
   ARC_MIME             VARCHAR(128)                   not null,
   ARC_PESOB            BIGINT                      not null,
   ARC_DATOS            BYTEA
);

alter table RFR_ARCHIV
   add constraint RFR_ARC_PK primary key (ARC_CODI);

create table RFR_AYUPAN  (
   AYU_CODI             BIGINT                      not null,
   AYU_CODPAN           BIGINT                      not null,
   AYU_CODPER           BIGINT                      not null
);

alter table RFR_AYUPAN
   add constraint RFR_AYU_PK primary key (AYU_CODI);

create table RFR_COMPON  (
   COM_CODI             BIGINT                      not null,
   COM_TYPE             VARCHAR(128)                   not null,
   COM_CODPAN           BIGINT,
   COM_CODPAL           BIGINT,
   COM_NOMLOG           VARCHAR(128)                   not null,
   COM_ORDEN            BIGINT                      not null,
   COM_POSICI           BIGINT                      not null,
   COM_ESTILO           VARCHAR(128),
   COM_ETIPDF           VARCHAR(128),
   COM_NUMERO           BIGINT,
   COM_OCULTO           BIGINT,
   COM_EXPAUR           VARCHAR(4000),
   COM_EXPAUT           VARCHAR(4000),
   COM_EXPDEP           VARCHAR(4000),
   COM_EXPVAL           VARCHAR(4000),
   COM_EXPVPO           VARCHAR(4000),
   COM_EXPPOS           VARCHAR(4000),
   COM_TIPVAL           VARCHAR(128),
   COM_CODPAT           BIGINT,
   COM_FILAS            BIGINT,
   COM_COLUMN           BIGINT,
   COM_MULTIL           BIGINT,
   COM_OBLIGA           BIGINT,
   COM_ALTURA           BIGINT,
   COM_VALDEF           BIGINT,
   COM_MAXSIZ           BIGINT,
   COM_MULTIF           BIGINT,
   COM_SELMUL           BIGINT,
   COM_EXTREE           BIGINT,
   COM_MOSTAB           BIGINT                      default 0 not null,
   COM_ANCCOL           BIGINT,
   COM_ANCMAX           BIGINT                      default 0 not null
);

alter table RFR_COMPON
   add constraint RFR_COM_PK primary key (COM_CODI);

create table RFR_FORMUL  (
   FOR_CODI             BIGINT                      not null,
   FOR_MODELO           VARCHAR(3)                     not null,
   FOR_ULNUSE           BIGINT                      not null,
   FOR_URLEN1           VARCHAR(256),
   FOR_URLEN2           VARCHAR(256),
   FOR_HASBCO           BIGINT                       not null,
   FOR_BCODEX           BIGINT,
   FOR_BCODEY           BIGINT,
   FOR_DTD              BIGINT,
   FOR_LOGTI1           BIGINT,
   FOR_LOGTI2           BIGINT,
   FOR_VERFUN           BIGINT                      default 0 not null,
   FOR_ESBLOQ           BIGINT                       not null,
   FOR_MTVBLQ           VARCHAR(2048),
   FOR_VERSIO           BIGINT                      not null,
   FOR_LASTVE           BIGINT                       not null,
   FOR_TAGCAR           VARCHAR(100),
   FOR_FECCAR           DATE
);

comment on column RFR_FORMUL.FOR_VERFUN is
'Codigo de version';

alter table RFR_FORMUL
   add constraint RFR_FOR_UNI unique (FOR_MODELO, FOR_VERSIO);

alter table RFR_FORMUL
   add constraint RFR_FOR_PK primary key (FOR_CODI);

create table RFR_FORSEG  (
   FSG_CODI             BIGINT                      not null,
   FSG_HTTPS            BIGINT                       not null,
   FSG_REQLOG           BIGINT                       not null,
   FSG_REQCER           BIGINT                       not null,
   FSG_REQFIR           BIGINT                       not null
);

alter table RFR_FORSEG
   add constraint RFR_FSG_PK primary key (FSG_CODI);

create table RFR_FSGROL  (
   FSR_CODFSG           BIGINT                      not null,
   FSR_ROL              VARCHAR(128)                   not null
);

alter table RFR_FSGROL
   add constraint RFR_FSR_PK primary key (FSR_CODFSG, FSR_ROL);

create table RFR_FSGVFI  (
   FSV_CODFSG           BIGINT                      not null,
   FSV_CODVFI           BIGINT                      not null
);

alter table RFR_FSGVFI
   add constraint RFR_FSV_PK primary key (FSV_CODFSG, FSV_CODVFI);

create table RFR_IDIOMA  (
   IDI_CODI             VARCHAR(2)                     not null,
   IDI_ORDEN            BIGINT                      not null
);

alter table RFR_IDIOMA
   add constraint RFR_IDI_PK primary key (IDI_CODI);

create table RFR_MASCAR  (
   MAS_CODI             BIGINT                      not null,
   MAS_NOMBRE           VARCHAR(128),
   MAS_DESCRI           VARCHAR(4000),
   MAS_VARIAB           BYTEA
);

alter table RFR_MASCAR
   add constraint RFR_MAS_PK primary key (MAS_CODI);

create table RFR_MASVAR  (
   MVA_CODMAS           BIGINT                      not null,
   MVA_VALOR            VARCHAR(255),
   MVA_ORDEN            BIGINT                      not null
);

alter table RFR_MASVAR
   add constraint RFR_MVA_PK primary key (MVA_CODMAS, MVA_ORDEN);

create table RFR_PALETA  (
   PAL_CODI             BIGINT                      not null,
   PAL_NOMBRE           VARCHAR(128)                   not null
);

alter table RFR_PALETA
   add constraint RFR_PAL_PK primary key (PAL_CODI);

create table RFR_PANTAL  (
   PAN_CODI             BIGINT                      not null,
   PAN_NOMBRE           VARCHAR(128)                   not null,
   PAN_ORDEN            BIGINT                      not null,
   PAN_EXPRES           VARCHAR(4000),
   PAN_ULTIMA           BIGINT,
   PAN_INICIA           BIGINT,
   PAN_CODFOR           BIGINT                      not null,
   PAN_DETALL           VARCHAR(300)
);

alter table RFR_PANTAL
   add constraint RFR_PAN_PK primary key (PAN_CODI);

create table RFR_PATRON  (
   PAT_CODI             BIGINT                      not null,
   PAT_NOMBRE           VARCHAR(128)                   not null,
   PAT_DESCRI           VARCHAR(4000),
   PAT_EJECUT           BIGINT                       not null,
   PAT_CODIGO           VARCHAR(4000)
);

alter table RFR_PATRON
   add constraint RFR_PAT_FK primary key (PAT_CODI);
   
alter table RFR_PATRON
   add constraint RFR_PAT_NOMBRE_FK unique (PAT_NOMBRE);  

create table RFR_PERUSU  (
   PER_CODI             BIGINT                      not null,
   PER_CODEST           VARCHAR(10)                    not null,
   PER_PATICO           VARCHAR(1024)                  not null
);

alter table RFR_PERUSU
   add constraint RFR_PER_PK primary key (PER_CODI);

create table RFR_PROSAL  (
   PRS_CODI             BIGINT                      not null,
   PRS_NOMBRE           VARCHAR(128)                   not null,
   PRS_VALOR            VARCHAR(4000),
   PRS_EXPRES           BIGINT,
   PRS_CODSAL           BIGINT                      not null,
   PRS_CODPLA           BIGINT
);

alter table RFR_PROSAL
   add constraint RFR_PRS_PK primary key (PRS_CODI);

create table RFR_PUNSAL  (
   PSA_CODI             BIGINT                      not null,
   PSA_NOMBRE           VARCHAR(128)                   not null,
   PSA_IMPLEM           VARCHAR(1024)
);

alter table RFR_PUNSAL
   add constraint RFR_PSA_PK primary key (PSA_CODI);

create table RFR_SALIDA  (
   SAL_CODI             BIGINT                      not null,
   SAL_ORDEN            BIGINT                      not null,
   SAL_CODPSA           BIGINT                      not null,
   SAL_CODFOR           BIGINT                      not null
);

alter table RFR_SALIDA
   add constraint RFR_SAL_PK primary key (SAL_CODI);

create table RFR_TRACAM  (
   TRC_CODCAM           BIGINT                      not null,
   TRC_NOMBRE           VARCHAR(256)                   not null,
   TRC_AYUDA            VARCHAR(4000),
   TRC_CODIDI           VARCHAR(2)                     not null,
   TRC_MENVAL           VARCHAR(256)
);

alter table RFR_TRACAM
   add constraint RFR_TRC_PK primary key (TRC_CODCAM, TRC_CODIDI);

create table RFR_TRAFOR  (
   TRF_CODFOR           BIGINT                      not null,
   TRF_TITULO           VARCHAR(256)                   not null,
   TRF_DESCRI           VARCHAR(4000),
   TRF_NOMEN1           VARCHAR(256),
   TRF_NOMEN2           VARCHAR(256),
   TRF_PLANTI           BIGINT,
   TRF_CODIDI           VARCHAR(2)                     not null
);

alter table RFR_TRAFOR
   add constraint RFR_TRF_PK primary key (TRF_CODFOR, TRF_CODIDI);

create table RFR_TRALAB  (
   TRL_CODLAB           BIGINT                      not null,
   TRL_ETIQUE           VARCHAR(4000)                  not null,
   TRL_CODIDI           VARCHAR(2)                     not null
);

alter table RFR_TRALAB
   add constraint RFR_TRL_PK primary key (TRL_CODLAB, TRL_CODIDI);

create table RFR_TRANSF  (
   TNF_CODI             BIGINT                      not null,
   TNF_CODPAN           BIGINT                      not null,
   TNF_CODPER           BIGINT                      not null,
   TNF_XSLT             TEXT
);

alter table RFR_TRANSF
   add constraint RFR_TNF_PK primary key (TNF_CODI);

create table RFR_TRAPAN  (
   TRP_CODPAN           BIGINT                      not null,
   TRP_TITULO           VARCHAR(256)                   not null,
   TRP_CODIDI           VARCHAR(2)                     not null
);

alter table RFR_TRAPAN
   add constraint RFR_TRP_PK primary key (TRP_CODPAN, TRP_CODIDI);

create table RFR_TRAYPA  (
   TRA_CODAYU           BIGINT                      not null,
   TRA_DESCOR           VARCHAR(1024),
   TRA_DESLAR           VARCHAR(4000),
   TRA_URLWEB           VARCHAR(1024),
   TRA_URLVID           VARCHAR(1024),
   TRA_URLSON           VARCHAR(1024),
   TRA_CODIDI           VARCHAR(2)                     not null
);

alter table RFR_TRAYPA
   add constraint RFR_TRA_PK primary key (TRA_CODAYU, TRA_CODIDI);

create table RFR_TRPEUS  (
   TPE_CODPER           BIGINT                      not null,
   TPE_NOMBRE           VARCHAR(256)                   not null,
   TPE_DESCRI           VARCHAR(4000),
   TPE_CODIDI           VARCHAR(2)                     not null
);

alter table RFR_TRPEUS
   add constraint RFR_TPE_PK primary key (TPE_CODPER, TPE_CODIDI);

create table RFR_TRVAPO  (
   TRV_CODVAP           BIGINT                      not null,
   TRV_ETIQUE           VARCHAR(4000),
   TRV_ARCHIV           BIGINT,
   TRV_CODIDI           VARCHAR(2)                     not null
);

alter table RFR_TRVAPO
   add constraint RFR_TRV_PK primary key (TRV_CODVAP, TRV_CODIDI);

create table RFR_VALFIR  (
   VFI_CODI             BIGINT                      not null,
   VFI_NOMBRE           VARCHAR(128)                   not null,
   VFI_IMPLEM           VARCHAR(1024)
);

alter table RFR_VALFIR
   add constraint RFR_VFI_PK primary key (VFI_CODI);

create table RFR_VALIDA  (
   VAL_CODI             BIGINT                      not null,
   VAL_ORDEN            BIGINT                      not null,
   VAL_VALORE           BYTEA,
   VAL_CODMAS           BIGINT                      not null,
   VAL_CODCAM           BIGINT                      not null
);

alter table RFR_VALIDA
   add constraint RFR_VAL_PK primary key (VAL_CODI);

create table RFR_VALPOS  (
   VAP_CODI             BIGINT                      not null,
   VAP_CODCAM           BIGINT,
   VAP_ORDEN            BIGINT                      not null,
   VAP_VALOR            VARCHAR(128),
   VAP_DEFECT           BIGINT
);

alter table RFR_VALPOS
   add constraint RFR_VAP_PK primary key (VAP_CODI);

create table RFR_VERSIO  (
   VER_CODIGO           BIGINT                       not null,
   VER_NOMBRE           VARCHAR(100)                   not null,
   VER_FECHA            DATE                            not null,
   VER_SUFIX            VARCHAR(10)
);

comment on column RFR_VERSIO.VER_CODIGO is
'Codigo de version';

comment on column RFR_VERSIO.VER_NOMBRE is
'Nombre de version';

comment on column RFR_VERSIO.VER_FECHA is
'echa';

comment on column RFR_VERSIO.VER_SUFIX is
'Sufijo para acceder a pantallas,actions,etc especificas';

alter table RFR_VERSIO
   add constraint RFR_VER_PK primary key (VER_CODIGO);

alter table RFR_AYUPAN
   add constraint RFR_AYUPAN_FK foreign key (AYU_CODPAN)
      references RFR_PANTAL (PAN_CODI)
      not deferrable;

alter table RFR_AYUPAN
   add constraint RFR_AYUPER_FK foreign key (AYU_CODPER)
      references RFR_PERUSU (PER_CODI)
      not deferrable;

alter table RFR_COMPON
   add constraint RFR_CAMPAT_FK foreign key (COM_CODPAT)
      references RFR_PATRON (PAT_CODI)
      not deferrable;

alter table RFR_COMPON
   add constraint RFR_COMPAL_FK foreign key (COM_CODPAL)
      references RFR_PALETA (PAL_CODI)
      not deferrable;

alter table RFR_COMPON
   add constraint RFR_COMPAN_FK foreign key (COM_CODPAN)
      references RFR_PANTAL (PAN_CODI)
      not deferrable;

alter table RFR_FORMUL
   add constraint RFR_FORDTD_FK foreign key (FOR_DTD)
      references RFR_ARCHIV (ARC_CODI)
      not deferrable;

alter table RFR_FORMUL
   add constraint RFR_FORLO1_FK foreign key (FOR_LOGTI1)
      references RFR_ARCHIV (ARC_CODI)
      not deferrable;

alter table RFR_FORMUL
   add constraint RFR_FORLO2_FK foreign key (FOR_LOGTI2)
      references RFR_ARCHIV (ARC_CODI)
      not deferrable;

alter table RFR_FORMUL
   add constraint RFR_FORVER_FK foreign key (FOR_VERFUN)
      references RFR_VERSIO (VER_CODIGO);

alter table RFR_FORSEG
   add constraint RFR_FSGFOR_FK foreign key (FSG_CODI)
      references RFR_FORMUL (FOR_CODI)
      not deferrable;

alter table RFR_FSGROL
   add constraint RFR_FSRFSG_FK foreign key (FSR_CODFSG)
      references RFR_FORSEG (FSG_CODI)
      not deferrable;

alter table RFR_FSGVFI
   add constraint RFR_FSVFSG_FK foreign key (FSV_CODFSG)
      references RFR_FORSEG (FSG_CODI)
      not deferrable;

alter table RFR_FSGVFI
   add constraint RFR_FSVVFI_FK foreign key (FSV_CODVFI)
      references RFR_VALFIR (VFI_CODI)
      not deferrable;

alter table RFR_MASVAR
   add constraint RFR_MASMVA_FK foreign key (MVA_CODMAS)
      references RFR_MASCAR (MAS_CODI)
      not deferrable;

alter table RFR_PANTAL
   add constraint RFR_PANFOR_FK foreign key (PAN_CODFOR)
      references RFR_FORMUL (FOR_CODI)
      not deferrable;

alter table RFR_PROSAL
   add constraint RFR_PRSARC_FK foreign key (PRS_CODPLA)
      references RFR_ARCHIV (ARC_CODI)
      not deferrable;

alter table RFR_PROSAL
   add constraint RFR_PRSSAL_FK foreign key (PRS_CODSAL)
      references RFR_SALIDA (SAL_CODI)
      not deferrable;

alter table RFR_SALIDA
   add constraint RFR_SALFOR_FK foreign key (SAL_CODFOR)
      references RFR_FORMUL (FOR_CODI)
      not deferrable;

alter table RFR_SALIDA
   add constraint RFR_SALPSA_FK foreign key (SAL_CODPSA)
      references RFR_PUNSAL (PSA_CODI)
      not deferrable;

alter table RFR_TRACAM
   add constraint RFR_CAMTRC_FK foreign key (TRC_CODCAM)
      references RFR_COMPON (COM_CODI)
      not deferrable;

alter table RFR_TRAFOR
   add constraint RFR_FORTRF_FK foreign key (TRF_CODFOR)
      references RFR_FORMUL (FOR_CODI)
      not deferrable;

alter table RFR_TRAFOR
   add constraint RFR_TRFARC_FK foreign key (TRF_PLANTI)
      references RFR_ARCHIV (ARC_CODI)
      not deferrable;

alter table RFR_TRALAB
   add constraint RFR_LABTRA_FK foreign key (TRL_CODLAB)
      references RFR_COMPON (COM_CODI)
      not deferrable;

alter table RFR_TRANSF
   add constraint RFR_TNFPAN_FK foreign key (TNF_CODPAN)
      references RFR_PANTAL (PAN_CODI)
      not deferrable;

alter table RFR_TRANSF
   add constraint RFR_TNFPER_FK foreign key (TNF_CODPER)
      references RFR_PERUSU (PER_CODI)
      not deferrable;

alter table RFR_TRAPAN
   add constraint RFR_PANTRA_FK foreign key (TRP_CODPAN)
      references RFR_PANTAL (PAN_CODI)
      not deferrable;

alter table RFR_TRAYPA
   add constraint RFR_AYUTRA_FK foreign key (TRA_CODAYU)
      references RFR_AYUPAN (AYU_CODI)
      not deferrable;

alter table RFR_TRPEUS
   add constraint RFR_PERTRP_FK foreign key (TPE_CODPER)
      references RFR_PERUSU (PER_CODI)
      not deferrable;

alter table RFR_TRVAPO
   add constraint RFR_TRVARC_FK foreign key (TRV_ARCHIV)
      references RFR_ARCHIV (ARC_CODI)
      not deferrable;

alter table RFR_TRVAPO
   add constraint RFR_VAPTRV_FK foreign key (TRV_CODVAP)
      references RFR_VALPOS (VAP_CODI)
      not deferrable;

alter table RFR_VALIDA
   add constraint RFR_VALCAM_FK foreign key (VAL_CODCAM)
      references RFR_COMPON (COM_CODI)
      not deferrable;

alter table RFR_VALIDA
   add constraint RFR_VALMAS_FK foreign key (VAL_CODMAS)
      references RFR_MASCAR (MAS_CODI)
      not deferrable;

alter table RFR_VALPOS
   add constraint RFR_VAPCAM_FK foreign key (VAP_CODCAM)
      references RFR_COMPON (COM_CODI)
      not deferrable;


	  create table RFR_USUFOR  (
   UST_CODUSU           VARCHAR(200)                   not null,
   UST_CODFOR           BIGINT                      not null
);

comment on table RFR_USUFOR is
'Permisos individuales para un usuario de acceso a formularios';

comment on column RFR_USUFOR.UST_CODUSU is
'CODIGO USUARIO';

comment on column RFR_USUFOR.UST_CODFOR is
'CODIGO FORMULARIO';

alter table RFR_USUFOR
   add constraint RFR_UST_PK primary key (UST_CODUSU, UST_CODFOR);

alter table RFR_USUFOR
   add constraint RFR_USTFOR_FK foreign key (UST_CODFOR)
      references RFR_FORMUL (FOR_CODI);

create table RFR_GRUPOS  (
   GRP_CODIGO           VARCHAR(50)                    not null,
   GRP_NOMBRE           VARCHAR(100)                   not null,
   GRP_DESCP            VARCHAR(300)
);

comment on table RFR_GRUPOS is
'Grupos de usuarios para establecer permisos de acceso a formularios';

comment on column RFR_GRUPOS.GRP_CODIGO is
'Código grupo';

comment on column RFR_GRUPOS.GRP_NOMBRE is
'Nombre grupo';

comment on column RFR_GRUPOS.GRP_DESCP is
'Descripción grupo';

alter table RFR_GRUPOS
   add constraint RFR_GRP_PK primary key (GRP_CODIGO);

create table RFR_GRPUSU  (
   GRU_CODGRP           VARCHAR(50)                    not null,
   GRU_CODUSU           VARCHAR(200)                   not null
);

comment on table RFR_GRPUSU is
'Asignación de usuarios a grupos';

comment on column RFR_GRPUSU.GRU_CODGRP is
'CODIGO GRUPO';

comment on column RFR_GRPUSU.GRU_CODUSU is
'CODIGO USUARIO';

alter table RFR_GRPUSU
   add constraint RFR_GRU_PK primary key (GRU_CODGRP, GRU_CODUSU);

alter table RFR_GRPUSU
   add constraint RFR_GRUGRP_FK foreign key (GRU_CODGRP)
      references RFR_GRUPOS (GRP_CODIGO);

create table RFR_GRPFOR  (
   GRF_CODGRP           VARCHAR(50)                    not null,
   GRF_CODFOR           BIGINT                      not null
);

comment on table RFR_GRPFOR is
'Formularios a los que el grupo tiene acceso';

comment on column RFR_GRPFOR.GRF_CODGRP is
'CODIGO GRUPO';

comment on column RFR_GRPFOR.GRF_CODFOR is
'CODIGO FORMULARIO';

alter table RFR_GRPFOR
   add constraint RFR_GRF_PK primary key (GRF_CODGRP, GRF_CODFOR);

alter table RFR_GRPFOR
   add constraint RFR_GRFFOR_FK foreign key (GRF_CODFOR)
      references RFR_FORMUL (FOR_CODI);

alter table RFR_GRPFOR
   add constraint RFR_GRFGRP_FK foreign key (GRF_CODGRP)
      references RFR_GRUPOS (GRP_CODIGO);