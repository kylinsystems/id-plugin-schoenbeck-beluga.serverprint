package printProvider;

import org.compiere.process.SvrProcess;

public class ServerPrintPrinterLookupProcess extends SvrProcess {

	int record_id;
	
	@Override
	protected void prepare() {
		record_id = getRecord_ID();
	}

	@Override
	protected String doIt() throws Exception {
		// TODO: pick the specific Lookup Process Implementation for the provider and run it
		
		//provider = new(record_id)
		//lookupProcess = ServerPrintProcessManager.getLookup(provider.value)
		//printers = lookupProcess.getAvailablePrinters(record_id)
		
		//kick out known printers
		//optionally show printers to user and let them select, which to keep
		//optionally show printers to user and let them set one as "theirs"
		
		return null;
	}

}
