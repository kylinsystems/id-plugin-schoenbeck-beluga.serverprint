package de.schoenbeck.serverprint.printProvider;

import java.util.HashSet;
import java.util.NoSuchElementException;

import org.compiere.process.SvrProcess;

import de.schoenbeck.serverprint.model.MPrinter;
import de.schoenbeck.serverprint.model.MPrinterProvider;

/**
 * Look up all printers at a provider using the printer provider implementation.
 * <br>
 * To skip all known printers, the field {@code PrinterNameIpp} is compared.
 */
public class ServerPrintPrinterLookupProcess extends SvrProcess {

	int record_id;
	
	@Override
	protected void prepare() {
		record_id = getRecord_ID();
	}

	@Override
	protected String doIt() throws Exception {
		
		MPrinterProvider provider = new MPrinterProvider(getCtx(), record_id, get_TrxName());
		PrinterLookup lookupProcess = ServerPrintProcessManager.getLookup(provider.getProtocol())
				.orElseThrow( () -> new NoSuchElementException("The provider does not exist.") );
		var printers = lookupProcess.getAvailablePrinters(record_id, get_TrxName());
		
		HashSet<MPrinter> knownPrinters = new HashSet<>(provider.getKnownPrinters());
		
		outerloop:
		for (MPrinter p : printers) {
			for (var k : knownPrinters)
				if (p.getPrinterNameIpp().equals(k.getPrinterNameIpp()))
					break outerloop;
			p.save();
		}

		//TODO: optionally show printers to user and let them select, which to keep
		//TODO: optionally show printers to user and let them set one as "theirs"
		
		return "@success@";
	}

}
