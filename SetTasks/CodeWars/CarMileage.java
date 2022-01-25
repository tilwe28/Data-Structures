public class CarMileage {
  public static int isInteresting(int number, int[] awesomePhrases) {
      if (number<98) return 0;
      if (number<100) return 1;
    
      //awesomePhrases
      boolean is=true, almost=false, close=false;
      for (int i=0; i<awesomePhrases.length; i++) {
          if (number == awesomePhrases[i])
              return 2;
          if (awesomePhrases[i] - number <= 2 && awesomePhrases[i] - number > 0)
            almost = true;
      }
      if (almost) close = true;
      
      //Followed by all 0s
      char[] nums = Integer.valueOf(number).toString().toCharArray();
      Integer firstExpected = Integer.parseInt(String.valueOf(nums[0])) + 1;
      String expected = firstExpected.toString();
      is=true;
      for (int i=1; i<nums.length; i++) {
          if (nums[i] != '0') is=false;
          expected += "0";
      }
      if (is) return 2;
      if (Integer.parseInt(expected)-number <= 2 && Integer.parseInt(expected)-number > 0) close = true;
    
      //Digits are all same number
      char digit = nums[0];
      is=true;
      almost=false;
      for (int i=1; i<nums.length && is; i++) {
          if (nums[i] != digit && i<nums.length-2) is=false;
          else if (nums[i] != digit && i>=nums.length-2) {
              is = false;
              Integer last3 = Integer.parseInt(String.valueOf(nums[nums.length-3]) + String.valueOf(nums[nums.length-2]) + String.valueOf(nums[nums.length-1]));
              Integer diff = Integer.parseInt(String.valueOf(digit)+String.valueOf(digit)+String.valueOf(digit))-last3;
              if (diff <= 2 && diff > 0)
                  almost = true;
          }
      }
      if (is) return 2;
      if (almost) close = true;
    
      //Incrementing
      is=true;
      almost=false;
      int n=number/10, prev=number%10;
      while (n!=0) {
          if (prev!=0) {
              if (prev-1 != n%10) is=false;
          }
          else if (n%10 != 9) is=false;
          prev=n%10;
          n=n/10;
      }
      if (is) return 2;
      else {
          String numStr = Integer.valueOf(number).toString(), shouldBe = String.valueOf(numStr.charAt(0));
          Integer digits = Integer.parseInt(String.valueOf(numStr.charAt(0)));
          for (int i=1; i<numStr.length(); i++) {
              digits++;
              if (digits == 10)
                  digits = 0;
              shouldBe += (digits);
          }
          if (Integer.parseInt(shouldBe)-number == 1 || Integer.parseInt(shouldBe)-number == 2)
              close = true;
      }
    
      //Decrementing
      is=true;
      almost=false;
      n=number/10;
      prev=number%10;
      while (n!=0) {
          if (prev+1 != n%10) is=false;
          prev=n%10;
          n=n/10;
      }
      if (is) return 2;
      else {
          String numStr = Integer.valueOf(number).toString(), shouldBe = String.valueOf(numStr.charAt(0));
          Integer digits = Integer.parseInt(String.valueOf(numStr.charAt(0)));
          for (int i=1; i<numStr.length(); i++) {
              digits--;
              if (digits == -1)
                  digits = 9;
              shouldBe += (digits);
          }
          if (Integer.parseInt(shouldBe)-number == 1 || Integer.parseInt(shouldBe)-number == 2)
              close = true;
      }
    
      //Pallindrome
      int reverse = Integer.parseInt(new StringBuilder(Integer.valueOf(number).toString()).reverse().toString());
      if (number == reverse) return 2;
      else {
          reverse = Integer.parseInt(new StringBuilder(Integer.valueOf(number+1).toString()).reverse().toString());
          if (number+1 == reverse) close = true;
          reverse = Integer.parseInt(new StringBuilder(Integer.valueOf(number+2).toString()).reverse().toString());
          if (number+2 == reverse) close = true;
      }
    
      if (close) return 1;
      return 0;
  }
}