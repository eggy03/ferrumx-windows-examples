Contains examples for v3.x.x of the API

Requires: Java 8 and above

A few examples have been shown below:

## CPU

```java
import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.processor.Win32AssociatedProcessorMemoryService;
import io.github.eggy03.ferrumx.windows.service.processor.Win32CacheMemoryService;
import io.github.eggy03.ferrumx.windows.service.processor.Win32ProcessorService;
import lombok.extern.slf4j.Slf4j;

public class Win32ProcessorAndCacheExample {

    static void main(String[] args) {
        // This example shows how to query each of Win32_Processor, Win32_AssociatedProcessorMemory and Win32_CacheMemory.
        // You can also use service.get() instead of service.get(shell parameter...) to have an auto managed PowerShell session
        // However, it is recommended to create and re-use your PowerShell session for batch queries like this
        try (PowerShell shell = PowerShell.openSession()) {

            new Win32ProcessorService().get(shell).forEach(System.out::println);

            new Win32AssociatedProcessorMemoryService().get(shell).forEach(System.out::println);

            new Win32CacheMemoryService().get(shell).forEach(System.out::println);
        }
    }
}
```

## GPU

```java
import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.display.Win32VideoControllerService;

public class Win32VideoControllerExample {

    static void main(String[] args) {

        // retrieve and print all Video Controller data using an auto-managed PowerShell session
        // The "get()" method returns a list of Win32VideoController entity objects,
        // and each object’s "toString()" prints its fields in JSON pretty-print format.
        new Win32VideoControllerService().get().forEach(System.out::println);

        // you can also reuse your own PowerShell session if you plan to query multiple services.
        try (PowerShell shell = PowerShell.openSession()) {
            new Win32VideoControllerService().get(shell).forEach(System.out::println);
        }

    }
}
```

## RAM

```java
import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.memory.Win32PhysicalMemoryService;

public class Win32PhysicalMemoryExample {

    static void main(String[] args) {

        // retrieve and print all PhysicalMemory data using an auto-managed PowerShell session
        // The "get()" method returns a list of Win32PhysicalMemory entity objects,
        // and each object’s "toString()" prints its fields in JSON pretty-print format.
        new Win32PhysicalMemoryService().get().forEach(System.out::println);

        // you can also reuse your own PowerShell session if you plan to query multiple services.
        try (PowerShell shell = PowerShell.openSession()) {
            new Win32PhysicalMemoryService().get(shell).forEach(System.out::println);
        }

    }
}
```

## Network

### MSFT Classes

```java
import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.entity.network.MsftDnsClientServerAddress;
import io.github.eggy03.ferrumx.windows.entity.network.MsftNetAdapter;
import io.github.eggy03.ferrumx.windows.entity.network.MsftNetConnectionProfile;
import io.github.eggy03.ferrumx.windows.entity.network.MsftNetIpAddress;
import io.github.eggy03.ferrumx.windows.service.network.MsftDnsClientServerAddressService;
import io.github.eggy03.ferrumx.windows.service.network.MsftNetAdapterService;
import io.github.eggy03.ferrumx.windows.service.network.MsftNetConnectionProfileService;
import io.github.eggy03.ferrumx.windows.service.network.MsftNetIpAddressService;

import java.util.List;

public class MsftNetworkExample {

    static void main(String[] args) {
        try (PowerShell shell = PowerShell.openSession()) {
            //This example shows how to query each MSFT_* network class individually.
            // can also use service.get() instead of service.get(shell parameter...) to have an auto managed PowerShell session
            // it is recommended to create and re-use your PowerShell session for batch queries like this
            List<MsftNetAdapter> adapterList = new MsftNetAdapterService().get(shell);
            List<MsftNetIpAddress> ipAddressList = new MsftNetIpAddressService().get(shell);
            List<MsftDnsClientServerAddress> dnsClientServerAddressList = new MsftDnsClientServerAddressService().get(shell);
            List<MsftNetConnectionProfile> connectionProfileList = new MsftNetConnectionProfileService().get(shell);

            adapterList.forEach(System.out::println);
            ipAddressList.forEach(System.out::println);
            dnsClientServerAddressList.forEach(System.out::println);
            connectionProfileList.forEach(System.out::println);
        }
    }
}
```

### Win32 Classes

```java
import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.entity.network.Win32NetworkAdapter;
import io.github.eggy03.ferrumx.windows.entity.network.Win32NetworkAdapterConfiguration;
import io.github.eggy03.ferrumx.windows.entity.network.Win32NetworkAdapterSetting;
import io.github.eggy03.ferrumx.windows.service.network.Win32NetworkAdapterConfigurationService;
import io.github.eggy03.ferrumx.windows.service.network.Win32NetworkAdapterService;
import io.github.eggy03.ferrumx.windows.service.network.Win32NetworkAdapterSettingService;

import java.util.List;

public class Win32NetworkExample {

    static void main(String[] args) {
        try (PowerShell shell = PowerShell.openSession()) {
            // This example shows how to query each Win32_* network class individually.
            // can also use service.get() instead of service.get(shell parameter...) to have an auto managed PowerShell session
            // it is recommended to create and re-use your PowerShell session for batch queries like this
            List<Win32NetworkAdapter> adapterList = new Win32NetworkAdapterService().get(shell);
            List<Win32NetworkAdapterConfiguration> configurationList = new Win32NetworkAdapterConfigurationService().get(shell);
            List<Win32NetworkAdapterSetting> settingList = new Win32NetworkAdapterSettingService().get(shell);

            adapterList.forEach(System.out::println);
            configurationList.forEach(System.out::println);
            settingList.forEach(System.out::println);
        }
    }
}
```

## Storage

```java
import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.compounded.Win32DiskPartitionToLogicalDiskService;
import io.github.eggy03.ferrumx.windows.service.storage.Win32DiskDriveService;
import io.github.eggy03.ferrumx.windows.service.storage.Win32DiskDriveToDiskPartitionService;
import io.github.eggy03.ferrumx.windows.service.storage.Win32DiskPartitionService;
import io.github.eggy03.ferrumx.windows.service.storage.Win32LogicalDiskService;

public class Win32DiskExample {

    static void main(String[] args) {
        // This example shows how to query the individual Win32 disk related classes.
        // You can also use service.get() instead of service.get(shell parameter...) to have an auto managed PowerShell session
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
```

More examples are available in the [repository](/src/main/java) itself.