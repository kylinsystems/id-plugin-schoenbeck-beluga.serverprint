package de.schoenbeck.serverprint.params;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.compiere.process.ProcessInfoParameter;

import de.schoenbeck.serverprint.work.Copy;

public class ServerPrintCopyParamBuilder {

	int ad_client_id = 0;
	int ad_org_id = 0;
	int ad_user_id = 0;
	int c_bpartner_id = 0;
	int c_doctype_id = 0;
	int sbsp_printconfig_id = 0;
	int ad_process_id = 0;
	String reportVariant = "";
	String exportFileExtension = "";
	String exportFilenamePattern = "";
	String depositPath = "";
	int from_ad_user_id = 0;
	int r_mailtext_id = 0;
	int copies = 0;
	String eMailTo = "";
	List<String> eMailCc = java.util.Collections.emptyList();
	List<String> eMailBcc = java.util.Collections.emptyList();
	String[] mailAttPrefix = {};
	
	boolean toArchive = false;
	boolean mailtouser = false;
	boolean mailtoaddress = false;
	boolean senddirectly = false;
	boolean actualuserasfrom = false;
	
	int ad_table_id = 0;
	int ad_user_id_bpartner = 0;
	int record_id = 0;
	
	int sbsp_printoption_id = 0;
	
	int windowno = 0;
	boolean isCalledFromProcess = true;
	ProcessInfoParameter[] processParams = {};
	public final String trxname;
	
	/**
	 * Values are initialized as follows:
	 * <ul>
	 * <li>All integers are 0.</li>
	 * <li>All booleans are false.</li>
	 * <li>All strings are the empty string.</li>
	 * <li>All iterables are of length 0.</li>
	 * </ul>
	 * @param trxname
	 */
	public ServerPrintCopyParamBuilder (String trxname) {
		this.trxname = trxname;
	}
	
	public ServerPrintCopyParamBuilder setFromResultSet (ResultSet rs) throws SQLException {
		this.ad_client_id = rs.getInt("ad_client_id");
		this.ad_org_id = rs.getInt("ad_org_id");
		this.ad_user_id = rs.getInt("ad_user_id");
		this.c_bpartner_id = rs.getInt("c_bpartner_id");
		this.c_doctype_id = rs.getInt("c_doctype_id");
		
		this.sbsp_printconfig_id = rs.getInt("sbsp_printconfig_id");
		this.ad_process_id = rs.getInt("ad_process_id");
		this.reportVariant = nvl(rs.getString("ReportVariant"));
		String extension = nvl(rs.getString("ExportFileExtension"));
		if (extension != null && extension.equals(""))
			extension = "pdf";
		this.exportFileExtension = extension;
		this.exportFilenamePattern = nvl(rs.getString("ExportFilenamePattern"));
		
		this.depositPath = nvl(rs.getString("DepositPath"));				
		this.toArchive = rs.getString("toarchive").equals("Y");
		
		this.from_ad_user_id = rs.getInt("From_AD_User_ID");
		this.r_mailtext_id = rs.getInt("r_mailtext_id");
		this.copies = (rs.getObject("copies") == null) ? (1) : rs.getInt("copies");
		
		this.eMailTo = nvl(rs.getString("EMail_to"));
		this.eMailCc = Copy.makeCcList(rs.getString("EMail_CC"));
		this.eMailBcc = Copy.makeCcList(rs.getString("RecipientBcc"));
		this.mailAttPrefix = ( (rs.getString("mailattachment_prefix") != null) ? (rs.getString("mailattachment_prefix").split(",")) : new String[0] );
		this.mailtoaddress = rs.getString("mailtoaddress").equals("Y");
		this.mailtouser = rs.getString("mailtouser").equals("Y");
		this.senddirectly = rs.getString("senddirectly").equals("Y");
		this.actualuserasfrom = rs.getString("actualuserasfrom").equals("Y");
		
		this.sbsp_printoption_id = rs.getInt("sbsp_printoption_id");
		
		return this;
	}
	
	public ServerPrintCopyParamBuilder setAd_client_id(int ad_client_id) {
		this.ad_client_id = ad_client_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setAd_org_id(int ad_org_id) {
		this.ad_org_id = ad_org_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setAd_user_id(int ad_user_id) {
		this.ad_user_id = ad_user_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setC_bpartner_id(int c_bpartner_id) {
		this.c_bpartner_id = c_bpartner_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setC_doctype_id(int c_doctype_id) {
		this.c_doctype_id = c_doctype_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setSbsp_printconfig_id(int sbsp_printconfig_id) {
		this.sbsp_printconfig_id = sbsp_printconfig_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setAd_process_id(int ad_process_id) {
		this.ad_process_id = ad_process_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setReportVariant(String reportVariant) {
		this.reportVariant = nvl(reportVariant);
		return this;
	}

	public ServerPrintCopyParamBuilder setExportFileExtension(String exportFileExtension) {
		this.exportFileExtension = nvl(exportFileExtension);
		return this;
	}

	public ServerPrintCopyParamBuilder setExportFilenamePattern(String exportFilenamePattern) {
		this.exportFilenamePattern = nvl(exportFilenamePattern);
		return this;
	}

	public ServerPrintCopyParamBuilder setDepositPath(String depositPath) {
		this.depositPath = nvl(depositPath);
		return this;
	}

	public ServerPrintCopyParamBuilder setFrom_ad_user_id(int from_ad_user_id) {
		this.from_ad_user_id = from_ad_user_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setR_mailtext_id(int r_mailtext_id) {
		this.r_mailtext_id = r_mailtext_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setCopies(int copies) {
		this.copies = copies;
		return this;
	}

	public ServerPrintCopyParamBuilder seteMailTo(String eMailTo) {
		this.eMailTo = nvl(eMailTo);
		return this;
	}

	public ServerPrintCopyParamBuilder seteMailCc(List<String> eMailCc) {
		this.eMailCc = (eMailCc != null) ? eMailCc : Collections.emptyList();
		return this;
	}

	public ServerPrintCopyParamBuilder seteMailBcc(List<String> eMailBcc) {
		this.eMailBcc = (eMailBcc != null) ? eMailBcc : Collections.emptyList();
		return this;
	}
	
	public ServerPrintCopyParamBuilder setMailAttPrefix(String[] mailAttPrefix) {
		this.mailAttPrefix = (mailAttPrefix != null) ? mailAttPrefix : new String[0];
		return this;
	}

	public ServerPrintCopyParamBuilder setToArchive(boolean toArchive) {
		this.toArchive = toArchive;
		return this;
	}

	public ServerPrintCopyParamBuilder setMailtouser(boolean mailtouser) {
		this.mailtouser = mailtouser;
		return this;
	}

	public ServerPrintCopyParamBuilder setMailtoaddress(boolean mailtoaddress) {
		this.mailtoaddress = mailtoaddress;
		return this;
	}

	public ServerPrintCopyParamBuilder setSenddirectly(boolean senddirectly) {
		this.senddirectly = senddirectly;
		return this;
	}

	public ServerPrintCopyParamBuilder setActualuserasfrom(boolean actualuserasfrom) {
		this.actualuserasfrom = actualuserasfrom;
		return this;
	}

	public ServerPrintCopyParamBuilder setAd_table_id(int ad_table_id) {
		this.ad_table_id = ad_table_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setAd_user_id_bpartner(int ad_user_id_bpartner) {
		this.ad_user_id_bpartner = ad_user_id_bpartner;
		return this;
	}

	public ServerPrintCopyParamBuilder setRecord_id(int record_id) {
		this.record_id = record_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setSbsp_printoption_id(int sbsp_printoption_id) {
		this.sbsp_printoption_id = sbsp_printoption_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setWindowno(int windowno) {
		this.windowno = windowno;
		return this;
	}

	public ServerPrintCopyParamBuilder setCalledFromProcess(boolean isCalledFromProcess) {
		this.isCalledFromProcess = isCalledFromProcess;
		return this;
	}
	
	public ServerPrintCopyParamBuilder setProcessParams(ProcessInfoParameter[] params) {
		this.processParams = params;
		return this;
	}

	public ServerPrintCopyParam build () {
		return new ServerPrintCopyParam(this);
	}
	
	private String nvl (String s) {
		return (s == null) ? "" : s;
	}
}
