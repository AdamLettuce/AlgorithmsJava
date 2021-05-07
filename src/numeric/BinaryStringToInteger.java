package numeric;

/**
 * Created by adam on 07/05/2018.
 */
public class BinaryStringToInteger {
    public static void main(String[] args) {
String topic []= {"10101",
        "11100",
        "11010",
        "00101"};

        int result = 0;
        int max =0;
        int maxCount = 0;
        for(int i=0;i<topic.length-1;++i) {
            for(int j=i+1;j<topic.length;++j) {
                char[] t1 = topic[i].toCharArray();
                char[] t2 = topic[j].toCharArray();

                int tmpCount =0;
                for(int k=0;k<t1.length;++k) {
                    if(t1[k]=='1' || t2[k]=='1') {
                        tmpCount++;
                    }
                }
                if(tmpCount==max) {
                    ++maxCount;
                }
                if(tmpCount>max) {
                    max=tmpCount;
                    maxCount=1;
                }
            }
        }

        System.out.println(max);
        System.out.println(maxCount);
    }
}
