public class SearchRange {
    
    public int search(int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;

            int isCorrect = isCorrect(mid);
            if (isCorrect > 0) {
                high = mid - 1;
            } else if (isCorrect < 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    } 

    // Return 1 if n is too big (n > 10)
    // Return 0 if it's correct
    // Return -1 if n is too small (n < 10)
    private int isCorrect(int n) {
        if (n > 10) {
            return 1; 
        } else if (n < 10) {
            return -1;
        } else {
            return 0;
        }
    }
}
