package org.dev.tech.service.impl;

import org.dev.tech.service.MyInterface;

import java.util.Collections;
import java.util.List;

public class MyInterfaceImpl implements MyInterface {
    @Override
    public Integer getMaxNum(List<Integer> intList) {
        Integer max = Collections.max(intList);
        return max;
    }
}
