package com.unitbv.beansnaming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component//("dependantBean")
public class DependantBeanImpl implements DependantBean {
    private SimpleBean simpleBean;

    //@Autowired
    public DependantBeanImpl(@Qualifier("simpleBeanImpl") SimpleBean simpleBean) {
        this.simpleBean = simpleBean;

        Logger logger = LoggerFactory.getLogger(DependantBeanImpl.class);
        logger.info("[DependantBeanImpl instantiation]");
    }

    @Override
    public String toString() {
        return " DependantBeanImpl{ code: " + hashCode() + "}";
    }
}
