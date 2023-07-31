package de.schoenbeck.serverprint.helper;

import java.io.File;
import java.util.Stack;

import javax.activation.DataSource;

import org.adempiere.webui.window.WEMailDialog;
import org.compiere.model.MUser;

public class SBSP_EMailDialog extends WEMailDialog {

	private static final long serialVersionUID = 6683726128915642048L;
	
	File printeddoc;
	Stack<Object> deletionStack = null;
	
	public SBSP_EMailDialog(String title, MUser from, String to, String subject, String message,
			DataSource attachment) {
		super(title, from, to, subject, message, attachment);
	}

	/**
	 * Leaves a note about the document to be attached
	 * To be used in later procedures if need be
	 * @param printeddoc - The invoice file
	 */
	@Deprecated
	public void setPrintedDoc (File printeddoc) {
		this.printeddoc = printeddoc;
	}
	
	/**
	 * Set the deletion stack to synchronize deletion
	 * @param s
	 */
	public void setDeletionStack (Stack<Object> s) {
		deletionStack = s;
	}
	
	/**
	 * Overidden instead of onClose due to access limitations
	 */
	@Override
	public void detach() {
		
		try {
			if(deletionStack != null && !deletionStack.isEmpty()) {
				//delete the top entry if it's the file
				Object f = deletionStack.pop();
				if (f instanceof File)
					((File) f).delete();
			}
		} catch (ClassCastException e) {}
		
		super.detach();
	}
	
	public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
	}
}
