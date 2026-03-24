Contains examples for v1.3.7 of the API

Requires: Java 21 and above

A few examples have been shown below:

## CPU

```java
import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_Processor;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32ProcessorExample {

    static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all CPU IDs
        List<String> cpuIdList = Win32_Processor.getProcessorList();

        // For each CPUID, fetch a map of its properties
        for(String cpuId : cpuIdList){
            Map<String, String> cpuMap = Win32_Processor.getCurrentProcessor(cpuId);
            // iterate through the map and print the properties
            cpuMap.forEach((k, v)-> System.out.println(k+": "+v));
        }
    }
}
```
## GPU

```java
import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_VideoController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32VideoControllerExample {

    static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all gpu IDs
        List<String> gpuIdList = Win32_VideoController.getGPUID();

        // For each gpuID, fetch a map of its properties
        for(String gpuId : gpuIdList){
            Map<String, String> gpuMap = Win32_VideoController.getGPU(gpuId);
            // iterate through the map and print the properties
            gpuMap.forEach((k, v)-> System.out.println(k+": "+v));
        }
    }
}
```

## RAM

```java
import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_PhysicalMemory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32PhysicalMemoryExample {

    static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all memory IDs
        List<String> memoryIdList = Win32_PhysicalMemory.getTag();

        // For each memoryID, fetch a map of its properties
        for(String memoryId : memoryIdList){
            Map<String, String> memoryMap = Win32_PhysicalMemory.getMemory(memoryId);
            // iterate through the map and print the properties
            memoryMap.forEach((k, v)-> System.out.println(k+": "+v));
        }
    }
}
```

## Network

The following example uses a combination of multiple WMI classes.
Individual easy to read examples are also available in the repository.

```java
import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.associatedclasses.Win32_NetworkAdapterSetting;
import com.ferrumx.system.hardware.Win32_NetworkAdapter;
import com.ferrumx.system.networking.Win32_NetworkAdapterConfiguration;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class NetworkExample {

    static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all networkAdapter IDs which are currently active
        // returns an empty list if the system is not connected to the internet
        List<String> networkAdapterIdList = Win32_NetworkAdapter.getDeviceIDList();

        // For each networkAdapterID, fetch a map of its properties
        for(String networkAdapterId : networkAdapterIdList){

            // get the adapters
            Map<String, String> networkAdapterMap = Win32_NetworkAdapter.getNetworkAdapters(networkAdapterId);

            // get the configuration index id for the particular adapter
            String networkAdapterConfigurationIndex = Win32_NetworkAdapterSetting.getIndex(networkAdapterId);

            //get the configuration via the configuration index id
            Map<String, String> networkAdapterConfigurationMap = Win32_NetworkAdapterConfiguration.getAdapterConfiguration(networkAdapterConfigurationIndex);

            // iterate through the maps and print the properties
            networkAdapterMap.forEach((k, v)-> System.out.println(k+": "+v));
            networkAdapterConfigurationMap.forEach((k, v)-> System.out.println(k+": "+v));
            System.out.println();
        }
    }
}
```

## Storage

The following example uses a combination of multiple WMI classes.
Individual easy to read examples are also available in the repository.

```java
import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.associatedclasses.Win32_DiskDriveToDiskPartition;
import com.ferrumx.system.associatedclasses.Win32_LogicalDiskToPartition;
import com.ferrumx.system.hardware.Win32_DiskDrive;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class StorageExample {

    static void main(String[] args) throws IOException, ShellException, InterruptedException {

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
```
More examples are available in the [repository](/src/main/java) itself.