
UPDATE ZPE_EXPEDI
SET 
	EXP_NIFRTE = (SELECT PER_IDENTI FROM ZPE_PERSON WHERE PER_SEYCON = EXP_SEYCIU )
WHERE 
	EXP_SEYCIU IS NOT NULL;

COMMIT;