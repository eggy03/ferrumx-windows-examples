package processor.combined;

import io.github.eggy03.ferrumx.windows.entity.compounded.Win32ProcessorToCacheMemory;
import io.github.eggy03.ferrumx.windows.entity.processor.Win32CacheMemory;
import io.github.eggy03.ferrumx.windows.entity.processor.Win32Processor;
import io.github.eggy03.ferrumx.windows.service.compounded.Win32ProcessorToCacheMemoryService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@SuppressWarnings("unused")
public class Win32ProcessorCombinedExample {

    public static void main (String[] args) {

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
        List<Win32ProcessorToCacheMemory> combinedProcessorAndCacheList =
                new Win32ProcessorToCacheMemoryService().get();

        // json pretty print the entire object or lists of objects
        combinedProcessorAndCacheList.forEach(processorAndCache -> log.info(processorAndCache.toString()));

        // or access the individual fields
        combinedProcessorAndCacheList.forEach(processorAndCache -> {
            String deviceId = processorAndCache.getDeviceId();
            Win32Processor processor = processorAndCache.getProcessor();
            List<Win32CacheMemory> cacheList = processorAndCache.getCacheMemoryList();
        });
    }
}
