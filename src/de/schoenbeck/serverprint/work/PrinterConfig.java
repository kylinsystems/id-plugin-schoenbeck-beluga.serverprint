package de.schoenbeck.serverprint.work;

import java.io.InputStream;

import de.schoenbeck.serverprint.model.MPrinter;
import de.schoenbeck.serverprint.model.MPrinterProvider;
import de.schoenbeck.serverprint.params.ServerPrintCopyParam;

public class PrinterConfig {
	
	public final MPrinter printer;
	public final MPrinterProvider provider;
	public final ServerPrintCopyParam copyparams;
	public final InputStream doc;
	public final int printerconfig_id;
	
	public PrinterConfig (MPrinter printer, MPrinterProvider provider, InputStream doc, ServerPrintCopyParam copyparams, int printerconfig_id) {
		this.printer = printer;
		this.provider = provider;
		this.copyparams = copyparams;
		this.doc = doc;
		this.printerconfig_id = printerconfig_id;
	}
}