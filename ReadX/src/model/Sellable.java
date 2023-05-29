// `package model;` is declaring the package name for the Java interface `Sellable`. In Java, packages
// are used to organize related classes and interfaces. The `model` package is a common convention for
// organizing model classes and interfaces in a Java application.
package model;

// Declaring a Java interface named `Sellable` with a single method signature `void sell()`. Any class
// that implements this interface must provide an implementation for the `sell()` method.
public interface Sellable {
    void sell();
}