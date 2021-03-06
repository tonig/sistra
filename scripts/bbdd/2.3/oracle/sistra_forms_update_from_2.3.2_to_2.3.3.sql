ALTER table RFR_COMPON  ADD COM_LBLTIPO VARCHAR2(2) default 'NO' not null;
comment on column RFR_COMPON.COM_LBLTIPO is 'CAMPO ETIQUETA:TIPO ETIQUETA (NORMAL NO / INFORMACION IN / ALERTA AL / ERROR ER)';

ALTER table RFR_COMPON  ADD COM_ORIENT  VARCHAR2(1) default 'H' not null;
comment on column RFR_COMPON.COM_ORIENT is 'CAMPO CSU: ORIENTACION (VERTICAL V / HORIZONTAL H)';

ALTER table RFR_COMPON  ADD COM_LDEIND NUMBER(1) default 0 not null;
comment on column RFR_COMPON.COM_LDEIND is 'CAMPO LDE: INDICA SI SE MUESTRA INDICE ALFABETICO';

ALTER table RFR_TRACAM  ADD  TRC_PLACEH VARCHAR2(100);
comment on column RFR_TRACAM.TRC_PLACEH is 'PLACEHOLDER PARA TEXTBOX';


UPDATE rfr_compon SET com_selmul = 1 WHERE com_type = 'listbox';
COMMIT;