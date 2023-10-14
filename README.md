# TestingAndCi

Spring boot Rest API with Jenkins and Docker integration

## Table of Contents

- [About](#about)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
- [License](#license)

## About

A project developed in Java that solves mobility issues regarding
booking a trip with separate services.

You will find all the typical classes in a rest api project like:
models, services, repositories, controllers, jwt and exception handlers.
Automating builds and test cases through Jenkins and hosted in docker.

The repository is controlled with Jpa due to simple functionality

#### Observe that JWT authentication is NOT implemented

Although it is a humble project and no where close in comparison to real life
you may use it in any ways you feel contribute to your purpose.

## Getting Started

You should not be needed to install any dependencies yourself
due to maven integration. All the necessary dependencies are available in pom.xml.
Therefore, I would advise you to build the project initially to check
whether you would need anything more to be installed or not.

This project utilizes MySQL driver and is already included in pom.xml.
Once again, it uses a simple JpaRepository.

You may check the application.properties file for more information
regarding connection types and configuration.

Also, you should be aware of that if your build fails either in Jenkins 
or your IDE due to connection issues, my guess would be that 
you haven't started Apache and/or MySQL services in xampp


### Prerequisites

    XAMPP v3.3.0,
    Jenkins v2.414.2
    Docker v4.23.0
    jdk-17.0.2

### Installation

Cd your way to the location you want to install the project and do:

#### Clone the repository: 
    
    git clone https://github.com/divby0exc/TestingAndCi.git
    Through GitHub CLI: gh repo clone divby0exc/TestingAndCi

You may then open up your IDE and search for the project in the given folder

#### To install xampp you may find it here:

      https://www.apachefriends.org/download.html

#### To install Jenkins you may find it here:
    
    https://www.jenkins.io/download/

#### To install Docker you may find it here:
    
    https://www.docker.com/

#### Configuration steps in Jenkins are as followed:
    
    If you have any questions about the different fields
    Jenkins have provided you with a black little question mark besides
    almost every title for you to see how or what that is.

    You repeat these below mentioned steps 2 times.
    One is for dev environment and one is for prod environment
    
    Branches to build is testing on dev and main for prod
    
    
    

    1. Create an item
    2. Freestyle project
    3. Ok
    4. Version control - Git
      Enter your repo url and eventual 
      credentials if you have a private repository
      For that you may add a token in GitHub as pwd.
    5. Branches to build - change master to main as it is the new master
      you may also have testing as your branch depending on what branch
      you want jenkins to build
    6. Build steps - Execute Windows batch command due to Windows host
      I have 2 commands which you may press add build-step to make
      1. ./mvnw compile
      2. ./mvnw package
    7. Post-build Actions - Archive the artifacts
      Inside of filed to archive box you write "target/*.jar"
      which looks for all of  your .jar files inside of the target folder
      regardless of filename
    8. Apply
    9. Save  


## Usage

You may visit this url after the installation and configuration is done:
Here you will find the necessary endpoints in the project.

    http://localhost:8080/

As described in [About](#about) section this project is far from complete.

It was merely a fair try to make a mobility service according
to a school assignment. Although I may continue on this project
furthermore, with real api integration and such.
This is not the case at the moment.

## License

This project is licensed under the [MIT License] - see the [LICENSE.md](LICENSE) file for details.

## Acknowledgments

    Borrowed asJsonString from [https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/]

## Contact
[Visit my GitHub][GitHub]  
[Contact mail][Mail]


[Mail]: mailto:seddigh.daniel@gmail.com
[GitHub]: https://github.com/divby0exc
