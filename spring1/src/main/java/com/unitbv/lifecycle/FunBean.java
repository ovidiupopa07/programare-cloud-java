package com.unitbv.lifecycle;

import com.unitbv.autowiring.util.FormatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class FunBean implements InitializingBean, DisposableBean{
    private Logger logger = LoggerFactory.getLogger(FunBean.class);

    private DepBean depBean;

    @Autowired
    public void setDepBean(DepBean depBean) {
        this.depBean = depBean;
        logger.debug("Initialize DepBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.debug("InitDisposeService.initialize");
    }

    @Override
    public void destroy() throws Exception {
        logger.debug("InitDisposeService.destroy");
    }
}
