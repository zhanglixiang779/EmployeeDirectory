## Build tools & versions used

I created the project from scratch. So it is gradle-8.9.

## Steps to run the app

1. Open project
2. Click on the `Run` button in Android Studio

## What areas of the app did you focus on?

I spent most of my time focusing on the architecture of the app:

1. Clean architecture: Presentation, Domain, Data layers
2. For Presentation layer, MVVM architectural pattern
3. Single responsibility principle: Each class has a single responsibility and is more testable
4. Composition pattern: One repository interface with 3 different implementations
5. Dependency injection using Hilt
6. Dependency inversion principle: The domain layer defines the interfaces that the data layer implements
7. Domain defines the models that data layer maps data layer models to
8. Coroutines and Flows across three layers

## What was the reason for your focus? What problems were you trying to solve?

I would love to make sure that the app was structured in a way that is easy to maintain and test. 
My interest is more of architecture and Api designs. And I was trying to ensure that the app follows the best practices at least that I am aware in terms of architecture and design patterns.

## How long did you spend on this project?

The total time spent was around 5 hours.

## Did you make any trade-offs for this project? What would you have done differently with more time?

For unit tests, I only wrote tests for UseCase and Datasource. I would have written more tests for the ViewModel and Repository if I had more time. 

## What do you think is the weakest part of your project?

I didn't spend much time on the UI/UX of the app, so it's not as polished as I would like it to be. 
If I had more time, I would have had EmployeeItem Composable include more content.

## Did you copy any code or dependencies? Please make sure to attribute them here!

I used the following code snippets from the official documentation:
1. Coil for image loading: https://coil-kt.github.io/coil/compose/#asyncimage
2. Pull to refresh example : https://developer.android.com/develop/ui/compose/components/pull-to-refresh

All other parts of the code were completely written by myself based on my existing knowledge and experience.

Dependencies used are defined in the module grade file.

## Is there any other information you’d like us to know?

Thank you for the opportunity to work on this project. I would love to hear your feedback on the project. I am looking forward to hearing from you. 