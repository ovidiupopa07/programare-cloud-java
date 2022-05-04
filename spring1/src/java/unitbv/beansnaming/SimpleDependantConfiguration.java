import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@@ -11,10 +12,12 @@ public class SimpleDependantCfg
{

    private final Logger logger = LoggerFactory.getLogger(SimpleDependantCfg.class);

    @Bean(name={"simpleBean", "customSimpleBean", "customSimpleBean1", "customSimpleBean2"})
    SimpleBean simpleBean()
    {
        return new SimpleBeanImpl();
    }

    @Bean(name={"dependantBean", "customDependantBean", "customDependantBean1", "customDependantBean2"})
    DependantBean dependantBean()
    {
        return new DependantBeanImpl(simpleBean());
    }
}