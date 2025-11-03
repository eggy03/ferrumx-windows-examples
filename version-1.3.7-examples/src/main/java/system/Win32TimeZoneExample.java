package system;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.operating_system.Win32_TimeZone;

import java.io.IOException;

public class Win32TimeZoneExample {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        Win32_TimeZone.getOSTimeZone()
            .forEach((k, v)-> System.out.println(k+": "+v));
    }
}
