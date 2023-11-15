/**
 * @file my_string.c
 * @author Isaac Song
 * @collaborators None
 * @brief My implementation of these famous 3 string.h library functions!
 *
 * NOTE: NO ARRAY NOTATION IS ALLOWED IN THIS FILE
 *
 * @date 2023-03-23
 */

#include <stddef.h>
#include "my_string.h"
/**
 * @brief Calculate the length of a string
 *
 * @param s a constant C string
 * @return size_t the number of characters in the passed in string
 */
    size_t my_strlen(const char *s)
    {
        size_t i = 0;
        while (*s != 0) {
            i += 1;
            s += 1;
        }
        return i;
    }

/**
 * @brief Compare two strings
 *
 * @param s1 First string to be compared
 * @param s2 Second string to be compared
 * @param n First (at most) n bytes to be compared
 * @return int "less than, equal to, or greater than zero if s1 (or the first n
 * bytes thereof) is found, respectively, to be less than, to match, or be
 * greater than s2"
 */
int my_strncmp(const char *s1, const char *s2, size_t n)
{
    size_t i = 0;
    while (i < n) {
        if (*s1 == 0 && *s2 == 0) return 0;
        if (*s1 == 0 || *s1 < *s2) return -1;
        if (*s2 == 0 || *s1 > *s2) return 1;

        s1 += 1;
        s2 += 1;
        i += 1;
    }
    
    return 0;
}

/**
 * @brief Copy a string
 *
 * @param dest The destination buffer
 * @param src The source to copy from
 * @param n maximum number of bytes to copy
 * @return char* a pointer same as dest
 */
char *my_strncpy(char *dest, const char *src, size_t n)
{
    size_t i = 0;
    char *result = dest;

    while (i < n) {
        *result = *src;
        if (*src == 0) return dest;

        result += 1;
        src += 1;
        i++;
    }
    
    return dest;
}

/**
 * @brief Concatenates two strings and stores the result
 * in the destination string
 *
 * @param dest The destination string
 * @param src The source string
 * @param n The maximum number of bytes from src to concatenate
 * @return char* a pointer same as dest
 */
char *my_strncat(char *dest, const char *src, size_t n)
{
    char *result = dest;
    
    while (*result != 0) {
        result += 1;
    } 

    size_t i = 0;
    while (i < n) {
        *result = *src;
        if (*src == 0) {
            return dest;
        }

        result += 1;
        src += 1;
        i += 1;
    }

    *result = 0;
    return dest;
}

/**
 * @brief Copies the character c into the first n
 * bytes of memory starting at *str
 *
 * @param str The pointer to the block of memory to fill
 * @param c The character to fill in memory
 * @param n The number of bytes of memory to fill
 * @return char* a pointer same as str
 */
void *my_memset(void *str, int c, size_t n)
{
    size_t i = 0;
    char *res = str;
    while (i < n) {
        *res = c;
        res += 1;
        i += 1;
    }

    return res;
}

/**
 * @brief Finds the first instance of c in str
 * and removes it from str in place
 *
 * @param str The pointer to the string
 * @param c The character we are looking to delete
 */
void remove_first_instance(char *str, char c){
    int removed = 0;

    while (*str != 0) {
        if (!removed && c == *str) {
            removed = 1;
            continue;
        }

        if (removed) {
            *str = *(str + 1);
        }

        str += 1;
    }
    
    return;
}

/**
 * @brief Finds the first instance of c in str
 * and replaces it with the contents of replaceStr
 *
 * @param str The pointer to the string
 * @param c The character we are looking to delete
 * @param replaceStr The pointer to the string we are replacing c with
 */
void replace_character_with_string(char *str, char c, char *replaceStr) {
    int removed = 0;
    char *start = str;
    char *replaceLoc; 
    int replaceLen = my_strlen(replaceStr);
    UNUSED_PARAM(start); // debugging reasons
    
    while (*str != 0) {
        if (!removed && c == *str) {
            removed = 1;
            replaceLoc = str;
        }

        str += 1;
    }

    if (!removed) {
        return;
    }

    if (replaceLen == 0) {
        replaceLoc += 1;
        while (*(replaceLoc - 1) != 0) {
            *(replaceLoc - 1) = *replaceLoc;
            replaceLoc += 1;
        }
    }

    for (int i = 0; i < replaceLen - 1; i++) {
        str += 1;
    }

    *str = 0;
    str -= 1;

    while (str - replaceLen + 1 > replaceLoc) {
        *str = *(str - replaceLen + 1);
        str -= 1;
    }

    my_strncpy(replaceLoc, replaceStr, my_strlen(replaceStr));

    return;
}

/**
 * @brief Remove the first character of str (ie. str[0]) IN ONE LINE OF CODE.
 * No loops allowed. Assume non-empty string
 * @param str A pointer to a pointer of the string
 */
void remove_first_character(char **str) {
    *str += 1;
}