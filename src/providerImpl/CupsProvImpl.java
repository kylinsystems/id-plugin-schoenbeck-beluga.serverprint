package providerImpl;

import java.util.List;

import de.schoenbeck.serverprint.model.MPrinter;
import de.schoenbeck.serverprint.work.PrinterConfig;
import printProvider.PrinterLookup;
import printProvider.Printrun;

public class CupsProvImpl implements Printrun, PrinterLookup {

	@Override
	public List<MPrinter> getAvailablePrinters(int provider_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void run(PrinterConfig conf) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public String getProviderValue() {
		// TODO Auto-generated method stub
		return "cups";
	}

}
