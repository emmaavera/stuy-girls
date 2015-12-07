//"Constants"
int POPULATION_SIZE = 25;

//Global Variables
int selectedX;
int selectedY;
int bestX;
int bestY;
boolean continuous = false;
float totalFitness;
int speed;
int generation;
float mutationRate = 0.05;

//The actual individuals
Individual[] population;
Individual selected;

int xinc = 3*31;  //increment; 31 b/c 11111 --> dec
int yinc = xinc;


/*=====================================
  Create an initial population of randomly
  generated individuals.
  Setup the basic window properties
  ====================================*/
 void setup() {
  frameRate = 1;
  int xcor;
  int ycor;
  population = new Individual[POPULATION_SIZE];
  int cols = (int) sqrt(POPULATION_SIZE); 
  //int colCounter = 1; int rowCounter = 1;
 
  
  int rows;
  if (cols*cols < POPULATION_SIZE) {
    rows = cols + 1;
  }
  else{ 
    rows = cols;
 }
 
 xcor = rows*xinc;
 ycor = cols*yinc;
  
  populate();
  
  size(xcor,ycor);
  
  
  
  /*int i = 1; int j = 1;
  xcor+=xinc; ycor+=yinc;
  //let i represent the rows and j the columns
 while ( i*rowCounter + j*colCounter < population.length) {//trying to count the num of individuals made
    population[i+j - 2] = new Individual(xcor, ycor);
    if (j < cols) {
      xcor += xinc;
      j++;
      //colCounter++;
    }
    else if ( j % cols == 0) {
      ycor += yinc;
      xcor -= xinc * (cols - 1);
      i++;
     //rowCounter++; colCounter = 0;
    }
  }*/
  
  //DEBUG
  for (int k = 0; k < population.length; k++) {
    System.out.println(k);
    System.out.println( " " + population[k].chromosome[0].value);
  }
}

/*=====================================
  Redraw every Individual in the population
  each frame. Make sure they are drawn in a grid without
  overlaping each other.
  If an individual has been selected (by the mouse), draw a box
  around it and draw a box around the individual with the
  highest fitness value.
  If mating mode is set to continuous, call mating season
  ====================================*/
void draw() {
   background (247, 120, 161);
  for (int i = 0; i < population.length; i++) {
    population[i].phenotype.display();
  }
}

/*=====================================
When the mouse is clicked, set selected to
the individual clicked on, and set 
selectedX and selectedY so that a box can be
drawn around it.
  ====================================*/
void mouseClicked() { //use leftmost coordinates
  int radius = selected.RAD;
  
}

/*====================================
The following keys are mapped to actions:

Right Arrow: move forard one generation
Up Arrow: speed up when in continuous mode
Down Arrow: slow down when in continuous mode
Shift: toggle continuous mode
Space: reset the population
f: toggle fitness value display
s: toggle smiley display
m: increase mutation rate
n: decrease mutation rate
  ==================================*/
void keyPressed() {
  println(keyCode); //wil display the integer value for whatever key has been pressed
}


/*====================================
  select will return a pseudo-random chromosome from the population
   Uses roulette wheel selection:
     A random number is generated between 0 and the total fitness 
     Go through the population and add each member's fitness until you exceed the random 
     number that was generated.
     Return the individual that the algorithm stopped on
     Do not include the "selected" Blob as a possible return value
  ==================================*/
Individual select() {
  float r = random (totalFitness - selected.fitness); //selected cannot have a fitness
  int currFitness = 0;
  Individual temp = population[0];
  int index = 0;
  while (currFitness < r){
    if (temp != selected){
    currFitness += population[index].fitness;
    temp = population [index];
    }
    index++;
  }
  return temp;
}

/*====================================

  Replaces the current population with a totally new one by
  selecting pairs of Individuals and "mating" them.
  Make sure that totalFitness is set before you use select().
  The goal shape (selected) should always be the frist Individual
  in the population, unmodified.
  ==================================*/
void matingSeason() {
}

/*====================================

  Randomly call the mutate method an Individual (or Individuals)
  in the population.
  ==================================*/
void mutate() {
}

/*====================================

  Set the totalFitness to the sum of the fitness values
  of each individual.
  Make sure that each individual has an accurate fitness value
  ==================================*/
void setTotalFitness() {
  for (int i=0; i<population.length; i++) {
    totalFitness += population[i].fitness;
  }
}

/*====================================
  Fill the population with randomly generated Individuals
  Make sure to set the location of each individual such that
  they display nicely in a grid.
  ==================================*/
void populate() {
  float xcor = xinc / 2.0; 
  float ycor = yinc / 2.0; 
  //int numIndividuals = 0;
  
  int cols = (int) sqrt(POPULATION_SIZE); int rows; //same as setup
  
  /*if (cols*cols < POPULATION_SIZE) {
    rows = cols + 1;
  }
  else{ 
    rows = cols;
 } */
 

 int colCounter = 1;

 for (int i=0; i<population.length; i++) {
   population[i] = new Individual (xcor, ycor);
   if (colCounter == cols){
     xcor = xinc / 2.0;
     colCounter = 1;
     ycor+=yinc;
   }
   else{
     xcor+=xinc;
     colCounter++;
   }
 }
     
    
   
 //populate
  /*for (int i=0; i<rows; i++) {
    while (numIndividuals < population.length){
      for (int j=0; j<cols; j++){
          population[i + j] = new Individual (xcor + xinc, ycor + yinc);
          ycor++;
          numIndividuals++;
      }
    }
  xcor++;
}*/
}

/*====================================
  Go through the population and find the Individual with the 
  highest fitness value.
  Set bestX and bestY so that the best Individual can have a 
  square border drawn around it.
  ==================================*/
 void findBest() {
  Individual temp = null;
  float highestFitness = 0;
  for (int i=0; i<population.length; i++){
    if (population[i].fitness > highestFitness){
      highestFitness = population[i].fitness;
      temp = population[i];
    }
  }
  
  bestX = (int)temp.centerX - xinc;
  bestY = (int)temp.centerY - yinc; 
}