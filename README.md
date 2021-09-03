# reverse-assignment
This is an demo project which exposing rest api to reverse string

Api takes input string and validates whether the input contains only alphabets/alphabets with space ( just an additional feature to handle batch string data)
    -> return reversed string once the validation pass through
    -> path not found exception when input string is not given
    -> Bad request when string passed with numbers or any other values 

## Steps to create a docker image first time from local

prepare the docker file with the steps to build the image and keep it in project path

# docker engine should be installed and started in your machine to build image

docker build -f Dockerfile -t <image-name> .

# docker image will be created and can be seen using below command

docker images

# docker image locally tested by running the docker with below command

docker run -p applictaionport:containerport <image-name>

# we can test the api by running the url through browser or postman
# retagging existing local image
docker tag <image-name> hub-username/repo-name

#pushing to docker hub repository
docker push hub-username/repo-name:<tag>

## Steps to download docker image and run locally
	
 1. Download the image from docker hub using the below command
 
	docker pull <hub-username>/assignment:latest
	
 2. Run the image with below command
    
    docker run -p 8086:8086 <hub-username>/assignment 	
	
 ## run the application:

1. check the application by hitting the below url without any authentication:

http://localhost:8086/api/reverse/palindrome

Reversed string will be displayed

2. Bad request when hit the url with invalid string

http://localhost:8086/api/reverse/test1

3. Not found when hit the url without the inputstring

http://localhost:8086/api/reverse/



