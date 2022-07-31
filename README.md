# Hadoop
Hadoop is an open-source software framework for storing data and running applications on clusters of commodity hardware.
We can run hadoop using docker.

docker problems:
[Problem](https://stackoverflow.com/questions/49278020/docker-cannot-start-service-as-already-exists)
```
to stop running container :
docker kill contaninerID

to remove a container:
docker rm containerID

to start and stop docker-compose:
docker-compose stop
docker-compose start

```

First We will setup docker in ubuntu:

commnad:
```
sudo apt install docker.io

docker --version

sudo systemctl status docker

sudo systemctl enable --now docker

sudo systemctl status docker

sudo docker run hello-world  ///this command will create a image called  hello-world

docker images
```
install hadoop:

```
docker-compose --version

docker-machine ---version

docker run -d -p 80:80 --name myserver nginx

visit http://localhost to view the homepage of your new server.

```

download this:
[link](https://github.com/big-data-europe/docker-hadoop)

next command:
```
docker-compose up -d

docker ps
```
Go to [link](http://localhost:9870) to view the current status of the system from the namenode.

Testing hadoop culster.
```
docker exec -it namenode bash

mkdir input

echo "Hello World" >input/f1.txt

echo "Hello Docker" >input/f2.txt

hadoop fs -mkdir -p input

hdfs dfs -put ./input/* input

docker container ls //this command will have to run into the docker folder

```
word count file link:
[link](https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqa0U4QzVzWENvby04a19mSTd2V1dDeFFYRnd6d3xBQ3Jtc0tsYkJuS1Vnb0tuZ3ktZUswUnhXdERsX1A3YlY1X09xaFB3YjdzZkVBNFlZb0lEdVdYbXhja0kzWDFTQkFJSDlMYzlwV3poaFZrcFY3TzI2VEtmcEVuLVJYNUhlWHJDVEF1eFVMRWpaNmktS3BPMEEwTQ&q=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Forg%2Fapache%2Fhadoop%2Fhadoop-mapreduce-examples%2F2.7.1%2Fhadoop-mapreduce-examples-2.7.1-sources.jar)

docker cp ../hadoop-mapreduce-examples-2.7.1-sources.jar cb0c13085cd3:hadoop-mapreduce-examples-2.7.1-sources.jar

```
to see the files use this command:

hadoop jar hadoop-mapreduce-examples-2.7.1-sources.jar org.apache.hadoop.examples.WordCount input output

```
 
 
 
