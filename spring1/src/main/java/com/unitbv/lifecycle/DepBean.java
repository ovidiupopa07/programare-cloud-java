package com.unitbv.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DepBean {
    public DepBean() {
      log.info("DepBean constructor");
    }
}
