package ch.dulce;

import ch.dulce.version.VersionResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

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
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );

    }

    @Override
    public void run(final TestConfiguration configuration, final Environment environment) {
        VersionResource vr = new VersionResource();
        environment.jersey().register(vr);
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
    }

}
