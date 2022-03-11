package com.unitbv.beansnaming;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("customDependantBean")
public class DependantBeanImpl implements DependantBean {
    private SimpleBean simpleBean;

    public DependantBeanImpl(SimpleBean simpleBean) {

        this.simpleBean = simpleBean;

        Logger logger = LoggerFactory.getLogger(DependantBean.class);
        logger.info("[DependantBeanImpl instantiation]");
    }

    @Override
    public String toString() {
        return "DependantBeanImpl { code: " + hashCode() + "}";
    }
}
