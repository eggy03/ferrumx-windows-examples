package peripheral;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_Printer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32PrinterExample {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all printer IDs
        List<String> printerIdList = Win32_Printer.getDeviceIDList();

        // For each printerID, fetch a map of its properties
        for(String printerId : printerIdList){
            Map<String, String> printerMap = Win32_Printer.getCurrentPrinter(printerId);
            // iterate through the map and print the properties
            for(Map.Entry<String, String> printer : printerMap.entrySet()){
                System.out.println(printer.getKey()+ ": "+ printer.getValue());
            }
        }
    }
}
