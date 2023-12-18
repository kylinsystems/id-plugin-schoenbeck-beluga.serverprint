package de.schoenbeck.serverprint.printProvider;

import java.io.Serializable;
import java.util.Optional;

import org.adempiere.base.Service;

/**
 * Quick access to implementations of
 * <ul>
 * <li>{@link AttributeLookup}
 * <li>{@link PrinterLookup}
 * <li>{@link Printrun}
 * </ul>
 */
public class ServerPrintProcessManager implements Serializable {

	private static final long serialVersionUID = 7277153172458307683L;
	
	public static synchronized Optional<Printrun> getPrint (String value) {
		var list = Service.locator().list(Printrun.class).getServiceReferences();
		for (var holder : list) {
			var service = holder.getService();
			if (service.getProviderValue().equalsIgnoreCase(value))
				return Optional.of(service);
		}
		return Optional.empty();
	}
	
	public static synchronized Optional<PrinterLookup> getLookup (String value) {
		var list = Service.locator().list(PrinterLookup.class).getServiceReferences();
		for (var holder : list) {
			var service = holder.getService();
			if (service.getProviderValue().equalsIgnoreCase(value))
				return Optional.of(service);
		}
		return Optional.empty();
	}
	
	public static synchronized Optional<AttributeLookup> getAttrLookup (String value) {
		var list = Service.locator().list(AttributeLookup.class).getServiceReferences();
		for (var holder : list) {
			var service = holder.getService();
			if (service.getProviderValue().equalsIgnoreCase(value))
				return Optional.of(service);
		}
		return Optional.empty();
	}
}
