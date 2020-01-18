Threads Example In Kotlin - 2020
---------------------------------

Implement basic multi-threading application 
add simple activities to application that perform asynchronous operations.
On the MainActivity it will add Menu item on the action bar with two options menu:
“Async Task Activity” and “Threads Handler Activity”
Clicking on each button opens a corresponding Activity.
Both AsyncTask and Threads Activity have three buttons: 
create, start & cancel And a TextView.

Both perform the same operation, but the implementation is different.
Create” button creates a new task,
“Start” button executes it,
And “Cancel” cancels it.
Upon execution, the task, on a worker thread (on the background) counts from 1 to 10.
From each number it writes it to the TextView and then sleeps for 500 milliseconds. 
When it gets to the end of the count (if wasn’t cancelled) it writes “Done!”
The Threads Activity performs the same thing with your implementation to AsyncTask,
using Java threads and Handler to communicate with the Main Thread.



