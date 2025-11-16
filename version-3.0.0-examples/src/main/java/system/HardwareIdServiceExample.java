package system;

import io.github.eggy03.ferrumx.windows.service.compounded.HardwareIdService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HardwareIdServiceExample {

    public static void main(String[] args){
        new HardwareIdService()
                .get()
                .ifPresent(hardwareId -> log.info(hardwareId.toString()));
    }
}
