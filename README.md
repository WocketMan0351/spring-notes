# spring-dependency-injection-notes
Contains notes covering best practices regarding various ways to inject dependencies. Covers @Qualifier, @Primary, @Controller, and @Profile in depth, as well as the Bean lifecycle and its related interfaces.

# SOLID Principles #

**Single Responsibility Principle:** A class should have one and only one reason to change, meaning that a class should only have one job.

**Open-Closed Principle:** Objects or entities should be open for extension but closed for modification. This means that a class should be extendable without modifying the class itself. In Java, we can create interfaces and abstract classes that are fixed but represent an unbounded group of possible behaviours through concrete implmentations.

**Liskov Substitution Principle:** Every subclass should be substitutible for their superclass.

**Interface Segregation Principle:** Clients should not be forced to depend on methods that they do not use. In Java, this means avoid bloated interfaces. We don't want to force classes to implement methods that aren't used by them (i.e. dummy methods or stubs). Instead, segregate a large interface into mulitple role interfaces with different sets of behaviours. 

**Dependency Inversion Principle:** High level modules should NOT depend on low level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions. Another way of saying this is avoid tightly coupled code. When one class knows explicitly about the design and implementation of another class, changes to one class raise the risk of breaking the other class. For example, a class should refer to an interface in its properties rather than a concrete class when possible.

# Component Annotations #
Changing the annotation does not change the functionality by itself. These annotations allow us to categorize our components and apply specific logic to specific categories. For example, Spring provides a default exception translation facility only if you use the @Repository annotation on a component. 

@Component - Use when in doubt of which component annotation to use. Generic component.

@Repository - Use in the Data layer of an application. Encapsulating storage, retrieval, and search behavior typically from a relational database.

@Service - Use in the Business layer of an applicationBusiness Service Facade.

@Controller - Use in the User Interface layer of the application. Controller in MVC pattern

# Spring Bean Lifecycle #

Lifecycle:
1) Instantiate
2) Populate Properties
3) Call setBeanName of BeanNameAware
4) Call setBeanFactory of BeanFactoryAware
5) Call setApplicationContext of ApplicationContextAware
6) Preinitialization (Bean PostProcessors)
7) afterPropertiesSet of Initializing Beans
8) Custom Init Method
9) Post Initialization (BeanPostProcessors)
10) Bean Ready to Use 

[SOME TYPE OF TERMINATION EVENT]

11) Container Shutdown
12) Disposable Bean's destroy() -- Spring has 2 interfaces you can implement for CALL BACK EVENTS (optional):
 
--- 1) InitializingBean.afterPropertiesSet() - called after properties are set

--- 2) DisposableBean.destroy() - called during bean destruction in shutdown

13) Call Custom Destroy Method

# LIFE CYCLE ANNOTATIONS #
Spring has 2 annotations we can use to hook into the bean life cycle:

1) @PostConstruct annotated methods will be called after the bean has been constructed, but before its returned to the requesting object.

2) @PreDestory is called just before the bean is destroyed by the container.

# BEAN POST PROCESSORS (rarely used) #
Gives you a means to tap into the Spring context life cycle and interact with beans as they are processed.

Implement interface BeanPostProcessor:

--- postProcessBeforeInitialization - called before bean initialization method

--- postProcessAfterInitialization - called after bean initialization method

# SPRING AWARE INTERFACES #
-Spring has over 14 "AWARE" INTERFACES

-These are used to access the Spring Framework infrastructure. These are largely used within the framework and rarely used by developers.
