from("direct:start").
    setBody(simple("yo!")).
    to("log:test1");
