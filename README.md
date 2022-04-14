# COP4520-PA3
Programing Assignment 3


# To Compile
`javac presents.java`
`java presents.java`

# Why the Minotaur The Minotaur has More Presents than Thank Yous
The Servants being overworked and unable to communicate could have caused an error where both of them were adding presents and writing thank-you
adjacently to each other. If both of them are removing a present next to eachother then while one is removing a present B which has a predecessor A.
The other servant has the order of removing A. So while one is removing B's link to A the other is removing A and having its predecesor connect to the next node
which would be B. When this resolves there would be missing note as a phantom B present will be present and thus they could loose the chain of presents after B.
This is why the minotaur had more presents then thank-you notes. Because of these phantom presents that can occur.


# Code Highlights
I am using the lock-free algorithmn from the book and utilizing a ConcurrentLinkedQueue that has the presents 1-500000 shuffled up and randomized. This will 
be the randomization used to insert it into the lock-free algorithmn. I then used another queue to remove these present from the lock-free algorithmn.
