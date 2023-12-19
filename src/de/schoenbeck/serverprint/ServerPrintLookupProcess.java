package de.schoenbeck.serverprint;

import org.compiere.process.SvrProcess;

import de.schoenbeck.serverprint.model.MPrinter;
import de.schoenbeck.serverprint.printProvider.ServerPrintProcessManager;


public class ServerPrintLookupProcess extends SvrProcess {

	private MPrinter printer;
	
	public ServerPrintLookupProcess() {

	}

	@Override
	protected void prepare() {
		printer = new MPrinter(getCtx(), getRecord_ID(), get_TrxName());
	}

	@Override
	protected String doIt() throws Exception {
		
		try {
			ServerPrintProcessManager.getAttrLookup(printer.getsbsp_printerprovider().getProtocol())
				.ifPresentOrElse(
						(pRun) -> {try {
							pRun.lookupAttributes(printer, get_TrxName());
						} catch (Exception e) {
							throw new RuntimeException(e);
						}}, 
						() -> {throw new RuntimeException("No implementation for such provider");}
				);
		} catch (RuntimeException e) {
			if (e.getCause() instanceof Exception)
				throw (Exception) e.getCause();
			else throw e;
		}
		
		return "Successfully gathered attributes";
	}
	
}
