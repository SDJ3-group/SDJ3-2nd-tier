# SDJ3-2nd-tier



Your task is to simulate an auto dismantling facility. In one end of the facility, decrepit cars arrive, and in the other various products, consisting of one or more car parts, depart. The facility has three stations where smaller parts of the whole process take place.

1. At the first station, the cars are weighed and registered by their chassis number and model.

2. At the second station, the cars are dismantled into their constituent parts. Each part is weighed and
registered, including a reference to which car it came from. The parts are put on pallets with each pallet containing only one type of parts. Each pallet has a maximum weight capacity.

3. At the third station, products are packed for distribution. One product might be a package with a number of the same kind of parts intended for repackaging in auto shops. Another kind of product might be “a steering system” where all the expected parts are included and from the same model, but not necessarily from the car. All products are registered including references back to the pallets the parts came from.

If it is later discovered that a car has been stolen or has been otherwise involved in a crime, it should be possible to trace all products, which might contain parts of the car. This function should be accessible outside the facility.
## Project part 1
This part is about making the above description more precise and designing the architecture of system. As a result of this part, I expect every group to hand in:
  – A diagram giving an overview of the facility
  – A class diagram describing the model of the system (cars, parts, etc.) – The architecture of the system you will make Deadline for hand-in of this part is Tuesday 17-Apr-2018 @ 23:59. Hand in by mailing a single rar file to me (jpe@via.dk).


## Project part 2
Implement the system. You have to hand in your source code and all documents produced (in both part 1 and part 2).
Deadline for handing in the project is Tuesday 15-May-2018 @ 23:59. Hand in by mailing a single rar file to me (jpe@via.dk). If don’t hand in you will not be allowed to attend the exam.
   
## Supervision
I will be available for supervision in the scheduled lessons of the course Thursdays @ 08:20-11:50. You find me in either room F.304 or my office A.301a.
You are welcome to ask short and precise questions on email jpe@via.dk 
## Rules
The project must be made in groups with two or three members.
You have to make a 3-tier architecture.
You have to use RMI and Web Services.
The system should in general be implemented in Java with at least one part implemented in C#. You have to make the data persistent in a database.
Making GUI’s are optional.
## Presentation
Each student has to make a five minute presentation of the project at the exam.
