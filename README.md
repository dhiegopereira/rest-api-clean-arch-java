# REST API SAMPLE WITH CLEAN ARCH IN JAVA

```CSS
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── api/
│   │           └── movies/
│   │               ├── Application.java
│   │               ├── adapters/
│   │               │   └── controllers/
│   │               │       └── MovieController.java
│   │               ├── domain/
│   │               │   ├── Movie.java
│   │               │   └── MovieRepository.java
│   │               ├── frameworks/
│   │               │   └── repositories/
│   │               │       └── JpaMovieRepository.java
│   │               └── usecases/
│   │                   ├── CreateMovieUseCase.java
│   │                   ├── ReadAllMoviesUseCase.java
│   └── resources/
│       └── application.properties
└── test/
    ├── java/
    │   └── com/
    │       └── api/
    │           └── movies/
    │               ├── adapters/
    │               │   └── controllers/
    │               │       └── MovieControllerTest.java
    │               ├── usecases/
    │               │   └── CreateMovieUseCaseTest.java
    │               │   └── ReadAllMoviesUseCaseTest.java
    └── resources/
```
