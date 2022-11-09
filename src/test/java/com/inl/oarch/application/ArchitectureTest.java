package com.inl.oarch.application;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = {
        "com.inl.oarch"
})
public class ArchitectureTest {
	
	  @ArchTest
	  static final ArchRule onion_architecture_is_respected = onionArchitecture()
      .domainModels("..domain.model..")
      .domainServices("..domain.service..")
      .applicationServices("..application..")
      .adapter("rest", "..adapter.rest..");
}
