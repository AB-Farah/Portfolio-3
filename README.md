# Portfolio Project 3 - Software Development

## Project Description

This portfolio is about graphs and graph algorithms.

It is the third of three parts that should be submitted for the exam as a mini-project.

## Assignment Description

The portfolio focuses on scheduling courses in a bachelor's programme. In the third semester, students take two subject module courses from two different subject modules. With 27 different subject modules, it is not possible to find 27 timeslots during the week so that no two subject modules overlap. Some combinations of subject modules have no students and can therefore be scheduled at the same time.

The assignment consists of the following parts:

1. Read the file of study combinations and represent it as a graph.
2. Examine whether the graph is connected.
3. List subject modules sorted by the number of combinations.
4. Check whether a given grouping of subject modules is feasible.
5. Calculate the number of students with courses in adjacent timeslots.

## Data

The file `combi.txt` contains combinations of subject modules as comma-separated lines with two subject modules and a number of students, for example:

    INFORMATIK , DATA , 136

The numbers are from Roskilde University but are not current or verified.

## Graph Model

- **Vertices:** subject modules.
- **Edges:** combinations of two subject modules that have students in common.
- **Weights:** the number of students taking both subject modules.

The graph is bidirectional, so every combination is stored in both directions.

## Parts

### Part 1 - Reading the Graph
The file is read with `readGraph` and stored as a `MatrixGraph`.

### Part 2 - Graph Connectivity
A breadth-first search from one vertex checks whether all other vertices can be reached. If the graph is not connected, the university consists of separate groupings with no students in common.

### Part 3 - Subject Modules Sorted by Degree
All subject modules are listed and sorted by their degree, which is the number of other subject modules they share students with.

### Part 4 - Checking the Grouping
A suggested grouping of the subject modules into 12 timeslots is checked. A grouping is feasible only if no two subject modules in the same group share students.

### Part 5 - Students in Adjacent Timeslots
The number of students with courses in two neighbouring timeslots is calculated for the suggested order of the groups, and then for a random reordering.

## Files

- `src/Main.java` - the solution to Parts 1-5.
- `src/Graphs.java` and `src/GraphAlgorithms.java` - graph classes and algorithms from the course Moodle page.
- `combi.txt` - the study combinations.

## How to Run

Open the project in IntelliJ and run `Main`. The file `combi.txt` must be in the project folder, since it is read with a relative path.

## Assignment Source

Mads Rosendahl
Software Development / RUC / Datalogi - Autumn 2026
