package pl.manes.soccereagles.structureManager;

import lombok.EqualsAndHashCode;

@SuppressWarnings("ALL")
@EqualsAndHashCode
public class AttendanceStatistics {

    private final String attendanceUser;

    public AttendanceStatistics(String attendanceUser) {
        this.attendanceUser = attendanceUser;
    }

    public String getAttendanceUser() {
        return attendanceUser;
    }

    @Override
    public String toString() {
        return "AttendanceStatistics{" +
                "attendanceUser='" + attendanceUser + '\'' +
                '}';
    }
}
