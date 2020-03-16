call .\backend\mvnw package -DskipTests
docker stop backend
docker-compose -f .\docker-compose.yml up --build --no-deps backend
