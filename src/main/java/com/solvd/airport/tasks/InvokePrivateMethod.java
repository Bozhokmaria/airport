package com.solvd.airport.tasks;

import java.lang.reflect.InvocationTargetException;

@FunctionalInterface
public interface InvokePrivateMethod {
    void invokePrivateMethod() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException;
}
