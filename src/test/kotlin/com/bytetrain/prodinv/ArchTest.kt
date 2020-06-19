package com.bytetrain.prodinv

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import org.junit.jupiter.api.Test

class ArchTest {

    @Test
    fun servicesAndRepositoriesShouldNotDependOnWebLayer() {

        val importedClasses = ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.bytetrain.prodinv")

        noClasses()
            .that()
                .resideInAnyPackage("com.bytetrain.prodinv.service..")
            .or()
                .resideInAnyPackage("com.bytetrain.prodinv.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.bytetrain.prodinv.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses)
    }
}
