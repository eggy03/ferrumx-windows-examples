package storage.individual;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.compounded.Win32DiskPartitionToLogicalDiskService;
import io.github.eggy03.ferrumx.windows.service.storage.Win32DiskDriveService;
import io.github.eggy03.ferrumx.windows.service.storage.Win32DiskDriveToDiskPartitionService;
import io.github.eggy03.ferrumx.windows.service.storage.Win32DiskPartitionService;
import io.github.eggy03.ferrumx.windows.service.storage.Win32LogicalDiskService;

@SuppressWarnings("java:S106")
public class Win32DiskExample {

    public static void main(String[] args) {
        // This example shows how to query the individual Win32 disk related classes.
        // You can also use service.get() or service.get(timeout...) instead of service.get(shell parameter...) to have an auto managed PowerShell session
        // However, it is recommended to create and re-use your PowerShell session for batch queries like this
        try (PowerShell shell = PowerShell.openSession()) {

            new Win32DiskDriveService().get(shell).forEach(System.out::println);

            new Win32DiskPartitionService().get(shell).forEach(System.out::println);

            new Win32DiskDriveToDiskPartitionService().get(shell).forEach(System.out::println);

            new Win32LogicalDiskService().get(shell).forEach(System.out::println);

            new Win32DiskPartitionToLogicalDiskService().get(shell).forEach(System.out::println);

        }
    }
}