﻿/* IDIOMAS */
INSERT INTO RDS_IDIOMA ( IDI_CODIGO, IDI_NOMBRE ) VALUES ( 
'es', 'Castellano'); 
INSERT INTO RDS_IDIOMA ( IDI_CODIGO, IDI_NOMBRE ) VALUES ( 
'ca', 'Catalán'); 

/* UBICACIONES */
INSERT INTO RDS_UBICA ( UBI_CODIGO, UBI_IDENT, UBI_NOMBRE,UBI_PLUGIN, UBI_DEFECT ) VALUES ( 
NEXTVAL('RDS_SEQUBI'), 'RDS', 'RDS defecto (BBDD)', 'es.caib.redose.persistence.plugin.PluginDefaultRDS','S'); 

insert into RDS_UBICA (UBI_CODIGO, UBI_IDENT, UBI_NOMBRE, UBI_PLUGIN, UBI_DEFECT)  
 values (NEXTVAL('RDS_SEQUBI'), 'FILE', 'Almacenamiento externo en ficheros', 
 'es.caib.redose.persistence.plugin.PluginAlmacenamientoFileSystem','N');
 
 update RDS_UBICA set  UBI_DEFECT = 'S' where UBI_IDENT = 'RDS';
 commit;

/* TIPO OPERACIONES */
INSERT INTO RDS_TIOPER ( TOP_CODIGO, TOP_NOMBRE ) VALUES ( 
'BODO', 'BORRADO AUTOMATICO DE DOCUMENTO SIN USOS'); 
INSERT INTO RDS_TIOPER ( TOP_CODIGO, TOP_NOMBRE ) VALUES ( 
'ELDO', 'ELIMINAR DOCUMENTO'); 
INSERT INTO RDS_TIOPER ( TOP_CODIGO, TOP_NOMBRE ) VALUES ( 
'AFDO', 'ASOCIAR FIRMA DOCUMENTO'); 
INSERT INTO RDS_TIOPER ( TOP_CODIGO, TOP_NOMBRE ) VALUES ( 
'ACDO', 'ACTUALIZAR DOCUMENTO'); 
INSERT INTO RDS_TIOPER ( TOP_CODIGO, TOP_NOMBRE ) VALUES ( 
'CODO', 'CONSULTAR DOCUMENTO'); 
INSERT INTO RDS_TIOPER ( TOP_CODIGO, TOP_NOMBRE ) VALUES ( 
'CODF', 'CONSULTAR DOCUMENTO FORMATEADO'); 
INSERT INTO RDS_TIOPER ( TOP_CODIGO, TOP_NOMBRE ) VALUES ( 
'NUUS', 'NUEVO USO'); 
INSERT INTO RDS_TIOPER ( TOP_CODIGO, TOP_NOMBRE ) VALUES ( 
'ELUS', 'ELIMINAR USO'); 
INSERT INTO RDS_TIOPER ( TOP_CODIGO, TOP_NOMBRE ) VALUES ( 
'ELUO', 'ELIMININAR USOS'); 
INSERT INTO RDS_TIOPER ( TOP_CODIGO, TOP_NOMBRE ) VALUES ( 
'NUDO', 'NUEVO DOCUMENTO'); 
INSERT INTO RDS_TIOPER ( TOP_CODIGO, TOP_NOMBRE ) VALUES ( 
'LIUS', 'LISTAR USOS'); 
INSERT INTO RDS_TIOPER ( TOP_CODIGO, TOP_NOMBRE ) VALUES ( 
'ACFI', 'ACTUALIZAR FICHERO'); 

/* TIPOS USO */
INSERT INTO RDS_TIUSO ( TIU_CODIGO, TIU_NOMBRE ) VALUES ( 
'ENV', 'ENVIO'); 
INSERT INTO RDS_TIUSO ( TIU_CODIGO, TIU_NOMBRE ) VALUES ( 
'EDI', 'EDI'); 
INSERT INTO RDS_TIUSO ( TIU_CODIGO, TIU_NOMBRE ) VALUES ( 
'PAD', 'PAD'); 
INSERT INTO RDS_TIUSO ( TIU_CODIGO, TIU_NOMBRE ) VALUES ( 
'RTE', 'RTE'); 
INSERT INTO RDS_TIUSO ( TIU_CODIGO, TIU_NOMBRE ) VALUES ( 
'EXP', 'EXP'); 
INSERT INTO RDS_TIUSO ( TIU_CODIGO, TIU_NOMBRE ) VALUES ( 
'RTS', 'RTS'); 
INSERT INTO RDS_TIUSO ( TIU_CODIGO, TIU_NOMBRE ) VALUES ( 
'TRA', 'TRA'); 
INSERT INTO RDS_TIUSO ( TIU_CODIGO, TIU_NOMBRE ) VALUES ( 
'PRE', 'PRE'); 
INSERT INTO RDS_TIUSO ( TIU_CODIGO, TIU_NOMBRE ) VALUES ( 
'BTE', 'BTE'); 

/* FORMATEADORES */
INSERT INTO RDS_FORMAT ( FOR_ID, FOR_CLASS, FOR_DESC ) VALUES ( 
NEXTVAL('RDS_SEQFOR'), 'es.caib.redose.persistence.formateadores.FormateadorPdfFormularios', 'Formateador basado en plantillas PDF'); 

INSERT INTO RDS_FORMAT ( FOR_ID, FOR_CLASS, FOR_DESC ) VALUES ( 
NEXTVAL('RDS_SEQFOR'), 'es.caib.redose.persistence.formateadores.FormateadorPdfPagos', 'Formateador basado en plantillas PDF para Justificantes de Pago'); 

INSERT INTO RDS_FORMAT ( FOR_ID, FOR_CLASS, FOR_DESC ) VALUES ( 
NEXTVAL('RDS_SEQFOR'), 'es.caib.redose.persistence.formateadores.FormateadorPdfJustificante', 'Formateador específico para Justificante'); 

INSERT INTO RDS_FORMAT ( FOR_ID, FOR_CLASS, FOR_DESC ) VALUES ( 
NEXTVAL('RDS_SEQFOR'), 'es.caib.redose.persistence.formateadores.FormateadorPdfJustificanteCopiaInteresado'
, 'Formateador específico para Justificante (copia interesado)'); 

INSERT INTO RDS_FORMAT ( FOR_ID, FOR_CLASS, FOR_DESC ) VALUES ( 
NEXTVAL('RDS_SEQFOR'), 'es.caib.redose.persistence.formateadores.FormateadorPdfJasper', 'Formateador basado en reportes JasperReport'); 

/* MODELOS */
INSERT INTO RDS_MODELO ( MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, MOD_DESC,MOD_ESTRUC ) 
VALUES ( NEXTVAL('RDS_SEQMOD'), 'GE0001JUSTIF', 'Justificant', 'Justificante', 'S'); 

INSERT INTO RDS_MODELO ( MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, MOD_DESC,MOD_ESTRUC ) 
VALUES ( NEXTVAL('RDS_SEQMOD'), 'GE0002ASIENTO', 'ASIENTO REGISTRAL', 'ASIENTO REGISTRAL', 'S'); 

INSERT INTO RDS_MODELO ( MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, MOD_DESC,
MOD_ESTRUC ) VALUES ( 
NEXTVAL('RDS_SEQMOD'), 'GE0003DATPROP', 'DATOS PROPIOS TRAMITE', 'DATOS PROPIOS TRAMITE', 'S'); 

INSERT INTO RDS_MODELO ( MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, MOD_DESC,
MOD_ESTRUC ) VALUES ( 
NEXTVAL('RDS_SEQMOD'), 'GE0004DOCID', 'Documento de Identidad', 'Documento genérico de identificación (NIF / NIE / CIF)'
, 'N'); 

INSERT INTO RDS_MODELO ( MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, MOD_DESC,
MOD_ESTRUC ) VALUES ( 
NEXTVAL('RDS_SEQMOD'), 'GE0005ANEXGEN', 'Anexo genérico', 'Documento para anexos genéricos que no tienen un modelo particular o que no es interesante modelar de forma individual'
, 'N'); 

INSERT INTO RDS_MODELO ( MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, MOD_DESC,
MOD_ESTRUC ) VALUES ( 
NEXTVAL('RDS_SEQMOD'), 'GE0006PAGO', 'Datos de Pago (Presencial y Telemático)', 'Documento para datos del pago (independiente del tipo de pago)'
, 'S'); 


INSERT INTO RDS_MODELO ( MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, MOD_DESC,
MOD_ESTRUC ) VALUES ( 
NEXTVAL('RDS_SEQMOD'), 'GE0008AVINOT', 'Aviso de notificacion', 'Modelo para aviso de notificación'
, 'S'); 

INSERT INTO RDS_MODELO ( MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, MOD_DESC,
MOD_ESTRUC ) VALUES ( 
NEXTVAL('RDS_SEQMOD'), 'GE0009OFIREM', 'Oficio de remisión', 'Oficio de remisión para notificaciones'
, 'S'); 

/* VERSIONES */
INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (NEXTVAL('RDS_SEQVER'),1,1,'Versión 1');

INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (NEXTVAL('RDS_SEQVER'),2,1,'Versión 1');

INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (NEXTVAL('RDS_SEQVER'),3,1,'Versión 1');

INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (NEXTVAL('RDS_SEQVER'),4,1,'Versión 1');

INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (NEXTVAL('RDS_SEQVER'),5,1,'Versión 1');

INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (NEXTVAL('RDS_SEQVER'),6,1,'Versión 1');

INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (NEXTVAL('RDS_SEQVER'),7,1,'Versión 1');

INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (NEXTVAL('RDS_SEQVER'),8,1,'Versión 1');

/* PLANTILLAS */
	/* JUSTIFICANTE */
INSERT INTO RDS_PLANTI ( PLA_CODIGO, PLA_CODVER, PLA_TIPO,  PLA_FORMAT, PLA_DEFECT, PLA_BARCOD,  PLA_SELLO) 
VALUES (NEXTVAL('RDS_SEQPLA') ,1 ,'PDF' , 3, 'S', 'S', 'N');
	/* PAGO */
INSERT INTO RDS_PLANTI ( PLA_CODIGO, PLA_CODVER, PLA_TIPO,  PLA_FORMAT, PLA_DEFECT, PLA_BARCOD,  PLA_SELLO) 
VALUES (NEXTVAL('RDS_SEQPLA') ,6 ,'PDF' , 2, 'S', 'S', 'N');

/* PLANTILLA  IDIOMA */
INSERT INTO RDS_PLAIDI (PLI_CODIGO, PLI_CODPLA, PLI_CODIDI,  PLI_NOMFIC) 
VALUES ( NEXTVAL('RDS_SEQPLI'), 1,'es' , 'cambiar.txt');

INSERT INTO RDS_PLAIDI (PLI_CODIGO, PLI_CODPLA, PLI_CODIDI,  PLI_NOMFIC) 
VALUES ( NEXTVAL('RDS_SEQPLI'), 2,'es' , 'cambiar.txt');

/* FICHEROS PLANTILLA  */	
INSERT INTO RDS_ARCPLI (ARP_CODPLI, ARP_DATOS) 
VALUES ( 1, ''); /* EMPTY_BLOB() */

INSERT INTO RDS_ARCPLI (ARP_CODPLI, ARP_DATOS) 
VALUES ( 2, ''); /* EMPTY_BLOB() */


INSERT INTO RDS_MODELO (MOD_CODIGO, MOD_MODELO, MOD_NOMBRE,MOD_DESC, MOD_ESTRUC) 
VALUES ( NEXTVAL('RDS_SEQMOD'), 'GE0011NOTIFICA', 'DOCUMENTO DE NOTIFICACION', 'DOCUMENTO ASOCIADO A UN REGISTRO DE SALIDA' , 'N');      

INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (NEXTVAL('RDS_SEQVER') , (SELECT MOD_CODIGO FROM RDS_MODELO WHERE MOD_MODELO='GE0011NOTIFICA'),1,'NOTIFICACION');


update RDS_DOCUM  set  DOC_REFGD = '#NOCONSOLIDABLE#';


INSERT INTO RDS_MODELO (
   MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, 
   MOD_DESC, MOD_ESTRUC, MOD_CUSTOD) 
VALUES (NEXTVAL('RDS_SEQMOD') , 'GE0012DELEGA','Autorización de delegación' ,
	   'Autorización de delegación', 'S', 'N');

INSERT INTO RDS_VERS (
   VER_CODIGO, 
   VER_CODMOD, 
   VER_VERSIO, 
   VER_DESC) 
VALUES (
	NEXTVAL('RDS_SEQVER') , 
	(SELECT MOD_CODIGO FROM RDS_MODELO WHERE MOD_MODELO = 'GE0012DELEGA'),
	 1 ,
	 'Version 1' );	   
commit;	   

INSERT INTO RDS_TIUSO ( TIU_CODIGO, TIU_NOMBRE ) VALUES ( 
'DLG', 'DELEGACION'); 

COMMIT;

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

COMMIT;


-- V2.1.0
INSERT INTO RDS_FORMAT ( FOR_ID, FOR_CLASS, FOR_DESC ) VALUES ( 
	NEXTVAL('RDS_SEQFOR'), 'es.caib.redose.persistence.formateadores.FormateadorPdfAsiento', 'Formateador específico para Asiento');
	
COMMIT;

-- From 2.2.4 to 2.2.5

UPDATE RDS_FICEXT SET FIE_CODUBI = (SELECT UBI_CODIGO FROM RDS_UBICA WHERE UBI_IDENT = 'FILE');

