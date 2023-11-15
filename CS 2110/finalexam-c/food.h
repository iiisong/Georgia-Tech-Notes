/**
 * CS 2110 - Spring 2023
 * Final Exam - Kirby Food Queue
 *
 * Do not modify this file!
 */

#ifndef FOOD_H
#define FOOD_H

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define FAILURE 1
#define SUCCESS 0

// This is just to remove compiler warnings associated with unused variables.
// Delete calls to this as you implement functions.
#define UNUSED(x) ((void)(x))
struct apple {
    int damage; // amount of damage Kirby will do
    char *appleVariety; // the variety of apple (e.g. Granny Smith, Fuji)
};

struct tomato {
    int health; // amount of health Kirby will heal
};

union food {
    struct apple apple; // holds properties of an apple
    struct tomato tomato; // holds properties of a tomato
};

typedef enum foodType { // enum specifying type of food (apple or tomato)
    APPLE, 
    TOMATO
} foodType;

struct data {
    union food food; // holds data containing the properties of an apple or tomato
    foodType foodType; // an enum specifying the type of food in the union
};

struct wrapper { // holds the data of the food; is a node in the linked list
    struct data data; // the contents of what is held in a wrapper
    struct wrapper *next; // the next wrapper in the list
};

extern struct wrapper *head; // head of the food linked list

int makeWrapper(foodType foodType, int damage, const char *appleVariety, int health);
int replaceAppleVariety(const char *replacementVariety, const char *targetType);

#endif
