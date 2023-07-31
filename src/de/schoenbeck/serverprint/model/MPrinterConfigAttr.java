package de.schoenbeck.serverprint.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MPrinterConfigAttr extends X_sbsp_printerconfigattr {

	private static final long serialVersionUID = -898709030182583453L;

	public MPrinterConfigAttr(Properties ctx, int sbsp_printerconfigattr_ID, String trxName) {
		super(ctx, sbsp_printerconfigattr_ID, trxName);
		// 
	}

	public MPrinterConfigAttr(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// 
	}

}
