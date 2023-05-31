package de.schoenbeck.serverprint.exceptions;

import org.compiere.util.Env;
import org.compiere.util.Msg;

public class InvalidMailAddressException extends Exception {

	private static final long serialVersionUID = 3762116105963550790L;
	static final String MSG_KEY = "InvalidEmailAddress";
	
	public InvalidMailAddressException(String addr) {
		super(Msg.getMsg(Env.getCtx(), MSG_KEY, new Object[] {addr}));
	}
}
