package de.schoenbeck.serverprint.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.DB;

public class MPrinterProvider extends X_sbsp_printerprovider {

	private static final long serialVersionUID = 8527823674369073195L;

	public MPrinterProvider(Properties ctx, int sbsp_printerprovider_ID, String trxName) {
		super(ctx, sbsp_printerprovider_ID, trxName);
	}

	public MPrinterProvider(Properties ctx, int sbsp_printerprovider_ID, String trxName, String... virtualColumns) {
		super(ctx, sbsp_printerprovider_ID, trxName, virtualColumns);
	}

	public MPrinterProvider(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public List<MPrinter> getKnownPrinters() {
		final String sql = "SELECT DISTINCT * FROM " + MPrinter.Table_Name
						+ " WHERE " + MPrinter.COLUMNNAME_sbsp_printerprovider_ID + " = ?";
		LinkedList<MPrinter> rtn = new LinkedList<>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = DB.prepareStatement(sql, get_TrxName());
			ps.setInt(1, get_ID());
			rs = ps.executeQuery();
			
			while (rs.next()) {
				rtn.add(new MPrinter(getCtx(), rs, sql));
			}
		} catch (SQLException e) {
			CLogger.get().log(Level.SEVERE, "Can't get known printers for " + this.getValue(), e);
		} finally {
			DB.close(rs, ps);
		}
		return rtn;
	}
	
	public int[] getKnownPrinterIDs() {
		final String where = MPrinter.COLUMNNAME_sbsp_printerprovider_ID + " = ?";
		
		return new Query(getCtx(), MPrinter.Table_Name, where, get_TrxName())
				.setParameters(get_ID())
				.setClient_ID()
				.getIDs();
	}
}
