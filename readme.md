## Inspiration

During our brainstorming session, the most interesting ideas seemed to be centered about augmented reality and machine-learning. NavARAI was born at the intersection of the two, a project meant to use Clarifai image recognition in order to provide navigational instructions displayed to a user on a pair of eSight goggles.



## What it does

NavARAI is a mobile app especially meant for shopping centers, home to a bounty of easily visible icons and logos. Provided such a center has been mapped out with the location of these landmarks, our app is able to search for a signed location and provide navigational instructions to the user based on visible landmarks along the way. At any point, the user is able to snap a photo of their surroundings and the NavARAI will detect nearby recognized symbols, thus determining the user's position, and providing them with new landmarks to travel towards in order to reach their destination.



## How we built it

Not having access to a shopping center's blueprints over the weekend, we used the QHacks sponsor bay as our testing grounds. We treated each sponsor booth as a "store", in which we trained a Clarifai image-recognition model on their logos. To navigate between stores, we found that as long as the user could be guided to a certain cluster of stores neighboring their destination, they would be able to manage on their own. Thus the mapping system that was used consisted only of clusters of stores and connecting pathways, rather than precise positions for each store. To build the app we used various technologies such as Android Studio, Clarifai API, SQLite, and Android text-to-speech, and AWS.



## Challenges we ran into

We ran into many challenges throughout the process. Our original inspiration of using the eSight goggles was deemed impossible due to limited supply, so we compromised and simply treated our Android smartphones as the "goggles". Then, network limitations deemed a live-feed of footage to our Clarifai model impossible, so we settled on the snapshot model. As for software difficulties, we faced immense challenges with shooting and storing photos due to an undocumented error related to phone screen resolution. This was a huge problem for us as we had no idea what was wrong as there are very few online examples. Through many hours of persistence we managed to solve it , severely limiting our time to develop our idea further. A third challenge we faced was learning which data is used to train a reliable model for logo recognition.



## Accomplishments that we're proud of

We're extremely proud of having committed ourselves to an ambitious project and seeing it all the way through, all while learning and enjoying ourselves. We are proud of the way we were able to use our very unique sets of skills in a way that benefited each other and contributed to the team success. Most of all, we are proud of having shown no retreat in the face of complex difficulties.



## What we learned

We learned many things while working in this hackathon, including but not limited to Clarifai API, Java, Android Studios, and UI/UX. Our first Clarifai models did not produce the results desired, so in creating our later training sets, we learned to consider many varying factors such as image-quality, blurriness, distance, and viewing angle. Another learned experience which proved invaluable was the effectiveness of different data types for different problems. Beyond the hard skills, we learned a lot from talking to the various sponsors QHacks had to offer. Many of them were more than willing to provide helpful advice for our project and we cannot thank them enough. From them, we were given insightful critiquing, valuable advice, inspiration, and ideas, all of which contributed greatly to NavARAI's success.



## What's next for NavARAI

Seeing that our original vision for NavARAI was for it to be integrated with augmented reality devices, this is a natural next step for the project. As for the business potential of NavARAI, through either AR devices or smartphones, organisations could greatly benefit from the convenience brought to their customers by implementing NavARAI systems for navigating their premises in any environment, be it shopping centers, sporting events, music concerts, or even perhaps driving.

[![IMAGE ALT TEXT HERE](https://github.com/vishvajit79/navarai/blob/master/app/src/main/res/drawable/logo.png)](https://www.youtube.com/watch?v=pEvHpAau5aU&t=5s)
