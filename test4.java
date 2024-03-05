// camel-k: language=java dependency=org.apache.camel:camel-jdbc

import org.apache.camel.builder.RouteBuilder;

public class test4 extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        SimpleRegistry registry = new SimpleRegistry();
        DateSource ds = setupDataSource("jdbc:mysql://root:Password1@192.168.49.2:30036/db1");
        registry.put("myDataSource", ds);
        CamelContext camel = new DefaultCamelContext(registry);
        
        from("timer:java?period={{time:1000}}")
            .setBody()
                .simple("select name from candidate")
            .to("jdbc:dataSource")
            .log("${body}");
    }
}
