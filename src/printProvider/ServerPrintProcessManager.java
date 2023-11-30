package printProvider;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;

import org.compiere.util.CLogger;

public class ServerPrintProcessManager {

	//Printer Provider[Value] mapped to Class
	static Map<String, Class<Printrun>> print = new HashMap<>();
	static Map<String, Class<PrinterLookup>> lookup = new HashMap<>();
	
	
	public static synchronized boolean registerPrint (String providerValue, Class<Printrun> process) {
		if (Printrun.class.isAssignableFrom(process)) {
			var old = print.put(providerValue, process);
			if (old != null) CLogger.get().log(Level.INFO, "Unregistered " + old + " for provider " + providerValue);
			return true;
		}
		return false;
	}
	
	public static synchronized boolean registerLookup (String providerValue, Class<PrinterLookup> process) {
		if (PrinterLookup.class.isAssignableFrom(process)) {
			var old = lookup.put(providerValue, process);
			if (old != null) CLogger.get().log(Level.INFO, "Unregistered " + old + " for provider " + providerValue);
			return true;
		}
		return false;
	}
	
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
	
	/**
	 * The reason to register for; is the process a lookup or 
	 */
	public enum Cause {
		PRINT,LOOKUP
	}
}
