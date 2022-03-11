package com.unitbv.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
    public class DepBean implements InitializingBean, DisposableBean {

        private final Logger logger = LoggerFactory.getLogger(FunBean.class);

        private FunBean funBean;

        @Autowired
        public void setFunBean(FunBean funBean){
            this.funBean = funBean;
        }

        @PostConstruct
        public void postConstruct() {
            logger.debug("post construct DepBean");
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            logger.debug("after prop set DepBean");
        }

        @Override
        public void destroy() throws Exception {
            logger.debug("destroy DepBean");
        }

        @PreDestroy
        public void preDestroy() {
            logger.debug("preDestroy DepBean");
        }
}
