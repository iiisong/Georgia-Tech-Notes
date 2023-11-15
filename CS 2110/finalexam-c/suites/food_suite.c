/**
 * @file stack_suite.c
 * @author Sameer
 * @brief Testing Suites to Final-C - Fall 2022
 * @date 2022-26-07
 */

// Check Docs
// Tutorial : https://libcheck.github.io/check/doc/check_html/check_3.html
// Check API: https://libcheck.github.io/check/doc/doxygen/html/check_8h.html

// System Headers
#include <string.h>
#include <check.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#include <sys/wait.h> // For grabbing return value of system call

// TA Headers
#include "test_utils.h"

int mallocs_until_fail = -1;


// allow infinite mallocs by default
static void reset_mallocs_until_fail_and_malloclist(void) {
   // malloclist = NULL;
    mallocs_until_fail = -1;
}

/* Tests */

START_TEST(test_create_apple_empty_list) {
    head = NULL;
    // Unlimited Malloc
    mallocs_until_fail = -1;

    foodType foodType = APPLE;
    int damage = 5;
    char *appleVariety = "GrannySmith";
    int health = 99;

    int retVal = makeWrapper(foodType, damage, appleVariety, health);
    ck_assert_msg(retVal == SUCCESS,                                           "Error with makeWrapper() when used on empty list! Expected return value: SUCCESS");
    ck_assert_msg(head->data.foodType == APPLE, "Error with makeWrapper() when used on empty list! Expected foodType: APPLE");
    ck_assert_msg(strcmp(head->data.food.apple.appleVariety, "GrannySmith") == 0, "Error with makeWrapper() when used on empty list! Expected appleVariety: %s but was: %s", appleVariety, head->data.food.apple.appleVariety);
    ck_assert_msg(head->data.food.apple.damage == 5,                           "Error with makeWrapper() when used on empty list! Expected apple damage: %d but was: %d", damage, head->data.food.apple.damage);
    ck_assert_msg(head->next == NULL,                                          "Error with makeWrapper() when used on empty list! Remember to set head->next to NULL!");
    
    free(head->data.food.apple.appleVariety);
    free(head);
}
END_TEST

START_TEST(test_create_tomato_empty_list) {
    head = NULL;
    // Unlimited Malloc
    mallocs_until_fail = -1;

    foodType foodType = TOMATO;
    int damage = 5;
    char *appleVariety = "Scrumptious";
    int health = 99;

    int retVal = makeWrapper(foodType, damage, appleVariety, health);
    ck_assert_msg(retVal == SUCCESS,                       "Error with makeWrapper()! Expected return value on empty list: SUCCESS");
    ck_assert_msg(head->data.foodType == TOMATO, "Error with makeWrapper() when used on empty list! Expected foodType: TOMATO");
    ck_assert_msg(head->data.food.tomato.health == 99,     "Error with makeWrapper()! Expected tomato health: %d but was: %d", health, head->data.food.tomato.health);
    ck_assert_msg(head->next == NULL,                      "Error with makeWrapper()! Remember to set head->next to NULL if the list is empty!");
    
    free(head);
}
END_TEST

START_TEST(test_create_tomato_malloc_failure) {
    head = NULL;
    // No Malloc Usages
    mallocs_until_fail = 0;

    foodType foodType = TOMATO;
    int damage = 5;
    char *appleVariety = "BigTomato";
    int health = 99;

    int retVal = makeWrapper(foodType, damage, appleVariety, health);
    ck_assert_msg(retVal == FAILURE, "Error with makeWrapper()! Should return FAILURE on malloc failure");
    ck_assert_msg(head == NULL,      "Error with makeWrapper()! Wrapper should not be added to list upon malloc failure");
}
END_TEST

START_TEST(test_create_apple_malloc_failure) {
    head = NULL;
    // No Malloc Usages
    mallocs_until_fail = 0;

    foodType foodType = TOMATO;
    int damage = 5;
    char *appleVariety = "ThisIsATomatoItDoesntHaveAName";
    int health = 99;

    int retVal = makeWrapper(foodType, damage, appleVariety, health);
    ck_assert_msg(retVal == FAILURE, "Error with makeWrapper()! Should return FAILURE on malloc failure");
    ck_assert_msg(head == NULL,      "Error with makeWrapper()Q Wrapper should not be added to list upon malloc failure");
}
END_TEST

START_TEST(test_create_apple_null_string) {
    head = NULL;
    // Unlimited Malloc
    mallocs_until_fail = -1;

    foodType foodType = APPLE;
    int damage = 5;
    char *appleVariety = NULL;
    int health = 99;

    int retVal = makeWrapper(foodType, damage, appleVariety, health);

    ck_assert_msg(retVal == FAILURE, "Error with makeWrapper()! Should return FAILURE on NULL string input");
    ck_assert_msg(head == NULL,      "Error with makeWrapper()! Wrapper should not be added to list upon failure");
}
END_TEST

START_TEST(test_create_apple_malloc_string_failure) {
    head = NULL;
    // 1 Malloc Usage
    mallocs_until_fail = 1;

    foodType foodType = APPLE;
    int damage = 5;
    char *appleVariety = "BadName";
    int health = 99;

    int retVal = makeWrapper(foodType, damage, appleVariety, health);

    ck_assert_msg(retVal == FAILURE, "Error with makeWrapper()! Should return FAILURE on malloc failure");
    ck_assert_msg(head == NULL,      "Error with makeWrapper()! Wrapper should not be added to list upon failure");
}
END_TEST

START_TEST(test_create_apple_big_list) {
    head = NULL;
    // Unlimited Malloc
    mallocs_until_fail = -1;

    foodType foodType1 = APPLE;
    int damage1 = 10;
    char *appleVariety1 = "Fuji";
    int health1 = -5;
    _makeWrapper(foodType1, damage1, appleVariety1, health1);

    foodType foodType2 = TOMATO;
    int damage2 = -5;
    char *appleVariety2 = "NoThanks!";
    int health2 = 5;
    _makeWrapper(foodType2, damage2, appleVariety2, health2);

    foodType foodType3 = APPLE;
    int damage3 = 20;
    char *appleVariety3 = "HoneyCrisp";
    int health3 = -10;
    _makeWrapper(foodType3, damage3, appleVariety3, health3);

    // New Wrapper info to add:
    foodType foodType4 = APPLE;
    int damage4 = 30;
    char *appleVariety4 = "PinkLady";
    int health4 = -50;
    int retVal = makeWrapper(foodType4, damage4, appleVariety4, health4);

    ck_assert_msg(retVal == SUCCESS, "Error with makeWrapper()! should return SUCCESS when wrapper added successfully");
    
    ck_assert_msg(head->next->next->next->data.foodType == APPLE,                    "Error with makeWrapper()! Incorrect foodType");
    ck_assert_msg(strcmp(head->next->next->next->data.food.apple.appleVariety, "Fuji") == 0,  "Error with makeWrapper()! Apple name not set properly!");
    ck_assert_msg(head->next->next->next->data.food.apple.damage == 10,                    "Error with makeWrapper()! Incorrect damage/health");
    ck_assert_msg(head->next->next->next->next == NULL,                                    "Error with makeWrapper()! NULL pointer on tail not set");

    ck_assert_msg(head->next->next->data.foodType == TOMATO,    "Error with makeWrapper()! Incorrect foodType");
    ck_assert_msg(head->next->next->data.food.tomato.health == 5,    "Error with makeWrapper()! Incorrect damage/health");

    ck_assert_msg(head->next->data.foodType == APPLE,                          "Error with makeWrapper()! Incorrect foodType");
    ck_assert_msg(strcmp(head->next->data.food.apple.appleVariety, "HoneyCrisp") == 0,  "Error with makeWrapper()! Apple name not set properly!");
    ck_assert_msg(head->next->data.food.apple.damage == 20,                          "Error with makeWrapper()! Incorrect damage/health");

    ck_assert_msg(head->data.foodType == APPLE, "Error with makeWrapper()! Incorrect foodType");
    ck_assert_msg(strcmp(head->data.food.apple.appleVariety, "PinkLady") == 0,    "Error with makeWrapper()! Apple name not set properly!");
    ck_assert_msg(head->data.food.apple.damage == 30,                          "Error with makeWrapper()! Incorrect damage/health");

    free(head->next->next->next->data.food.apple.appleVariety);
    free(head->next->next->next);
    free(head->next->next);
    free(head->next->data.food.apple.appleVariety);
    free(head->next);
    free(head->data.food.apple.appleVariety);
    free(head);
}
END_TEST

START_TEST(test_create_tomato_big_list) {
    head = NULL;
    // Unlimited Malloc
    mallocs_until_fail = -1;

    foodType foodType1 = APPLE;
    int damage1 = 10;
    char *appleVariety1 = "Fuji";
    int health1 = -5;
    _makeWrapper(foodType1, damage1, appleVariety1, health1);

    foodType foodType2 = TOMATO;
    int damage2 = -5;
    char *appleVariety2 = "NoThanks!";
    int health2 = 5;
    _makeWrapper(foodType2, damage2, appleVariety2, health2);

    foodType foodType3 = APPLE;
    int damage3 = 20;
    char *appleVariety3 = "HoneyCrisp";
    int health3 = -10;
    _makeWrapper(foodType3, damage3, appleVariety3, health3);

    // New Wrapper info to add:
    foodType foodType4 = TOMATO;
    int damage4 = -50;
    char *appleVariety4 = "PinkLady";
    int health4 = 50;
    int retVal = makeWrapper(foodType4, damage4, appleVariety4, health4);

    ck_assert_msg(retVal == SUCCESS, "Error with makeWrapper()! Should return SUCCESS when wrapper added successfully");
    
    ck_assert_msg(head->next->next->next->data.foodType == APPLE,                    "Error with makeWrapper()! Incorrect foodType");
    ck_assert_msg(strcmp(head->next->next->next->data.food.apple.appleVariety, "Fuji") == 0,  "Error with makeWrapper()! Apple name not set properly!");
    ck_assert_msg(head->next->next->next->data.food.apple.damage == 10,                    "Error with makeWrapper()! Incorrect damage/health");
    ck_assert_msg(head->next->next->next->next == NULL,                                    "Error with makeWrapper()! NULL pointer on tail not set");

    ck_assert_msg(head->next->next->data.foodType == TOMATO,        "Error with makeWrapper()! Incorrect foodType");
    ck_assert_msg(head->next->next->data.food.tomato.health == 5,       "Error with makeWrapper()! Incorrect damage/health");

    ck_assert_msg(head->next->data.foodType == APPLE,                         "Error with makeWrapper()! Incorrect damage/health");
    ck_assert_msg(strcmp(head->next->data.food.apple.appleVariety, "HoneyCrisp") == 0,  "Error with makeWrapper()! Apple name not set properly!");
    ck_assert_msg(head->next->data.food.apple.damage == 20,                          "Error with makeWrapper()! Incorrect damage/health");

    ck_assert_msg(head->data.foodType == TOMATO,                          "Error with makeWrapper()! Incorrect foodType");
    ck_assert_msg(head->data.food.tomato.health == 50,                         "Error with makeWrapper()! Incorrect damage/health");

    free(head->next->next->next->data.food.apple.appleVariety);
    free(head->next->next->next);
    free(head->next->next);
    free(head->next->data.food.apple.appleVariety);
    free(head->next);
    free(head);
}
END_TEST

START_TEST(test_change_apple_variety_null_replacement) {
    
    head = NULL;
    // Unlimited Malloc
    mallocs_until_fail = -1;

    makeWrapper(APPLE, 10, "Fuji", 50);
    makeWrapper(APPLE, 20, "PinkLady", 60);
    makeWrapper(APPLE, 30, "PinkLady", 70);
    makeWrapper(TOMATO, 40, "HoneyCrisp", 80);

    char *replacementVariety = NULL;
    char *targetVariety = "PinkLady";

    // The actual tests
    int retVal = replaceAppleVariety(replacementVariety, targetVariety);

    ck_assert_msg(retVal == FAILURE, "Error with replaceAppleVariety()! should return FAILURE on NULL string input");

    ck_assert_msg(strcmp(head->next->next->next->data.food.apple.appleVariety, "Fuji") == 0,  "Error with replaceAppleVariety()! Apple name not set properly!");
    ck_assert_msg(head->next->next->next->data.food.apple.damage == 10,                    "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->next->next->data.food.tomato.health == 10,                   "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->next->next->next == NULL,                                    "Error with replaceAppleVariety()! Error with makeWrapper()! NULL pointer on tail not set");

    ck_assert_msg(strcmp(head->next->next->data.food.apple.appleVariety, "PinkLady") == 0,    "Error with replaceAppleVariety()! Apple name not set properly!");
    ck_assert_msg(head->next->next->data.food.apple.damage == 20,                          "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->next->data.food.tomato.health == 20,                         "Error with replaceAppleVariety()! Incorrect damage/health");

    ck_assert_msg(strcmp(head->next->data.food.apple.appleVariety, "PinkLady") == 0,          "Error with replaceAppleVariety()! Apple name not set properly!");
    ck_assert_msg(head->next->data.food.apple.damage == 30,                                "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->data.food.tomato.health == 30,                               "Error with replaceAppleVariety()! Incorrect damage/health");

    ck_assert_msg(head->data.food.apple.damage == 80,                                      "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->data.food.tomato.health == 80,                                     "Error with replaceAppleVariety()! Incorrect damage/health");
    
    free(head->next->next->next->data.food.apple.appleVariety);
    free(head->next->next->next);
    free(head->next->next->data.food.apple.appleVariety);
    free(head->next->next);
    free(head->next->data.food.apple.appleVariety);
    free(head->next);
    free(head);

}
END_TEST

START_TEST(test_change_apple_variety_null_target) {
    
    head = NULL;
    // Unlimited Malloc
    mallocs_until_fail = -1;

    _makeWrapper(APPLE, 10, "Fuji", 50);
    _makeWrapper(APPLE, 20, "PinkLady", 60);
    _makeWrapper(APPLE, 30, "PinkLady", 70);
    _makeWrapper(TOMATO, 40, "HoneyCrisp", 80);

    char *replacementVariety = "AppleCat";
    char *targetVariety = NULL;

    // The actual tests
    int retVal = replaceAppleVariety(replacementVariety, targetVariety);

    ck_assert_msg(retVal == FAILURE, "Error with replaceAppleVariety()! should return FAILURE on NULL string input %d %d", retVal, FAILURE);

    ck_assert_msg(strcmp(head->next->next->next->data.food.apple.appleVariety, "Fuji") == 0,  "Error with replaceAppleVariety()! Apple name not set properly!");
    ck_assert_msg(head->next->next->next->data.food.apple.damage == 10,                    "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->next->next->data.food.tomato.health == 10,                   "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->next->next->next == NULL,                                    "Error with replaceAppleVariety()! Error with makeWrapper()! NULL pointer on tail not set");

    ck_assert_msg(strcmp(head->next->next->data.food.apple.appleVariety, "PinkLady") == 0,    "Error with replaceAppleVariety()! Apple name not set properly!");
    ck_assert_msg(head->next->next->data.food.apple.damage == 20,                          "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->next->data.food.tomato.health == 20,                         "Error with replaceAppleVariety()! Incorrect damage/health");

    ck_assert_msg(strcmp(head->next->data.food.apple.appleVariety, "PinkLady") == 0,          "Error with replaceAppleVariety()! Apple name not set properly!");
    ck_assert_msg(head->next->data.food.apple.damage == 30,                                "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->data.food.tomato.health == 30,                               "Error with replaceAppleVariety()! Incorrect damage/health");

    ck_assert_msg(head->data.food.apple.damage == 80,                                      "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->data.food.tomato.health == 80,                                     "Error with replaceAppleVariety()! Incorrect damage/health");

    free(head->next->next->next->data.food.apple.appleVariety);
    free(head->next->next->next);
    free(head->next->next->data.food.apple.appleVariety);
    free(head->next->next);
    free(head->next->data.food.apple.appleVariety);
    free(head->next);
    free(head);
}
END_TEST


START_TEST(test_change_apple_variety) {
    
    head = NULL;
    // Unlimited Malloc
    mallocs_until_fail = -1;

    _makeWrapper(APPLE, 10, "Fuji", 50);
    _makeWrapper(APPLE, 20, "PinkLady", 60);
    _makeWrapper(APPLE, 30, "PinkLady", 70);
    _makeWrapper(TOMATO, 40, "HoneyCrisp", 80);

    char *replacementVariety = "AppleCat";
    char *targetVariety = "PinkLady";

    // The actual tests
    int retVal = replaceAppleVariety(replacementVariety, targetVariety);

    ck_assert_msg(retVal == SUCCESS, "Error with replaceAppleVariety()!");

    ck_assert_msg(strcmp(head->next->next->next->data.food.apple.appleVariety, "Fuji") == 0,  "Error with replaceAppleVariety()! Apple name not set properly!");
    ck_assert_msg(head->next->next->next->data.food.apple.damage == 10,                    "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->next->next->data.food.tomato.health == 10,                   "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->next->next->next == NULL,                                    "Error with replaceAppleVariety()! NULL pointer on tail not set");

    ck_assert_msg(strcmp(head->next->next->data.food.apple.appleVariety, "PinkLady") == 0,    "Error with replaceAppleVariety()! Apple name not set properly!");
    ck_assert_msg(head->next->next->data.food.apple.damage == 20,                          "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->next->data.food.tomato.health == 20,                         "Error with replaceAppleVariety()! Incorrect damage/health");

    ck_assert_msg(strcmp(head->next->data.food.apple.appleVariety, "AppleCat") == 0,          "Error with replaceAppleVariety()! Apple name not set properly!");
    ck_assert_msg(head->next->data.food.apple.damage == 30,                                "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->data.food.tomato.health == 30,                               "Error with replaceAppleVariety()! Incorrect damage/health");

    ck_assert_msg(head->data.food.apple.damage == 80,                                      "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->data.food.tomato.health == 80,                                     "Error with replaceAppleVariety()! Incorrect damage/health");

    free(head->next->next->next->data.food.apple.appleVariety);
    free(head->next->next->next);
    free(head->next->next->data.food.apple.appleVariety);
    free(head->next->next);
    free(head->next->data.food.apple.appleVariety);
    free(head->next);
    free(head);
}
END_TEST


START_TEST(test_change_apple_variety_empty_list) {
    
    head = NULL;
    // Unlimited Malloc
    mallocs_until_fail = -1;

    char *replacementVariety = "AppleCat";
    char *targetVariety = "PinkLady";

    // The actual tests
    int retVal = replaceAppleVariety(replacementVariety, targetVariety);

    ck_assert_msg(retVal == FAILURE, "Error with replaceAppleVariety() on empty list!");
    ck_assert_msg(head == NULL,      "Error with replaceAppleVariety() on empty list!");
}
END_TEST


START_TEST(test_change_apple_variety_malloc_failure) {
    head = NULL;

    _makeWrapper(APPLE, 10, "Fuji", 50);
    _makeWrapper(APPLE, 20, "PinkLady", 60);
    _makeWrapper(APPLE, 30, "PinkLady", 70);
    _makeWrapper(TOMATO, 40, "HoneyCrisp", 80);

    char *replacementVariety = "AppleCat";
    char *targetVariety = "PinkLady";

    // No Malloc
    mallocs_until_fail = 0;
    int retVal = replaceAppleVariety(replacementVariety, targetVariety);

    ck_assert_msg(retVal == FAILURE, "Error with replaceAppleVariety()!");

    ck_assert_msg(strcmp(head->next->next->next->data.food.apple.appleVariety, "Fuji") == 0,  "Error with replaceAppleVariety()! Apple name not set properly!");
    ck_assert_msg(head->next->next->next->data.food.apple.damage == 10,                    "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->next->next->data.food.tomato.health == 10,                   "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->next->next->next == NULL,                                    "Error with replaceAppleVariety()! NULL pointer on tail not set");

    ck_assert_msg(strcmp(head->next->next->data.food.apple.appleVariety, "PinkLady") == 0,    "Error with replaceAppleVariety()! Apple name not set properly!");
    ck_assert_msg(head->next->next->data.food.apple.damage == 20,                          "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->next->data.food.tomato.health == 20,                         "Error with replaceAppleVariety()! Incorrect damage/health");

    ck_assert_msg(strcmp(head->next->data.food.apple.appleVariety, "PinkLady") == 0,          "Error with replaceAppleVariety()! Apple name not set properly!");
    ck_assert_msg(head->next->data.food.apple.damage == 30,                                "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->data.food.tomato.health == 30,                               "Error with replaceAppleVariety()! Incorrect damage/health");

    ck_assert_msg(head->data.food.apple.damage == 80,                                      "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->data.food.tomato.health == 80,                                     "Error with replaceAppleVariety()! Incorrect damage/health");
    
    free(head->next->next->next->data.food.apple.appleVariety);
    free(head->next->next->next);
    free(head->next->next->data.food.apple.appleVariety);
    free(head->next->next);
    free(head->next->data.food.apple.appleVariety);
    free(head->next);
    free(head);
}
END_TEST

START_TEST(test_change_apple_variety_no_match) {
    head = NULL;

    _makeWrapper(TOMATO, 10, "Fuji", 50);
    _makeWrapper(APPLE, 20, "PinkLady", 60);
    _makeWrapper(TOMATO, 30, "PinkLady", 70);
    _makeWrapper(TOMATO, 40, "HoneyCrisp", 80);

    char *replacementVariety = "AppleCat";
    char *targetVariety = "Fuji";

    // Unlimited Malloc
    mallocs_until_fail = -1;
    int retVal = replaceAppleVariety(replacementVariety, targetVariety);

    ck_assert_msg(retVal == FAILURE, "Error with replaceAppleVariety()!");
    
    ck_assert_msg(head->next->next->next->data.food.apple.damage == 50,                    "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->next->next->data.food.tomato.health == 50,                   "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->next->next->next == NULL,                                    "Error with replaceAppleVariety()! NULL pointer on tail not set");

    ck_assert_msg(strcmp(head->next->next->data.food.apple.appleVariety, "PinkLady") == 0,    "Error with replaceAppleVariety()! Apple name not set properly!");
    ck_assert_msg(head->next->next->data.food.apple.damage == 20,                          "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->next->data.food.tomato.health == 20,                         "Error with replaceAppleVariety()! Incorrect damage/health");

    ck_assert_msg(head->next->data.food.apple.damage == 70,                                "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->next->data.food.tomato.health == 70,                               "Error with replaceAppleVariety()! Incorrect damage/health");

    ck_assert_msg(head->data.food.apple.damage == 80,                                      "Error with replaceAppleVariety()! Incorrect damage/health");
    ck_assert_msg(head->data.food.tomato.health == 80,                                     "Error with replaceAppleVariety()! Incorrect damage/health");

    free(head->next->next->next);
    free(head->next->next->data.food.apple.appleVariety);
    free(head->next->next);
    free(head->next);
    free(head);
}
END_TEST


Suite *food_suite(void)
{
    Suite *s = suite_create("food_suite");

    // push tests
    tcase_singleton(s, reset_mallocs_until_fail_and_malloclist, NULL, test_create_apple_empty_list);
    tcase_singleton(s, reset_mallocs_until_fail_and_malloclist, NULL, test_create_tomato_empty_list);
    tcase_singleton(s, reset_mallocs_until_fail_and_malloclist, NULL, test_create_tomato_malloc_failure);
    tcase_singleton(s, reset_mallocs_until_fail_and_malloclist, NULL, test_create_apple_malloc_failure);
    tcase_singleton(s, reset_mallocs_until_fail_and_malloclist, NULL, test_create_apple_malloc_string_failure);
    tcase_singleton(s, reset_mallocs_until_fail_and_malloclist, NULL, test_create_apple_null_string);
    tcase_singleton(s, reset_mallocs_until_fail_and_malloclist, NULL, test_create_apple_big_list);
    tcase_singleton(s, reset_mallocs_until_fail_and_malloclist, NULL, test_create_tomato_big_list);
    tcase_singleton(s, reset_mallocs_until_fail_and_malloclist, NULL, test_change_apple_variety);
    tcase_singleton(s, reset_mallocs_until_fail_and_malloclist, NULL, test_change_apple_variety_null_target);
    tcase_singleton(s, reset_mallocs_until_fail_and_malloclist, NULL, test_change_apple_variety_null_replacement);
    tcase_singleton(s, reset_mallocs_until_fail_and_malloclist, NULL, test_change_apple_variety_malloc_failure);
    tcase_singleton(s, reset_mallocs_until_fail_and_malloclist, NULL, test_change_apple_variety_empty_list);
    tcase_singleton(s, reset_mallocs_until_fail_and_malloclist, NULL, test_change_apple_variety_no_match);

    return s;
}
