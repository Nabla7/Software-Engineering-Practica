| Path | Input | Motivation |
|-----------------------------|-------|------------|
| {1, 2, 3, 4, 5, 6} | {'course.get_enrollment_starting_date() <= get_current_date()': True, 'student.has_paid_tuition()': True} | Enrollment date has passed and tuition is paid; tests normal course addition. |
| {1, 2, 3, 4, 10, 11, 12} | {'course.get_enrollment_starting_date() <= get_current_date()': False, 'course.is_informational_course()': True} | Enrollment date not passed but informational course; should allow addition. |
| {1, 2, 3, 4, 5, 7, 8} | {'course.get_enrollment_starting_date() <= get_current_date()': True, 'student.has_financial_aid()': True} | Enrollment date has passed and student has financial aid; tests course addition with aid. |
| {1, 2, 3, 4, 10, 13, 14} | {'course.get_enrollment_starting_date() <= get_current_date()': False, 'course.is_informational_course()': False} | Future enrollment date and not informational; blocked from addition. |
| {16, 17, 18, 19, 20} | {'course.student_has_all_requirements(student)': False} | Student does not meet course requirements; course should not be added. |
| {16, 17, 18, 21, 22, 23, 33, 34, 35, 36, 38, 39, 40, 41} | {'student.get_available_credits() > 0': True, 'adjusted_remaining_credits >= course.get_num_credits()': True, 'schedule.is_space_available_for_course(course)': True} | Student has enough credits and space in schedule; course should be added. |
| {16, 17, 18, 21, 24, 25, 26, 33, 34, 35, 36, 38, 39, 40, 41} | {'student.get_available_credits() > 0': True, 'adjusted_remaining_credits >= course.get_num_credits()': False, 'student.can_enroll_without_credits()': True, 'schedule.is_space_available_for_course(course)': True} | Not enough credits but can enroll without; tests alternative enrollment. |
| {16, 17, 18, 29, 30, 31, 32, 43} | {'student.get_available_credits() > 0': False, 'courses_with_not_enough_credits > max_skipped': True} | No available credits and skipped too many courses; should prevent enrollment. |
