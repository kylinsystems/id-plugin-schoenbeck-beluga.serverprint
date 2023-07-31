package de.schoenbeck.serverprint.exceptions;

import org.compiere.util.Env;
import org.compiere.util.Msg;

public class MailNotSentException extends Exception {

	private static final long serialVersionUID = 7193970235786032864L;
	static final String MSG_KEY = "EMailnotsent";
	
	public MailNotSentException (String addr) {
		super(Msg.getMsg(Env.getCtx(), MSG_KEY, new Object[] {addr}));
	}
}
