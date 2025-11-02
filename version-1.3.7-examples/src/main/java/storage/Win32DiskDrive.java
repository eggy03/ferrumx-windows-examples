package storage;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_DiskDrive;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32DiskDrive {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all diskDrive IDs
        List<String> diskDriveIdList = Win32_DiskDrive.getDriveID();

        // For each diskDriveID, fetch a map of its properties
        for(String diskDriveId : diskDriveIdList){
            Map<String, String> diskDriveMap = Win32_DiskDrive.getDrive(diskDriveId);
            // iterate through the map and print the properties
            for(Map.Entry<String, String> diskDrive : diskDriveMap.entrySet()){
                System.out.println(diskDrive.getKey()+ ": "+ diskDrive.getValue());
            }
            System.out.println();
        }
    }
}
