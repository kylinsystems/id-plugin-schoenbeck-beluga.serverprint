package de.schoenbeck.serverprint.params;

public class ServerPrintWorkerParamBuilder {

	int ad_client_id = 0;
	int ad_org_id = 0;
	int c_bpartner_id = 0;
	int ad_user_id = 0;
	int c_doctype_id = 0;
	int ad_tab_id = 0;
	int ad_user_id_bpartner = 0;
	int ad_table_id = 0;
	int record_id = 0;
	int sbsp_printoption_id = -1;
	
	public ServerPrintWorkerParamBuilder (ServerPrintWorkerParam copyFrom) {
		this.ad_client_id = copyFrom.ad_client_id;
		this.ad_org_id  = copyFrom.ad_org_id;
		this.c_bpartner_id = copyFrom.c_bpartner_id;
		this.ad_user_id = copyFrom.ad_user_id;
		this.c_doctype_id = copyFrom.c_doctype_id;
		this.ad_tab_id = copyFrom.ad_tab_id;
		this.ad_user_id_bpartner = copyFrom.ad_user_id_bpartner;
		this.ad_table_id = copyFrom.ad_table_id;
		this.record_id = copyFrom.record_id;
		this.sbsp_printoption_id = copyFrom.sbsp_printoption_id;
	}
	
	public ServerPrintWorkerParamBuilder() {}

	public ServerPrintWorkerParamBuilder setSbsp_printoption_id(int sbsp_printoption_id) {
		this.sbsp_printoption_id = sbsp_printoption_id;
		return this;
	}
	public ServerPrintWorkerParamBuilder setAd_client_id(int ad_client_id) {
		this.ad_client_id = ad_client_id;
		return this;
	}
	public ServerPrintWorkerParamBuilder setAd_org_id(int ad_org_id) {
		this.ad_org_id = ad_org_id;
		return this;
	}
	public ServerPrintWorkerParamBuilder setC_bpartner_id(int c_bpartner_id) {
		this.c_bpartner_id = c_bpartner_id;
		return this;
	}
	public ServerPrintWorkerParamBuilder setAd_user_id(int ad_user_id) {
		this.ad_user_id = ad_user_id;
		return this;
	}
	public ServerPrintWorkerParamBuilder setC_doctype_id(int c_doctype_id) {
		this.c_doctype_id = c_doctype_id;
		return this;
	}
	public ServerPrintWorkerParamBuilder setAd_tab_id(int ad_tab_id) {
		this.ad_tab_id = ad_tab_id;
		return this;
	}
	public ServerPrintWorkerParamBuilder setAd_user_id_bpartner(int ad_user_id_bpartner) {
		this.ad_user_id_bpartner = ad_user_id_bpartner;
		return this;
	}
	public ServerPrintWorkerParamBuilder setAd_table_id(int ad_table_id) {
		this.ad_table_id = ad_table_id;
		return this;
	}
	public ServerPrintWorkerParamBuilder setRecord_id(int record_id) {
		this.record_id = record_id;
		return this;
	}
	
	public ServerPrintWorkerParam build () {
		return new ServerPrintWorkerParam(this);
	}
}
