# [The Licence Tracker application](https://licencetracker.herokuapp.com/)

Licence tracker is designed to track sold application licence. User licence input is tracked from the first sold date. The values like date of sold, number of licence sold, phone number, email, invoice  and othere relevant informations are stored in the H2 database. The application can track licence expiration and send notification prior licence expire.
The all relevant information can be presented and printedas an PDF or Doc document.

## How it works 

The first step is to create customer and fill customers details form. 

![Screenshot from 2020-11-17 10-55-42](https://user-images.githubusercontent.com/28749141/99377646-bded1900-28c6-11eb-8956-b72b62b7dc62.png)

Next insert sold licence detail

![Screenshot from 2020-11-17 11-21-52](https://user-images.githubusercontent.com/28749141/99377967-305df900-28c7-11eb-8f3e-1c329627718c.png)

On the home page you can preview sold licence, update, delete, or create PDF,Doc report and print it.

![Screenshot from 2020-11-17 11-24-09](https://user-images.githubusercontent.com/28749141/99378230-7dda6600-28c7-11eb-86ed-6dd138c4e00e.png)


![Screenshot from 2020-11-17 11-25-36](https://user-images.githubusercontent.com/28749141/99378421-b0845e80-28c7-11eb-81c3-ad35dc864e85.png)



## Tech Stack
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring security](https://spring.io/projects/spring-security)
* [Bootstrap](https://getbootstrap.com)
* [H2 database](https://www.h2database.com/html/main.html)
* [JSTL](https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm)
* [iText PDF](https://itextpdf.com/en)
* [Heroku PaaS](https://www.heroku.com)
