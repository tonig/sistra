/* EVENTOS EXPEDIENTES */
INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT ZPE_SEQIND.NEXTVAL, EXP_NIFRTE, 'A', HIE_CODIGO, 'T�tulo', HIE_TITULO
    FROM ZPE_HISTEX, ZPE_EXPEDI, ZPE_ELEEX 
					 WHERE EXP_SEYCIU IS NOT NULL AND EXP_NIFRTE IS NOT NULL AND
            EXP_CODIGO = ELE_CODEXP AND ELE_TIPO = 'A' AND ELE_CODELE = HIE_CODIGO AND HIE_TITULO IS NOT NULL;
					 
INSERT INTO ZPE_INDELE (IND_CODIGO, IND_NIF, IND_TIPEL, IND_CODEL, IND_DESCR, IND_VALOR) 
  SELECT ZPE_SEQIND.NEXTVAL, EXP_NIFRTE, 'A', HIE_CODIGO, 'Texto', HIE_TEXTO
    FROM ZPE_HISTEX, ZPE_EXPEDI, ZPE_ELEEX 
					 WHERE EXP_SEYCIU IS NOT NULL AND EXP_NIFRTE IS NOT NULL AND
            EXP_CODIGO = ELE_CODEXP AND ELE_TIPO = 'A' AND ELE_CODELE = HIE_CODIGO AND HIE_TEXTO IS NOT NULL;
