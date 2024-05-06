package de.schoenbeck.serverprint.params;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.compiere.process.ProcessInfoParameter;

public class ServerPrintCopyParam {

	public final int ad_client_id;
	public final int ad_org_id;
	public final int ad_user_id;
	public final int c_bpartner_id;
	public final int c_doctype_id;
	public final int sbsp_printconfig_id;
	public final int ad_process_id;
	public final String reportVariant;
	public final String exportFileExtension;
	public final String exportFilenamePattern;
	public final String depositPath;
	public final int from_ad_user_id;
	public final int r_mailtext_id;
	public final int copies;
	public final String eMailTo;
	public final List<String> eMailCc;
	public final List<String> eMailBcc;
	public final String[] mailAttPrefix;
	
	public final boolean toArchive;
	public final boolean useFromArchive;
	public final boolean mailtouser;
	public final boolean mailtoaddress;
	public final boolean senddirectly;
	public final boolean actualuserasfrom;
	
	public final int ad_table_id;
	public final int ad_user_id_bpartner;
	public final int record_id;
	
	public final int sbsp_printoption_id;
	
	public final int windowno = 0;
	public final boolean isCalledFromProcess;
	public final ProcessInfoParameter[] processParams;
	public final String trxname;
	
	
	ServerPrintCopyParam(ServerPrintCopyParamBuilder b) {
		this.ad_client_id = b.ad_client_id;
		this.ad_org_id = b.ad_org_id;
		this.ad_user_id = b.ad_user_id;
		this.c_bpartner_id = b.c_bpartner_id;
		this.c_doctype_id = b.c_doctype_id;
		this.sbsp_printconfig_id = b.sbsp_printconfig_id;
		this.ad_process_id = b.ad_process_id;
		this.reportVariant = b.reportVariant;
		this.exportFileExtension = b.exportFileExtension;
		this.exportFilenamePattern = b.exportFilenamePattern;
		this.depositPath = b.depositPath;
		this.from_ad_user_id = b.from_ad_user_id;
		this.r_mailtext_id = b.r_mailtext_id;
		this.copies = b.copies;
		this.eMailTo = b.eMailTo;
		this.eMailCc = b.eMailCc;
		this.eMailBcc = b.eMailBcc;
		this.mailAttPrefix = b.mailAttPrefix;
		this.toArchive = b.toArchive;
		this.useFromArchive = b.useFromArchive;
		this.mailtouser = b.mailtouser;
		this.mailtoaddress = b.mailtoaddress;
		this.senddirectly = b.senddirectly;
		this.actualuserasfrom = b.actualuserasfrom;
		this.ad_table_id = b.ad_table_id;
		this.ad_user_id_bpartner = b.ad_user_id_bpartner;
		this.record_id = b.record_id;
		this.isCalledFromProcess = b.isCalledFromProcess;
		this.trxname = b.trxname;
		this.sbsp_printoption_id = b.sbsp_printoption_id;
		this.processParams = b.processParams;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(mailAttPrefix);
		result = prime * result + Objects.hash(actualuserasfrom, ad_client_id, ad_org_id, ad_process_id, ad_table_id,
				ad_user_id, ad_user_id_bpartner, c_bpartner_id, c_doctype_id, copies, depositPath, eMailCc, eMailTo,
				exportFileExtension, exportFilenamePattern, from_ad_user_id, isCalledFromProcess, mailtoaddress,
				mailtouser, r_mailtext_id, record_id, reportVariant, sbsp_printconfig_id, senddirectly, toArchive,
				trxname, windowno);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServerPrintCopyParam other = (ServerPrintCopyParam) obj;
		return actualuserasfrom == other.actualuserasfrom && ad_client_id == other.ad_client_id
				&& ad_org_id == other.ad_org_id && ad_process_id == other.ad_process_id
				&& ad_table_id == other.ad_table_id && ad_user_id == other.ad_user_id
				&& ad_user_id_bpartner == other.ad_user_id_bpartner && c_bpartner_id == other.c_bpartner_id
				&& c_doctype_id == other.c_doctype_id && copies == other.copies
				&& Objects.equals(depositPath, other.depositPath) && Objects.equals(eMailCc, other.eMailCc)
				&& Objects.equals(eMailTo, other.eMailTo)
				&& Objects.equals(exportFileExtension, other.exportFileExtension)
				&& Objects.equals(exportFilenamePattern, other.exportFilenamePattern)
				&& from_ad_user_id == other.from_ad_user_id && isCalledFromProcess == other.isCalledFromProcess
				&& Arrays.equals(mailAttPrefix, other.mailAttPrefix) && mailtoaddress == other.mailtoaddress
				&& mailtouser == other.mailtouser && r_mailtext_id == other.r_mailtext_id
				&& record_id == other.record_id && Objects.equals(reportVariant, other.reportVariant)
				&& sbsp_printconfig_id == other.sbsp_printconfig_id && senddirectly == other.senddirectly
				&& toArchive == other.toArchive && Objects.equals(trxname, other.trxname) && windowno == other.windowno;
	}
}
