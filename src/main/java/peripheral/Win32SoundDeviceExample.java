package peripheral;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_SoundDevice;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32SoundDeviceExample {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all soundDevice IDs
        List<String> soundDeviceIdList = Win32_SoundDevice.getSoundDeviceID();

        // For each soundDeviceId, fetch a map of its properties
        for(String soundDeviceId : soundDeviceIdList){
            Map<String, String> soundDeviceMap = Win32_SoundDevice.getCurrentAudioDevice(soundDeviceId);
            // iterate through the map and print the properties
            soundDeviceMap.forEach((k, v)-> System.out.println(k+": "+v));
            System.out.println();
        }
    }
}
