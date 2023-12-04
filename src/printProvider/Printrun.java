package printProvider;

public interface Printrun {

	public void run () throws Exception;
	
	/**
	 * 
	 * @return The value (search key) of the provider to register for
	 */
	public String getProviderValue();
}
