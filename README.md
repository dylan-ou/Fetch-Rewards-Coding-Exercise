# Fetch-Rewards-Coding-Exercise

### Exercise
[Link](https://fetch-hiring.s3.amazonaws.com/mobile.html)

### Premise
This is the coding exercise required for the Mobile Software Engineer position at Fetch Rewards.
This Android application runs on Android API 28 and is made using Android Studio. This application
retrieves data from this [JSON file](https://fetch-hiring.s3.amazonaws.com/hiring.json) and groups
the data by "listId" and sorts them by "name." Since there are only four total "listId's," there
are four buttons for each "listId." When the user presses a button with a specific "listId," it displays all
items in the JSON file with the "listId" specified by the button.

### Result
- Information is grouped by "listId" correctly
- Any lines where "name" equals "" or "null" are omitted from displaying
- This isn't dynamic enough to support more "listId's" in any other JSON
- I noticed that if you group it by "name," it actually misplaces some of the results due to string comparison 
(e.g. {"id": 28, "listId": 1, "name": "Item 28"} comes after {"id": 276, "listId": 1, "name": "Item 276"}). I'm
sure it would've made sense if you sorted the numbers that you get from accessing "id" instead of "name." Regardless,
this is what the instructions required.