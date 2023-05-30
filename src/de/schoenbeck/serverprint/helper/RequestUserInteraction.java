package de.schoenbeck.serverprint.helper;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.adempiere.webui.editor.WEditor;
import org.adempiere.webui.window.FDialog;
import org.compiere.process.SvrProcess;

public class RequestUserInteraction extends SvrProcess {

	public static final int timeout = 30;
	
	int windowno;
	WEditor editor;
	String msg;
	
	@Override
	protected void prepare() {
		
		for (var p : getParameter()) {
			switch (p.getParameterName()) {
			case "windowno": this.windowno = (Integer)p.getParameter(); break;
			case "editor": this.editor = (WEditor)p.getParameter(); break;
			case "msg": this.msg = (String)p.getParameter(); break;
			}
		}
	}

	@Override
	protected String doIt() throws Exception {
		
		CompletableFuture<Object> future = new CompletableFuture<>();
		FDialog.askForInput(windowno, editor, msg, (obj) -> future.complete(obj));
		
		var rtn = future.get(timeout, TimeUnit.SECONDS);
		
		return String.valueOf(rtn);
	}

}
