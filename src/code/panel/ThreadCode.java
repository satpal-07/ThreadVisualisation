package code.panel;

/**
 * Class that provides the code to display in code panel
 * 
 * @author Satpal Singh
 * @version 1.0
 */
public class ThreadCode {
	
	
	/**
	 * Gets the code of run method for waiting section scenario
	 * @return String containing formatted code for run method
	 */
	public String getRunMethodCode_WS() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\tpublic void run() {");
		sb.append("\n\n\t\t runway.use();");
		sb.append("\n\n\t}");
		return sb.toString();
	}
	
	/**
	 * Gets the code of use runway method
	 * @return String containing formatted code for useRunWay method
	 */
	public String getUseRunwayMethodCode_WS() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\tpublic void use() {");
		sb.append("\n\t\tsynchronized (this) {");
		sb.append("\n\t\t\twhile(this.isBusy()){");
		sb.append("\n\t\t\t\t wait();");
		sb.append("\n\t\t\t}");
		sb.append("\n\t\t\tthis.setBusy(true);");
		sb.append("\n\t\t}");
		sb.append("\n\t\tthis.takeOff();");
		sb.append("\n\t\tsynchronized (this) {");
		sb.append("\n\t\t\tthis.setBusy(false);");
		sb.append("\n\t\t\tnotify();");
		sb.append("\n\t\t}");
		sb.append("\n\t}");
		return sb.toString();

	}

	/**
	 * Gets the code of use junction method
	 * @return String containing formatted code for useJunction method
	 */
	public String getUseJunctionMethodCode_WS() {
		StringBuilder sb = new StringBuilder();
		sb.append("\npublic void use() {");
		sb.append("\n\tsynchronized (this){");
		sb.append("\n\t\ttry{");
		sb.append("\n\t\t\tpassingJunction();");
		sb.append("\n\t\t} catch(InterruptedException e){");
		sb.append("\n\t\t\te.printStackTrace();");
		sb.append("\n\t\t}");
		sb.append("\n\t}");
		sb.append("\n}");
		return sb.toString();
	}

	/**
	 * Gets the code of run method for critical section scenario
	 * @return String containing formatted code for run method
	 */
	public String getRunMethodCode_CS() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\tpublic void run() {");
		sb.append("\n\n\t\t junction.use();");
		sb.append("\n\n\t}");
		return sb.toString();
	}	
	
}
