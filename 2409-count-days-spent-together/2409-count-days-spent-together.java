class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] day={
            31,28,31,30,31,30,
            31,31,30,31,30,31
        };
        int a1=getDay(arriveAlice,day);
        int a2=getDay(leaveAlice,day);
        int b1=getDay(arriveBob,day);
        int b2=getDay(leaveBob,day);
        int s=Math.max(a1,b1);
        int e=Math.min(a2,b2);

        return Math.max(0,e-s+1);
    }
    private int getDay(String date,int[] day) {
        int m=Integer.parseInt(date.substring(0,2));
        int d=Integer.parseInt(date.substring(3,5));
        for(int i=0;i<m-1;i++)
           d+=day[i];
        return d;
    }
}