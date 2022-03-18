package com.unitbv.beansnaming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//TODO test what will happen when you add a stereotype annotation
public class SimpleBeanImpl implements SimpleBean {

    public SimpleBeanImpl() {
        Logger logger = LoggerFactory.getLogger(SimpleBeanImpl.class);
        logger.info("[SimpleBeanImpl instantiation]");
    }

    @Override
    public String toString() {
        return "SimpleBeanImpl{ code: " + hashCode() + "}";
    }

}
