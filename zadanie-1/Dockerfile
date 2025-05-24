FROM ubuntu:22.04

RUN apt-get update && \
    apt-get -y install software-properties-common tzdata curl unzip zip

RUN add-apt-repository ppa:deadsnakes/ppa && \
    apt-get -y install python3.10

RUN ln -s /usr/bin/python3.10 /usr/bin/python

CMD ["python", "--version"]