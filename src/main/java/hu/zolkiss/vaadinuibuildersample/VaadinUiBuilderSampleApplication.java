package hu.zolkiss.vaadinuibuildersample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"hu.zolkiss.vaadinuibuildersample", "hu.zolkiss.uibuilder"})
public class VaadinUiBuilderSampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(VaadinUiBuilderSampleApplication.class, args);
  }

}
