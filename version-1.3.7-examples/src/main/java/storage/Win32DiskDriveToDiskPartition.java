package storage;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.associatedclasses.Win32_DiskDriveToDiskPartition;
import com.ferrumx.system.hardware.Win32_DiskDrive;

import java.io.IOException;
import java.util.List;

public class Win32DiskDriveToDiskPartition {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all diskDrive IDs
        List<String> diskDriveIdList = Win32_DiskDrive.getDriveID();

        // For each diskDriveID, fetch a list of its partitions
        for(String diskDriveId : diskDriveIdList){
            List<String> diskPartitionIdList = Win32_DiskDriveToDiskPartition.getPartitionList(diskDriveId);
            diskPartitionIdList.forEach(System.out::println);
        }
    }
}
