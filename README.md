## Movie Review Platform

### Platform Internal Capabilities:
- Users of the Platform can review only Movies which are released so far, they cannot
review upcoming movies.
- Users can give a review-score between 1 and 10. (Higher the score the better the liking for
the movie). Currently, we are not allowing a user to review the same Movie multiple
times.
- Platform by default on-boards a user as a ‘viewer’. Later a ‘viewer’ can be upgraded to a
‘critic’ after he/she published more than 3 reviews for various movies.
- Critics are considered as experts in the judgement here, so critics reviews will be
captured with more weightage. i.e. 6 review rating of a critic will be considered as 12 (2x)
NOTE: Older reviews by users as `viewer` shall not be affected .
- *Good To Have* Based on the users' behaviour Platform should give capability to plugin
more user upgrade policies from. Ex. User ->Critic -> Expert ->Admin
  

### Requirements:
Each of the following features needs to be implemented:
1. Adding Users and Movies.
2. User to review a Movie.
3. List top n movies by total review score by ‘viewer’ in a particular year of release.
4. List top n movies by total review score by ‘viewer’ in a particular genre.
5. List top n movies by total review score by ‘critics’ in a particular year of release.
6. *Good To Have* Average review score in a particular year of release.
7. *Good To Have* Average review score in a particular genre.

### Expectations:
1. Make sure that you have working and demonstrable code for all the above requirements.
2. Feature requirements should be strictly followed. Work on the expected output first and
   then add good-to-have features of your own.
3. Use of proper abstraction, separation of concerns is required.
4. Code should easily accommodate new requirements with minimal changes. Use of
   strategies for filtering criteria is encouraged.
5. Proper exception handling is required.
6. Code should be modular, readable and unit-testable.