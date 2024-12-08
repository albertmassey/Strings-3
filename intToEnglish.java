//time O(1)
//space O(1)

class Solution {
    // Arrays for number words
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
                         "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", 
                         "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousand = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero"; // Handle edge case for zero
        
        int i = 0; // Index for thousand array
        String result = "";

        // Process triplets of numbers
        while (num > 0) {
            int triplet = num % 1000;
            if (triplet != 0) {
                result = helper(triplet).trim() + " " + thousand[i] + " " + result;
            }
            num /= 1000;
            i++;
        }

        return result.trim(); // Remove extra spaces
    }

    // Helper function to process a number less than 1000
    private String helper(int triplet) {
        if (triplet == 0) {
            return "";
        } else if (triplet < 20) {
            return below_20[triplet];
        } else if (triplet < 100) {
            return tens[triplet / 10] + " " + helper(triplet % 10);
        } else {
            return below_20[triplet / 100] + " Hundred " + helper(triplet % 100);
        }
    }
}
