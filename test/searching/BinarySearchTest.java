package searching;

import org.junit.Test;

import static org.junit.Assert.*;


public class BinarySearchTest {

    public void find_zero_length_array() throws Exception {
        test(new int[0], 0, -1);

    }

    @Test
    public void find_one_length_array_should_not_find_element() throws Exception {
        test(new int[]{1}, 2, -1);
    }

    @Test
    public void find_one_length_array_should_find_element() throws Exception {
        test(new int[]{1}, 1, 0);
    }

    @Test
    public void find_two_length_array_should_not_find_element_to_low() throws Exception {
        test(new int[]{1, 2}, 0, -1);
    }

    @Test
    public void find_two_length_array_should_find_element_at_0() throws Exception {
        test(new int[]{1, 2}, 1, 0);
    }

    @Test
    public void find_two_length_array_should_find_element_at_1() throws Exception {
        test(new int[]{1, 2, 3}, 0, -1);
    }

    @Test
    public void find_two_length_array_should_not_find_element_to_high() throws Exception {
        test(new int[]{1, 2, 3}, 1, 0);
    }

    @Test
    public void find_three_length_array_should_find_element_at_0() throws Exception {
        test(new int[]{1, 2, 3}, 2, 1);
    }

    @Test
    public void find_three_length_array_should_find_element_at_1() throws Exception {
        test(new int[]{1, 2, 3}, 3, 2);
    }

    @Test
    public void find_three_length_array_should_find_element_at_2() throws Exception {
        test(new int[]{1, 2, 3}, 4, -1);
    }

    @Test
    public void find_eight_length_array_should_find_element_at_2() throws Exception {
        test(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}, 13, 12);
    }

    private void test(int[] data, int elementToFind, int expectedIndex) {
        //given
        SearchingAlgorithm SearchingAlgorithm = getBinarySearch();
        //when
        int actual = SearchingAlgorithm.find(data, elementToFind);
        //then
        assertEquals(expectedIndex, actual);
    }

    protected SearchingAlgorithm getBinarySearch() {
        return new BinarySearchRecursive();
//        return new BinarySearchIterative();
    }
}