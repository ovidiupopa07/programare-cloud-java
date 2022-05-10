package com.unitbv.autowiring.service;

import com.unitbv.autowiring.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormatServiceConstructorInjection {
    private final FormatUtil formatUtil;

    public void checkFormatted() {
        System.out.println(this.formatUtil.formatted(true));
    }
}
