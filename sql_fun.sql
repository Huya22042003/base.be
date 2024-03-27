-- DROP FUNCTION public.fn_code_name(varchar);

CREATE OR REPLACE FUNCTION public.fn_code_name(p_cd_id character varying)
 RETURNS character varying
 LANGUAGE plpgsql
AS $function$
	DECLARE
v_CODE_NAME varchar(255);
BEGIN
		IF p_CD_ID IS NULL THEN
	        v_CODE_NAME := p_CD_ID;
else
select INTO v_CODE_NAME cd_key from code_mng WHERE cd_id = p_CD_ID;
END IF;

RETURN v_CODE_NAME;
END;
$function$
;