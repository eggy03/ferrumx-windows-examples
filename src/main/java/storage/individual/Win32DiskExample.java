package storage.individual;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.compounded.Win32DiskPartitionToLogicalDiskService;
import io.github.eggy03.ferrumx.windows.service.storage.Win32DiskDriveService;
import io.github.eggy03.ferrumx.windows.service.storage.Win32DiskDriveToDiskPartitionService;
import io.github.eggy03.ferrumx.windows.service.storage.Win32DiskPartitionService;
import io.github.eggy03.ferrumx.windows.service.storage.Win32LogicalDiskService;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("unused")
@Slf4j
public class Win32DiskExample {

    public static void main (String[] args){
        // This example shows how to query the individual Win32 disk related classes.
        // You can also use service.get() instead of service.get(Powershell) to have an auto managed powershell session
        // However, it is recommended to create and re-use your powershell session for batch queries like this
          try (PowerShell shell = PowerShell.openSession()){

              new Win32DiskDriveService()
                      .get(shell)
                      .forEach(physicalDisk -> log.info(physicalDisk.toString()));

              new Win32DiskPartitionService()
                      .get(shell)
                      .forEach(partition -> log.info(partition.toString()));

              new Win32DiskDriveToDiskPartitionService()
                      .get(shell)
                      .forEach(driveToPartition -> log.info(driveToPartition.toString()));

              new Win32LogicalDiskService()
                      .get(shell)
                      .forEach(logicalDisk -> log.info(logicalDisk.toString()));

              new Win32DiskPartitionToLogicalDiskService()
                      .get(shell)
                      .forEach(partitionToLogical -> log.info(partitionToLogical.toString()));

          }
    }
}
