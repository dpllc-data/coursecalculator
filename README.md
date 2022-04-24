<!-- Headings -->
# Course Progression (Time Left) Calculator
___
## URL: (none currently)
##Author: Stan Shelton (Manager, Data Panda LLC)
##Email: support@datapandemonium.com
###Data Panda LLC is a database and database services company
___
__Terms of Use:__  Internal Use Only. All access to and use of the Product and Web Site shall be solely for the End User’s own internal business operations (Florida Virtual School, Flexpoint Education Cloud, and Data Panda LLC) and not for the benefit or business of any other party.

__© 2022 Data Panda LLC__

![Data Panda](https://drive.google.com/uc?export=view&id=1I5KWAh7O4AUzTqjkLQkdtfD8JVnBIMyh)
___
__Overview:__ A simple Java Web project that allows schools and course developers to offer students a calculator that details the approximate amount of time left in a course from anywhere the student is presently at in the course.

__Step 1:__ There are two inputs. The student selects their course from a pulldown menu.
![Data Panda](https://drive.google.com/uc?export=view&id=1aieOVlZRd9n7QSsItLWeMMblas5FqRm6)

__Step 2:__ Student inputs (as instructed) the last assginment number that was completed.
![Data Panda](https://drive.google.com/uc?export=view&id=1hh1Pq2VyfsncbQAmTAYUpV6bGUyP7uXO)

__Results:__ The student is taken to a page that displays the following results
*[x] Page heading/title including name of course
*[x] A warning of how to interpret the results
*[x] The last assignment completed
*[x] The next assignment coming up
*[x] Total time left in the course in minutes
*[x] Total time left in the course in hours
*[x] Approx time left in the course working 1hr/day - 5days/wk
*[x] Approx time left in the course working 2hrs/day - 5days/wk
*[x] Approx time left in the course working 1hr/day - 7days/wk
*[x] Approx time left in the course working 2hr/day - 7days/wk
*[x] Ability to go "BACK" to the inputs/home page

![Data Panda](https://drive.google.com/uc?export=view&id=1RGMU5s4iYV2jN1B6dXrkxy1ft8xoATG3)

Note: Estimated time left in the course is calculated based on recommended time amounts already established and published in the curriculum at the beginning of each new section.

__Tools Used / Prerequisites__
* IntelliJ 2021.2.2 (Ultimate)
* IntelliJ Runtime v11.0.12+7-b1504.28 amd64
* Java SDK v1.8.0.171
* Tomcat Server 9.0.56
* Ubuntu Server 20.04
* Hosted: Digital Ocean (when published to web)

__Dependencies__
* JUnit Jupiter API
* JUnit Jupiter Engine
* Jackson-core
* Java Servlet API
* Java.net parent
* Maven Model
* Spring Web
* javax.servlet.jstl
* thymeleaf

__Backend Features__
* Java Server Pages (JSP)
* Java Servlet
* ArrayList
* JSON

__Frontend Features__
* HTML
* CSS
* Javascript
* JSON

__Security Features__
* log4j compliant (patched)
* No database protection to worry about

__Convenience Features__
* Data time stats loaded from text (csv) file for each course
* Pertinent course data read into Servlet object or optional arrayList
* Only pertinent data sent to frontend to be displayed