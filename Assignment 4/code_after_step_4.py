def enroll_in_courses(student: Student, courses: list[Course], max_skipped: int, weight_factor: list[float]):
    i: int = 0
    while i < len(courses):  # 1
        course = courses[i]  # 2
        if course.get_enrollment_starting_date() <= get_current_date() and (student.has_paid_tuition() or student.has_financial_aid()):  # 3
            print("Adding course")  # 4
        else:
            if course.is_informational_course():  # 5
                print("Adding course")  # 6
            else:
                log_error(f"Cannot add course {student.get_student_nr()} for student {course.get_course_id()}")  # 7
                return []
        i += 1  #  8

    schedule = student.get_schedule()  # 9

    courses_with_not_enough_credits = 0

    approved_courses = []

    adjusted_remaining_credits = student.get_available_credits()

    while len(courses) > 0 and adjusted_remaining_credits > 0:  # 10
        course = courses.pop()  # 11

        if not course.student_has_all_requirements(student):  # 12
            continue  # 13

        if (adjusted_remaining_credits >= course.get_num_credits() or student.can_enroll_without_credits()) and student.get_available_credits() > 0:  # 14
            enough_credits = True  # 15
        else:
            enough_credits = False  # 16

        if not enough_credits:  # 17
            courses_with_not_enough_credits += 1  # 18

            if courses_with_not_enough_credits > max_skipped:  # 19
                break  # 20

        if schedule.is_space_available_for_course(course) and student.get_available_credits() >= course.get_num_credits():  # 21
            adjusted_remaining_credits -= course.get_num_credits()  # 22
            approved_courses.append(course)
            courses_with_not_enough_credits = 0
            continue
        # 23

    i: int = 0  # 24
    while i < len(approved_courses): # 25
        approved_course = approved_courses[i]  # 26
        schedule.add_course(approved_course)

    return approved_courses  # 27