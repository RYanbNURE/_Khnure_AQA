curl -X POST -H "Content-Type: application/json" -d '{"jsonrpc": "2.0", "method": "add", "params": [10, 20], "id": 1}' http://localhost:8080/calculator

curl -X POST -H "Content-Type: application/json" -d "{\"jsonrpc\": \"2.0\", \"method\": \"add\", \"params\": [10, 20], \"id\": 1}" http://localhost:8080/calculator

curl -X POST -H "Content-Type: application/json" -d "{\"jsonrpc\": \"2.0\", \"method\": \"subtract\", \"params\": [30, 15], \"id\": 2}" http://localhost:8080/calculator

curl -X POST -H "Content-Type: application/json" -d "{\"jsonrpc\": \"2.0\", \"method\": \"multiply\", \"params\": [5, 6], \"id\": 3}" http://localhost:8080/calculator

curl -X POST -H "Content-Type: application/json" -d "{\"jsonrpc\": \"2.0\", \"method\": \"multiply\", \"params\": [5, 6], \"id\": 3}" http://localhost:8080/calculator

curl -X POST -H "Content-Type: application/json" -d "{\"jsonrpc\": \"2.0\", \"method\": \"divide\", \"params\": [20, 4], \"id\": 4}" http://localhost:8080/calculator

curl http://localhost:8080/health