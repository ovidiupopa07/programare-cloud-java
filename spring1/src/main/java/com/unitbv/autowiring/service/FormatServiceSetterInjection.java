package com.unitbv.autowiring.service;

import com.unitbv.autowiring.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormatServiceSetterInjection {
    private FormatUtil formatUtil;

    public void checkFormatted() {
        System.out.println(this.formatUtil.formatted(true));
    }

    @Autowired
    public void setFormatUtil(FormatUtil formatUtil) {
        this.formatUtil=formatUtil;
    }
}
