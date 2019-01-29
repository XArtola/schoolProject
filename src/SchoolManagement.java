
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Calendar.Builder;
import java.util.Scanner;

import com.zubiri.school.*;

import java.io.*;

public class SchoolManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		School school = new School("zubiri");
		boolean finish = false;

		while (!finish) {

			System.out.println("Welcome to the school management program.\n\n \tWhat do you want to do?\n"
					+ " 0- Exit\n 1- Change the school name\n 2- Manage teachers \n 3- Manage students\n 4- Manage administratives\n");
			String option = sc.next();
			sc.nextLine();
			switch (option) {
			default:
				System.out.println("Enter a number, try again.");
				break;
			case "0":
				finish = true;
				break;
			case "1":
				System.out.println("Enter the name you want for your school.");
				school.setSchoolName(sc.nextLine());
				System.out.println("Done.");
				break;

			case "2":
				System.out.println("Welcome to Teachers management option. What do you want?\n");
				System.out.println(
						" 0- Exit\n 1- View Teacher information\n 2- Modify Teacher\n 3- Delete Teacher\n 4- New Teacher\n ");
				String teacherOption = sc.next();
				sc.nextLine();
				switch (teacherOption) {
				case "1":
					if (school.getTeachers().size() > 0) {
						System.out.println(
								"Whose information do you want to view? (Enter the ID of the Teacher you want to find)");
						String teacherID = sc.next();
						sc.nextLine();
						System.out.println("The information of the teacher you are looking for is:\n" + "\tName: "
								+ school.getTeachers().get(school.findTeacher(teacherID)).getName() + "\n \tTeacherID: "
								+ teacherID + "\n\t BirthDate: "
								+ school.getTeachers().get(school.findTeacher(teacherID)).getBirthDate() + "\n\tDNI: "
								+ school.getTeachers().get(school.findTeacher(teacherID)).getDni() + "\n\tPhone number "
								+ school.getTeachers().get(school.findTeacher(teacherID)).getPhoneNumber()
								+ "\n\tSalary: " + school.getTeachers().get(school.findTeacher(teacherID)).getSalary()
								+ "€\n\t Joined date: "
								+ school.getTeachers().get(school.findTeacher(teacherID)).getJoined() + "\n\t Tutor: "
								+ school.getTeachers().get(school.findTeacher(teacherID)).getTutor());
						System.out.println("\t Subjects: ");
						for (int i = 0; i < school.getTeacher(school.findTeacher(teacherID)).getSubjects()
								.size(); i++) {

							System.out.println(
									i + "- " + school.getTeacher(school.findTeacher(teacherID)).getSubjects().get(i));
						}
						school.findTeacher(teacherID);

					} else
						System.out.println("There's no Teacher created yet.");
					break;

				case "2":

					System.out.println("What teachers information do you want to modify? [Enter the teacherID]");

					String teacherID = sc.next();
					sc.nextLine();
					Teacher teacher2 = school.getTeachers().get(school.findTeacher(teacherID));

					System.out.println(
							"What information do you want to modify?\n 1-Name\n 2- BirthDate\n 3- Dni\n 4- Phone number\n 5- Salary\n 6- Joined\n 7- Tutor\n 8- Subjects\n");

					int modifyOption = sc.nextInt();
					switch (modifyOption) {
					case 1:

						System.out.println("Enter the new name");
						String possibleName2 = sc.next();
						sc.nextLine();
						while (!teacher2.checkName(possibleName2)) {
							System.out.println("Enter a valid name (no numbers)");
							possibleName2 = sc.next();
							sc.nextLine();
						}
						teacher2.setName(possibleName2);

						break;
					case 2:

						System.out.println("Enter the new birthdate");
						System.out.println("year:");
						int year2 = sc.nextInt();
						System.out.println("month:");
						int month2 = sc.nextInt();
						System.out.println("day:");
						int day2 = sc.nextInt();
						Calendar birthDate2 = new Calendar.Builder().setCalendarType("iso8601")
								.setDate(year2, month2, day2).build();
						while (!teacher2.checkDate(birthDate2)) {
							System.out.println("Enter a valid date");
							System.out.println("year:");
							year2 = sc.nextInt();
							System.out.println("month:");
							month2 = sc.nextInt();
							System.out.println("day:");
							day2 = sc.nextInt();
							birthDate2 = new Calendar.Builder().setCalendarType("iso8601").setDate(year2, month2, day2)
									.build();
						}
						teacher2.setBirthDate(birthDate2);

						break;
					case 3:
						System.out.println("Enter the new Dni");
						String dni2 = sc.next();
						sc.nextLine();
						while (!teacher2.checkDni(dni2)) {
							System.out.println("Enter a valid DNI");
							dni2 = sc.next();
							sc.nextLine();
						}
						teacher2.setDni(dni2);
						break;
					case 4:
						System.out.println("Enter the new telephone number:");
						String phoneNumber2 = sc.next();
						sc.nextLine();
						while (!teacher2.checkPhoneNumber(phoneNumber2)) {
							System.out.println("Enter a valid phone number");
							phoneNumber2 = sc.next();
							sc.nextLine();
						}
						teacher2.setPhoneNumber(phoneNumber2);

						break;
					case 5:
						System.out.println("Enter the new salary:");
						double salary2 = sc.nextDouble();
						while (!teacher2.checkSalary(salary2)) {
							System.out.println("Enter a valid salary");
							salary2 = sc.nextDouble();
						}
						teacher2.setSalary(salary2);

						break;
					case 6:

						System.out.println("Enter the new joined date");
						System.out.println("Year:");
						int year = sc.nextInt();
						System.out.println("Month:");
						int month = sc.nextInt();
						System.out.println("Day:");
						int day = sc.nextInt();
						Calendar joined2 = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day)
								.build();
						while (!teacher2.checkDate(joined2)) {
							System.out.println("Enter a valid date");
							System.out.println("Year:");
							year = sc.nextInt();
							System.out.println("Month:");
							month = sc.nextInt();
							System.out.println("Day:");
							day = sc.nextInt();
							joined2 = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day)
									.build();
						}
						teacher2.setJoined(joined2);
						break;
					case 7:

						System.out.println("Is she/he a tutor? (y/n)");
						boolean askAgain2 = true;
						while (askAgain2) {
							String answer = sc.next().toLowerCase();
							sc.nextLine();
							switch (answer) {
							case "y":
								System.out.println("What class is she/he tutor of?");
								teacher2.setTutor(sc.next());
								sc.nextLine();
								askAgain2 = false;
								break;
							case "n":
								askAgain2 = false;
								break;
							default:
								System.out.println("Please, select a possible value(y/n)");
								break;
							}
						}
						break;
					case 8:

						System.out.println("How many subjects do she/he teach?");
						int numberOfSubjects2 = sc.nextInt();
						for (int i = 0; i < numberOfSubjects2; i++) {
							System.out.println("Enter a subject:");
							teacher2.addSubject(sc.next());
							sc.nextLine();

						}
						break;
					}
					school.modifyTeacher(school.findTeacher(teacherID), teacher2);

					break;
				case "3":

					System.out.println("Enter the ID of the teacher you want to remove");

					school.deleteTeacher(school.findTeacher(sc.next()));
					sc.nextLine();

					break;

				case "4":
					System.out.println("*NEW TEACHER*");
					Teacher teacher = new Teacher();
					System.out.println("Name:");
					String possibleName = sc.next();
					sc.nextLine();
					while (!teacher.checkName(possibleName)) {
						System.out.println("Enter a valid name (no numbers)");
						possibleName = sc.next();
						sc.nextLine();
					}
					teacher.setName(possibleName);
					System.out.println("Birth date:");
					System.out.println("year:");
					int year = sc.nextInt();
					System.out.println("month:");
					int month = sc.nextInt();
					System.out.println("day:");
					int day = sc.nextInt();
					Calendar birthDate = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day)
							.build();
					while (!teacher.checkDate(birthDate)) {
						System.out.println("Enter a valid date");
						System.out.println("year:");
						year = sc.nextInt();
						System.out.println("month:");
						month = sc.nextInt();
						System.out.println("day:");
						day = sc.nextInt();
						birthDate = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day).build();
					}
					teacher.setBirthDate(birthDate);
					System.out.println("DNI:");
					String dni = sc.next();
					sc.nextLine();
					while (!teacher.checkDni(dni)) {
						System.out.println("Enter a valid DNI");
						dni = sc.next();
						sc.nextLine();
					}
					teacher.setDni(dni);
					System.out.println("Telephone number:");
					String phoneNumber = sc.next();
					sc.nextLine();
					while (!teacher.checkPhoneNumber(phoneNumber)) {
						System.out.println("Enter a valid phone number");
						phoneNumber = sc.next();
						sc.nextLine();
					}
					teacher.setPhoneNumber(phoneNumber);
					System.out.println("Salary:");
					double salary = sc.nextDouble();
					while (!teacher.checkSalary(salary)) {
						System.out.println("Enter a valid salary");
						salary = sc.nextDouble();
					}
					teacher.setSalary(salary);
					System.out.println("Joined");
					System.out.println("year:");
					year = sc.nextInt();
					System.out.println("month:");
					month = sc.nextInt();
					System.out.println("day:");
					day = sc.nextInt();
					Calendar joined = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day)
							.build();
					while (!teacher.checkDate(joined)) {
						System.out.println("Enter a valid date");
						System.out.println("Year:");
						year = sc.nextInt();
						System.out.println("Month:");
						month = sc.nextInt();
						System.out.println("Day:");
						day = sc.nextInt();
						joined = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day).build();
					}
					teacher.setJoined(joined);
					System.out.println("Is she/he a tutor? (y/n)");
					boolean askAgain = true;
					while (askAgain) {
						String answer = sc.next().toLowerCase();
						sc.nextLine();
						switch (answer) {
						case "y":
							System.out.println("What class is she/he tutor of?");
							teacher.setTutor(sc.next());
							sc.nextLine();
							askAgain = false;
							break;
						case "n":
							askAgain = false;
							break;
						default:
							System.out.println("Please, select a possible value(y/n)");
							break;
						}
					}
					System.out.println("How many subjects do she/he teach?");
					int numberOfSubjects = sc.nextInt();
					for (int i = 0; i < numberOfSubjects; i++) {
						System.out.println("Enter a subject:");
						teacher.addSubject(sc.next());
						sc.nextLine();
					}

					school.addTeacher(teacher);
					System.out.println("Teacher added with the "
							+ school.getTeachers().get(school.getTeachers().size() - 1).getTeacherID() + " teacher ID");
					break;
				}

				break;

			case "3":

				System.out.println("Welcome to Students management option. What do you want?\n");
				System.out.println(
						" 0- Exit\n 1- View Student information\n 2- Modify Student\n 3- Delete Student\n 4- New Student\n ");
				String studentOption = sc.next();
				sc.nextLine();
				switch (studentOption) {
				case "1":
					if (school.getstudents().size() > 0) {
						System.out.println(
								"Whose information do you want to view? (Enter the ID of the Student you want to find)");
						String studentID = sc.next();
						sc.nextLine();
						System.out.println("The information of the student you are looking for is:\n" + "\tName: "
								+ school.getstudents().get(school.findStudent(studentID)).getName() + "\n \tStudentID: "
								+ studentID + "\n\t BirthDate: "
								+ school.getstudents().get(school.findStudent(studentID)).getBirthDate() + "\n\tDNI: "
								+ school.getstudents().get(school.findStudent(studentID)).getDni() + "\n\tPhone number "
								+ school.getstudents().get(school.findStudent(studentID)).getPhoneNumber()
								+ "\n\tAbsenses: "
								+ school.getstudents().get(school.findStudent(studentID)).getAbsenses()
								+ "€\n\t Classroom: "
								+ school.getstudents().get(school.findStudent(studentID)).getClassroom()
								+ "Mark average"
								+ school.getstudents().get(school.findStudent(studentID)).getMarkAverage() + "Course "
								+ school.getstudents().get(school.findStudent(studentID)).getCourse() + "Repeater: "
								+ school.getstudents().get(school.findStudent(studentID)).getRepeater());

					} else
						System.out.println("There's no Student created yet.");
					break;

				case "2":

					System.out.println("What students information do you want to modify? [Enter the studentID]");

					String studentID = sc.next();
					sc.nextLine();
					Student student = school.getstudents().get(school.findStudent(studentID));

					System.out.println(
							"What information do you want to modify?\n 1-Name\n 2- BirthDate\n 3- Dni\n 4- Phone number\n 5- Absenses\n 6- Classroom\n 7- Mark average\n 8- Course 9- Repeater");

					int modifyOption = sc.nextInt();
					switch (modifyOption) {
					case 1:

						System.out.println("Enter the new name");
						String possibleName = sc.next();
						sc.nextLine();
						while (!student.checkName(possibleName)) {
							System.out.println("Enter a valid name (no numbers)");
							possibleName = sc.next();
							sc.nextLine();
						}
						student.setName(possibleName);

						break;
					case 2:

						System.out.println("Enter the new birthdate");
						System.out.println("Year:");
						int year = sc.nextInt();
						System.out.println("Month:");
						int month = sc.nextInt();
						System.out.println("Day:");
						int day = sc.nextInt();
						Calendar birthDate = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day)
								.build();
						while (!student.checkDate(birthDate)) {
							System.out.println("Enter a valid date");
							System.out.println("Year:");
							year = sc.nextInt();
							System.out.println("Month:");
							month = sc.nextInt();
							System.out.println("Day:");
							day = sc.nextInt();
							birthDate = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day)
									.build();
						}
						student.setBirthDate(birthDate);

						break;
					case 3:
						System.out.println("Enter the new Dni");
						String dni = sc.next();
						sc.nextLine();
						while (!student.checkDni(dni)) {
							System.out.println("Enter a valid DNI");
							dni = sc.next();
							sc.nextLine();
						}
						student.setDni(dni);
						break;
					case 4:
						System.out.println("Enter the new telephone number:");
						String phoneNumber = sc.next();
						sc.nextLine();
						while (!student.checkPhoneNumber(phoneNumber)) {
							System.out.println("Enter a valid phone number");
							phoneNumber = sc.next();
							sc.nextLine();
						}
						student.setPhoneNumber(phoneNumber);

						break;
					case 5:
						System.out.println("Enter the new absenses:");
						int absenses = sc.nextInt();
						student.setAbsenses(absenses);

						break;
					case 6:

						System.out.println("Enter the new classroom");

						student.setClassroom(sc.next());
						sc.nextLine();
						break;
					case 7:

						System.out.println("Enter the new mark average");
						student.setMarkAverage(sc.nextInt());
						sc.nextLine();

						break;

					case 8:

						System.out.println("Enter the new course");
						student.setCourse(sc.nextInt());
						sc.nextLine();

						break;

					case 9:

						System.out.println("Enter the new repeater");
						student.setRepeater(sc.nextBoolean());
						sc.nextLine();

						break;

					}
					school.modifyStudent(school.findStudent(studentID), student);

					break;

				case "3":

					System.out.println("Enter the ID of the student you want to remove");

					school.deleteStudent(school.findStudent(sc.next()));

					sc.nextLine();

					break;

				case "4":
					System.out.println("*NEW STUDENT*");
					Student student2 = new Student();
					System.out.println("Name:");
					String possibleName = sc.next();
					sc.nextLine();
					while (!student2.checkName(possibleName)) {
						System.out.println("Enter a valid name (no numbers)");
						possibleName = sc.next();
						sc.nextLine();
					}
					student2.setName(possibleName);
					System.out.println("Birth date:");
					System.out.println("year:");
					int year = sc.nextInt();
					System.out.println("month:");
					int month = sc.nextInt();
					System.out.println("day:");
					int day = sc.nextInt();
					Calendar birthDate = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day)
							.build();
					while (!student2.checkDate(birthDate)) {
						System.out.println("Enter a valid date");
						System.out.println("Year:");
						year = sc.nextInt();
						System.out.println("Month:");
						month = sc.nextInt();
						System.out.println("Day:");
						day = sc.nextInt();
						birthDate = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day).build();
					}
					student2.setBirthDate(birthDate);
					System.out.println("DNI:");
					String dni = sc.next();
					sc.nextLine();
					while (!student2.checkDni(dni)) {
						System.out.println("Enter a valid DNI");
						dni = sc.next();
						sc.nextLine();
					}
					student2.setDni(dni);
					System.out.println("Telephone number:");
					String phoneNumber = sc.next();
					sc.nextLine();
					while (!student2.checkPhoneNumber(phoneNumber)) {
						System.out.println("Enter a valid phone number");
						phoneNumber = sc.next();
						sc.nextLine();
					}
					student2.setPhoneNumber(phoneNumber);
					System.out.println("Enter the absenses:");
					int absenses = sc.nextInt();
					student2.setAbsenses(absenses);

					System.out.println("Enter the classroom");
					student2.setClassroom(sc.next());
					sc.nextLine();

					System.out.println("Enter the mark average");
					student2.setMarkAverage(sc.nextInt());
					sc.nextLine();

					System.out.println("Enter the course");
					student2.setCourse(sc.nextInt());
					sc.nextLine();
					System.out.println("Enter the repeater");
					student2.setRepeater(sc.nextBoolean());
					sc.nextLine();
					school.addStudent(student2);
					System.out.println("Administrative added with the " + school.getAdministratives()
							.get(school.getAdministratives().size() - 1).getAdministrativeID() + " administrative ID");
					break;
				}

				break;

			case "4":

				System.out.println("Welcome to Teachers management option. What do you want?\n");
				System.out.println(
						" 0- Exit\n 1- View Administrative information\n 2- Modify Administrative\n 3- Delete Administrative\n 4- New Administrative\n ");
				String administrativeOption = sc.next();
				sc.nextLine();
				switch (administrativeOption) {
				case "1":
					if (school.getAdministratives().size() > 0) {
						System.out.println(
								"Whose information do you want to view? (Enter the ID of the Administrative you want to find)");
						String administrativeID = sc.next();
						sc.nextLine();
						System.out.println("The information of the administrative you are looking for is:\n"
								+ "\tName: "
								+ school.getAdministratives().get(school.findAdministrative(administrativeID)).getName()
								+ "\n \tAdministrativeID: " + administrativeID + "\n\t BirthDate: "
								+ school.getAdministratives().get(school.findAdministrative(administrativeID))
										.getBirthDate()
								+ "\n\tDNI: "
								+ school.getAdministratives().get(school.findAdministrative(administrativeID)).getDni()
								+ "\n\tPhone number " + school.getAdministratives()
										.get(school.findAdministrative(administrativeID)).getPhoneNumber()
								+ "\n\tSalary: "
								+ school.getAdministratives().get(school.findAdministrative(administrativeID))
										.getSalary()
								+ "€\n\t Joined date: " + school.getAdministratives()
										.get(school.findAdministrative(administrativeID)).getJoined());
						System.out.println("\t Languages: ");

						String[] languagesToPrint = school.getAdministratives()
								.get(school.findAdministrative(administrativeID)).getLanguages();
						for (int i = 0; i < school.getAdministratives().get(school.findAdministrative(administrativeID))
								.getLanguages().length; i++) {

							System.out.println(i + "- " + languagesToPrint[i]);
						}
						school.findAdministrative(administrativeID);

					} else
						System.out.println("There's no Administrative created yet.");
					break;

				case "2":

					System.out.println(
							"What administratives information do you want to modify? [Enter the administrativeID]");

					String administrativeID = sc.next();
					sc.nextLine();
					Administrative administrative = school.getAdministratives()
							.get(school.findAdministrative(administrativeID));

					System.out.println(
							"What information do you want to modify?\n 1-Name\n 2- BirthDate\n 3- Dni\n 4- Phone number\n 5- Salary\n 6- Joined\n 7- Languages\n");

					int modifyOption = sc.nextInt();
					switch (modifyOption) {
					case 1:

						System.out.println("Enter the new name");
						String possibleName = sc.next();
						sc.nextLine();
						while (!administrative.checkName(possibleName)) {
							System.out.println("Enter a valid name (no numbers)");
							possibleName = sc.next();
							sc.nextLine();
						}
						administrative.setName(possibleName);

						break;
					case 2:

						System.out.println("Enter the new birthdate");
						System.out.println("Year:");
						int year = sc.nextInt();
						System.out.println("Month:");
						int month = sc.nextInt();
						System.out.println("Day:");
						int day = sc.nextInt();
						Calendar birthDate = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day)
								.build();
						while (!administrative.checkDate(birthDate)) {
							System.out.println("Enter a valid date");
							System.out.println("Year:");
							year = sc.nextInt();
							System.out.println("Month:");
							month = sc.nextInt();
							System.out.println("Day:");
							day = sc.nextInt();
							birthDate = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day)
									.build();
						}
						administrative.setBirthDate(birthDate);

						break;
					case 3:
						System.out.println("Enter the new Dni");
						String dni = sc.next();
						sc.nextLine();
						while (!administrative.checkDni(dni)) {
							System.out.println("Enter a valid DNI");
							dni = sc.next();
							sc.nextLine();
						}
						administrative.setDni(dni);
						break;
					case 4:
						System.out.println("Enter the new telephone number:");
						String phoneNumber = sc.next();
						sc.nextLine();
						while (!administrative.checkPhoneNumber(phoneNumber)) {
							System.out.println("Enter a valid phone number");
							phoneNumber = sc.next();
							sc.nextLine();
						}
						administrative.setPhoneNumber(phoneNumber);

						break;
					case 5:
						System.out.println("Enter the new salary:");
						double salary = sc.nextDouble();
						while (!administrative.checkSalary(salary)) {
							System.out.println("Enter a valid salary");
							salary = sc.nextDouble();
						}
						administrative.setSalary(salary);

						break;
					case 6:

						System.out.println("Enter the new joined date");
						System.out.println("Year:");
						int year2 = sc.nextInt();
						System.out.println("Month:");
						int month2 = sc.nextInt();
						System.out.println("Day:");
						int day2 = sc.nextInt();
						Calendar joined2 = new Calendar.Builder().setCalendarType("iso8601")
								.setDate(year2, month2, day2).build();
						while (!administrative.checkDate(joined2)) {
							System.out.println("Enter a valid date");
							System.out.println("Year:");
							year2 = sc.nextInt();
							System.out.println("Month:");
							month2 = sc.nextInt();
							System.out.println("Day:");
							day2 = sc.nextInt();
							joined2 = new Calendar.Builder().setCalendarType("iso8601").setDate(year2, month2, day2)
									.build();
						}
						administrative.setJoined(joined2);
						break;
					case 7:

						System.out.println("How many languages does she/he know?");
						int numberOfSubjects = sc.nextInt();
						for (int i = 0; i < numberOfSubjects; i++) {
							System.out.println("Enter a language:");
							administrative.addLanguages(sc.next());
							;
							sc.nextLine();
						}

						break;

					}
					school.modifyAdministrative(school.findAdministrative(administrativeID), administrative);

					break;

				case "3":

					System.out.println("Enter the ID of the administrative you want to remove");

					school.deleteAdministrative(school.findAdministrative(sc.next()));

					sc.nextLine();

					break;

				case "4":
					System.out.println("*NEW ADMINISTRATIVE*");
					Administrative administrative2 = new Administrative();
					System.out.println("Name:");
					String possibleName = sc.next();
					sc.nextLine();
					while (!administrative2.checkName(possibleName)) {
						System.out.println("Enter a valid name (no numbers)");
						possibleName = sc.next();
						sc.nextLine();
					}
					administrative2.setName(possibleName);
					System.out.println("Birth date:");
					System.out.println("year:");
					int year = sc.nextInt();
					System.out.println("month:");
					int month = sc.nextInt();
					System.out.println("day:");
					int day = sc.nextInt();
					Calendar birthDate = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day)
							.build();
					while (!administrative2.checkDate(birthDate)) {
						System.out.println("Enter a valid date");
						System.out.println("Year:");
						year = sc.nextInt();
						System.out.println("Month:");
						month = sc.nextInt();
						System.out.println("Day:");
						day = sc.nextInt();
						birthDate = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day).build();
					}
					administrative2.setBirthDate(birthDate);
					System.out.println("DNI:");
					String dni = sc.next();
					sc.nextLine();
					while (!administrative2.checkDni(dni)) {
						System.out.println("Enter a valid DNI");
						dni = sc.next();
						sc.nextLine();
					}
					administrative2.setDni(dni);
					System.out.println("Telephone number:");
					String phoneNumber = sc.next();
					sc.nextLine();
					while (!administrative2.checkPhoneNumber(phoneNumber)) {
						System.out.println("Enter a valid phone number");
						phoneNumber = sc.next();
						sc.nextLine();
					}
					administrative2.setPhoneNumber(phoneNumber);
					System.out.println("Salary:");
					double salary = sc.nextDouble();
					while (!administrative2.checkSalary(salary)) {
						System.out.println("Enter a valid salary");
						salary = sc.nextDouble();
					}
					administrative2.setSalary(salary);
					System.out.println("Joined");
					System.out.println("year:");
					year = sc.nextInt();
					System.out.println("month:");
					month = sc.nextInt();
					System.out.println("day:");
					day = sc.nextInt();
					Calendar joined = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day)
							.build();
					while (!administrative2.checkDate(joined)) {
						System.out.println("Enter a valid date");
						System.out.println("Year:");
						year = sc.nextInt();
						System.out.println("Month:");
						month = sc.nextInt();
						System.out.println("Day:");
						day = sc.nextInt();
						joined = new Calendar.Builder().setCalendarType("iso8601").setDate(year, month, day).build();
					}
					administrative2.setJoined(joined);
					System.out.println("How many languages does she/he know?");
					int numberOfSubjects = sc.nextInt();
					for (int i = 0; i < numberOfSubjects; i++) {
						System.out.println("Enter a language:");
						administrative2.addLanguages(sc.next());

						sc.nextLine();
					}

					school.addAdministrative(administrative2);
					System.out.println("Administrative added with the " + school.getAdministratives()
							.get(school.getAdministratives().size() - 1).getAdministrativeID() + " administrative ID");
					break;
				}

				break;

			}

		}

	}

}
