docker network create redis-net

docker run --name fintech-redis `
             -p 6379:6379 `
             --network redis-net `
             -d redis:latest

//redis-cli 실행
docker exec -it a8d344dfc17b redis-cli