package Tasks;

/* Array of integers named "blocks" with the size N is given and every integer is the size of the block;
you have 2 frogs that start on one block (either the first one or the "optimal starting block")and the frogs want
to get as far away from each other as possible. The frogs can only jump to the adjacent block if it is at least as
big as the one they are sitting on and can not jump if the adjacent block is smaller than the one they sit on.
The exercise also states that distance between blocks numbered J and K, where J<=K is computed as K - J + 1.
The question is: what is the longest distance that they can possibly create between each other if they chose the optimal
starting block.

Example 1:
Given blocks [2,6,8,5] it should return 3 (starting block is 0 and right frog jumps to block [2])

Example 2:
Given blocks [1,5,5,2,6] it should return 4 (starting block is [3], left frog jumps to [1] and right frog to [4])

Example 3:
Given blocks[1,1] it should return (starting block is [1], first frog can jump to block [0] or vica versa) 2*/

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
