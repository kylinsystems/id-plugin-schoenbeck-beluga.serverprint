package printProvider;

import java.util.List;

import de.schoenbeck.serverprint.model.X_sbsp_printer;

public interface PrinterLookup {

	/**
	 * implementation info: don't save the printers in this method, only pass newly created objects over!
	 * @param provider_id - The Print Provider's ID in DB
	 * @return A list of printers that are available with this provider
	 */
	public List<X_sbsp_printer> getAvailablePrinters(int provider_id);
}
