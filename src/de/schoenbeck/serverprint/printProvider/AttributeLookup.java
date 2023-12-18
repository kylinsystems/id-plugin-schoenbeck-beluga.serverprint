package de.schoenbeck.serverprint.printProvider;

import de.schoenbeck.serverprint.ServerPrintLookupProcess;
import de.schoenbeck.serverprint.model.MPrinter;

/**
 * This Interface is used in the {@link ServerPrintLookupProcess}.
 * <p>
 * Its purpose is to look up and add attributes to a given printer.
 */
public interface AttributeLookup {

	/**
	 * Return the value (search key) of the provider to register for.<br>
	 * The behavior of multiple registered providers with the same value is unknown as of now.
	 * @return the *case insensitive* search key
	 */
	public String getProviderValue();
	
	/**
	 * Lookup attributes, check for duplicates and add them to the database.
	 * @param printer
	 * @param trxname - Add using transaction for rollback on error. 
	 * @throws Exception - Any one; make sure, the message is localized as needed
	 */
	public void lookupAttributes(MPrinter printer, String trxname) throws Exception;
}
