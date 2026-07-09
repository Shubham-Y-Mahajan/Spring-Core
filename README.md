# Spring Dependency Injection & `@Autowired` Notes

A concise guide to understanding **Dependency Injection (DI)** in Spring, the different injection techniques, and how `@Autowired` works.

---

# Table of Contents

1. Why Dependency Injection?
2. Understanding Loose Coupling
3. How Spring Solves the Problem
4. Ways to Configure Dependency Injection
5. Types of Dependency Injection
6. Understanding `@Autowired`
7. What Can and Cannot Be Autowired
8. Rule of Thumb

---

# 1. Why Dependency Injection?

One of the primary goals while designing software is **loose coupling**.

Loose coupling means that you can change one implementation without affecting the rest of the application.

Benefits include:

- Easier maintenance
- Easier replacement of implementations
- Better testability
- Ability to use mock objects during unit testing

---

## Example Without Dependency Injection

```java
class Laptop {
    HitachiHD hardDrive = new HitachiHD();
}
```

The `Laptop` class is directly dependent on `HitachiHD`.

---

## Using an Interface (Better Abstraction)

```java
class Laptop {
    HardDrive hardDrive = new HitachiHD();
}

class HitachiHD implements HardDrive {}
```

Using an interface improves abstraction, but the code is **still tightly coupled** because `Laptop` is responsible for creating the implementation.

If you later switch to `SandiskHD`, every occurrence of:

```java
new HitachiHD()
```

must be changed manually.

---

# 2. How Spring Solves the Problem

Instead of creating dependencies yourself, let **Spring create and inject them**.

```java
@Component
class HitachiHD implements HardDrive {}

@Component
class SandiskHD implements HardDrive {}
```

```java
class Laptop {

    @Autowired
    private HardDrive hardDrive;

}
```

Spring now decides which implementation to inject.

### What the annotations mean

### `@Component`

Marks a class as a Spring-managed bean.

Spring creates and manages its lifecycle inside the IoC container.

### `@Autowired`

Requests Spring to inject a suitable bean of the required type.

---

# 3. Ways to Configure Dependency Injection

Spring supports three common configuration styles:

- XML-based configuration
- Annotation-based configuration
- Java-based configuration (`@Configuration` + `@Bean`)

All three ultimately create beans inside the Spring IoC container.

---

# 4. Types of Dependency Injection

Spring supports three injection styles.

---

## 1. Field Injection

```java
@Component
public class Car {

    @Autowired
    private Tyre tyre;

}
```

Spring:

1. Creates `Car`
2. Injects the field using reflection

### Pros

- Very short
- Easy for small examples and tutorials

### Cons

- Harder to unit test
- Dependency is hidden
- Object may exist in an incomplete state

Because of these drawbacks, field injection is generally **not recommended for production code**.

---

## 2. Setter Injection

```java
@Component
public class Car {

    private Tyre tyre;

    @Autowired
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

}
```

Spring:

1. Creates `Car`
2. Calls `setTyre()`

### Best suited for

- Optional dependencies
- Dependencies that may change after object creation

---

## 3. Constructor Injection (Recommended)

```java
@Component
public class Car {

    private final Tyre tyre;

    public Car(Tyre tyre) {
        this.tyre = tyre;
    }

}
```

Notice:

- No `@Autowired` is required when there is only one constructor.
- Spring automatically detects the constructor and injects the dependency.

Conceptually, Spring performs something similar to:

```java
Tyre tyre = context.getBean(Tyre.class);
Car car = new Car(tyre);
```

### Multiple Constructors

If a class has multiple constructors, specify which one Spring should use.

```java
@Component
public class Car {

    private final Tyre tyre;

    public Car() {
    }

    @Autowired
    public Car(Tyre tyre) {
        this.tyre = tyre;
    }

}
```

---

## Why Constructor Injection is Preferred

Suppose a `Car` cannot exist without a `Tyre`.

Constructor injection guarantees that every `Car` is created with a valid `Tyre`.

```java
Car car = new Car(tyre);
```

You cannot accidentally write:

```java
Car car = new Car();
```

because such a constructor does not exist.

This ensures required dependencies are always available.

---

## Quick Comparison

| Injection Type | Recommended Use |
|----------------|-----------------|
| Constructor Injection | Required dependencies (recommended default) |
| Setter Injection | Optional or configurable dependencies |
| Field Injection | Tutorials, demos, legacy code |

---

# 5. Understanding `@Autowired`

A common misconception is:

> "Only `@Component` classes can be autowired."

This is **not true**.

The actual rule is:

> **Only Spring-managed beans can be autowired.**

`@Component` is simply one way to create a Spring bean.

---

## Spring-managed Beans

All of the following create Spring-managed beans:

```java
@Component
public class Tyre {}
```

```java
@Service
public class UserService {}
```

```java
@Repository
public class UserRepository {}
```

```java
@Controller
public class HomeController {}
```

```java
@Configuration
public class AppConfig {

    @Bean
    public Tyre tyre() {
        return new Tyre();
    }

}
```

Since all of these are managed by Spring, they can all be injected.

```java
@Component
public class Car {

    @Autowired
    private Tyre tyre;

}
```

---

# 6. What Cannot Be Autowired?

Objects created using `new` are **not managed by Spring**.

Example:

```java
public class Car {

    private Tyre tyre = new Tyre();

}
```

or

```java
Tyre tyre = new Tyre();
```

These are ordinary Java objects.

Since Spring did not create them, it cannot inject or manage them.

---

# 7. Mental Model

Think of the Spring IoC container as a warehouse.

| Annotation | Meaning |
|------------|---------|
| `@Component` | Put this class in the warehouse. |
| `@Bean` | I'm creating this object manually—please store it in the warehouse. |
| `@Autowired` | Fetch a suitable bean from the warehouse and inject it here. |

If an object is **not inside the warehouse**, Spring has nothing to inject.

---

# 8. Key Takeaways

- Dependency Injection promotes loose coupling.
- Loose coupling improves maintainability and testing.
- Spring manages object creation through its IoC container.
- Dependencies can be configured using XML, annotations, or Java configuration.
- Constructor injection is the preferred approach for required dependencies.
- Setter injection is useful for optional dependencies.
- Field injection is common in tutorials but discouraged in production.
- `@Autowired` works with **any Spring-managed bean**, not only `@Component`.
- Objects created with `new` are outside the Spring container and cannot be autowired.