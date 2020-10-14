#include <iostream>
using namespace std;

// Course struct
struct course {
    string dept; 
    int courseNum; 
    string title;
};

// Function to count number of courses in the given department
int numCoursesInDepartment(course courseArray[], int numCourses, string department) {
    int coursesInDept = 0;
    for(int i = 0; i < numCourses; i++) {
        if (courseArray[i].dept.compare(department) == 0) {
            coursesInDept++;
        }
    }
    return coursesInDept;
}

// Array declaration and function testing
int main() {
    const int ARRAY_SIZE = 10;
    course givenCourses[ARRAY_SIZE] = {
        {"COMP", 1001, "Introduction to Computer Science I"},
        {"CHEM", 1001, "Chemistry I"},
        {"CHEM", 1002, "Chemistry II"},
        {"CIVE", 3200, "Structural Design I"},
        {"CIVE", 4400, "Design of Structural Steel Components"},
        {"COMP", 1406, "Introduction to Computer Science II"},
        {"ARCH", 1001, "Introduction to Architecture"},
        {"ARCH", 1002, "History of Architecture"}, 
        {"CIVE", 4300, "Design of Reinforced Concrete Components"},
        {"ARCH", 3405, "Historic Site Recording and Documentation"}
    };
    string deptOfInterest = "COMP"; // we can easily change this if we want to look at another department

    cout << numCoursesInDepartment(givenCourses, ARRAY_SIZE, deptOfInterest) 
        << " courses in the department " << deptOfInterest << "\n";

    return 0;
}