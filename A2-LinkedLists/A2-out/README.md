# A2 Linked Lists

## Basic Information

Your name: Claire Newcom

Other students you worked with, including TAs: None

If anyone was particularly helpful, please give them a shout-out here: None


## References

Any references or resources used besides JavaDoc and course materials: None

If you used generative AI, how did you use it? What role did it play in your learning?
I did not use generative AI.

## Questions to Answer

What did you observe when comparing the benchmark results for index-based operations vs. node-based operations? Why do those results make sense for a linked list?
I noticed that consistently, node addAfter/removeAfter was significantly faster that index add/remove. 
This makes sense because addAfter and removeAfter are given nodes to add at or remove, and the only operations that are really required are changing the next pointers of easily accessed nodes, which is very fast to do.
Additionally, index add/remove requires that the list travels iteratively over all the nodes in order to reach the desired index, unlike how in arrays we would just know what is at the index. Iterating over all of the nodes takes a lot of time, even though changing the pointers is fast, so add and remove take more time.


## Reflection 

Please provide a brief reflection about your experience with this assignment. What was easiest? What was hardest? How did your understanding of linked lists evolve?
My reflection will go here.