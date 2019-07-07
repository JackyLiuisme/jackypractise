package company.practise18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Pinduoduo2018b {


        public static int limit;
        public static ArrayList<Integer> parent;
        public static ArrayList<Integer> dist;
        public static ArrayList<HashSet<Integer>> child;
        public static void main( String[] args ) {
            Scanner sc = new Scanner( System.in );
            limit = sc.nextInt();
            int n = sc.nextInt();
            parent = new ArrayList<Integer>();
            child = new ArrayList<HashSet<Integer>>();
            dist = new ArrayList<Integer>();
            for( int i = 0; i < n; i ++ ) {
                dist.add( 0 );
                parent.add( -1 );
                child.add( new HashSet<Integer>() );
            }
            for( int i = 0; i < n - 1; i ++ ) {
                int u = sc.nextInt(); int v = sc.nextInt(); int d = sc.nextInt();
                if( d > limit ) continue;
                child.get( u ).add( v );
                parent.set( v, u );
                dist.set( v, d );
            }
            int root = 0;
            while( parent.get( root ) != -1 )
                root = parent.get( root );
            System.out.println( values( root ).last() );
            sc.close();
        }
        public static TreeSet<Integer> values(int root ) {
            TreeSet<Integer> set = new TreeSet<>();
            int d = dist.get( root );
            set.add( 0 );
            if( child.get( root ).size() == 0 ) {
                set.add( d );
                return set;
            }
            ArrayList<TreeSet<Integer>> sets = new ArrayList<>();
            for( int i : child.get( root ) )
                sets.add( values( i ) );
            for( int i = 0; i < sets.size(); i ++ ) {
                for( int j : sets.get(i) )
                    if( d + j <= limit ) set.add( d + j );
                for( int j = i + 1; j < sets.size(); j ++ )
                    for( int m : sets.get(i) )
                        for( int n : sets.get(j) )
                            if( m + n + d <= limit ) set.add( m + n + d );
            }
            return set;
    }

}
