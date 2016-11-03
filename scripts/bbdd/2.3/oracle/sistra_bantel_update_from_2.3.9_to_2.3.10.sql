ALTER table BTE_PROAPL  ADD  TAP_REGOFI           VARCHAR2(25);
ALTER table BTE_PROAPL  ADD TAP_REGORG           VARCHAR2(25);
ALTER table BTE_PROAPL  ADD  TAP_CLAVE            VARCHAR2(1)  default 'N' not null;
ALTER table BTE_PROAPL  ADD TAP_AVIREM           VARCHAR2(255);
ALTER table BTE_PROAPL  ADD TAP_AVIREP           VARCHAR2(255);

comment on column BTE_PROAPL.TAP_REGOFI is
'OFICINA REGISTRO (DEFECTO GESTION EXPEDIENTES)';

comment on column BTE_PROAPL.TAP_REGORG is
'ORGANO DESTINO REGISTRO  (DEFECTO GESTION EXPEDIENTES)';

comment on column BTE_PROAPL.TAP_CLAVE is
'SI POR DEFECTO SE PERMITE EL ACCESO POR CLAVE EN NOTIFICACIONES';

comment on column BTE_PROAPL.TAP_AVIREM is
'REMITENTE PARA AVISOS PROCEDIMIENTO';

comment on column BTE_PROAPL.TAP_AVIREP is
'EMAIL PARA RESPUESTA PARA AVISOS PROCEDIMIENTO';