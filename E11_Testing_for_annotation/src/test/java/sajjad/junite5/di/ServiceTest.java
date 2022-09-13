package sajjad.junite5.di;

import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {


    //Write a test that validates that the Service class only has one constructor annotated with @Inject
    @Test
    void ensureServiceClassHasJustOnceConstructorWithInjectAnnotation() throws NoSuchMethodException {

        assertTrue(Arrays.stream(Service
                .class
                .getConstructors())
                .anyMatch(constructor -> constructor.isAnnotationPresent(Inject.class)));
    }


}