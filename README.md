# Moview Forum Backend

This project is backend of Moview Forum.

> JDK 17
>
> Gradle 7.5+

## Development

### Run

1. Setup local postgresql server (choose one of below)

   - Docker single container
     ```
     $ docker run --name moviewdb -e POSTGRES_PASSWORD=admin -dp 5432:5432 postgres:14.2-alpine
     ```
   - Docker compose
     ```
     $ cd path/moview-backend (where docker-compose.yml is located)
     $ docker-compose up -d
     ```
   - Run postgresql database as Window/Mac service

2. Open project with IDEA and click **Run**

### Test

- By IDEA

  Gradle -> Tasks -> verification -> test

- By CLI

```
./gradlew test
```

### Build

- By IDEA

  Gradle -> Tasks -> build -> clean

  Gradle -> Tasks -> build -> build

- By CLI

```
./gradlew clean build
```
