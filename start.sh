# build + test backend application
cd ./backend/
mvn clean install

# build frontend
cd ../frontend/todo-list-app/
npm install

# run the backend + frontend 
java -jar ../../backend/target/ToDo-list-0.0.1-SNAPSHOT.jar & npm start

