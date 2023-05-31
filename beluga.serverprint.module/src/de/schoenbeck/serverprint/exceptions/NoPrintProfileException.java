package de.schoenbeck.serverprint.exceptions;

import org.compiere.util.Env;
import org.compiere.util.Msg;

public class NoPrintProfileException extends RuntimeException {

	private static final long serialVersionUID = -7656268301795975474L;
	static final String MSG_KEY = "PrintConfigNotFound";
	
	public NoPrintProfileException () {
		super(Msg.getMsg(Env.getCtx(), MSG_KEY));
	}
}
