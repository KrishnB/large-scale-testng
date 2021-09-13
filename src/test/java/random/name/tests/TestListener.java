package random.name.tests;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.io.CharSink;
import com.google.common.io.Files;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TestListener implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
    List<String> tests = new LinkedList<>();
        suites
        .forEach(
            iSuite -> {
              iSuite.getAllMethods()
                  .forEach(
                          iTestNGMethod -> {
                        tests.add(iTestNGMethod.getTestClass().getName()+"."+iTestNGMethod.getMethodName());
                      });
            });

        String testsCsv = Joiner.on(',').join(tests);
        File file = new File("tests.csv");
        CharSink sink = Files.asCharSink(file, Charsets.UTF_8);
        try {
            sink.write(testsCsv);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
