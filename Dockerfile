FROM java:8
EXPOSE 4567
ADD vsp_diana.jar /
CMD ["java","-jar","/vsp_diana.jar"]

