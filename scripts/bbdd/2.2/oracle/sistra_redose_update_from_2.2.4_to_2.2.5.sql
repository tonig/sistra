alter table RDS_FICEXT  add FIE_CODUBI  NUMBER(20);

comment on column RDS_FICEXT.FIE_CODUBI is 'INDICA CODIGO DE UBICACION';

UPDATE RDS_FICEXT SET FIE_CODUBI = (SELECT UBI_CODIGO FROM RDS_UBICA WHERE UBI_IDENT = 'FILE');

COMMIT;

alter table RDS_FICEXT modify FIE_CODUBI  not null;