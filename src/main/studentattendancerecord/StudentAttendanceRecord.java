package main.studentattendancerecord;

/**
 * You are given a string s representing an attendance record for a student where each character signifies whether the student was absent,
 * late, or present on that day. The record only contains the following three characters:
 *
 * 'A': Absent.
 * 'L': Late.
 * 'P': Present.
 * The student is eligible for an attendance award if they meet both of the following criteria:
 *
 * The student was absent ('A') for strictly fewer than 2 days total.
 * The student was never late ('L') for 3 or more consecutive days.
 * Return true if the student is eligible for an attendance award, or false otherwise.
 */
class StudentAttendanceRecord {

    boolean calculateAttendanceByStatusLine(String statusLine) {
        int absentCount = 0;
        int lateCountByLine = 0;

        for (char index : statusLine.toCharArray()) {
            if (index == 'A') {
                if (absentCount == 1)
                    return false;

                absentCount++;
                lateCountByLine = 0;
            } else if (index == 'L') {
                if (lateCountByLine == 2)
                    return false;

                lateCountByLine++;
            } else {
                lateCountByLine = 0;
            }
        }

        return absentCount <= 1;
    }

}

class Main {
    public static void main(String[] args) {
        var record = new StudentAttendanceRecord();
        boolean result = record.calculateAttendanceByStatusLine("LPLPLPLPLPL");
        System.out.println(result);
    }
}
