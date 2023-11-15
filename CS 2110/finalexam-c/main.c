/**
 * CS 2110 - Fall 2021
 * Final Exam - Implement Stack
 *
 * You may use this file to test your functions from stack.c
 */

#include "food.h"

/**
 * @brief A main function that you can use for testing.
 * 
 * Implementing this function is NOT necessary for the final.
 * You can use this if you want to create custom tests.
 * We have included a basic test as an example.
 * 
 */
int main(void) {

    makeWrapper(APPLE, 50, "Gala", 3475784); // health doesn't matter since its an apple
    printf("head data (apple damage: %d, apple variety: %s)", head->data.food.apple.damage, head->data.food.apple.appleVariety);

    replaceAppleVariety("GrannySmith", "Gala");
    printf("head data (apple variety: %s)", head->data.food.apple.appleVariety);
    return 0;
}
