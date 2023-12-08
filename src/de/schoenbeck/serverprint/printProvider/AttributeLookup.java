package de.schoenbeck.serverprint.printProvider;

import de.schoenbeck.serverprint.model.MPrinter;

public interface AttributeLookup {

	public String getProviderValue();
	
	public void lookupAttributes(MPrinter printer, String trxname) throws Exception;
}
