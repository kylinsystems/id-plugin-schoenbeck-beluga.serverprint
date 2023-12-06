package printProvider;

import de.schoenbeck.serverprint.work.PrinterConfig;

public interface Printrun {

	public void run (PrinterConfig conf) throws Exception;
	
	/**
	 * 
	 * @return The value (search key) of the provider to register for
	 */
	public String getProviderValue();
}
