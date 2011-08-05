ALTER TABLE BTE_TRAAPL ADD (TAP_WSVER  VARCHAR2(10 BYTE));

update bte_traapl set tap_wsver = 'v1' where tap_tipacc = 'W';
commit;

ALTER TABLE BTE_TRAAPL
 ADD (TAP_ERRORS  BLOB);

COMMENT ON COLUMN BTE_TRAAPL.TAP_ERRORS IS 'MUESTRA LOS DOS ULTIMOS ERRORES QUE HAN SUCEDIDO DURANTE LAS INTEGACIONES';


ALTER table BTE_TRAMIT ADD TRA_NIFDLG           VARCHAR2(12);
ALTER table BTE_TRAMIT ADD TRA_NOMDLG           VARCHAR2(500);


comment on column BTE_TRAMIT.TRA_NIFDLG is
'En caso de existir delegacion, indica NIF del delegado que presenta el tramite';

comment on column BTE_TRAMIT.TRA_NOMDLG is
'En caso de existir delegacion indica nombre del delegado que presenta el tramite';

ALTER TABLE BTE_TRAMIT  ADD   TRA_SBEXID           VARCHAR2(50);
ALTER TABLE BTE_TRAMIT  ADD   TRA_SBEXUA           NUMBER(19);

comment on column BTE_TRAMIT.TRA_SBEXID is
'EN CASO DE TRAMITE DE SUBSANACION INDICA ID EXPEDIENTE ASOCIADO';

comment on column BTE_TRAMIT.TRA_SBEXUA is
'EN CASO DE TRAMITE DE SUBSANACION INDICA UNIDAD ADMINISTRATIVA EXPEDIENTE';

ALTER TABLE BTE_TRAAPL MODIFY TAP_IDETRA VARCHAR2(20);
ALTER TABLE BTE_TRAMIT MODIFY TRA_IDETRA VARCHAR2(20);

ALTER TABLE BTE_FICEXP  MODIFY FIC_IDETRA VARCHAR2(20); 
ALTER TABLE BTE_GESTRA  MODIFY GAP_IDETRA VARCHAR2(20); 