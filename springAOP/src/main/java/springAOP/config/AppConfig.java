package springAOP.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"springAOP.beans","springAOP.aspects"})
@EnableAspectJAutoProxy
public class AppConfig {

}
