# SpringAI Chatbot

Spring Boot 애플리케이션에 **OpenAI GPT API**를 연동하여 사용자가 입력한 질문에 실시간으로 답변하는 **챗봇 서비스**입니다.  
대화 내역은 JDBC 기반 저장소(PostgreSQL)에 기록되며, `application-secret.yml`을 통해 API 키를 안전하게 분리 관리합니다.  

---

## 🚀 주요 기능
- **실시간 챗봇**: OpenAI GPT API를 활용하여 사용자 입력에 대한 답변 제공
- **대화 내역 관리**: JDBC 기반 저장소(JPA + PostgreSQL)로 대화 기록 저장/조회
- **보안 관리**: `application-secret.yml`을 통한 API Key 분리 관리
- **템플릿 뷰**: Mustache 템플릿으로 간단한 UI 제공

---

## 🛠 기술 스택
- **Backend**: Spring Boot 3.5, Spring AI
- **Database**: PostgreSQL (JPA & JDBC)
- **Template Engine**: Mustache
- **Build Tool**: Gradle
- **Language**: Java 21

---
## 🛠 프로젝트 소개



https://github.com/user-attachments/assets/c837ef17-4299-4dea-9386-c1fc61aa5cb6





---

## 📦 Gradle Dependencies

```gradle
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.5.3'
    id 'io.spring.dependency-management' version '1.1.7'
}

group = 'com.practice.springai'
version = '0.0.1-SNAPSHOT'

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

ext {
    set('springAiVersion', "1.0.0")
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-mustache'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.ai:spring-ai-starter-model-openai'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.ai:spring-ai-starter-model-chat-memory-repository-jdbc'
    runtimeOnly 'org.postgresql:postgresql'

    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'

    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}

dependencyManagement {
    imports {
        mavenBom "org.springframework.ai:spring-ai-bom:${springAiVersion}"
    }
}

tasks.named('test') {
    useJUnitPlatform()
}


