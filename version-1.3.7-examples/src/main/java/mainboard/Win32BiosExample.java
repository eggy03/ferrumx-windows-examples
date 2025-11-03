package mainboard;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_BIOS;

import java.io.IOException;
import java.util.Map;

public class Win32BiosExample {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // only exposes info about the PrimaryBIOS
       Win32_BIOS.getPrimaryBIOS().forEach((k, v)-> System.out.println(k+": "+v));
    }
}
