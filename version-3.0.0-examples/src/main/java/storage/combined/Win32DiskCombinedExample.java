package storage.combined;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.entity.compounded.Win32DiskDriveToPartitionAndLogicalDisk;
import io.github.eggy03.ferrumx.windows.entity.compounded.Win32DiskPartitionToLogicalDisk;
import io.github.eggy03.ferrumx.windows.service.compounded.Win32DiskDriveToPartitionAndLogicalDiskService;
import io.github.eggy03.ferrumx.windows.service.compounded.Win32DiskPartitionToLogicalDiskService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@SuppressWarnings("unused")
public class Win32DiskCombinedExample {

    public static void main (String[] args){

        try(PowerShell shell = PowerShell.openSession()){
            // retrieve 1:N drive to partition and 1:N drive to logical disk associations
            List<Win32DiskDriveToPartitionAndLogicalDisk> combinedDriveToPartitionAndLogical =
                    new Win32DiskDriveToPartitionAndLogicalDiskService().get(shell);

            // retrieve 1:N partition to logical disk associations
            List<Win32DiskPartitionToLogicalDisk> combinedPartitionToLogical =
                    new Win32DiskPartitionToLogicalDiskService().get(shell);

            // you can use the toString() method to print the combined objects in a json pretty print format
            // or access the fields individually
        }

    }
}
