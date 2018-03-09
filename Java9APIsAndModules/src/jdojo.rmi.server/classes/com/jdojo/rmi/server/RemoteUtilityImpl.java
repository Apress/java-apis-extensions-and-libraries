// RemoteUtilityImpl.java
package com.jdojo.rmi.server;

import com.jdojo.rmi.common.RemoteUtility;
import java.rmi.server.Unreferenced;
import java.time.ZonedDateTime;

public class RemoteUtilityImpl implements RemoteUtility, Unreferenced {
    public RemoteUtilityImpl() {
    }

    @Override
    public String echo(String msg) {
        return msg;
    }

    @Override
    public ZonedDateTime getServerTime() {
        return ZonedDateTime.now();
    }

    @Override
    public int add(int n1, int n2) {
        return n1 + n2;
    }

    @Override
    public void unreferenced() {
        System.out.println("RemoteUtility unreferenced at: " + ZonedDateTime.now());
    }
}
