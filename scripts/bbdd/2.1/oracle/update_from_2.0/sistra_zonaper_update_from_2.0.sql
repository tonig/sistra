drop view ZPE_ESTEXP;

alter table ZPE_EXPEDI add EXP_TIPO VARCHAR2(1);

comment on column ZPE_EXPEDI.EXP_TIPO is
'Tipo expediente: E (Expediente real) / V (Expediente virtual de una entrada para la que a�n no se ha generado expediente)';

update ZPE_EXPEDI set EXP_TIPO = 'E';

alter table ZPE_EXPEDI modify EXP_TIPO not null;

alter table ZPE_EXPEDI modify EXP_UNIADM null;

alter table ZPE_EXPEDI modify EXP_USER null;

/* Expedientes virtuales para entradas telematicas  no asociadas a expedientes */
INSERT INTO ZPE_EXPEDI (
   EXP_CODIGO, EXP_TIPO, EXP_UNIADM, EXP_IDEXP, 
   EXP_FECEXP, EXP_FECCON, EXP_DESC, 
   EXP_SEYCIU, EXP_USER, EXP_NUMBTE, 
   EXP_CLAVE, EXP_IDIOMA, EXP_FECINI, 
   EXP_FECULT, EXP_ESTADO, EXP_NIFRDO, 
   EXP_NOMRDO, EXP_AVISOS, EXP_AVISMS, 
   EXP_AVIEMA, EXP_NIFRTE, EXP_IDEPRO)
 SELECT ZPE_SEQEXP.NEXTVAL,
 	'V',
 	null,
 	ENT_IDEPER,
	ENT_FECHA,
 	ENT_FECHA,
 	ENT_DESC,
 	ENT_USER,
 	ENT_USER,
 	null,
 	null,
 	ENT_IDIOMA,
 	ENT_FECHA,
 	ENT_FECHA,
 	'SE',
 	ENT_NIFRDO,
 	ENT_NOMRDO,
 	'N',
 	null,
 	null,
 	ENT_NIFRTE,
 	ENT_IDEPRO
   FROM ZPE_ENTTEL
     WHERE ENT_CODIGO NOT IN (SELECT ELE_CODELE
                                FROM ZPE_ELEEX
                               WHERE ELE_TIPO = 'T');
                               
                               
  INSERT INTO ZPE_ELEEX (
   ELE_CODIGO, ELE_CODEXP, ELE_FECHA, 
   ELE_TIPO, ELE_CODELE, ELE_CODAVI) 
 SELECT ZPE_SEQELE.nextval,
         (select EXP_CODIGO from ZPE_EXPEDI where EXP_IDEXP = ENT_IDEPER),
         ENT_FECHA,
         'T',
         ENT_CODIGO,
         null
   FROM ZPE_ENTTEL
     WHERE ENT_CODIGO NOT IN (SELECT ELE_CODELE
                                FROM ZPE_ELEEX
                               WHERE ELE_TIPO = 'T');


/* Expedientes virtuales para entradas preregistro no asociadas a expedientes */
INSERT INTO ZPE_EXPEDI (
   EXP_CODIGO, EXP_TIPO, EXP_UNIADM, EXP_IDEXP, 
   EXP_FECEXP, EXP_FECCON, EXP_DESC, 
   EXP_SEYCIU, EXP_USER, EXP_NUMBTE, 
   EXP_CLAVE, EXP_IDIOMA, EXP_FECINI, 
   EXP_FECULT, EXP_ESTADO, EXP_NIFRDO, 
   EXP_NOMRDO, EXP_AVISOS, EXP_AVISMS, 
   EXP_AVIEMA, EXP_NIFRTE, EXP_IDEPRO)
 SELECT ZPE_SEQEXP.NEXTVAL,
 	'V',
 	null,
 	PRE_IDEPER,
	PRE_FECHA,
 	PRE_FECHA,
 	PRE_DESC,
 	PRE_USER,
 	PRE_USER,
 	null,
 	null,
 	PRE_IDIOMA,
 	PRE_FECHA,
 	NVL(PRE_FECREG, PRE_FECHA),
 	DECODE(PRE_FECREG, null,'SP','SE'),
 	PRE_NIFRDO,
 	PRE_NOMRDO,
 	'N',
 	null,
 	null,
 	PRE_NIFRTE,
 	PRE_IDEPRO
   FROM ZPE_PREREG
   WHERE PRE_CODIGO NOT IN (SELECT ELE_CODELE
                                FROM ZPE_ELEEX
                               WHERE ELE_TIPO = 'P');
                              
INSERT INTO ZPE_ELEEX (
   ELE_CODIGO, ELE_CODEXP, ELE_FECHA, 
   ELE_TIPO, ELE_CODELE, ELE_CODAVI) 
 SELECT ZPE_SEQELE.nextval,
         (select EXP_CODIGO from ZPE_EXPEDI where EXP_IDEXP = PRE_IDEPER),
         PRE_FECHA,
         'P',
         PRE_CODIGO,
         null
  FROM ZPE_PREREG
   WHERE PRE_CODIGO NOT IN (SELECT ELE_CODELE
                                FROM ZPE_ELEEX
                               WHERE ELE_TIPO = 'P');                                                             
                               

UPDATE ZPE_EXPEDI
SET EXP_NIFRTE = (SELECT ENT_NIFRTE 
                FROM  ZPE_ELEEX,   ZPE_ENTTEL
                WHERE  ELE_TIPO = 'T'  AND
                ELE_CODELE = ENT_CODIGO AND
                ENT_NIVAUT = 'A' AND
                ENT_SBEXID IS NULL AND
                ENT_NIFRTE IS NOT NULL AND
                ELE_CODEXP  =  EXP_CODIGO )
WHERE EXP_TIPO = 'E' AND EXP_SEYCIU IS null AND
           EXP_CODIGO in ( 
                SELECT ELE_CODEXP 
                FROM  ZPE_ELEEX,   ZPE_ENTTEL
                WHERE  ELE_TIPO = 'T'  AND
                ELE_CODELE = ENT_CODIGO AND
                ENT_NIVAUT = 'A' AND
                ENT_SBEXID IS NULL AND
                ENT_NIFRTE IS NOT NULL                
           );                                    
                               
COMMIT;

alter table ZPE_NOTTEL add NOT_IDEPER VARCHAR2(50);
update ZPE_NOTTEL set NOT_IDEPER = 'MIGRADO-N-' || TO_CHAR(NOT_CODIGO);
COMMIT;
alter table ZPE_NOTTEL modify NOT_IDEPER not null;


alter table ZPE_HISTEX add HIE_IDEPER VARCHAR2(50);
update ZPE_HISTEX set HIE_IDEPER = 'MIGRADO-A-' || TO_CHAR(HIE_CODIGO);
COMMIT;
alter table ZPE_HISTEX modify HIE_IDEPER not null;

alter table ZPE_ELEEX add ELE_IDPELE VARCHAR2(50);

update ZPE_ELEEX set 
    ELE_IDPELE = (SELECT ENT_IDEPER FROM ZPE_ENTTEL WHERE ENT_CODIGO = ELE_CODELE)
WHERE ELE_TIPO = 'T';

update ZPE_ELEEX set 
    ELE_IDPELE = (SELECT PRE_IDEPER FROM ZPE_PREREG WHERE PRE_CODIGO = ELE_CODELE)
WHERE ELE_TIPO = 'P';

update ZPE_ELEEX set 
    ELE_IDPELE = (SELECT HIE_IDEPER FROM ZPE_HISTEX WHERE HIE_CODIGO = ELE_CODELE)
WHERE ELE_TIPO = 'A';

update ZPE_ELEEX set 
    ELE_IDPELE = (SELECT NOT_IDEPER FROM ZPE_NOTTEL WHERE NOT_CODIGO = ELE_CODELE)
WHERE ELE_TIPO = 'N';

COMMIT;

alter table ZPE_ELEEX modify ELE_IDPELE not null;

create unique index ZPE_ELEIDP_UNI on ZPE_ELEEX (
   ELE_IDPELE ASC
);


/* INDICES ENTRADAS PREREGISTROS ANONIMOS*/ 
INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
	SELECT ZPE_SEQIND.NEXTVAL, PRE_NIFRTE, 'P', PRE_CODIGO, 'N�mero preregistro', PRE_NUMPRE
        FROM  ZPE_PREREG
        WHERE  PRE_NIVAUT = 'A' AND PRE_NIFRTE IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
	SELECT ZPE_SEQIND.NEXTVAL, PRE_NIFRTE, 'P', PRE_CODIGO, 'N�mero registro', PRE_NUMREG
        FROM  ZPE_PREREG
        WHERE  PRE_NIVAUT = 'A'  AND PRE_NIFRTE IS NOT NULL AND PRE_NUMREG IS NOT NULL;
 
INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
	SELECT ZPE_SEQIND.NEXTVAL, PRE_NIFRTE, 'P', PRE_CODIGO, 'T�tulo tr�mite', PRE_DESC
        FROM  ZPE_PREREG
        WHERE  PRE_NIVAUT = 'A'  AND PRE_NIFRTE IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
	SELECT ZPE_SEQIND.NEXTVAL, PRE_NIFRTE, 'P', PRE_CODIGO, 'Nif representado', PRE_NIFRDO
        FROM  ZPE_PREREG
        WHERE  PRE_NIVAUT = 'A' AND PRE_NIFRTE IS NOT NULL AND PRE_NIFRDO IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
	SELECT ZPE_SEQIND.NEXTVAL, PRE_NIFRTE, 'P', PRE_CODIGO, 'Nombre representado', PRE_NOMRDO
        FROM  ZPE_PREREG
        WHERE  PRE_NIVAUT = 'A' AND PRE_NIFRTE IS NOT NULL AND PRE_NOMRDO IS NOT NULL;

				
/* INDICES DOCS ENTRADAS PREREGISTROS ANONIMOS */
INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR)
SELECT ZPE_SEQIND.NEXTVAL, PRE_NIFRTE, 'P', PRE_CODIGO,  DPR_DOCIDE || '(' || to_char(DPR_DOCNUM, '999') || ')', DPR_DESC
FROM ZPE_DOCPRE, ZPE_PREREG 
WHERE PRE_CODIGO = DPR_CODPRE AND PRE_NIVAUT = 'A' AND PRE_NIFRTE IS NOT NULL AND DPR_DOCIDE <> 'DTP';

/* INDICES ENTRADAS TELEMATICAS ANONIMOS */
INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT ZPE_SEQIND.NEXTVAL, ENT_NIFRTE, 'T', ENT_CODIGO, 'N�mero registro', ENT_NUMREG
    FROM ZPE_ENTTEL 
       WHERE ENT_NIVAUT = 'A' AND ENT_NIFRTE IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT ZPE_SEQIND.NEXTVAL, ENT_NIFRTE, 'T', ENT_CODIGO, 'T�tulo tr�mite', ENT_DESC
    FROM ZPE_ENTTEL 
       WHERE ENT_NIVAUT = 'A'  AND ENT_NIFRTE IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT ZPE_SEQIND.NEXTVAL, ENT_NIFRTE, 'T', ENT_CODIGO, 'Nif representado', ENT_NIFRDO
    FROM ZPE_ENTTEL 
       WHERE ENT_NIVAUT = 'A' AND ENT_NIFRTE IS NOT NULL AND ENT_NIFRDO IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT ZPE_SEQIND.NEXTVAL, ENT_NIFRTE, 'T', ENT_CODIGO, 'Nombre representado', ENT_NOMRDO
    FROM ZPE_ENTTEL 
      WHERE ENT_NIVAUT = 'A' AND ENT_NIFRTE IS NOT NULL AND ENT_NOMRDO IS NOT NULL;

/* INDICES DOCS ENTRADAS TELEMATICAS ANONIMAS */
INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT ZPE_SEQIND.NEXTVAL, ENT_NIFRTE, 'T', ENT_CODIGO, DEN_DOCIDE || '(' || to_char(DEN_DOCNUM,'999') || ')', DEN_DESC
    FROM ZPE_ENTTEL, ZPE_DOCENT
      WHERE 
        ENT_NIVAUT = 'A'  AND ENT_NIFRTE IS NOT NULL  AND ENT_CODIGO =  DEN_CODENT AND DEN_DOCIDE <> 'DTP';

/* INDICES EVENTOS EXPEDIENTES ANONIMOS */
INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT ZPE_SEQIND.NEXTVAL, EXP_NIFRTE, 'A', HIE_CODIGO, 'T�tulo', HIE_TITULO
    FROM ZPE_HISTEX, ZPE_EXPEDI, ZPE_ELEEX 
       WHERE EXP_SEYCIU IS NULL AND EXP_NIFRTE IS NOT NULL AND
            EXP_CODIGO = ELE_CODEXP AND ELE_TIPO = 'A' AND ELE_CODELE = HIE_CODIGO AND HIE_TITULO IS NOT NULL;
					 
INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT ZPE_SEQIND.NEXTVAL, EXP_NIFRTE, 'A', HIE_CODIGO, 'Texto', HIE_TEXTO
    FROM ZPE_HISTEX, ZPE_EXPEDI, ZPE_ELEEX 
       WHERE EXP_SEYCIU IS NULL AND EXP_NIFRTE IS NOT NULL AND
            EXP_CODIGO = ELE_CODEXP AND ELE_TIPO = 'A' AND ELE_CODELE = HIE_CODIGO AND HIE_TEXTO IS NOT NULL;
			
/* INDICES EXPEDIENTES ANONIMOS */
INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT ZPE_SEQIND.NEXTVAL, EXP_NIFRTE, 'E', EXP_CODIGO, 'N�mero expediente', EXP_IDEXP FROM ZPE_EXPEDI
                    WHERE EXP_SEYCIU IS NULL AND EXP_NIFRTE IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT ZPE_SEQIND.NEXTVAL, EXP_NIFRTE, 'E', EXP_CODIGO, 'T�tulo', EXP_DESC FROM ZPE_EXPEDI
                    WHERE EXP_SEYCIU IS NULL  AND EXP_NIFRTE IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT ZPE_SEQIND.NEXTVAL, EXP_NIFRTE, 'E', EXP_CODIGO, 'Nif representado', EXP_NIFRDO FROM ZPE_EXPEDI
                    WHERE EXP_SEYCIU IS NULL  AND EXP_NIFRTE IS NOT NULL AND EXP_NIFRDO IS NOT NULL;

INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT ZPE_SEQIND.NEXTVAL, EXP_NIFRTE, 'E', EXP_CODIGO, 'Nombre representado', EXP_NOMRDO FROM ZPE_EXPEDI
                    WHERE EXP_SEYCIU IS NULL  AND EXP_NIFRTE IS NOT NULL AND EXP_NOMRDO IS NOT NULL;

COMMIT;  

/* ACCESO ANONIMO A EXPEDIENTE A TRAVES DE TRAMITES ANONIMOS */
alter table ZPE_ELEEX add ELE_ACCEXP NUMBER(1) default 0 not null;

 comment on column ZPE_ELEEX.ELE_ACCEXP is
'Indica si elemento proporciona acceso a expediente de forma an�nima a traves de su id persistencia';

update ZPE_ELEEX set ELE_ACCEXP = 1
 WHERE ELE_TIPO = 'T' AND ELE_CODELE IN (SELECT ENT_CODIGO FROM ZPE_ENTTEL WHERE ENT_NIVAUT = 'A');

update ZPE_ELEEX set ELE_ACCEXP = 1
 WHERE ELE_TIPO = 'P' AND ELE_CODELE IN (SELECT PRE_CODIGO FROM ZPE_PREREG WHERE PRE_NIVAUT = 'A');

 COMMIT;
 
/* ACCESO ANONIMO NOTIF POR CLAVE */
ALTER table ZPE_NOTTEL ADD NOT_ACCCLA  NUMBER(1) default 0 not null;
comment on column ZPE_NOTTEL.NOT_ACCCLA is
'Indica si se permite que la notificacion sea accesible mediante clave (id persistencia notificacion)';

/* ACCESO ANONIMO EVENTO POR CLAVE */
ALTER table ZPE_HISTEX ADD   HIE_ACCCLA        NUMBER(1)     default 0                  not null;
comment on column ZPE_HISTEX.HIE_ACCCLA is
'Indica si se permite que el evento sea accesible mediante clave (id persistencia evento)';

/* TIPO FIRMA NOTIFICACION */
alter table ZPE_NOTTEL  add NOT_TIPFIR  VARCHAR2(3);

comment on column ZPE_NOTTEL.NOT_TIPFIR is
'En caso de que se haya firmado el acuse de recibo indica el tipo de firma: 
 CER: Certificado digital
 CLA: Clave de acceso';
 
 update  ZPE_NOTTEL set NOT_TIPFIR = 'CER' where NOT_FECACU is not null;
 commit; 
 
 /* ACTUALIZAR PROPS TABLA BACKUP DE TRAMITES */
 ALTER table ZPE_TPEBCK  add  TPB_DLGEST VARCHAR2(2);

 comment on column ZPE_TPEBCK.TPB_DLGEST is
'ESTADO DE DELEGACION: PASO A FIRMA DOCUMENTO, PASO A PRESENTACION TRAMITE';

 ALTER table ZPE_TPEBCK  add    TPB_DELEGA           VARCHAR2(1536);
 
 comment on column ZPE_TPEBCK.TPB_DELEGA is
'INDICA QUE EL TRAMITE SE ESTA EFECTUANDO DE FORMA DELEGADA PARA ESTE USUARIO (SOLO PARA NIVEL C Y U)';

ALTER table ZPE_DPEBCK ADD DPB_GENDES           VARCHAR2(255);

ALTER table ZPE_DPEBCK ADD DPB_DLGEST           VARCHAR2(2);

ALTER table ZPE_DPEBCK ADD DPB_DLGFIR           VARCHAR2(4000);

ALTER table ZPE_DPEBCK  ADD DPB_DLGFIP           VARCHAR2(4000);

comment on column ZPE_DPEBCK.DPB_GENDES is
'DESCRIPCION PERSONALIZADA PARA GEN�RICOS';

comment on column ZPE_DPEBCK.DPB_DLGEST is
'ESTADO DE DELEGACION: PASO A FIRMA DOCUMENTO';

comment on column ZPE_DPEBCK.DPB_DLGFIR is
'NIFS QUE TIENEN QUE FIRMAR EL DOCUMENTO SEPARADOS POR #';

comment on column ZPE_DPEBCK.DPB_DLGFIP is
'NIFS QUE QUEDAN POR FIRMAR EL DOCUMENTO SEPARADOS POR #';

 
