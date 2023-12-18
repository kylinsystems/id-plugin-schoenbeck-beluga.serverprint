package de.schoenbeck.serverprint.printProvider;

import de.schoenbeck.serverprint.work.Copy;
import de.schoenbeck.serverprint.work.PrinterConfig;

/**
 * This Interface is used in {@link Copy}.
 * <p>
 * Its purpose is to create and pass print jobs to a printer. 
 */
public interface Printrun {

	/**
	 * Perform all printing operations.
	 * @param conf - A record combining the parameter set
	 * @throws Exception - Any one; make sure, the message is localized as needed
	 */
	public void run (PrinterConfig conf) throws Exception;
	
	/**
	 * Return the value (search key) of the provider to register for.<br>
	 * The behavior of multiple registered providers with the same value is unknown as of now.
	 * @return the *case insensitive* search key
	 */
	public String getProviderValue();
}
