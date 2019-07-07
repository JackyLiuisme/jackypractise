package company.practise18;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class jinritoutiaoC {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        char[][] chas=new char[n][m];
        int startX=0,startY=0,boxX=0,boxY=0;
        for(int i=0;i<n;i++){
            String string=sc.next();
            for(int j=0;j<m;j++){
                chas[i][j]=string.charAt(j);
                if(chas[i][j]=='S'){
                    startX=i;
                    startY=j;
                }
                if(chas[i][j]=='0'){
                    boxX=i;
                    boxY=j;
                }
            }
        }
        System.out.println(bfsMinStep(chas,startX,startY,boxX,boxY));
    }

    public static class Node{
        int x;
        int y;
        int bx;
        int by;
        int step;
        public Node(int x,int y,int bx,int by){
            this.x=x;
            this.y=y;
            this.bx=bx;
            this.by=by;
        }
    }
    private static int bfsMinStep(char[][] chas,int startX, int startY,int boxX,int boxY) {
        Node start=new Node(startX, startY,boxX,boxY);
        int n=chas.length;
        int m=chas[0].length;
        boolean[][][][] isVisted=new boolean[n][m][n][m];

        int[][] dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<Node> queue=new LinkedList<>();
        start.step=0;
        queue.add(start);
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            int newBx=cur.bx;
            int newBy=cur.by;
            for(int i=0;i<4;i++){
                //在箱子上面或下面
                if(cur.y==cur.by){
                    newBx=cur.x+dir[i][0]==cur.bx?cur.bx+dir[i][0]:cur.bx;
                }
                //在箱子左边或右边
                if(cur.x==cur.bx){
                    newBy=cur.y+dir[i][1]==cur.by?cur.by+dir[i][1]:cur.by;
                }
                Node next=new Node(cur.x+dir[i][0], cur.y+dir[i][1],newBx,newBy);
                if(next.x<0||next.x>=n||next.y<0||next.y>=m||chas[next.x][next.y]=='#'
                        ||next.bx<0||next.bx>=n||next.by<0||next.by>=m
                        ||chas[next.bx][next.by]=='#'){
                    continue;
                }
                if(!isVisted[next.x][next.y][next.bx][next.by]){
                    isVisted[next.x][next.y][next.bx][next.by]=true;
                    next.step=cur.step+1;
                    if(chas[next.bx][next.by]=='E'){
                        return next.step;
                    }
                    queue.add(next);
                }
            }
        }
        return -1;
    }
}