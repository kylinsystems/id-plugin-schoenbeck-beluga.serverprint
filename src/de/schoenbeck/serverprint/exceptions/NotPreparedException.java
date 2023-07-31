package de.schoenbeck.serverprint.exceptions;

import org.compiere.util.Env;
import org.compiere.util.Msg;

public class NotPreparedException extends RuntimeException {

	private static final long serialVersionUID = -5835366858440236186L;
	static final String MSG_KEY = "NotPrepared";
	
	public NotPreparedException () {
		super(Msg.getMsg(Env.getCtx(), MSG_KEY));
	}
}
