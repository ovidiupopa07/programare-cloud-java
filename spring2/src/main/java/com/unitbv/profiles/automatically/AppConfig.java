package com.unitbv.profiles.automatically;

import com.unitbv.multipleConfigs.ConfigA;
import com.unitbv.multipleConfigs.ConfigB;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySource("classpath:profiles.properties")
public class AppConfig {
}
