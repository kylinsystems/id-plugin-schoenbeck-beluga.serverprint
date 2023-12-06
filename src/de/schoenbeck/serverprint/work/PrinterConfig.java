package de.schoenbeck.serverprint.work;

import java.io.InputStream;

import de.schoenbeck.serverprint.model.MPrinter;
import de.schoenbeck.serverprint.model.MPrinterProvider;

public class PrinterConfig {
	/*
	public final DocPrintJob printJob;
	public final PrintRequestAttributeSet printAttributes;
	
	
	public PrinterConfig (DocPrintJob printJob, PrintService service, int printConfigId) throws SQLException {
		this.printJob = printJob;
		this.printAttributes = Copy.getAttributes(service, printConfigId);
	}
	*/
	
	public final MPrinter printer;
	public final MPrinterProvider provider;
	public final InputStream doc;
	
	public PrinterConfig (MPrinter printer, MPrinterProvider provider, InputStream doc) {
		this.printer = printer;
		this.provider = provider;
		this.doc = doc;
	}
}