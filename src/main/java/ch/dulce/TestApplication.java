package ch.dulce;

import ch.dulce.version.VersionResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TestApplication extends Application<TestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TestApplication().run(args);
    }

    @Override
    public String getName() {
        return "os-test";
    }

    @Override
    public void initialize(final Bootstrap<TestConfiguration> bootstrap) {

    }

    @Override
    public void run(final TestConfiguration configuration, final Environment environment) {
        VersionResource vr = new VersionResource();
        environment.jersey().register(vr);
    }

}
