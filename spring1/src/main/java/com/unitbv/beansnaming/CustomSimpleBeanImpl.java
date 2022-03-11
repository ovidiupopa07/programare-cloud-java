package com.unitbv.beansnaming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomSimpleBeanImpl implements CustomSimpleBean{
    public CustomSimpleBeanImpl() {
        Logger logger = LoggerFactory.getLogger(SimpleBeanImpl.class);
        logger.info("[CustomSimpleBeanImpl instantiation]");
    }

    @Override
    public String toString() {
        return "CustomSimpleBeanImpl{ code: " + hashCode() + "}";
    }
}
