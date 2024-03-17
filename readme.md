# NotesApp

This is a Notes Application where users and store and access their notes

# Build and Run
```bash
docker build -t notes-app .
```

```bash
docker run -e SPRING_PROFILES_ACTIVE=dev -p 8080:8080 notes-app
```