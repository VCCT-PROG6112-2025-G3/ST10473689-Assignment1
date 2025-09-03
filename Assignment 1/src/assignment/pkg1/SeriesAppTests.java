package assignment.pkg1;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class SeriesAppTests {

    // Checks if search finds a series
    @Test
    public void testSearchFound() {
        SeriesModel s = new SeriesModel("1", "Test Series", 10, 5);
        ArrayList<SeriesModel> list = new ArrayList<>();
        list.add(s);

        SeriesModel found = null;
        for (SeriesModel item : list) {
            if (item.getSeriesId().equals("1")) {
                found = item;
                break;
            }
        }
        assertNotNull(found); // found series is not null
        assertEquals("Test Series", found.getSeriesName()); // name matches
    }

    // Checks if search fails for non-existing series
    @Test
    public void testSearchNotFound() {
        ArrayList<SeriesModel> list = new ArrayList<>();

        SeriesModel found = null;
        for (SeriesModel item : list) {
            if (item.getSeriesId().equals("x")) {
                found = item;
                break;
            }
        }
        assertNull(found); // found series is null
    }

    // Checks if series can be updated
    @Test
    public void testUpdateSeries() {
        SeriesModel s = new SeriesModel("1", "Old Name", 10, 5);
        s.setSeriesName("New Name");
        s.setSeriesAge(12);
        s.setSeriesNumberOfEpisodes(8);

        assertEquals("New Name", s.getSeriesName()); // name updated
        assertEquals(12, s.getSeriesAge()); // age updated
        assertEquals(8, s.getSeriesNumberOfEpisodes()); // episodes updated
    }

    // Checks if series can be deleted
    @Test
    public void testDeleteSeries() {
        ArrayList<SeriesModel> list = new ArrayList<>();
        SeriesModel s = new SeriesModel("1", "Test", 10, 5);
        list.add(s);

        boolean removed = list.remove(s);
        assertTrue(removed); // deleted successfully
        assertTrue(list.isEmpty()); // list is empty
    }

    // Checks delete fails for non-existing series
    @Test
    public void testDeleteSeriesNotFound() {
        ArrayList<SeriesModel> list = new ArrayList<>();
        SeriesModel s = new SeriesModel("1", "Test", 10, 5);
        list.add(s);

        SeriesModel dummy = new SeriesModel("x", "Dummy", 10, 5);
        boolean removed = list.remove(dummy);
        assertFalse(removed); // deletion failed
        assertEquals(1, list.size()); // list still has 1 series
    }

    // Checks if valid age is accepted
    @Test
    public void testAgeValid() {
        SeriesModel s = new SeriesModel("1", "Test", 10, 5);
        assertTrue(s.getSeriesAge() >= 2 && s.getSeriesAge() <= 18); // age valid
    }

    // Checks if invalid age is rejected
    @Test
    public void testAgeInvalid() {
        SeriesModel s = new SeriesModel("1", "Test", 30, 5);
        assertFalse(s.getSeriesAge() >= 2 && s.getSeriesAge() <= 18); // age invalid
    }
}
