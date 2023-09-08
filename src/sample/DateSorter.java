package sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;


public class DateSorter {

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2005-07-01, 2005-01-02, 2005-01-01, 2005-05-03)
     * would sort to
     * (2005-01-01, 2005-01-02, 2005-07-01, 2005-05-03)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
 /*   public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> result = new ArrayList<>(unsortedDates.stream()
                .filter(DateSorter::containsR)
                .toList());
        result.sort(Collections.reverseOrder());
        List<LocalDate> datesWithoutR = new ArrayList<>(unsortedDates.stream()
                .filter(date -> !containsR(date))
                .sorted()
                .toList());

        result.addAll(datesWithoutR);

        return result;
    }*/
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        ArrayList<LocalDate> datesWithR = new ArrayList<>(unsortedDates.size());
        ArrayList<LocalDate> datesWithoutR = new ArrayList<>(unsortedDates.size());

        for (LocalDate date : unsortedDates) {
            if (containsR(date)) {
                datesWithR.add(date);
            } else {
                datesWithoutR.add(date);
            }
        }
        sort(datesWithR);
        datesWithoutR.trimToSize();
        datesWithoutR.sort(reverseOrder());
        datesWithR.addAll(datesWithoutR);

        return datesWithR;
    }

    private boolean containsR(LocalDate date) {
        return date.getMonth().toString().toLowerCase().contains("r");
    }
}
