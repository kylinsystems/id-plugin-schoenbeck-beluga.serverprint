package de.schoenbeck.serverprint.printProvider;

import java.util.HashSet;
import java.util.NoSuchElementException;

import org.compiere.process.SvrProcess;

import de.schoenbeck.serverprint.model.MPrinter;
import de.schoenbeck.serverprint.model.MPrinterProvider;

public class ServerPrintPrinterLookupProcess extends SvrProcess {

	int record_id;
	
	@Override
	protected void prepare() {
		record_id = getRecord_ID();
	}

	@Override
	protected String doIt() throws Exception {
		
		MPrinterProvider provider = new MPrinterProvider(getCtx(), record_id, get_TrxName());
		PrinterLookup lookupProcess = ServerPrintProcessManager.getLookup(provider.getValue())
				.orElseThrow( () -> new NoSuchElementException("The provider does not exist.") );
		var printers = lookupProcess.getAvailablePrinters(record_id, get_TrxName());
		
		var knownPrinters = new HashSet<Integer>();
		for (int i : provider.getKnownPrinterIDs())
			knownPrinters.add(i);
		
		for (MPrinter p : printers) {
			if (!knownPrinters.contains(p.get_ID()))
				p.save();
		}

		//TODO: optionally show printers to user and let them select, which to keep
		//TODO: optionally show printers to user and let them set one as "theirs"
		
		return "@success@";
	}

}
