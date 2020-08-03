# 基础镜像：openjdk:8-jdk-alpine
FROM openjdk:8-jdk-alpine
# 挂载目录，默认的安装jar包位置：/tmp
VOLUME /tmp
# 上一步在pom.xml指定的JAR_FILE参数 
ARG JAR_FILE
# 将上一步的jar包copy到镜像中的根目录，并重命名为app.jar
COPY ${JAR_FILE} app.jar
# 启动jar包
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]