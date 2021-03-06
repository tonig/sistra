ALTER TABLE STR_TRAMIT ADD TRA_IDPROC VARCHAR2(100);

comment on column STR_TRAMIT.TRA_IDPROC is
'Identificador del procedimiento al que pertenece el tr�mite';

UPDATE STR_TRAMIT SET TRA_IDPROC = TRA_IDENTI;
COMMIT;

ALTER TABLE STR_TRAMIT  MODIFY  TRA_IDPROC  not null;
 
alter table STR_ESPNIV add ETN_PERSMS VARCHAR2(1) default 'N' not null;

alter table STR_ESPNIV drop column ETN_AVISOS;

commit;