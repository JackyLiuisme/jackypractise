package offer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ZJUNews{

    private String url;
    private String title;
    private String time;
    private String content;

    public ZJUNews(String url1,String title1,String time1,String content1){
        url = url1;
        title = title1;
        time = time1;
        content = content1;
    }

    public ZJUNews(String url1){

        url = url1;

        title = null;
        time = null;
        content = null;


        // 尝试三次
        for (int tryt = 0;tryt < 3;tryt ++){

            Connection con = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36").timeout(5000).ignoreContentType(true);

            try{
                // 获取网页源代码
                String source = con.get().toString();
                if (source == null) {
                    continue;
                }

                // 得到信息
                Document doc = Jsoup.parse(source);

                title = doc.title();

                // 匹配发布时间
                Pattern pattern = Pattern.compile("发布时间: ((\\d+)-(\\d+)-(\\d+))");
                Matcher matcher = pattern.matcher(source);

                while(matcher.find()){
                    time = matcher.group();
                }

                Elements news = doc.select("[class=vid_wz]");
                if (news != null && news.size() == 1){
                    content = news.text();
                }

            }catch(Exception e){
                e.printStackTrace();
                break;
            }

        }

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString(){
        return url+"\t"+time+"\t"+title+"\t"+content;
    }

}



public class ZJUCSTSPI {

    public static void main(String [] args){

        String urlHead = "http://www.cst.zju.edu.cn/index.php?c=Index&a=tlist&catid=72&p=";

        int pageNum = 1;
        int maxPageNum = -1;

        ArrayList<ZJUNews> zjuNewsArrayList = new ArrayList<ZJUNews> ();

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

                            ZJUNews zjuNews = new ZJUNews("http://www.cst.zju.edu.cn/"+lis.get(i).getElementsByTag("a").first().attr("href").toString());
//                            System.out.println(zjuNews.toString());

                            zjuNewsArrayList.add(zjuNews);

                        }

                    }

                }

                pageNum ++ ;
            }catch(Exception e){
                e.printStackTrace();
                break;
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.printf("共有%d条新闻。耗时%d毫秒\n",zjuNewsArrayList.size(),endTime-startTime);

//        for(int i=0;i<zjuNewsArrayList.size();i++){
//            System.out.println(zjuNewsArrayList.get(i));
//        }

    }



}
