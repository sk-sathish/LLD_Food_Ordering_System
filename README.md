# LLD_Food_Ordering_System

java solution based on this https://leetcode.com/discuss/study-guide/3231299/Secret-to-cracking-Machine-Coding-Rounds

Description: Implement an online food ordering system. Features: 
1. This system has a tie-up with restaurants where each restaurant has a menu with all the 
items & their prices. Restaurants also have a rating out of 5. 
2. Each restaurant has max #orders it can process at any given time. Beyond that, it 
shouldn’t be assigned any further orders until an ongoing order is completed. 
3. Once an order is ACCEPTED, the restaurant can mark it as COMPLETED when the order is ready. This will free up the processing capacity of the restaurant. A restaurant can’t CANCEL an ACCEPTED order. 
4. An order will be auto-assigned to a restaurant based on a selection strategy. Eg: Assign 
by lowest cost or best rating. 
5. An order will be auto-assigned to a restaurant only if all the items in an order can be fulfilled by a single restaurant. Else the order will not be ACCEPTED. 
Requirement: 
Onboard a new restaurant with a menu.
A customer should be able to place an order by giving items, respective quantities & selection strategy.
Restaurants can mark ACCEPTED orders as COMPLETED. Orders once ACCEPTED can’t be CANCELLED by a restaurant.
Order will be auto-assigned to a restaurant based on a selection strategy. 
Implement at least one restaurant selection strategy. 
A restaurant should be able to update its menu. For simplicity, a restaurant can't delete an item from the menu.
Note: Do not use any database or NoSQL store, use an in-memory store. 
Expectation: 
1. Make sure that you have working and demoable & functionally correct code. 
2. Use proper abstractions, separation of concerns, proper entity modeling 
3. Use appropriate design patterns wherever required.
4. The code should be modular, extensible, readable and unit-testable. 
5. Proper exception handling is required. 
6. Restaurant selection strategy must be pluggable 
7. Concurrency handling (BONUS / Good to have) 
8. Unit test cases (Bonus/ Good to have)


For My Reference: 
Time taken to complete : 3 hours
