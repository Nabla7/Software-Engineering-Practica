"""
MIT License

Copyright (c) 2023 Kasper Engelen

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
"""


from datetime import datetime


def log_error(message: str):
    pass


def get_current_date() -> datetime:
    pass


class Student:
    def get_student_nr(self) -> int:
        pass

    def has_paid_tuition(self) -> bool:
        pass

    def has_financial_aid(self) -> bool:
        pass

    def get_available_credits(self) -> int:
        pass

    def get_schedule(self) -> "StudentSchedule":
        pass

    def has_unfinished_courses(self) -> bool:
        pass

    def can_enroll_without_credits(self) -> bool:
        pass


class Course:
    def get_course_id(self) -> int:
        pass

    def get_enrollment_starting_date(self) -> datetime:
        pass

    def get_num_credits(self) -> int:
        pass

    def student_has_all_requirements(self, student: Student):
        pass

    def is_informational_course(self) -> bool:
        pass


class StudentSchedule:
    def add_course(self, course: Course):
        pass

    def is_space_available_for_course(self, course: Course) -> int:
        pass


def enroll_in_courses(student: Student, courses: list[Course], max_skipped: int, weight_factor: list[float]):
    for course in courses:
        if course.get_enrollment_starting_date() <= get_current_date() and (student.has_paid_tuition() or student.has_financial_aid()):
            print("Adding course")
        elif course.is_informational_course():
            print("Adding course")
        else:
            log_error(f"Cannot add course {student.get_student_nr()} for student {course.get_course_id()}")
            return []

    schedule = student.get_schedule()

    courses_with_not_enough_credits = 0

    approved_courses = []

    adjusted_remaining_credits = student.get_available_credits()

    while len(courses) > 0 and adjusted_remaining_credits > 0:
        course = courses.pop()

        if not course.student_has_all_requirements(student):
            continue

        enough_credits = (adjusted_remaining_credits >= course.get_num_credits() or student.can_enroll_without_credits()) and student.get_available_credits() > 0

        if not enough_credits:
            courses_with_not_enough_credits += 1

            if courses_with_not_enough_credits > max_skipped:
                break

        if schedule.is_space_available_for_course(course) and student.get_available_credits() >= course.get_num_credits():
            adjusted_remaining_credits -= course.get_num_credits()
            approved_courses.append(course)
            courses_with_not_enough_credits = 0
            continue

    for approved_course in approved_courses:
        schedule.add_course(approved_course)

    return approved_courses
