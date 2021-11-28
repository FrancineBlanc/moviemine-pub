[comment]: <> (# moviemine)

[comment]: <> (<div id="top"></div>)

<br />
<br />
<div align="center">
<!-- PROJECT LOGO -->

</div>

![LOGO](src/main/resources/static/images/logo2.png)
<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

We watch a LOT of movies in our lifetime, and when we watch an amazing movie we might want to talk about it and share that with our friends and family. How many times have there been where you want to rewatch a film you really liked, or recommend a certain film to someone but just can’t remember the name of the film, or can’t put into words what it was about that film that you liked specifically?

Having an app like this would solve that problem, something focused solely to:


* Capture how you felt in the moments you’ve watched your movies and refer back to them easily in one place
* Have ONE watchlist to keep track of as not every movie platform has the same library of films
* See other peoples' reviews like yourself without any added clutter searching through Google or apps with a multitude of different features.


<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

Major frameworks/libraries we used. 

* [Thymeleaf](https://www.thymeleaf.org/)
* [Bootstrap](https://getbootstrap.com/)
* [JQuery](https://jquery.com)
* [Spring Boot](https://spring.io/projects/spring-boot)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started


To get a local copy up and running follow these simple example steps:

### Prerequisites

Fork this repository and clone it to your local machine.

* Install the required dependencies:
  ```sh
  brew install gradle
  ```

<p align="right">(<a href="#top">back to top</a>)</p>

### Installation

1. Get a free API Key at [https://themovieDB.org](https://themovieDB.org)

2. Clone the repo
   ```sh
   git clone https://github.com/our repo
   ```
3. Create the database:
   ```sh
    createdb moviemine
   ```
4. If file does not exist, create a config folder in root of project and create a file called `application-dev.properties`
   ```sh
    mkdir config
    touch config/application-dev.properties
   ```
4. Enter your API key in `config/application-dev.properties`
5. Type the following command to start the server and run the application:
   ```sh
   gradle bootRun
   ```
6. Navigate to localhost:8080
   

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

* Start by signing up for a new account on the homepage
* Log in to your account and add your first review!
* Explore the movies you’ve watched and add your own!
* See other peoples reviews.
* Start building your watchlist.


<p align="right">(<a href="#top">back to top</a>)</p>

  



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

Resources we found helpful and would like to give credit to:

* [Trello](https://trello.com)
* [Balsamiq](https://www.balsamiq.com/)
* [GitHub Pages](https://pages.github.com)
* [Font Awesome](https://fontawesome.com)
* [Diagrams](https://app.diagrams.net)
* and most importantly, [The Movie Database](https://themovieDB.org)

<p align="right">(<a href="#top">back to top</a>)</p>

This project was a lot of fun to create and we hope you enjoy using it as much as we enjoyed making it!

N.B. For a full commit history, please get in touch with any one of the collaborators on this project, [Francine](https://github.com/FrancineBlanc), [Lauren](https://github.com/adashtra), [Nejla](https://github.com/nejlalowe), or [Patrick](https://github.com/pchan2).


