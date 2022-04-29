**SOLID Principles**
Single Responsibility Principle: A class should have one and only one reason to change, meaning that a class should only have one job.

Open-Closed Principle: Objects or entities should be open for extension but closed for modification. This means that a class should be extendable without modifying the class itself. In Java, we can create interfaces and abstract classes that are fixed but represent an unbounded group of possible behaviours through concrete implmentations.

Liskov Substitution Principle: Every subclass should be substitutible for their superclass.

Interface Segregation Principle: Clients should not be forced to depend on methods that they do not use. In Java, this means avoid bloated interfaces. We don't want to force classes to implement methods that aren't used by them (i.e. dummy methods or stubs). Instead, segregate a large interface into mulitple role interfaces with different sets of behaviours.

Dependency Inversion Principle: High level modules should NOT depend on low level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions. Another way of saying this is avoid tightly coupled code. When one class knows explicitly about the design and implementation of another class, changes to one class raise the risk of breaking the other class. For example, a class should refer to an interface in its properties rather than a concrete class when possible.

**Spring Bean Lifecycle**
Lifecycle:

-Instantiate
-Populate Properties
-Call setBeanName of BeanNameAware
-Call setBeanFactory of BeanFactoryAware
-Call setApplicationContext of ApplicationContextAware
-Preinitialization (Bean PostProcessors)
-afterPropertiesSet of Initializing Beans
-Custom Init Method
-Post Initialization (BeanPostProcessors)
-Bean Ready to Use
[SOME TYPE OF TERMINATION EVENT]

Container Shutdown
Disposable Bean's destroy() -- Spring has 2 interfaces you can implement for CALL BACK EVENTS (optional):
--- 1) InitializingBean.afterPropertiesSet() - called after properties are set

--- 2) DisposableBean.destroy() - called during bean destruction in shutdown

Call Custom Destroy Method
LIFE CYCLE ANNOTATIONS
Spring has 2 annotations we can use to hook into the bean life cycle:

@PostConstruct annotated methods will be called after the bean has been constructed, but before its returned to the requesting object.

@PreDestory is called just before the bean is destroyed by the container.

BEAN POST PROCESSORS (rarely used)
Gives you a means to tap into the Spring context life cycle and interact with beans as they are processed.

Implement interface BeanPostProcessor:

--- postProcessBeforeInitialization - called before bean initialization method

--- postProcessAfterInitialization - called after bean initialization method

SPRING AWARE INTERFACES
-Spring has over 14 "AWARE" INTERFACES

-These are used to access the Spring Framework infrastructure. These are largely used within the framework and rarely used by developers.
