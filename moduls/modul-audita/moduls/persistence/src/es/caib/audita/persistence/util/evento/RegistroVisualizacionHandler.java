package es.caib.audita.persistence.util.evento;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import es.caib.audita.model.AuditConstants;
import es.caib.audita.modelInterfaz.ConstantesAuditoria;

public class RegistroVisualizacionHandler extends
		CuadroMandoDetalleHandler
{
	
	public String obtenerCodigoVisualizacion()
	{
		this.getDateFinal();
		this.getDateInicial();
		String ls_tipo = this.getTipoEvento();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String ls_fechaInicio = dateFormat.format(this.getDateInicial());
		String ls_fechaFinal = "";
		if(this.getDateFinal() != null)
		{
		   ls_fechaFinal = dateFormat.format(this.getDateFinal());
		}
		String result = "";
		Connection con = null;
		try
		{
			List lstResultConsulta;
			String ls_query = "sql.select.registro";
			con = this.getConnection();
			if(this.getDateFinal() == null)
			{
				ls_query += ".desde";
				lstResultConsulta = this.queryForMapList( con, RegistroVisualizacionHandler.class, ls_query , new Object[]{ ls_tipo, ls_fechaInicio });
			}
			else
			{
				lstResultConsulta = this.queryForMapList( con, RegistroVisualizacionHandler.class, ls_query , new Object[]{ ls_tipo, ls_fechaInicio, ls_fechaFinal });
			}
			
			String registro = (getIdioma().equals(ConstantesAuditoria.LANGUAGE_CATALAN)) ? "Registre" : "Registro" ;
			String bandeja = (getIdioma().equals(ConstantesAuditoria.LANGUAGE_CATALAN)) ? "Safata" : "Bandeja" ;

			// Registro
			result += "<img src=\"./images/cuadromando/i_registro_r.gif\" title=\"" + registro + "\"  style=\"vertical-align:middle;\"> &nbsp;" + 
                      getTotal(lstResultConsulta,String.valueOf(AuditConstants.REGISTRO))+
                      "&nbsp;"; 
			
			// Bandeja
			result += "<img src=\"./images/cuadromando/i_registro_b.gif\"  title=\"" + bandeja + "\" style=\"vertical-align:middle;\"> &nbsp;" + 
                      getTotal(lstResultConsulta,String.valueOf(AuditConstants.BANDEJA)) +
                      "&nbsp;"; 			
			// Consulta
			result += "<img src=\"./images/cuadromando/i_registro_c.gif\" title=\"Consulta\"  style=\"vertical-align:middle;\"> &nbsp;" + 
                      getTotal(lstResultConsulta,String.valueOf(AuditConstants.CONSULTA)); 
			
			// Asistente
			result += "<img src=\"./images/cuadromando/i_registro_a.gif\" title=\"Asistente\"  style=\"vertical-align:middle;\"> &nbsp;" + 
                      getTotal(lstResultConsulta,String.valueOf(AuditConstants.ASISTENTE)); 

			return result;
		}
		catch( Exception exc )
		{
			log.error("Excepcion: " + exc.getMessage(), exc);
		}
		/*
		finally
		{
			if(con != null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					log.error("Excepcion: " + e.getMessage(), e);
				}
			}
		}
		*/

		return result;
	}
	
	private int getTotal(List lista, String tipo)
	{
		for(int i=0; i<lista.size(); i++)
		{
			Map mResult = ( Map ) lista.get(i);
			String clave = ( String ) mResult.get( "clave" );
			if(clave == null)
			{
				return 0;
			}
			if(clave.equals(tipo))
			{
				Number total = (Number) mResult.get( "total" );
				return total.intValue();
			}
		}
		return 0;
	}

}
