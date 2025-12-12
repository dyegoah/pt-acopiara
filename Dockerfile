# ===============================
# ESTÁGIO 1: Build (Compilação)
# ===============================
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo de dependências (pom.xml) e baixa as libs
# Isso aproveita o cache do Docker se as dependências não mudarem
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia todo o código fonte do projeto
COPY src ./src

# Compila o projeto e gera o arquivo .jar (pula testes para ser mais rápido no deploy)
RUN mvn clean package -DskipTests

# ===============================
# ESTÁGIO 2: Run (Execução)
# ===============================
FROM eclipse-temurin:17-jre-alpine

# Define diretório de trabalho
WORKDIR /app

# Cria a estrutura de pastas para os uploads funcionarem conforme seu código Java
# Nota: Seu controller usa "src/main/resources/static/uploads/..."
# Em produção, o ideal é mudar esse path no Java para um volume externo, 
# mas aqui criamos a pasta para evitar erro de "Directory not found".
RUN mkdir -p src/main/resources/static/uploads/fake_analysis
RUN mkdir -p src/main/resources/static/uploads/candidatos
RUN mkdir -p src/main/resources/static/uploads/noticias

# Copia o .jar gerado no estágio anterior
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]