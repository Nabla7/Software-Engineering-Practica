def enroll_in_courses(student: Student, courses: list[Course], max_skipped: int, weight_factor: list[float]):
    i: int = 0
    while i < len(courses):
        course = courses[i]
        if course.get_enrollment_starting_date() <= get_current_date():
            if student.has_paid_tuition():
                print("Adding course")
            if student.has_financial_aid():
                print("Adding course")
        else:
            if course.is_informational_course():
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

        if student.get_available_credits() > 0:
            if adjusted_remaining_credits >= course.get_num_credits():
                enough_credits = True
            else:
                if student.can_enroll_without_credits():
                    enough_credits = True
                else:
                    enough_credits = False
        else:
            enough_credits = False

        if not enough_credits:
            courses_with_not_enough_credits += 1

            if courses_with_not_enough_credits > max_skipped:
                break

        if schedule.is_space_available_for_course(course):
            if student.get_available_credits() >= course.get_num_credits():
                adjusted_remaining_credits -= course.get_num_credits()
                approved_courses.append(course)
                courses_with_not_enough_credits = 0

                continue
    i: int = 0
    while i < len(approved_courses):
        approved_course = approved_courses[i]
        schedule.add_course(approved_course)

    return approved_courses
