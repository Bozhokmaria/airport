package com.solvd.airport.tasks;

import com.solvd.airport.processes.seed_data.SeedDataAdder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokePrivateMethodImpl implements InvokePrivateMethod {

    private static final Logger LOGGER = LogManager.getLogger(InvokePrivateMethodImpl.class);

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        LOGGER.info("Before invoking private method");
        InvokePrivateMethodImpl invokePrivateMethod = new InvokePrivateMethodImpl();
        invokePrivateMethod.invokePrivateMethod();
        LOGGER.info("After invoking private method");

        InvokePrivateMethod privateMethod = new InvokePrivateMethod() {
            @Override
            public void invokePrivateMethod() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
                StringUtilsTask stringUtilsTask = new StringUtilsTask();
                Method privateMethod
                        = StringUtilsTask.class.getDeclaredMethod("getFile", String.class);
                privateMethod.setAccessible(true);
                File file = (File)privateMethod.invoke(stringUtilsTask, "files/electric-plane.txt");
                LOGGER.info("In private method. File directory we got -" + file);
            }
        };

        LOGGER.info("Before invoking private method");
        privateMethod.invokePrivateMethod();
        LOGGER.info("After invoking private method");
    }

    @Override
    public void invokePrivateMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method indexOfMethod = SeedDataAdder.class.getDeclaredMethod("addGates");
        indexOfMethod.setAccessible(true);
        indexOfMethod.invoke(SeedDataAdder.class);
        LOGGER.info("In private method.");
    }
}
