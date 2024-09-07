# Types of dependency injection in spring boot

## Dependency injection in Spring can be done through

- Constructor injection
- Setters injection
- Field injection

##  Autowiring in spring
no – Default, no auto wiring, set it manually via “ref” attribute
byName – Auto wiring by property name. If the name of a bean is same as the name of other bean property, auto wire it.
byType – Auto wiring by property data type. If data type of a bean is compatible with the data type of other bean property, auto wire it.
constructor – byType mode in constructor argument.
autodetect – If a default constructor is found, use “autowired by constructor”; Otherwise, use “autowire by type”.


The default mode of the @Autowired is byType.

If annotated with @Autowired it will inject the bean with the matching type (An exception will be thrown if there are more than one of a type). 
To specify a name use the @Qualifier annotation. when there are more than one of a matching type, 
spring framework will try to use field name as bean name to determine a proper candidate.

As of Spring Framework 4.3, an @Autowired annotation on such a constructor is no longer necessary if the target bean defines only one constructor to begin with. 
However, if several constructors are available and there is no primary/default constructor, at least one of the constructors must be annotated with 
@Autowired in order to instruct the container which one to use. See the discussion on constructor resolution for details.


If you use Java Configuration, a corresponding @Bean method always silently overrides 
a scanned bean class with the same component name as long as the return type of the @Bean method matches that bean class.
This simply means that the container will call the @Bean factory method in favor of any pre-declared constructor on the bean class.

### Multiple Beans of the Same Type causes NoUniqueBeanDefinitionException
When we run the above application with the following bean configuration (RootConfig) then Spring finds multiple candidates 
(Square and Circle) to inject into ShapeService so it throws an exception.

### Only a Single Matching Bean works Perfectly
Suppose we remove the Square (or Circle) bean. Since there is only one bean of type Shape in the context (either Circle or Square),
Spring will successfully autowire it, and you will see the appropriate draw message.
``` 
@Bean
Square square() {
return new Square();
}

@Bean
ShapeService shapeService() {
return new ShapeService();

}
```

### No Matching Bean causes NoSuchBeanDefinitionException
``
@Bean
ShapeService shapeService() {
return new ShapeService();
}
``
By default, @Bean methods will be eagerly instantiated at container bootstrap time.
To avoid this, @Configuration may be used in conjunction with the @Lazy annotation to indicate that all @Bean methods declared within the class are by default lazily initialized.
Note that @Lazy may be used on individual @Bean methods as well.

# Customizing the Nature of a Bean
The Spring Framework provides a number of interfaces you can use to customize the nature of a bean. This section groups them as follows:

- Lifecycle Callbacks

- ApplicationContextAware and BeanNameAware

- Other Aware Interfaces

# Lifecycle Callbacks
To interact with the container’s management of the bean lifecycle, you can implement the Spring InitializingBean and DisposableBean interfaces.
The container calls afterPropertiesSet() for the former and destroy() for the latter to let the bean perform certain actions upon initialization and destruction of your beans.

The JSR-250 @PostConstruct and @PreDestroy annotations are generally considered best practice for receiving lifecycle callbacks in a modern Spring application. Using these annotations means that your beans are not coupled to Spring-specific interfaces. 

``
public class CachingMovieLister {

	@PostConstruct
	public void populateMovieCache() {
		// populates the movie cache upon initialization...
	}

	@PreDestroy
	public void clearMovieCache() {
		// clears the movie cache upon destruction...
	}
}
``

Like @Resource, the @PostConstruct and @PreDestroy annotation types were a part of the standard Java libraries from JDK 6 to 8. 
However, the entire javax.annotation package got separated from the core Java modules in JDK 9 and eventually removed in JDK 11. 
As of Jakarta EE 9, the package lives in jakarta.annotation now. If needed, the jakarta.annotation-api artifact needs to be obtained via Maven Central now, 
simply to be added to the application’s classpath like any other library.


# Combining Lifecycle Mechanisms
As of Spring 2.5, you have three options for controlling bean lifecycle behavior:

The InitializingBean and DisposableBean callback interfaces

Custom init() and destroy() methods

The @PostConstruct and @PreDestroy annotations

You can combine these mechanisms to control a given bean.

# ApplicationContextAware and BeanNameAware

When an ApplicationContext creates an object instance that implements the org.springframework.context.ApplicationContextAware interface, the instance is provided with a reference to that ApplicationContext. The following listing shows the definition of the ApplicationContextAware interface:

public interface ApplicationContextAware {

	void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
Thus, beans can programmatically manipulate the ApplicationContext that created them, through the ApplicationContext interface or by casting the reference to a known subclass of this interface (such as ConfigurableApplicationContext, which exposes additional functionality). One use would be the programmatic retrieval of other beans. Sometimes this capability is useful. However, in general, you should avoid it, because it couples the code to Spring and does not follow the Inversion of Control style, where collaborators are provided to beans as properties. Other methods of the ApplicationContext provide access to file resources, publishing application events, and accessing a MessageSource. These additional features are described in Additional Capabilities of the ApplicationContext.

Autowiring is another alternative to obtain a reference to the ApplicationContext. The traditional constructor and byType autowiring modes (as described in Autowiring Collaborators) can provide a dependency of type ApplicationContext for a constructor argument or a setter method parameter, respectively. For more flexibility, including the ability to autowire fields and multiple parameter methods, use the annotation-based autowiring features. If you do, the ApplicationContext is autowired into a field, constructor argument, or method parameter that expects the ApplicationContext type if the field, constructor, or method in question carries the @Autowired annotation. For more information, see Using @Autowired.

When an ApplicationContext creates a class that implements the org.springframework.beans.factory.BeanNameAware interface, the class is provided with a reference to the name defined in its associated object definition. The following listing shows the definition of the BeanNameAware interface:

public interface BeanNameAware {

	void setBeanName(String name) throws BeansException;
}
The callback is invoked after population of normal bean properties but before an initialization callback such as InitializingBean.afterPropertiesSet() or a custom init-method.