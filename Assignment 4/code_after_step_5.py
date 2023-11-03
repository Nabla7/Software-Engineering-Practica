def enroll_in_courses(student: Student, courses: list[Course], max_skipped: int, weight_factor: list[float]):
    i: int = 0 #1
    while i < len(courses): #2
        course = courses[i] #3
        if course.get_enrollment_starting_date() <= get_current_date(): #4
            if student.has_paid_tuition(): #5
                print("Adding course") #6
            if student.has_financial_aid(): #7
                print("Adding course") #8
            else:
                log_error(f"Cannot add course {student.get_student_nr()} for student {course.get_course_id()}") #9 
        else: #10
            if course.is_informational_course(): #11
                print("Adding course") #12
            else: # 13
                log_error(f"Cannot add course {student.get_student_nr()} for student {course.get_course_id()}") #14
                return []
            
        i += 1 #15

    schedule = student.get_schedule() #16

    courses_with_not_enough_credits = 0 #16

    approved_courses = [] #16

    adjusted_remaining_credits = student.get_available_credits() #16

    while len(courses) > 0 and adjusted_remaining_credits > 0: #17
        course = courses.pop() #18

        if not course.student_has_all_requirements(student): #19
            continue #20

        if student.get_available_credits() > 0: #21
            if adjusted_remaining_credits >= course.get_num_credits(): #22
                enough_credits = True #23
            else: #24
                if student.can_enroll_without_credits(): #25
                    enough_credits = True # 26
                else: #27
                    enough_credits = False # 28
        else: #29
            enough_credits = False #42

        if not enough_credits: #30
            courses_with_not_enough_credits += 1 #31

            if courses_with_not_enough_credits > max_skipped: #32
                break #43

        if schedule.is_space_available_for_course(course): # 33
            if student.get_available_credits() >= course.get_num_credits(): #34
                adjusted_remaining_credits -= course.get_num_credits() #35
                approved_courses.append(course) #35
                courses_with_not_enough_credits = 0 #35

                continue ##36

        #37

    i: int = 0 #38
    while i < len(approved_courses): #39
        approved_course = approved_courses[i] #40
        schedule.add_course(approved_course) #40

        i += 1 #40

    return approved_courses #41
