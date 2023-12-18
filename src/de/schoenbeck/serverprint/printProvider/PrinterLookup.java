package de.schoenbeck.serverprint.printProvider;

import java.util.List;

import de.schoenbeck.serverprint.model.MPrinter;

/**
 * This Interface is used in the {@link ServerPrintPrinterLookupProcess}.
 * <p>
 * Its purpose is to look up and return all printers at at given provider.
 */
public interface PrinterLookup {

	/**
	 * implementation info: don't save the printers in this method, only pass newly created objects over!
	 * @param provider_id - The Print Provider's ID in DB
	 * @return A list of printers that are available with this provider
	 */
	public List<MPrinter> getAvailablePrinters(int provider_id, String trxName);
	
	/**
	 * Return the value (search key) of the provider to register for.<br>
	 * The behavior of multiple registered providers with the same value is unknown as of now.
	 * @return the *case insensitive* search key
	 */
	public String getProviderValue();
}
