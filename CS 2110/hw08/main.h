#ifndef MAIN_H
#define MAIN_H

#include "gba.h"

// TODO: Create any necessary structs

/*
* For example, for a Snake game, one could be:
*
* struct snake {
*   int heading;
*   int length;
*   int row;
*   int col;
* };
*
* Example of a struct to hold state machine data:
*
* struct state {
*   int currentState;
*   int nextState;
* };
*
*/

struct player {
    int row;
    int col;
    int prev_row;
    int prev_col;
    int spawn_row;
    int spawn_col;
    int sidelen;
};

struct state {
    int currentState;
    int nextState;
};

struct goal {
    int row;
    int col;
    int sidelen;
};

struct game {
    struct player p;
    struct goal g;
};
#endif
