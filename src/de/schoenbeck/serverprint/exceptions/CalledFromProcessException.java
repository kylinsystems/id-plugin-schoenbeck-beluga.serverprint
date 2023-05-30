package de.schoenbeck.serverprint.exceptions;

import org.compiere.util.Env;
import org.compiere.util.Msg;

public class CalledFromProcessException extends RuntimeException {

	private static final long serialVersionUID = -1377800085156702463L;
	static final String MSG_KEY = "CalledFromProcess";
	
	public CalledFromProcessException () {
		super(Msg.getMsg(Env.getCtx(), MSG_KEY));
	}
}
