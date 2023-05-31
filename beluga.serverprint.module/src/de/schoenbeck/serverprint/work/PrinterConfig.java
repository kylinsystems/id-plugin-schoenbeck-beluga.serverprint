package de.schoenbeck.serverprint.work;

import java.sql.SQLException;

import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.attribute.PrintRequestAttributeSet;

class PrinterConfig {
	public final DocPrintJob printJob;
	public final PrintRequestAttributeSet printAttributes;
	
	public PrinterConfig (DocPrintJob printJob, PrintService service, int printConfigId) throws SQLException {
		this.printJob = printJob;
		this.printAttributes = Copy.getAttributes(service, printConfigId);
	}
}