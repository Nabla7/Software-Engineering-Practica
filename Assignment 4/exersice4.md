
## first While loop
| Path | Input | Motivation         |
| ---  | ---   | ---        |
|1, 9, 10, 24, 25, 27| len(courses) = 0, the rest doesnt matter | If we don't have any courses the student wants to enroll in, we dont enter the loop. | 
|1, 2, 3, 5, 7, 28|  The enrollment date of first course has passed and it is not an informational course, len(courses) > 0  |    | |
|1, 2, 3, 4, 8, 1, 2, 3, 5, 7, 28| len(courses) > 0 and the enrollment date of first course has not passed + student has enough credits for the first course, but not the second. The courses are not informational courses | |
|1, 2, 3, 4, 8, 1, 2, 3, 5, 6, 8, 1, 2, 3, 4, 8, 1, 2, 3, 5, 7, 28| len(courses) = 7 and the enrollemnt dates for the courses have not passed except for the second one. The student has enough credits for the first 3 courses. Only the second course is an informational course.| | |
|1, 2, 3, 4, 8, 1, 2, 3, 4, 8, 1, 2, 3, 4, 8, 1, 2, 3, 4, 8, 1, 2, 3, 4, 8, 1, 2, 3, 5, 7, 28| len(courses) = 7 and all the enrollment dates of all courses have not passed. the student has enough credits for 5 courses. There are no informational courses. |  |
|1, 2, 3, 4, 8, 1, 2, 3, 4, 8, 1, 2, 3, 4, 8, 1, 2, 3, 4, 8, 1, 2, 3, 4, 8, 1, 2, 3, 4, 8, 1, 2, 3, 5, 7, 28| len(courses) = 7 and all the enrollment dates of all courses have not passed. the student has enough credits for 6 courses. There are no informational courses. | |
| 1, 2, 3, 4, 8, 1, 2, 3, 4, 8, 1, 2, 3, 4, 8, 1, 2, 3, 4, 8, 1, 2, 3, 4, 8, 1, 2, 3, 4, 8, 1, 2, 3, 4, 8, 1, 2, 3, 5, 7, 28| not possible. We cant enter the loop more than the length of the courses | not possible. We cant enter the loop more than the length of the courses, because i will always increment except for the return statement where this function ends. |

## Second While loop
It does not matter what happens beforehand, this is already tested
| Path | Input | Motivation         |
| ---  | ---   | ---        |
|10, 24, 25, 27 ,28   | Adjusted_remaining_credits = 0 |When there are no credits remaining, the loop will not be entered. |
| 10, 11, 12, 13, 10, 24, 25, 26, 27 | len(courses) = 1 and the student does not have all the requirements to enter this course. | Because the student does not have all the requirements. We will go out of the loop.|
| 10, 11, 12, 14, 15, 21, 23, 10, 11, 12, 14, 16, 17, 18, 19, 20 | len(courses) >= 2 and the student cannot skip more than 1 course. The student has enough credits for the first one but not for the second one. |On the second one, the student does not have enough credits, so we will go out of the loop. |
| 10, 11, 12, 13, 10, 11, 12, 13, 10, 11, 12, 14, 15, 17, 21, 22, 24, 10, 11, 12, 14, 16, 17, 18, 19, 20 | len(courses) >= 4 and the student has enough credits for the first course and can't skip any courses. The student does not have all the requirements for the first 2 courses | | # 4 times
| 10, 11, 12, 13, 10, 11, 12, 13, 10, 11, 12, 14, 15, 17, 21, 22, 24, 10, 11, 12, 14, 15, 17, 21, 22, 24, 10, 11, 12, 14, 16, 17, 18, 19, 20| len(courses) >= 5 and the student has enough credits for the first 2 courses. the student can not skip any courses. The student does not have all the requirements for the first 2 courses| |
| 10, 11, 12, 14, 15, 17, 21, 22, 23, 10, 11, 12, 14, 15, 17, 21, 22, 23, 10, 11, 12, 14, 15, 17, 21, 22, 23, 10, 11, 12, 14, 15, 17, 21, 22, 23 ,10, 11, 12, 14, 15, 17, 21, 22, 23 ,10, 11, 12, 14, 15, 17, 21, 22, 23| len(courses) = 6, the student has all the requirements for all the courses and has schedule space available for all the courses. the student also has enough credits for all the courses. | |
| 10, 11, 12, 13, 10, 11, 12, 13, 10, 11, 12, 13, 10, 11, 12, 13, 10, 11, 12, 13, 10, 11, 12, 13, 10, 11, 12, 13,  | | This is not possible we always pop a course from the courses list and cant pop more than there are on the list. |

## third while loop

| Path | Input | Motivation         |
| ---  | ---   | ---        |
| 24, 25, 27 | len(approved_courses) = 0| |
| 24, 25, 26, 25, 27 | len(approved_courses) = 1 | |
| 24, 25, 26, 25, 26, 25, 26| len(approved_courses) = 3|

I am going to stop here, because we always do the loop n times. We do not have an exit condition anywhere in the loop. We can't fully test this loop with the loop method.