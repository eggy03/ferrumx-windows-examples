package misc;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.CommonServiceInterface;
import io.github.eggy03.ferrumx.windows.service.OptionalCommonServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;

@Slf4j
public class AllInOneViaReflection {

    public static void main(String[] args) {

        // scans all the services classes in the given library package
        // and executes their methods
        // to check the output of all the services
        // this is purely for diagnostic purposes and should not be used as an example

        // for a given package, scans all the classes that implements the CommonServiceInterface
        // and for each class found, creates a new instance via the default constructor and then calls the get(shell)
        // and iterates over the found entities and prints their toString()
        new Reflections("io.github.eggy03.ferrumx.windows.service")
                .getSubTypesOf(CommonServiceInterface.class)
                .forEach(serviceClass -> {
                    try (PowerShell shell = PowerShell.openSession()) {
                        CommonServiceInterface<?> service = serviceClass.getDeclaredConstructor().newInstance();
                        service.get(shell).forEach(entity -> log.info(entity.toString()));
                    } catch (Exception e) {
                        log.error("Exception", e);
                    }
                });

        // similar to the first one, except it looks for subtypes of OptionalCommonServiceInterface
        new Reflections("io.github.eggy03.ferrumx.windows.service")
                .getSubTypesOf(OptionalCommonServiceInterface.class)
                .forEach(serviceClass -> {
                    try (PowerShell shell = PowerShell.openSession()) {
                        OptionalCommonServiceInterface<?> service = serviceClass.getDeclaredConstructor().newInstance();
                        service.get(shell).ifPresent(entity -> log.info(entity.toString()));
                    } catch (Exception e) {
                        log.error("Exception", e);
                    }
                });
    }
}
