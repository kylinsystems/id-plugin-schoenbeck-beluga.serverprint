package de.schoenbeck.serverprint.exceptions;

import org.compiere.util.Env;
import org.compiere.util.Msg;

public class TemplateNotFoundException extends Exception {

	private static final long serialVersionUID = 2612885131932045288L;
	static final String MSG_KEY = "EMailtemplatenotfound";
	
	public TemplateNotFoundException (int mailtext_id) {
		super(Msg.getMsg(Env.getCtx(), MSG_KEY, new Object[] {mailtext_id}));
	}
}
