package de.schoenbeck.serverprint.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MPrinterAttributeName extends X_sbsp_attributename {

	private static final long serialVersionUID = 3996635495692287199L;

	public MPrinterAttributeName(Properties ctx, int sbsp_attributename_ID, String trxName) {
		super(ctx, sbsp_attributename_ID, trxName);
		
	}

	public MPrinterAttributeName(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);

	}

}
