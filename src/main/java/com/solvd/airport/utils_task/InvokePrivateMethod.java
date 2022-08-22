package com.solvd.airport.utils_task;

import java.lang.reflect.InvocationTargetException;

@FunctionalInterface
public interface InvokePrivateMethod {
    void invokePrivateMethod() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException;
}
