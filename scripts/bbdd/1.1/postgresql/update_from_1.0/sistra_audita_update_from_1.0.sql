ALTER TABLE AUD_AUDIT ALTER COLUMN AUD_MODTRA TYPE VARCHAR(20);

-- From 1.1.4 to 1.1.5
INSERT INTO AUD_TIPOEV (
   TIP_TIPO, TIP_MODUL, TIP_AUDIT, 
   TIP_DESC, TIP_ORDEN, TIP_PRPCLS, 
   TIP_HANDLR, TIP_AYUDA, TIP_DESCCA, 
   TIP_AYUDAC) 
VALUES ( 'PATETA',
'CATALG',
'S',
'Pago telem�tico con tarjeta',
11,
null,
null,
'Pago telem�tico con tarjeta',
'Pagament telem�tic amb targeta',
'Pagament telem�tic amb targeta');