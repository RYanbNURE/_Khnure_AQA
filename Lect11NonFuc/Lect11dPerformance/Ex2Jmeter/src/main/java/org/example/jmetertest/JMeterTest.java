package org.example.jmetertest;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.gui.ArgumentsPanel;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.LoopControlPanel;
import org.apache.jmeter.control.gui.TestPlanGui;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.threads.gui.ThreadGroupGui;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.ListedHashTree;

import java.io.File;
import java.io.FileOutputStream;

public class JMeterTest {

    public static void main(String[] args) throws Exception {
        // Set JMeter home directory
        File jmeterHome = new File(System.getProperty("user.dir"), "jmeter");
        String jmeterProperties = jmeterHome.getAbsolutePath() + "/bin/jmeter.properties";

        if (!new File(jmeterProperties).exists()) {
            throw new RuntimeException("JMeter properties file not found: " + jmeterProperties);
        }

        JMeterUtils.setJMeterHome(jmeterHome.getAbsolutePath());
        JMeterUtils.loadJMeterProperties(jmeterProperties);
        JMeterUtils.initLocale();

        // Create JMeter test plan
        ListedHashTree testPlanTree = new ListedHashTree();

        // Create test plan
        TestPlan testPlan = new TestPlan("Create JMeter Script From Java Code");
        testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());
        testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());
        testPlan.setUserDefinedVariables((Arguments) new ArgumentsPanel().createTestElement());

        // Create thread group
        ThreadGroup threadGroup = new ThreadGroup();
        threadGroup.setName("Thread Group");
        threadGroup.setNumThreads(1);
        threadGroup.setRampUp(1);
        threadGroup.setSamplerController(new LoopController());
        threadGroup.setProperty(TestElement.TEST_CLASS, ThreadGroup.class.getName());
        threadGroup.setProperty(TestElement.GUI_CLASS, ThreadGroupGui.class.getName());

        // Create loop controller
        LoopController loopController = new LoopController();
        loopController.setLoops(1);
        loopController.setFirst(true);
        loopController.setProperty(TestElement.TEST_CLASS, LoopController.class.getName());
        loopController.setProperty(TestElement.GUI_CLASS, LoopControlPanel.class.getName());
        loopController.initialize();

        // Create HTTP Sampler
        HTTPSampler httpSampler = new HTTPSampler();
        httpSampler.setDomain("example.com");
        httpSampler.setPort(80);
        httpSampler.setPath("/");
        httpSampler.setMethod("GET");
        httpSampler.setName("HTTP Request");
        httpSampler.setProperty(TestElement.TEST_CLASS, HTTPSampler.class.getName());
        httpSampler.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());

        // Add everything to the test plan tree
        testPlanTree.add(testPlan);
        ListedHashTree threadGroupHashTree = (ListedHashTree) testPlanTree.add(testPlan, threadGroup);
        threadGroupHashTree.add(httpSampler);

        // Save the test plan to a JMX file
        SaveService.saveTree(testPlanTree, new FileOutputStream("testplan.jmx"));

        // Add summariser for results
        Summariser summer = null;
        String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
        if (summariserName.length() > 0) {
            summer = new Summariser(summariserName);
        }

        // Store execution results into a .jtl file
        String logFile = "result.jtl";
        ResultCollector logger = new ResultCollector(summer);
        logger.setFilename(logFile);
        testPlanTree.add(testPlanTree.getArray()[0], logger);

        // Run the test
        StandardJMeterEngine jmeter = new StandardJMeterEngine();
        jmeter.configure(testPlanTree);
        jmeter.run();

        System.out.println("Test completed. See " + logFile + " for results");
    }
}