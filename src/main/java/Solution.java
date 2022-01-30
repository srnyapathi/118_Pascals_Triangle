import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> generateb(int numRows) {
        List<List<Integer>> result = new ArrayList<>();


            var row1 = new ArrayList<Integer>();
                                                        row1.add(1);                                                                              result.add(row1);                                                               //1
            var row2 =  new ArrayList<Integer>();
                                                    row2.add(1);row2.add(1);                                                                       result.add(row2);                                                        //1 1
            var row3 = new ArrayList<Integer>();
                                                row3.add(1);row3.add(row2.get(0)+row2.get(1));row3.add(1);                                                  result.add(row3);                          //1,2,1
            var row4 = new ArrayList<Integer>();
                                        row4.add(1);row4.add(row3.get(0)+row3.get(1));row4.add(row3.get(1)+row3.get(2));row4.add(1);                        result.add(row4);    //1,3,3,1
            var row5 = new ArrayList<Integer>();
                            row5.add(1);row5.add(row4.get(0)+row4.get(1));row5.add(row4.get(1)+row4.get(2));row5.add(row4.get(2)+row4.get(3));row5.add(1);  result.add(row5);



                            return result;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();


        for(int i=1;i<=numRows;i++){
            if(i==1){                                           //        1
                Integer[] temp=new Integer[i];
                temp[0]=1;
                result.add(Arrays.asList(temp));
            }
            if(i==2){                                          // 1     1
                Integer[] temp=new Integer[i];
                fillOne(temp,0,1);
                result.add(Arrays.asList(temp));
            }
            if(i>2){
                Integer[] temp= new Integer[i];
                fillOne(temp,0,i-1);
                var previousRow=  result.get(i - 2);
                for(int j=1;j<=i-2;j++){
                    temp[j]= previousRow.get(j-1)+previousRow.get(j);
                }
                result.add(Arrays.asList(temp));
            }
        }


        return result;
    }

    private void fillOne(Integer[] temp, int i, int j) {
        temp[i]=1;
        temp[j]=1;
    }


    public static void main(String...args){
        Solution sln = new Solution();
        List<List<Integer>> generate = sln.generate(5);
        System.out.println(generate);
    }
}
