package com.unitbv.autowiring.service;

import com.unitbv.autowiring.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormatServiceFieldInjection {
    public FormatUtil formatUtil;

    public void checkFormatted() {
        System.err.println(this.formatUtil.formatted(true));
    }
}
