// camel-k: language=java dependency=org.apache.camel:camel-jdbc

import org.apache.camel.builder.RouteBuilder;

public class test4 extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        spring.datasource.driver-class-name = "mysql";
        spring.datasource.url = "192.168.49.2:30036/db1";
        spring.datasource.username = "root";
        spring.datasource.password = "Password1";
        
        from("timer:java?period={{time:1000}}")
            .setBody()
                .simple("select name from candidate")
            .to("jdbc:dataSource")
            .log("${body}");
    }
}
