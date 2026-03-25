package storage.combined;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.entity.compounded.Win32DiskDriveToPartitionAndLogicalDisk;
import io.github.eggy03.ferrumx.windows.entity.storage.Win32DiskDrive;
import io.github.eggy03.ferrumx.windows.entity.storage.Win32DiskPartition;
import io.github.eggy03.ferrumx.windows.entity.storage.Win32LogicalDisk;
import io.github.eggy03.ferrumx.windows.service.compounded.Win32DiskDriveToPartitionAndLogicalDiskService;

import java.util.List;

@SuppressWarnings({"unused", "java:S106"})
public class Win32DiskCombinedExample {

    public static void main(String[] args) {

        try (PowerShell shell = PowerShell.openSession()) {

            /*
             * This example demonstrates how to retrieve a disk drive along with its partitions and logical volumes
             *
             * The Win32DiskDriveToPartitionAndLogicalDisk returns a list of objects, each containing a
             *   - Win32_DiskDrive instance
             *   - all instances of Win32_DiskPartition linked by Win32_DiskDrive.deviceId
             *   - all instances of Win32_LogicalDisk linked by Win32_DiskDrive.deviceId
             *
             * This convenience class helps users avoid performing their own mapping.
             */
            List<Win32DiskDriveToPartitionAndLogicalDisk> combinedDriveToPartitionAndLogical = new Win32DiskDriveToPartitionAndLogicalDiskService().get(shell);

            /*
             * Print each aggregated network object in JSON format.
             *
             * The toString() implementation of Win32DiskDriveToPartitionAndLogicalDisk
             * uses Gson pretty-printing.
             */
            combinedDriveToPartitionAndLogical.forEach(System.out::println);

            /*
             * Access the individual components.
             *
             * Every Win32DiskDriveToPartitionAndLogicalDisk instance gives you:
             *   - deviceId: the device ID of the disk drive set by WMI
             *   - Win32DiskDrive: the disk instance itself
             *   - List<Win32DiskPartition>: a list of partitions associated with the disk instance
             *   - List<Win32LogicalDisk>: a list of logical volumes associated with the disk instance as a whole
             *
             * Check out the class level documentation to know more about the classes
             */
            combinedDriveToPartitionAndLogical.forEach(disk -> {
                String id = disk.getDeviceId();
                Win32DiskDrive drive = disk.getDiskDrive();
                List<Win32DiskPartition> partition = disk.getDiskPartitionList();
                List<Win32LogicalDisk> logicalVolume = disk.getLogicalDiskList();
            });
        }

    }
}