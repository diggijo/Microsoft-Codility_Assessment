package Tasks;

/* Given a string S, return the maximum number of unique substrings that the given string can be split into.
* Example: Cycle can be split into 2 substring (Cy, Cle) or (C, Ycle) */

public class Task1 {
    public static void main(String[] args) {
        Task1 sol = new Task1();

        System.out.println(sol.solution("world"));
        System.out.println(sol.solution("abacdec"));
        System.out.println(sol.solution("cycle"));
        System.out.println(sol.solution("ddddd"));
        System.out.println(sol.solution("mississippi"));
    }

    public int solution(String S) {
        // write your code in Java SE 8
        int substrings=1;
        int breakpoint = 0;

        for(int i=0; i< S.length()-1; i++)
        {
            for(int j=i+1; j<S.length(); j++)
            {
                if(S.charAt(i) == S.charAt(j))
                {

                    if(j-i > 2)
                    {
                        if(S.charAt(i+1) == S.charAt(j-1))
                        {
                            breakpoint = j-1;
                        }
                        else
                        {
                            breakpoint = j;
                        }
                    }
                    else
                    {
                        breakpoint = j;
                    }

                    j = S.length();
                    i = breakpoint-1;
                    substrings++;
                }
            }
        }
        return substrings;
    }
}