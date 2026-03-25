package processor.combined;

import io.github.eggy03.ferrumx.windows.entity.compounded.Win32ProcessorToCacheMemory;
import io.github.eggy03.ferrumx.windows.entity.processor.Win32CacheMemory;
import io.github.eggy03.ferrumx.windows.entity.processor.Win32Processor;
import io.github.eggy03.ferrumx.windows.service.compounded.Win32ProcessorToCacheMemoryService;

import java.util.List;

@SuppressWarnings({"unused", "java:S106"})
public class Win32ProcessorCombinedExample {

    public static void main(String[] args) {

        /*
         * This example demonstrates how to retrieve a combined processor + cache view.
         *
         * The Win32ProcessorToCacheMemoryService returns a list of objects, each containing a
         *   - Win32_Processor instance
         *   - all instances of Win32_CacheMemory linked to the processor instance
         *   - linking happens via the processor device id
         *
         * This convenience class helps users avoid performing their own mapping.
         */
        List<Win32ProcessorToCacheMemory> combinedProcessorAndCacheList = new Win32ProcessorToCacheMemoryService().get();

        /*
         * Print each aggregated network object in JSON format.
         *
         * The toString() implementation of Win32NetworkAdapterToConfiguration
         * uses Gson pretty-printing.
         */
        combinedProcessorAndCacheList.forEach(System.out::println);

        /*
         * Access the individual components.
         *
         * Every Win32ProcessorToCacheMemory instance gives you:
         *   - deviceId: the device ID of the CPU set by WMI
         *   - Win32Processor: the CPU instance itself
         *   - List<Win32CacheMemory>: a list of cache memories associated with this CPU instance
         *
         * Check out the class level documentation to know more about the classes
         */
        combinedProcessorAndCacheList.forEach(processorAndCache -> {
            String deviceId = processorAndCache.getDeviceId();
            Win32Processor processor = processorAndCache.getProcessor();
            List<Win32CacheMemory> cacheList = processorAndCache.getCacheMemoryList();
        });
    }
}