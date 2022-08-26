package Tasks;

public class Task2 {
    public static void main(String[] args) {
        int[] one = {2,6,8,5};
        int[] two = {1,5,5,2,6};
        int[] three = {1,1};

        Task2 sol = new Task2();

        System.out.println(sol.solution(one));
        System.out.println(sol.solution(two));
        System.out.println(sol.solution(three));
    }

    public int solution(int[] blocks) {
        // write your code in Java SE 8
        int distance = 0;
        int possibleJumpsRight=0;
        int possibleJumpsLeft=0;
        int totalJumps=0;
        int mostJumps = 0;
        int bestStartBlock = 0;
        int newPosRight;
        int newPosLeft;


        for(int i=0; i< blocks.length-1; i++)
        {
            for(int j=i; j<blocks.length-1; j++)
            {
                if(blocks[j+1]>=blocks[j])
                {
                    possibleJumpsRight++;
                }
                else
                    break;
            }

            for(int k=i; k>=0; k--)
            {
                if(k>0 && blocks[k-1]>k)
                {
                    possibleJumpsLeft++;
                }
                else
                    break;
            }

            totalJumps = possibleJumpsLeft + possibleJumpsRight;

            if(totalJumps>mostJumps)
            {
                mostJumps = totalJumps;
                bestStartBlock = i;
                newPosRight = bestStartBlock + possibleJumpsRight;
                newPosLeft = bestStartBlock - possibleJumpsLeft;
                distance = (newPosRight - newPosLeft) + 1;
            }

            possibleJumpsLeft=0;
            possibleJumpsRight=0;
        }

        return distance;
    }
}
