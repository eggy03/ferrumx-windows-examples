package storage;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_DiskDrive;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32DiskDriveExample {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all diskDrive IDs
        List<String> diskDriveIdList = Win32_DiskDrive.getDriveID();

        // For each diskDriveID, fetch a map of its properties
        for(String diskDriveId : diskDriveIdList){
            Map<String, String> diskDriveMap = Win32_DiskDrive.getDrive(diskDriveId);
            // iterate through the map and print the properties
            diskDriveMap.forEach((k, v)-> System.out.println(k+": "+v));
            System.out.println();
        }
    }
}
