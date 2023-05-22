# profile-ms 

To deploy locally, run the following Docker commands:

```shell
docker run -d -p 3307:3306 --name sourcelambda_profile_db tete144/sourcelambda_profile_db
docker network create spring-net
docker network connect spring-net sourcelambda_profile_db
docker run -d -p 9090:8080 --name profile_ms --net spring-net tete144/sourcelambda_profile_ms
```

The Docker Compose file will be available soon!
