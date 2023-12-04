package printProvider;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;

import org.compiere.util.CLogger;

public class ServerPrintProcessManager implements Serializable {

	private static final long serialVersionUID = 7277153172458307683L;
	
	//Printer Provider[Value] mapped to Class
	static Map<String, Class<? extends Printrun>> print = new HashMap<>();
	static Map<String, Class<? extends PrinterLookup>> lookup = new HashMap<>();
	
	public static synchronized Optional<Printrun> getPrint (String value) {
		try {
			var o = print.get(value);
			if (o != null)
				return Optional.of(o.getConstructor().newInstance());
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {}
		return Optional.empty();
	}
	
	public static synchronized Optional<PrinterLookup> getLookup (String value) {
		try {
			var o = lookup.get(value);
			if (o != null)
				return Optional.of(o.getConstructor().newInstance());
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {}
		return Optional.empty();
	}
	
	public void bindLookup (PrinterLookup pl) {
		Class<? extends PrinterLookup> process = pl.getClass();
		var old = lookup.put(pl.getProviderValue(), process);
		if (old != null) CLogger.get().log(Level.INFO, "Unregistered " + old + " for provider " + pl.getProviderValue());
		CLogger.get().info("Successfully registered Lookup: " + process.getCanonicalName());
	}
	
	public void unbindLookup (PrinterLookup pl) {
		if (lookup.get(pl.getProviderValue()) == pl.getClass())
			lookup.remove(pl.getProviderValue());
		CLogger.get().info(pl.getClass().getCanonicalName() + " unregistered.");
	}
	
	public void bindPrint (Printrun pr) {
		Class<? extends Printrun> process = pr.getClass();
		var old = print.put(pr.getProviderValue(), process);
		if (old != null) CLogger.get().log(Level.INFO, "Unregistered " + old + " for provider " + pr.getProviderValue());
		CLogger.get().info("Successfully registered Printrun: " + process.getCanonicalName());
	}
	
	public void unbindPrintrun (Printrun pr) {
		if (print.get(pr.getProviderValue()) == pr.getClass())
			print.remove(pr.getProviderValue());
		CLogger.get().info(pr.getClass().getCanonicalName() + " unregistered.");
	}
	
}
