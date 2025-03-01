package com.example.jbehave;


import java.util.List;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.InjectableStepsFactory;

public class RunJBehaveTest extends JUnitStories {

    public RunJBehaveTest() {
//        configuredEmbedder().reportStepdocs();
//        configuredEmbedder().candidateSteps().add(new CalculatorSteps());
    }

    @Override
    public Configuration configuration() {
        return new Configuration() {
            {
                useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()));
                useStoryReporterBuilder(new StoryReporterBuilder()
                        .withDefaultFormats()
                        .withFormats(Format.TXT, Format.HTML, Format.XML));
            }
        };
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new CalculatorSteps());
    }

    @Override
    public List<String> storyPaths() {
        return List.of("jbehave/calculator_scenario.story");
    }
}
