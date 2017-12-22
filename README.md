# videorentalstore

#Functional description 
This application allows a registred user to rent a movie from a video store.
The application contains predefined list of user and movies for testing.
All test data are loaded when application is started.

#Flow
- user must exist in DB
- user get a list of movies
- select few of them
- he can vizualize the price before rent
- client send request to rent few movies
- to finish with success 
     - movie must exist in store
     - in store must be enough copies
     - client must have enough balance
- client return movies to the store
     - rental must exist in store 
- on return there is a check if client not exceeded rent period
  if yes then price is recalculated and the difference is taken from client balance, here is normal
  to have negative rezult it means that client owe money to store
  Here also is taken in place bonus calculation and asigning it to client
  

#Data Model
Client - represents registred customers, it contains info about user balance and its bonus points
Movie - represents the video in store (title, director, description, type : new release, regular, old.)
MoviePrice -  contains prices for each movie type, it has information of start period this is number of days for which user 
              pays, after this period user pays per day but not per period
MovieRental -  contains info about which movies were rented and by which client

#Validation
- client must have suffiecient money to rent movies
- movie copy stock should be availabale in the store
- 

#Technical solution
- spring-boot
- spring- mvc
- spring-data-jpa
- swagger
- java bean validation and hibernate validation
- hsqldb
- junit+mockito
- aspects to do retry in cae of optimistick lock
- guava 
- hibernate
