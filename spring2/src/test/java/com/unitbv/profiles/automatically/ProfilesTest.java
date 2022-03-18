package com.unitbv.profiles.automatically;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
@RunWith(SpringRunner.class)
public class ProfilesTest {

    @Qualifier("devDataSourceConfig")
    @Autowired
    DataSourceConfig dataSourceConfig;

    // set dev as active profile in profile.properties file; use this file in AppConfig;
    @Test
    public void test() {
        assertInstanceOf(DevDataSourceConfig.class, dataSourceConfig);

    }
}
