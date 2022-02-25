import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class AmountOfTimeBeforeOrAfterCourseCompletion {
    public static int startWorkingHour = 10;
    public static int endWorkingHour = 18;

    public static ArrayList<Integer> calculateAmountOfTimeBeforeOrAfterCourseCompletion(Calendar endDate, int coursesDuration) {
        ArrayList<Integer> daysAndHoursBeforeOrAfterCourseCompletion = new ArrayList<>();
        int daysAfterCourseCompletion = 0;
        int daysBeforeCourseCompletion = 0;
        int hoursAfterCourseCompletion = 0;
        int hoursBeforeCourseCompletion = 0;
        int amountOfWorkingHoursAtLastDay = coursesDuration % DetermineCourseCompletion.workHoursPerDay;
        endDate.set(Calendar.HOUR_OF_DAY, 23);
        endDate.set(Calendar.MINUTE, 59);
        Calendar currentDate = Calendar.getInstance();
        int hoursToday = currentDate.get(Calendar.HOUR_OF_DAY);
        System.out.println(currentDate.get(Calendar.HOUR_OF_DAY));
        System.out.println(currentDate.get(Calendar.DAY_OF_WEEK));
        System.out.println(currentDate.getTime());
        System.out.println(endDate.getTime());
        LocalDate today = LocalDate.ofInstant(currentDate.toInstant(), ZoneId.systemDefault());
        LocalDate finish = LocalDate.ofInstant(endDate.toInstant(), ZoneId.systemDefault());

        if (currentDate.getTimeInMillis() > endDate.getTimeInMillis()) {
            List<LocalDate> workingDays = finish.datesUntil(today.plusDays(1))
                    .collect(Collectors.toList());
            if (amountOfWorkingHoursAtLastDay == 0) {
                if (hoursToday < startWorkingHour || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) ==
                        Calendar.SATURDAY || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    daysAfterCourseCompletion = workingDays.size() - 2;
                } else if (hoursToday >= startWorkingHour && hoursToday <= endWorkingHour) {
                    daysAfterCourseCompletion = workingDays.size() - 2;
                    hoursAfterCourseCompletion = hoursToday - startWorkingHour;
                } else {
                    daysAfterCourseCompletion = workingDays.size() - 1;
                }
            } else {
                if (hoursToday < startWorkingHour || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) ==
                        Calendar.SATURDAY || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    daysAfterCourseCompletion = workingDays.size() - 2;
                    hoursAfterCourseCompletion = endWorkingHour - (startWorkingHour + amountOfWorkingHoursAtLastDay);
                } else if (hoursToday >= startWorkingHour && hoursToday <= endWorkingHour) {
                    daysAfterCourseCompletion = workingDays.size() - 2;
                    hoursAfterCourseCompletion = hoursToday - startWorkingHour + endWorkingHour - (startWorkingHour + amountOfWorkingHoursAtLastDay);
                } else {
                    daysAfterCourseCompletion = workingDays.size() - 1;
                    hoursAfterCourseCompletion = endWorkingHour - (startWorkingHour + amountOfWorkingHoursAtLastDay);
                }
            }
            daysAndHoursBeforeOrAfterCourseCompletion.add(daysAfterCourseCompletion);
            daysAndHoursBeforeOrAfterCourseCompletion.add(hoursAfterCourseCompletion);
            System.out.println(workingDays);

        } else {
            List<LocalDate> workingDays = today.datesUntil(finish.plusDays(1))
                    .collect(Collectors.toList());
            if (amountOfWorkingHoursAtLastDay == 0) {
                if (hoursToday < startWorkingHour || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) ==
                        Calendar.SATURDAY || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    daysBeforeCourseCompletion = workingDays.size();
                } else if (hoursToday >= startWorkingHour && hoursToday <= endWorkingHour) {
                    daysBeforeCourseCompletion = workingDays.size() - 1;
                    hoursBeforeCourseCompletion = endWorkingHour - hoursToday;
                } else {
                    daysBeforeCourseCompletion = workingDays.size() - 1;
                }
            } else {
                if (hoursToday < startWorkingHour || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) ==
                        Calendar.SATURDAY || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    daysBeforeCourseCompletion = workingDays.size() - 1;
                    hoursBeforeCourseCompletion = amountOfWorkingHoursAtLastDay;
                } else if (hoursToday >= startWorkingHour && hoursToday <= endWorkingHour) {
                    daysBeforeCourseCompletion = workingDays.size() - 2;
                    hoursBeforeCourseCompletion = endWorkingHour - hoursToday + amountOfWorkingHoursAtLastDay;
                } else {
                    daysBeforeCourseCompletion = workingDays.size() - 2;
                    hoursBeforeCourseCompletion = amountOfWorkingHoursAtLastDay;
                }
            }
            daysAndHoursBeforeOrAfterCourseCompletion.add(daysBeforeCourseCompletion);
            daysAndHoursBeforeOrAfterCourseCompletion.add(hoursBeforeCourseCompletion);
            System.out.println(workingDays);
        }
        return daysAndHoursBeforeOrAfterCourseCompletion;
    }

    public static ArrayList<Integer> calculateAmountOfTimeBeforeOrAfterCourseCompletion(LocalDate endDate, int coursesDuration) {
        ArrayList<Integer> daysAndHoursBeforeOrAfterCourseCompletion = new ArrayList<>();
        int daysAfterCourseCompletion = 0;
        int daysBeforeCourseCompletion = 0;
        int hoursAfterCourseCompletion = 0;
        int hoursBeforeCourseCompletion = 0;
        int amountOfWorkingHoursAtLastDay = coursesDuration % DetermineCourseCompletion.workHoursPerDay;
        endDate.atTime(23, 59);
        LocalDate currentDate = LocalDate.now(ZoneId.of("Europe/Moscow"));
        LocalDateTime currentDateToFindHourOfDay = LocalDateTime.now(ZoneId.of("Europe/Moscow"));
        int hoursToday = currentDateToFindHourOfDay.getHour();

        if (currentDate.isAfter(endDate)) {
            List<LocalDate> workingDays = endDate.datesUntil(currentDate.plusDays(1))
                    .collect(Collectors.toList());
            if (amountOfWorkingHoursAtLastDay == 0) {
                if (hoursToday < startWorkingHour || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) ==
                        Calendar.SATURDAY || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    daysAfterCourseCompletion = workingDays.size() - 2;
                } else if (hoursToday >= startWorkingHour && hoursToday <= endWorkingHour) {
                    daysAfterCourseCompletion = workingDays.size() - 2;
                    hoursAfterCourseCompletion = hoursToday - startWorkingHour;
                } else {
                    daysAfterCourseCompletion = workingDays.size() - 1;
                }
            } else {
                if (hoursToday < startWorkingHour || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) ==
                        Calendar.SATURDAY || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    daysAfterCourseCompletion = workingDays.size() - 2;
                    hoursAfterCourseCompletion = endWorkingHour - (startWorkingHour + amountOfWorkingHoursAtLastDay);
                } else if (hoursToday >= startWorkingHour && hoursToday <= endWorkingHour) {
                    daysAfterCourseCompletion = workingDays.size() - 2;
                    hoursAfterCourseCompletion = hoursToday - startWorkingHour + endWorkingHour - (startWorkingHour + amountOfWorkingHoursAtLastDay);
                } else {
                    daysAfterCourseCompletion = workingDays.size() - 1;
                    hoursAfterCourseCompletion = endWorkingHour - (startWorkingHour + amountOfWorkingHoursAtLastDay);
                }
            }
            daysAndHoursBeforeOrAfterCourseCompletion.add(daysAfterCourseCompletion);
            daysAndHoursBeforeOrAfterCourseCompletion.add(hoursAfterCourseCompletion);
            System.out.println("Training completed. " + daysAfterCourseCompletion + " d " + hoursAfterCourseCompletion + " hours have passed since the end.");

        } else if (currentDate.isBefore(endDate)) {
            List<LocalDate> workingDays = currentDate.datesUntil(endDate.plusDays(1))
                    .collect(Collectors.toList());
            if (amountOfWorkingHoursAtLastDay == 0) {
                if (hoursToday < startWorkingHour || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) ==
                        Calendar.SATURDAY || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    daysBeforeCourseCompletion = workingDays.size();
                } else if (hoursToday >= startWorkingHour && hoursToday <= endWorkingHour) {
                    daysBeforeCourseCompletion = workingDays.size() - 1;
                    hoursBeforeCourseCompletion = endWorkingHour - hoursToday;
                } else {
                    daysBeforeCourseCompletion = workingDays.size() - 1;
                }
            } else {
                if (hoursToday < startWorkingHour || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) ==
                        Calendar.SATURDAY || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    daysBeforeCourseCompletion = workingDays.size() - 1;
                    hoursBeforeCourseCompletion = amountOfWorkingHoursAtLastDay;
                } else if (hoursToday >= startWorkingHour && hoursToday <= endWorkingHour) {
                    daysBeforeCourseCompletion = workingDays.size() - 2;
                    hoursBeforeCourseCompletion = endWorkingHour - hoursToday + amountOfWorkingHoursAtLastDay;
                } else {
                    daysBeforeCourseCompletion = workingDays.size() - 2;
                    hoursBeforeCourseCompletion = amountOfWorkingHoursAtLastDay;
                }
            }
            daysAndHoursBeforeOrAfterCourseCompletion.add(daysBeforeCourseCompletion);
            daysAndHoursBeforeOrAfterCourseCompletion.add(hoursBeforeCourseCompletion);
            System.out.println("Training is not finished. " + daysBeforeCourseCompletion + " d " + hoursBeforeCourseCompletion + " hours are left until the end.");
        } else {
            if (amountOfWorkingHoursAtLastDay == 0) {
                if (hoursToday < startWorkingHour) {
                    daysBeforeCourseCompletion = 1;
                    daysAndHoursBeforeOrAfterCourseCompletion.add(daysBeforeCourseCompletion);
                    daysAndHoursBeforeOrAfterCourseCompletion.add(hoursBeforeCourseCompletion);
                    System.out.println("Training is not finished. " + hoursBeforeCourseCompletion + " hours are left until the end.");
                } else if (hoursToday >= startWorkingHour && hoursToday <= endWorkingHour) {
                    hoursBeforeCourseCompletion = endWorkingHour - hoursToday;
                    daysAndHoursBeforeOrAfterCourseCompletion.add(daysBeforeCourseCompletion);
                    daysAndHoursBeforeOrAfterCourseCompletion.add(hoursBeforeCourseCompletion);
                    System.out.println("Training is not finished. " + hoursBeforeCourseCompletion + " hours are left until the end.");
                } else {
                    hoursAfterCourseCompletion = hoursToday - endWorkingHour;
                    daysAndHoursBeforeOrAfterCourseCompletion.add(daysAfterCourseCompletion);
                    daysAndHoursBeforeOrAfterCourseCompletion.add(hoursAfterCourseCompletion);
                    System.out.println("Training completed. " + hoursAfterCourseCompletion + " hours have passed since the end.");
                }
            } else {
                if (hoursToday < startWorkingHour) {
                    hoursBeforeCourseCompletion = amountOfWorkingHoursAtLastDay;
                    daysAndHoursBeforeOrAfterCourseCompletion.add(daysBeforeCourseCompletion);
                    daysAndHoursBeforeOrAfterCourseCompletion.add(hoursBeforeCourseCompletion);
                    System.out.println("Training is not finished. " + hoursBeforeCourseCompletion + " hours are left until the end.");
                } else if (hoursToday >= startWorkingHour && hoursToday <= (amountOfWorkingHoursAtLastDay + startWorkingHour)) {
                    hoursBeforeCourseCompletion = amountOfWorkingHoursAtLastDay + startWorkingHour - hoursToday;
                    daysAndHoursBeforeOrAfterCourseCompletion.add(daysBeforeCourseCompletion);
                    daysAndHoursBeforeOrAfterCourseCompletion.add(hoursBeforeCourseCompletion);
                    System.out.println("Training is not finished. " + hoursBeforeCourseCompletion + " hours are left until the end.");
                } else {
                    hoursAfterCourseCompletion = hoursToday - (amountOfWorkingHoursAtLastDay + startWorkingHour);
                    daysAndHoursBeforeOrAfterCourseCompletion.add(daysAfterCourseCompletion);
                    daysAndHoursBeforeOrAfterCourseCompletion.add(hoursAfterCourseCompletion);
                    System.out.println("Training completed. " + hoursAfterCourseCompletion + " hours have passed since the end.");
                }
            }
        }
        return daysAndHoursBeforeOrAfterCourseCompletion;
    }
}