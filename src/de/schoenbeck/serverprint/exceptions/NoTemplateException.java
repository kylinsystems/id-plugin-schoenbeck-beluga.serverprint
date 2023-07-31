package de.schoenbeck.serverprint.exceptions;

import org.compiere.util.Env;
import org.compiere.util.Msg;

public class NoTemplateException extends Exception {

	private static final long serialVersionUID = 7063645990416665597L;
	static final String MSG_KEY = "Notemplatedefined";
	
	public NoTemplateException() {
		super(Msg.getMsg(Env.getCtx(), MSG_KEY));
	}
}
