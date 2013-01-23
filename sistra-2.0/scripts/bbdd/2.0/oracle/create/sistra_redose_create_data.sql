/* IDIOMAS */
INSERT INTO RDS_IDIOMA ( IDI_CODIGO, IDI_NOMBRE ) VALUES ( 
'es', 'Castellano'); 
INSERT INTO RDS_IDIOMA ( IDI_CODIGO, IDI_NOMBRE ) VALUES ( 
'ca', 'Catal�n'); 

/* UBICACIONES */
INSERT INTO RDS_UBICA ( UBI_CODIGO, UBI_IDENT, UBI_NOMBRE,UBI_PLUGIN, UBI_DEFECT ) VALUES ( 
RDS_SEQUBI.NEXTVAL, 'RDS', 'RDS defecto (BBDD)', 'es.caib.redose.persistence.plugin.PluginDefaultRDS','S'); 

insert into RDS_UBICA (UBI_CODIGO, UBI_IDENT, UBI_NOMBRE, UBI_PLUGIN, UBI_DEFECT)  
 values (RDS_SEQUBI.NEXTVAL, 'FILE', 'Almacenamiento externo en ficheros', 
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
RDS_SEQFOR.NEXTVAL, 'es.caib.redose.persistence.formateadores.FormateadorPdfFormularios', 'Formateador basado en plantillas PDF'); 

INSERT INTO RDS_FORMAT ( FOR_ID, FOR_CLASS, FOR_DESC ) VALUES ( 
RDS_SEQFOR.NEXTVAL, 'es.caib.redose.persistence.formateadores.FormateadorPdfPagos', 'Formateador basado en plantillas PDF para Justificantes de Pago'); 

INSERT INTO RDS_FORMAT ( FOR_ID, FOR_CLASS, FOR_DESC ) VALUES ( 
RDS_SEQFOR.NEXTVAL, 'es.caib.redose.persistence.formateadores.FormateadorPdfJustificante', 'Formateador espec�fico para Justificante'); 

INSERT INTO RDS_FORMAT ( FOR_ID, FOR_CLASS, FOR_DESC ) VALUES ( 
RDS_SEQFOR.NEXTVAL, 'es.caib.redose.persistence.formateadores.FormateadorPdfJustificanteCopiaInteresado'
, 'Formateador espec�fico para Justificante (copia interesado)'); 

INSERT INTO RDS_FORMAT ( FOR_ID, FOR_CLASS, FOR_DESC ) VALUES ( 
RDS_SEQFOR.NEXTVAL, 'es.caib.redose.persistence.formateadores.FormateadorPdfJasper', 'Formateador basado en reportes JasperReport'); 

/* MODELOS */
INSERT INTO RDS_MODELO ( MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, MOD_DESC,MOD_ESTRUC ) 
VALUES ( RDS_SEQMOD.NEXTVAL, 'GE0001JUSTIF', 'Justificant', 'Justificante', 'S'); 

INSERT INTO RDS_MODELO ( MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, MOD_DESC,MOD_ESTRUC ) 
VALUES ( RDS_SEQMOD.NEXTVAL, 'GE0002ASIENTO', 'ASIENTO REGISTRAL', 'ASIENTO REGISTRAL', 'S'); 

INSERT INTO RDS_MODELO ( MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, MOD_DESC,
MOD_ESTRUC ) VALUES ( 
RDS_SEQMOD.NEXTVAL, 'GE0003DATPROP', 'DATOS PROPIOS TRAMITE', 'DATOS PROPIOS TRAMITE', 'S'); 

INSERT INTO RDS_MODELO ( MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, MOD_DESC,
MOD_ESTRUC ) VALUES ( 
RDS_SEQMOD.NEXTVAL, 'GE0004DOCID', 'Documento de Identidad', 'Documento gen�rico de identificaci�n (NIF / NIE / CIF)'
, 'N'); 

INSERT INTO RDS_MODELO ( MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, MOD_DESC,
MOD_ESTRUC ) VALUES ( 
RDS_SEQMOD.NEXTVAL, 'GE0005ANEXGEN', 'Anexo gen�rico', 'Documento para anexos gen�ricos que no tienen un modelo particular o que no es interesante modelar de forma individual'
, 'N'); 

INSERT INTO RDS_MODELO ( MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, MOD_DESC,
MOD_ESTRUC ) VALUES ( 
RDS_SEQMOD.NEXTVAL, 'GE0006PAGO', 'Datos de Pago (Presencial y Telem�tico)', 'Documento para datos del pago (independiente del tipo de pago)'
, 'S'); 


INSERT INTO RDS_MODELO ( MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, MOD_DESC,
MOD_ESTRUC ) VALUES ( 
RDS_SEQMOD.NEXTVAL, 'GE0008AVINOT', 'Aviso de notificacion', 'Modelo para aviso de notificaci�n'
, 'S'); 

INSERT INTO RDS_MODELO ( MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, MOD_DESC,
MOD_ESTRUC ) VALUES ( 
RDS_SEQMOD.NEXTVAL, 'GE0009OFIREM', 'Oficio de remisi�n', 'Oficio de remisi�n para notificaciones'
, 'S'); 

/* VERSIONES */
INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (RDS_SEQVER.NEXTVAL,1,1,'Versi�n 1');

INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (RDS_SEQVER.NEXTVAL,2,1,'Versi�n 1');

INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (RDS_SEQVER.NEXTVAL,3,1,'Versi�n 1');

INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (RDS_SEQVER.NEXTVAL,4,1,'Versi�n 1');

INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (RDS_SEQVER.NEXTVAL,5,1,'Versi�n 1');

INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (RDS_SEQVER.NEXTVAL,6,1,'Versi�n 1');

INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (RDS_SEQVER.NEXTVAL,7,1,'Versi�n 1');

INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (RDS_SEQVER.NEXTVAL,8,1,'Versi�n 1');

/* PLANTILLAS */
	/* JUSTIFICANTE */
INSERT INTO RDS_PLANTI ( PLA_CODIGO, PLA_CODVER, PLA_TIPO,  PLA_FORMAT, PLA_DEFECT, PLA_BARCOD,  PLA_SELLO) 
VALUES (RDS_SEQPLA.NEXTVAL ,1 ,'PDF' , 3, 'S', 'S', 'N');
	/* PAGO */
INSERT INTO RDS_PLANTI ( PLA_CODIGO, PLA_CODVER, PLA_TIPO,  PLA_FORMAT, PLA_DEFECT, PLA_BARCOD,  PLA_SELLO) 
VALUES (RDS_SEQPLA.NEXTVAL ,6 ,'PDF' , 2, 'S', 'S', 'N');

/* PLANTILLA  IDIOMA */
INSERT INTO RDS_PLAIDI (PLI_CODIGO, PLI_CODPLA, PLI_CODIDI,  PLI_NOMFIC) 
VALUES ( RDS_SEQPLI.NEXTVAL, 1,'es' , 'cambiar.txt');

INSERT INTO RDS_PLAIDI (PLI_CODIGO, PLI_CODPLA, PLI_CODIDI,  PLI_NOMFIC) 
VALUES ( RDS_SEQPLI.NEXTVAL, 2,'es' , 'cambiar.txt');

/* FICHEROS PLANTILLA  */	
INSERT INTO RDS_ARCPLI (ARP_CODPLI, ARP_DATOS) 
VALUES ( 1, EMPTY_BLOB());

INSERT INTO RDS_ARCPLI (ARP_CODPLI, ARP_DATOS) 
VALUES ( 2, EMPTY_BLOB());


INSERT INTO RDS_MODELO (MOD_CODIGO, MOD_MODELO, MOD_NOMBRE,MOD_DESC, MOD_ESTRUC) 
VALUES ( RDS_SEQMOD.NEXTVAL, 'GE0011NOTIFICA', 'DOCUMENTO DE NOTIFICACION', 'DOCUMENTO ASOCIADO A UN REGISTRO DE SALIDA' , 'N');      

INSERT INTO RDS_VERS ( VER_CODIGO, VER_CODMOD, VER_VERSIO, VER_DESC) 
VALUES (RDS_SEQVER.NEXTVAL , (SELECT MOD_CODIGO FROM RDS_MODELO WHERE MOD_MODELO='GE0011NOTIFICA'),1,'NOTIFICACION');


update RDS_DOCUM  set  DOC_REFGD = '#NOCONSOLIDABLE#';


INSERT INTO RDS_MODELO (
   MOD_CODIGO, MOD_MODELO, MOD_NOMBRE, 
   MOD_DESC, MOD_ESTRUC, MOD_CUSTOD) 
VALUES (RDS_SEQMOD.NEXTVAL , 'GE0012DELEGA','Autorizaci�n de delegaci�n' ,
	   'Autorizaci�n de delegaci�n', 'S', 'N');

INSERT INTO RDS_VERS (
   VER_CODIGO, 
   VER_CODMOD, 
   VER_VERSIO, 
   VER_DESC) 
VALUES (
	RDS_SEQVER.NEXTVAL , 
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
RDS_SEQMOD.NEXTVAL, 
'GE0013NOTIFEXT', 
'Modelo documento externo notificacion', 
'Usado para documentos externos de anexos de notificaciones y avisos en los que se indica una url al documento. En el redose se almacenara un xml con la url de acceso',
'S',
'N');

INSERT INTO RDS_VERS (
   VER_CODIGO, VER_CODMOD, VER_VERSIO, 
   VER_DESC) 
VALUES ( RDS_SEQVER.NEXTVAL,
 (SELECT MOD_CODIGO FROM RDS_MODELO WHERE MOD_MODELO = 'GE0013NOTIFEXT'),
 1,
 'VERSION 1');

COMMIT;



