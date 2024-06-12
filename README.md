# Introduction

Welcome to the my Physics Kinematics Solving program. I created this in Junior year of high school when my AP Physics 1 teacher said that we could use calculator programs on our exams, as long as we only used programs we created ourselves, the full (romanticized) backstory on my motivation is somewhere below. To use the program, it's quite easy, just download the .jar file (or source code and compile it yourself) and then you pick whether you want to solve a one-dimensional or two-dimensional kinematics problem. Then you will enter in all the information you have been given (all your known variables) and the program will calculate all the unknown variables.

## Getting Started

1. **Prerequisites**: Ensure you have Java Development Kit (JDK) installed on your machine. If not, download and install it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. **IDE**: This project was developed using Visual Studio Code, but you can use any IDE that supports Java.

## Folder Structure

The project contains the following folders:

- `src`: Contains the source code for the calculator program.
- `lib`: Contains any dependencies that the project might need. Currently, this project does not have external dependencies.
- `bin`: This folder will be generated when you compile the Java files and will contain the bytecode.

> If you wish to customize the folder structure, you can modify the `.vscode/settings.json` file accordingly.

## Running the Program

Once installed, you can simply run the `physics final.jar` file and the GUI will show up.

If you make changes to the calculator and wish to instead recompile it:

1. Navigate to the `src` directory.
2. Compile the Java file using the command: `javac PhysicsSolver.java`
3. Run the program using the command: `java PhysicsSolver`

You should now see the calculator's user interface in your terminal. Follow the on-screen instructions to perform calculations.

## Motivation

As promised, here's how the story went:

“You may ‘cheat’ using your graphing calculators on my tests, but I ask that any and all programs are of your own creation.” This is how my physics teacher introduced her class, starting the 2021-2022 school year.

Enamoured by the opportunity, I started by learning the basics of the coding language my calculator used, TI-Basic. My program started barebones, only being able to solve 2-variable problems; although it guaranteed me an ‘A’ for my upcoming test, I wanted to probe further, to make the Ultimate Physics Solver. The program rocketed from 40-lines of code to 900. It intrigued me how the more I added, the less everything worked.

I was in the deep end: adding more functions hindered loading times, code had to be optimized; optimizing code required more lists; more lists required more operators, etc. I realize that this endeavour helped me understand fundamental coding principles, making it easier for me to learn other programming languages like Java and C++. I participated in, and won, school-wide programming competitions which involve optimizing code, just as I had done with my TI-Basic program, and plan on publishing my own website, using the same principles I learned with my TI-Basic program.

## Contributing

Contributions to improve the chat application are welcome. Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch: `git checkout -b feature-branch-name`.
3. Make changes and commit them: `git commit -am 'Add some feature'`.
4. Push to the branch: `git push origin feature-branch-name`.
5. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [license](/LICENSE.md) file for details.
