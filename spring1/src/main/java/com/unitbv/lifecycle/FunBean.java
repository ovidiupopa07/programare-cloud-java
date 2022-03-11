package com.unitbv.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class FunBean implements InitializingBean,DisposableBean{
    private Logger logger = LoggerFactory.getLogger(FunBean.class);

    private DepBean depBean;

    private void init() {
        System.out.println("init done");
    }

    public void destroy(){System.out.println("destroy done");}

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
