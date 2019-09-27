package cn.tx.spider;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySpider {
    public static void main(String[] args) throws Exception{
        List<String> pages = getTiziPages("https://www.gamersky.com/ent/201901/1141204.shtml");
        List<String> imgs = getImgUrls(pages);
        downloadImg(imgs);
    }

    /**
     * 根据帖子url集合获取帖子内所有分页的集合
     * @param url
     * @return
     * @throws IOException
     */
    private static List<String> getTiziPages(String url) throws IOException {

            // 本帖子的所有分页集合
            List<String> pages = new ArrayList<>();
            // 获取本页页面内容
            Document document = Jsoup.connect(url).get();
            // 获取分页组件(可能失败)
            Element page_css = document.getElementsByClass("page_css").get(0);
            // 获取分页组件内所有a标签
            Elements tags = page_css.getElementsByTag("a");
            // 获取所有分页信息
            // tags.size()-1 最后一个a标签为  下一页  无需获取
            for(int i=0;i<tags.size()-1;i++){
                // 获取一个分页a标签
                Element element = tags.get(i);
                // 解析a标签获取href属性并添加到本帖子所有分页集合内
                pages.add(element.attr("abs:href"));
            }
            return pages;
    }

    /**
     * 根据帖子页的url集合获取所有图片链接
     * @param urls
     * @return
     * @throws IOException
     */
    private static List<String> getImgUrls(List<String> urls) throws IOException {
        // 结果集合
        List<String> list = new ArrayList<>();
        // 对帖子分页进行循环
        for(String url : urls){
            try{
                // 获取帖子某一页内容
                Document document = Jsoup.connect(url).get();
                // 根据class获取图片所在div
                Element mid2L_con = document.getElementsByClass("Mid2L_con").get(0);
                // 根据 有align属性的标签获取所有标签
                Elements aligns = mid2L_con.getElementsByAttribute("align");

                // 循环所有标签
                for(Element align : aligns){
                    // http://www.gamersky.com/showimage/id_gamersky_02.shtml?http://img1.gamersky.com/image2015/01/20150130ge_6/gamersky_02origin_03_201513017292A1.jpg
                    // 解析a标签获取href并根据 ? 截取后面的大图链接 添加至结果集合
                    if(!align.getElementsByTag("a").isEmpty()) {
                        list.add(align.getElementsByTag("a").get(0).attr("abs:href").split("\\?")[1]);
                    }
                }
            }catch (IndexOutOfBoundsException e){
//                e.printStackTrace();
                System.out.println("页面无法解析:");
                System.out.println(url);
            }catch (SocketTimeoutException e){
//                e.printStackTrace();
                System.out.println("页面链接超时:");
                System.out.println(url);
            }
        }
        return list;
    }

    /**
     * 下载所有图片至文件夹
     * @param imgs
     * @throws IOException
     */
    private static void downloadImg(List<String> imgs) throws IOException {
        // 帖子文件夹
        String baseDir = "D:\\temp\\课堂示例\\";
        new File(baseDir).mkdirs();
        // 循环下载所有图片链接
        for(int i=0;i<imgs.size();i++){
            // 生成url
            URL url = new URL(imgs.get(i));
            // 获得连接
            URLConnection connection = url.openConnection();
            // 设置10秒的相应时间
            connection.setConnectTimeout(10 * 1000);
            // 获得输入流
            try {
                InputStream in = connection.getInputStream();
                // 使用工具类转换输入流为二进制数组
                // 使用工具类写入图片到硬盘
                IOUtils.write(IOUtils.toByteArray(in),new FileOutputStream(new File(baseDir+i+".jpg")));
            }catch (FileNotFoundException e){
                System.out.println("连接失效:");
                System.out.println(imgs.get(i));
            }catch (SocketTimeoutException e){
                System.out.println("连接超时:");
                System.out.println(imgs.get(i));
            }

        }
        System.out.println("下载完成!");
    }

}
