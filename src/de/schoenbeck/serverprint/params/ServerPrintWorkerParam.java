package de.schoenbeck.serverprint.params;

import org.compiere.process.ProcessInfoParameter;

public class ServerPrintWorkerParam {

	public final int ad_client_id;
	public final int ad_org_id;
	public final int c_bpartner_id;
	public final int ad_user_id;
	public final int c_doctype_id;
	public final int ad_tab_id;
	public final int ad_user_id_bpartner;
	public final int ad_table_id;
	public final int record_id;
	public final int sbsp_printoption_id;
	public final ProcessInfoParameter[] parameter;
	
	ServerPrintWorkerParam (ServerPrintWorkerParamBuilder builder) {
		this.ad_client_id = builder.ad_client_id;
		this.ad_org_id = builder.ad_org_id;
		this.c_bpartner_id = builder.c_bpartner_id;
		this.ad_user_id = builder.ad_user_id;
		this.c_doctype_id = builder.c_doctype_id;
		this.ad_tab_id = builder.ad_tab_id;
		this.ad_user_id_bpartner = builder.ad_user_id_bpartner;
		this.ad_table_id = builder.ad_table_id;
		this.record_id = builder.record_id;
		this.sbsp_printoption_id = builder.sbsp_printoption_id;
		this.parameter = builder.parameter;
	}
}
