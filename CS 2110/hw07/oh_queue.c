// DO NOT MODIFY THE INCLUDE(S) LIST
#include <stdio.h>
#include "oh_queue.h"

struct Queue oh_queue;

/** push
 * @brief Create a new student and push him
 * onto the OH queue
 * @param studentName pointer to the student's name
 * @param topicName topic the student has a question on
 * @param questionNumber hw question number student has a question on
 * @param pub_key public key used for calculating the hash for customID
 * @return FAILURE if the queue is already at max length, SUCCESS otherwise
 */
int push(const char *studentName, const enum subject topicName, const float questionNumber, struct public_key pub_key){
    UNUSED_PARAM(studentName);
    UNUSED_PARAM(topicName);
    UNUSED_PARAM(questionNumber);
    UNUSED_PARAM(pub_key);

    if (oh_queue.stats.no_of_people_in_queue == MAX_QUEUE_LENGTH) return FAILURE;


    struct Topic topic;
    topic.topicName = topicName;
    topic.questionNumber = questionNumber;

    struct StudentData student_data;
    my_strncpy(student_data.name, studentName, MAX_NAME_LENGTH - 1);
    student_data.topic = topic;

    struct Student student;
    hash(student.customID, (char*) studentName, pub_key);
    student.queue_number = oh_queue.stats.no_of_people_visited;
    student.studentData = student_data;
    
    oh_queue.students[oh_queue.stats.no_of_people_in_queue] = student;

    oh_queue.stats.no_of_people_visited += 1;
    oh_queue.stats.no_of_people_in_queue += 1;

    OfficeHoursStatus(&oh_queue.stats);

    return SUCCESS;
}

/** pop
 * @brief Pop a student out the OH queue
 * @return FAILURE if the queue is already at empty, SUCCESS otherwise
 */
int pop(void) {
    if (oh_queue.stats.no_of_people_in_queue == 0) return FAILURE;
    
    for (int i = 0; i < oh_queue.stats.no_of_people_in_queue; i++) {
        oh_queue.students[i] = oh_queue.students[i + 1];
    }

    oh_queue.stats.no_of_people_in_queue -= 1;
    oh_queue.stats.no_of_people_visited += 1;
    OfficeHoursStatus(&oh_queue.stats);

    return SUCCESS;
}

/** group_by_topic
 * @brief Push pointers to students, who match the given topic, to
 * the given array "grouped"
 * @param topic the topic the students need to match
 * @param grouped an array of pointers to students
 * @return the number of students matched
 */
int group_by_topic(struct Topic topic, struct Student *grouped[]) { 
    UNUSED_PARAM(topic);
    UNUSED_PARAM(grouped);
    int group_in = 0;
    for (int i = 0; i < oh_queue.stats.no_of_people_in_queue; i++) {
        if (oh_queue.students[i].studentData.topic.questionNumber == topic.questionNumber &&
        oh_queue.students[i].studentData.topic.topicName == topic.topicName) {
            grouped[group_in] = &(oh_queue.students[i]);
            group_in += 1;
        }
    }

    return group_in;
}

/** hash
 * @brief Creates a hash based on pub_key provided
 * @param ciphertext the pointer where you will store the hashed text
 * @param plaintext the originak text you need to hash
 * @param pub_key public key used for calculating the hash
 */
void hash(int *ciphertext, char *plaintext, struct public_key pub_key) {
    while (*plaintext != 0) {
        *ciphertext = power_and_mod(*plaintext, pub_key.e, pub_key.n);
        ciphertext += 1;
        plaintext += 1;
    }
}

/** update_student
 * @brief Find the student with the given ID and update his topic
 * @param customID a pointer to the id of the student you are trying to find
 * @param newTopic the new topic that should be assigned to him
 * @return FAILURE if no student is matched, SUCCESS otherwise
 */
int update_student(struct Topic newTopic, int *customID) {
    for (int i = 0; i < oh_queue.stats.no_of_people_in_queue; i++) {
        if (*oh_queue.students[i].customID == *customID) {
            oh_queue.students[i].studentData.topic = newTopic;
            return SUCCESS;
        }
    }

    return FAILURE;
}

/** remove_student_by_name
 * @brief Removes first instance of a student with the given name
 * @param name the name you are searching for
 * @return FAILURE if no student is matched, SUCCESS otherwise
 */
int remove_student_by_name(char *name){
    for (int i = 0; i < oh_queue.stats.no_of_people_in_queue; i++) {
        if (*oh_queue.students[i].studentData.name == *name) {
            while (i < oh_queue.stats.no_of_people_in_queue) {
                oh_queue.students[i] = oh_queue.students[i + 1];
                i += 1;
            }

            oh_queue.stats.no_of_people_in_queue -= 1;
            oh_queue.stats.no_of_people_visited += 1;
            OfficeHoursStatus(&oh_queue.stats);

            return SUCCESS;
        }
    }

    return FAILURE;
}

/** remove_student_by_topic
 * @brief Remove all instances of students with the given topic
 * @param topic the topic you are trying to remove from the queue
 * @return FAILURE if no student is matched, SUCCESS otherwise
 */
int remove_student_by_topic(struct Topic topic) {
    int numRemoved = 0;

    for (int i = 0; i < oh_queue.stats.no_of_people_in_queue; i++) {
        while (oh_queue.students[i + numRemoved].studentData.topic.questionNumber == topic.questionNumber &&
        oh_queue.students[i + numRemoved].studentData.topic.topicName == topic.topicName) {
            numRemoved += 1;
        }

        oh_queue.students[i] = oh_queue.students[i + numRemoved];
    }

    if (numRemoved == 0) {
        return FAILURE;
    }

    oh_queue.stats.no_of_people_in_queue -= numRemoved;
    oh_queue.stats.no_of_people_visited += numRemoved;
    OfficeHoursStatus(&oh_queue.stats);

    return SUCCESS;
}

/** OfficeHoursStatus
 * @brief Updates the "currentStatus" field based on
 * whether or not all students in the queue have been helped
 * @param resultStats A pointer the OfficeHoursStats variable
 * you are to update
 */
void OfficeHoursStatus(struct OfficeHoursStats* resultStats){
    if (resultStats->no_of_people_in_queue == 0) {
        resultStats->currentStatus = "Completed";
        return;
    }

    resultStats->currentStatus = "InProgress";
}

/*
 * Calculates (b^e)%n without overflow
 */
int power_and_mod(int b, int e, int n) {
    long int currNum = 1;
    for (int i = 0; i < e; i++) {
        currNum *= b;
        if (currNum >= n) {
            currNum %= n;
        }
    }
    return (int) (currNum % n);
}
