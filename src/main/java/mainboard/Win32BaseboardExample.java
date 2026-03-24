package mainboard;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_Baseboard;

import java.io.IOException;

public class Win32BaseboardExample {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // will only give the last baseboard in case multiple instances of it are present
        Win32_Baseboard.getMotherboard().forEach((k, v)-> System.out.println(k+": "+v));
    }
}
