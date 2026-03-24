package system;

import com.ferrumx.system.hardware.HardwareID;

import java.util.concurrent.ExecutionException;

public class HardwareIdRetrievalExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(HardwareID.getHardwareID());
    }
}
