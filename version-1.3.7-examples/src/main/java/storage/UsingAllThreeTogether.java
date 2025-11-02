package storage;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.associatedclasses.Win32_DiskDriveToDiskPartition;
import com.ferrumx.system.associatedclasses.Win32_LogicalDiskToPartition;
import com.ferrumx.system.hardware.Win32_DiskDrive;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UsingAllThreeTogether {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all diskDrive IDs
        List<String> diskDriveIdList = Win32_DiskDrive.getDriveID();

        for(String diskDriveId : diskDriveIdList){
            // fetch drive properties
            Map<String, String> diskDriveMap = Win32_DiskDrive.getDrive(diskDriveId);
            // fetch drive partition list
            List<String> diskPartitionIdList = Win32_DiskDriveToDiskPartition.getPartitionList(diskDriveId);

            // print the drive property
            for(Map.Entry<String, String> diskDrive : diskDriveMap.entrySet()){
                System.out.println(diskDrive.getKey()+ ": "+ diskDrive.getValue());
            }

            // for each partitionId in the drive, get its letter
            for(String diskPartitionId: diskPartitionIdList){
                System.out.println("Partition: "+diskPartitionId+" Drive Letter: "+Win32_LogicalDiskToPartition.getDriveLetter(diskPartitionId));
            }
            System.out.println();
        }
    }
}
