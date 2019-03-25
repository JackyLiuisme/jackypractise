package offer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZJUCSTMULSPI {

    private static ExecutorService fixedThreadPool;

    private static ArrayList<ZJUNews> zjuNewsArrayList;

    //传的参数分别是：链表,线程数
    public static void start(final ArrayList<String> l,int n){
        fixedThreadPool = Executors.newFixedThreadPool(n);
        final int one=l.size()/n+1;
        for (int i = 0; i < n; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        for(int i=(index*one);i<(index+1)*one;i++){
                            if(i<l.size()){
                                ZJUNews zjuNews = new ZJUNews(l.get(i));
                                zjuNewsArrayList.add(zjuNews);
                                System.out.printf("当前%d个页面\n",zjuNewsArrayList.size());
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        fixedThreadPool.shutdown();
    }


    public static void main(String [] args){

        //String urlHead = "http://www.cst.zju.edu.cn/index.php?c=Index&a=tlist&catid=72&p=";
        String urlHead = "http://www.cst.zju.edu.cn/index.php?c=Index&a=tlist&catid=72&p=";

        int pageNum = 1;
        int maxPageNum = -1;

        zjuNewsArrayList = new ArrayList<ZJUNews> ();

        ArrayList<String> detailUrls = new ArrayList<String> ();

        // 计时开始
        long startTime = System.currentTimeMillis();


        while(maxPageNum == -1 || pageNum <= maxPageNum){

            System.out.printf("当前第%d页，共%d页\n",pageNum,maxPageNum);

            String url = urlHead + pageNum;
            Connection con = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36").timeout(5000).ignoreContentType(true);

            try{
                // 获取网页源代码
                String source = con.get().toString();
                if (source == null) {
                    continue;
                }

                // 得到最大的页数
                if (maxPageNum == -1){
                    // 匹配最大页数
                    Pattern pattern = Pattern.compile("当前第 (\\d+)/(\\d+) 页");
                    Matcher matcher = pattern.matcher(source);
                    while(matcher.find()){
                        maxPageNum = Integer.parseInt(matcher.group(2));
                    }
                }

                // 得到网址信息
                Document doc = Jsoup.parse(source);
                Elements news = doc.select("[class=lm_new]");
                if (news != null && news.size() == 1){

                    Elements lis = news.get(0).getElementsByTag("li");

                    if(lis != null){

                        for(int i=0;i<lis.size();i++){

                            detailUrls.add("http://www.cst.zju.edu.cn/"+lis.get(i).getElementsByTag("a").first().attr("href").toString());
//                            ZJUNews zjuNews = new ZJUNews("http://www.cst.zju.edu.cn/"+lis.get(i).getElementsByTag("a").first().attr("href").toString());
////                            System.out.println(zjuNews.toString());
//
//                            zjuNewsArrayList.add(zjuNews);

                        }

                    }

                }

                pageNum ++ ;
            }catch(Exception e){
                e.printStackTrace();
                break;
            }
        }

        start(detailUrls,25);
        while(!fixedThreadPool.isTerminated()){
        }

        long endTime = System.currentTimeMillis();

        System.out.printf("共有%d条新闻。耗时%d毫秒\n",zjuNewsArrayList.size(),endTime-startTime);

        for(int i=0;i<zjuNewsArrayList.size();i++){
            System.out.println(zjuNewsArrayList.get(i));
        }

    }



}
