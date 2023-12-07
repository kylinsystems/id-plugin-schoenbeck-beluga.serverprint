package printProvider;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.logging.Level;

import org.adempiere.base.Service;
import org.compiere.util.CLogger;

public class ServerPrintProcessManager implements Serializable {

	private static final long serialVersionUID = 7277153172458307683L;
	
	//Printer Provider[Value] mapped to Class
	static Map<String, Class<? extends Printrun>> print = new HashMap<>();
	static Map<String, Class<? extends PrinterLookup>> lookup = new HashMap<>();
	
	public static synchronized Optional<Printrun> getPrint (String value) {
//		try {
//			var o = print.get(value.toLowerCase(Locale.ENGLISH));
//			if (o != null)
//				return Optional.of(o.getConstructor().newInstance());
//			
//		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {}
//		return Optional.empty();
		
		ServiceLoader<Printrun> loader = ServiceLoader.load(Printrun.class);
		for (var service : loader) {
			if (service.getProviderValue() != null
					&& service.getProviderValue().equalsIgnoreCase(value))
				return Optional.of(service);
		}
		return Optional.empty();
	}
	
	public static synchronized Optional<PrinterLookup> getLookup (String value) {
//		try {
//			var o = lookup.get(value.toLowerCase(Locale.ENGLISH));
//			if (o != null)
//				return Optional.of(o.getConstructor().newInstance());
//			
//		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {}
		
//		ServiceLoader<PrinterLookup> loader = ServiceLoader.load(PrinterLookup.class);
//		for (var service : loader) {
//			if (service.getProviderValue() != null
//					&& service.getProviderValue().equalsIgnoreCase(value))
//				return Optional.of(service);
//		}
		
		var list = Service.locator().list(PrinterLookup.class).getServiceReferences();
		for (var holder : list) {
			var service = holder.getService();
			if (service.getProviderValue().equalsIgnoreCase(value))
				return Optional.of(service);
		}
		
		return Optional.empty();
	}
	
	public void bind(PrinterLookup pl) {
		Class<? extends PrinterLookup> process = pl.getClass();
		var old = lookup.put(pl.getProviderValue().toLowerCase(Locale.ENGLISH), process);
		if (old != null) CLogger.get().log(Level.INFO, "Unregistered " + old + " for provider " + pl.getProviderValue());
		CLogger.get().info("Successfully registered Lookup: " + process.getCanonicalName());
	}
	
	public void unbind(PrinterLookup pl) {
		if (lookup.get(pl.getProviderValue().toLowerCase(Locale.ENGLISH)) == pl.getClass())
			lookup.remove(pl.getProviderValue().toLowerCase(Locale.ENGLISH));
		CLogger.get().info(pl.getClass().getCanonicalName() + " unregistered.");
	}
	
	public void bind(Printrun pr) {
		Class<? extends Printrun> process = pr.getClass();
		var old = print.put(pr.getProviderValue().toLowerCase(Locale.ENGLISH), process);
		if (old != null) CLogger.get().log(Level.INFO, "Unregistered " + old + " for provider " + pr.getProviderValue());
		CLogger.get().info("Successfully registered Printrun: " + process.getCanonicalName());
	}
	
	public void unbind(Printrun pr) {
		if (print.get(pr.getProviderValue().toLowerCase(Locale.ENGLISH)) == pr.getClass())
			print.remove(pr.getProviderValue().toLowerCase(Locale.ENGLISH));
		CLogger.get().info(pr.getClass().getCanonicalName() + " unregistered.");
	}
	
}
