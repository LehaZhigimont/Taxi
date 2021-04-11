---
# <h1>Java project implemting QueueTaxi
---
### <h7>Main tasks of this project: 
  
  + [Ordered queue](https://github.com/LehaZhigimont/Taxi/blob/main/README.md#Ordered-queue)
  + [Show on screenboard](https://github.com/LehaZhigimont/Taxi/blob/main/README.md#Show-on-screenboard)
  + [Print coupon](https://github.com/LehaZhigimont/Taxi/blob/main/README.md#Print-coupon)
  + [Сall on a speakerphone](https://github.com/LehaZhigimont/Taxi/blob/main/README.md#Сall-on-a-speakerphone)
  + [Mooving in queue](https://github.com/LehaZhigimont/Taxi/blob/main/README.md#Mooving-in-queue)
  
---

<h7> This program works with third party applications such as HDPlayer which displays information on the screenboard. It implements a line of taxis on the territory of the Minsk National Airport. Designed to control the queue. The screenboard show the current count and sequence. When registering a client, a coupon with a number is printed, if the client has a priority, it moves in the queue.
  
---
### <h7> Detailed about the project and [main tasks](https://github.com/LehaZhigimont/Taxi/blob/main/README.md#Main-tasks-of-this-project).

+ Project development that implements a queue of customers and printin out their coupon with a number, moving a customer in queue, makin a call on a speakerphone. When a client arrives, he is given a ticket with the number of the queue, then he takes a place in the parking lot and waits for him to be called on the speakerphone at this moment his number will be visible at the top of the screenboard.If the client has priority, the subscription, he can be moved to the head of the queue.

+ #### Ordered queue
    + The queue is filled in turn, but some clients also have a priority, in this case the program has some methods for moving such clients in turn.
    + The program has the ability to view the history of the queue of past days. Some methods read and write history to files on the computer.
+ #### Show on screenboard
     + To show the number on the screnboard, the uses a special program for LED panels HDPlayer, when loaded into the image program area, displays this image on the screenboard. It was revealed that HDPlayer uses a tempfolder in which the current image is located. From this it followed that my methods would substitute the necessary images in this folder for displaying on the board of the screen.
+ #### Print coupon
     + A coupon with a queue number is printed at the time of customer registration, when the button is pressed, the customer is recorded in the program, show on the screenboard and the coupon is printed. There is also a method that allows you to change some information on the coupon.
+ #### Сall on a speakerphone
     + When you press the "next" button, the sound is played through the speakers. Sounds are recorded in a file up to a certain amount, then, according to the idea of the program, the maximum number of 100 clients, then reset to zero.
+ #### Mooving in queue
     + If the customer has a priority, the queue is moved over no longer priority ones.
 
 
---
### My thoughts for this project

Of course this project is subject to a very large upgrade. Now I am at the level of a junior developer and devote more time to learning new technologies. But in the future I have plans to improve this project using newer technologies.

---
Thanks!

[To begining](https://github.com/LehaZhigimont/Taxi/blob/main/README.md#java-project-implemting-queuetaxi)
  
